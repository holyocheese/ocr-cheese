package com.ocr.tesseract;

import static org.bytedeco.leptonica.global.lept.pixDestroy;
import static org.bytedeco.leptonica.global.lept.pixRead;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.leptonica.PIX;
import org.bytedeco.tesseract.TessBaseAPI;
import org.bytedeco.tesseract.TessProgressFunc;
import org.bytedeco.tesseract.TessResultRenderer;

public class TessExample {

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		BytePointer outText;

        TessBaseAPI api = new TessBaseAPI();
        if (api.Init("D:/cheese java/ocr/ocr-cheese/holycheese-ocr/ocr-platform-service/src/main/resources/traindata", 
        		"eng") != 0) {
            System.err.println("Could not initialize tesseract.");
            System.exit(1);
        }

        String path = "D:\\cheese python\\osaka\\ou\\img2012\\0000\\index1-0.jpg";
        PIX image = pixRead(args.length > 0 ? args[0] : 
        	URLDecoder.decode(path,"UTF-8"));
        api.SetImage(image);
        outText = api.GetUTF8Text();
        String result = outText.getString().replaceAll(": ", ":");
        //String[] resultArray = result.split(" |\\n");
        String[] resultArray = result.split(" |\\n|:");
        System.out.println("-------OCR output--------\n\n" + outText.getString());

        api.End();
        api.close();
        outText.deallocate();
        pixDestroy(image);
	}
	
	public String tess4eng(String imagePath){
		BytePointer outText;

        TessBaseAPI api = new TessBaseAPI();
        if (api.Init("D:/cheese java/ocr/ocr-cheese/holycheese-ocr/ocr-platform-service/src/main/resources/traindata", 
        		"eng") != 0) {
            System.err.println("Could not initialize tesseract.");
            System.exit(1);
        }

        PIX image = pixRead(imagePath);
        api.SetImage(image);
        outText = api.GetUTF8Text();
        String result = outText.getString().replaceAll(": ", ":");
        String[] resultArray = result.split(" |\\n");
        System.out.println("-------OCR output--------\n\n" + outText.getString());
        api.End();
        api.close();
        outText.deallocate();
        pixDestroy(image);
        return result;
	}
	
	public static void image2pdf(){
		BytePointer outText;

        TessBaseAPI api = new TessBaseAPI();
        if (api.Init("D:/cheese java/ocr/ocr-cheese/holycheese-ocr/ocr-platform-service/src/main/resources/traindata", 
        		"eng") != 0) {
            System.err.println("Could not initialize tesseract.");
            System.exit(1);
        }

        PIX image = pixRead("D:\\2-0.pdf");
        api.SetImage(image);
        outText = api.GetUTF8Text();
		TessResultRenderer pdfRender = new TessResultRenderer();
        api.ProcessPage(image, 0, "123.pdf", null, 0, pdfRender);
	}

}
