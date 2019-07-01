package com.ocr.pdfUtil;


import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import org.apache.pdfbox.io.RandomAccessBuffer;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
 

public class PdfUtil {
	public final  static String  IMG_TYPE_JPG = "jpg";
    public final  static String  IMG_TYPE_PNG = "png";
    public static void main( String[] args ) throws IOException{
    	PdfUtil pdf2Image = new PdfUtil();
        pdf2Image.pdf2img("D:\\cheese python\\osaka\\ou\\呼吸機能検査_20170718"
        		+ "\\0032_M004k004_呼吸機能検査_170704_システム_呼吸記録検査報告書_1.pdf", "D:",IMG_TYPE_JPG);
    }

	/**
	 * 将单页PDF文件转换为图片
	 * apache pdfbox工具实现
	 * @param srcPath PDF文件绝对路径
	 * @param destPath 图片文件绝对路径
	 */
	public static void singlePagePdf2Image(String srcPath,String destPath){
		try{
			PDDocument document=PDDocument.load(new File(srcPath));
			PDFRenderer pdfRenderer=new PDFRenderer(document);
			BufferedImage bufferedImage=pdfRenderer.renderImageWithDPI(0,100);
			ImageIOUtil.writeImage(bufferedImage,destPath,100);
			document.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	 /**
     * PDF转图片
     * @param pdfPath pdf文件的路径
     * @param savePath 图片保存的地址
     * @param imgType 图片保存方式
     */
    public void pdf2img(String pdfPath,String savePath,String imgType){
        String fileName = pdfPath.substring(pdfPath.lastIndexOf("\\")+1, pdfPath.length());
        fileName = fileName.substring(0,fileName.lastIndexOf("."));
        InputStream is = null;
        PDDocument pdDocument = null;
        try {
            is = new BufferedInputStream(new FileInputStream(pdfPath));
            //创建pdf文件解析器
            PDFParser parser = new PDFParser(new RandomAccessBuffer(is));
            parser.parse();
            //获取解析后的pdf文档
            pdDocument = parser.getPDDocument();
            //获取pdf渲染器，主要用来后面获取BufferedImage
            PDFRenderer renderer = new PDFRenderer(pdDocument);
            //获取pdf文件总页数
            int pageCount = pdDocument.getNumberOfPages();
            for (int i = 0; i < pageCount; i++) {
                //构造保存文件名称格式
                String saveFileName = savePath+"\\"+fileName+"-"+i+"."+imgType;
                //获取当前页对象
                PDPage page =  pdDocument.getPage(i);
                //图片转换
                pdfPage2Img(page,saveFileName,imgType,renderer,i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(pdDocument != null){
                try {
                    pdDocument.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 将pdf单页转换为图片
     * @param page 当页对象
     * @param saveFileName 保存的图片名称
     * @param imgType 保存的图片类型
     * @param renderer 用于获取BufferedImage
     * @param index 页索引
     * @throws IOException
     */
    public void pdfPage2Img(PDPage page,String saveFileName,String imgType,PDFRenderer renderer,int index) throws IOException{
        //构造图片 添加DPI更加清晰
        BufferedImage img_temp  = renderer.renderImageWithDPI(index, 350);
        //设置图片格式
        Iterator<ImageWriter> it = ImageIO.getImageWritersBySuffix(imgType);
        //将文件写出
        ImageWriter writer = (ImageWriter) it.next();
        ImageOutputStream imageout = ImageIO.createImageOutputStream(new FileOutputStream(saveFileName));
        writer.setOutput(imageout);
        writer.write(new IIOImage(img_temp, null, null));
    }
}
