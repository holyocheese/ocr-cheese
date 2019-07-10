package com.ocr.pdfUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

import com.ocr.pdfUtil.pdfBox.PrintTextLocations;

public class PdfFormatUtil {

	public static void main(String[] args) throws Exception {
		// createTextFile("D://1.pdf", "D://123.txt", "UTF-8", false);
//		File file = new File("d:/1.pdf");
//		PDDocument doc = PDDocument.load(file);
//		int numberOfPages = doc.getNumberOfPages();
//		System.out.println("页数：" + numberOfPages + " ");
//
//		FileOutputStream fos = new FileOutputStream(new File("d:/123.txt"));
//		Writer writer = new OutputStreamWriter(fos, "UTF-8");
//
//		PDFTextStripper pdfTextStripper = new PDFTextStripper();
//		pdfTextStripper.setStartPage(1);
//		pdfTextStripper.setEndPage(1);
//		pdfTextStripper.writeText(doc, writer);
//
//		writer.close();
//		doc.close();
		readPdf();
	}

	public static void createTextFile(String pdfFile, String textFile, String encoding, boolean sort) throws Exception {

		// 开始提取页数
		int startPage = 1;

		// 结束提取页数
		int endPage = Integer.MAX_VALUE;

		// 文件输入流，生成文本文件
		Writer output = null;

		// 内存中存储的PDF Document
		PDDocument document = null;

		try {

			try {

				// 首先当作一个URL来装载文件，如果得到异常再从本地文件系统//去装载文件
				File file = new File(pdfFile);

				document = PDDocument.load(file);

				File outputFile = new File("123" + ".txt");

				textFile = outputFile.getName();

			} catch (MalformedURLException e) {

				System.out.println(e);
			}

			// 文件输入流，写入文件倒textFile
			output = new OutputStreamWriter(new FileOutputStream(textFile), encoding);

			// PDFTextStripper来提取文本
			PDFTextStripper stripper = null;

			stripper = new PDFTextStripper();

			// 设置是否排序
			stripper.setSortByPosition(sort);

			// 设置起始页
			stripper.setStartPage(startPage);

			// 设置结束页
			stripper.setEndPage(endPage);

			// 调用PDFTextStripper的writeText提取并输出文本
			stripper.writeText(document, output);


			output.write("333");

		} finally {

			if (output != null) {

				// 关闭输出流
				output.close();
			}

			if (document != null) {

				// 关闭PDF Document
				document.close();
			}
		}
	}

	public static void readPdf() throws IOException{
		PDDocument document = null;
        try {
            File input = new File("D:\\1.pdf");
            document = PDDocument.load(input);
            PrintTextLocations printer = new PrintTextLocations();
            PDPageTree allPages = document.getDocumentCatalog().getPages();
            for (int i = 0; i < allPages.getCount(); i++) {
                PDPage page = (PDPage) allPages.get(i);
                System.out.println("Processing page: " + i);
            }
        } finally {
            if (document != null) {
                document.close();
            }
        }
	}
	
	void processTextPosition(TextPosition text) {
		System.out.println("String[" + text.getXDirAdj() + "," + text.getYDirAdj() + " fs=" + text.getFontSize()
				+ " xscale=" + text.getXScale() + " height=" + text.getHeightDir() + " space=" + text.getWidthOfSpace()
				+ " width=" + text.getWidthDirAdj() + "]" + text.getCharacterCodes());
	}
}
