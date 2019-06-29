package com.ocr.tesseract;

import org.bytedeco.javacpp.*;
import org.bytedeco.leptonica.*;
import org.bytedeco.tesseract.*;
import static org.bytedeco.leptonica.global.lept.*;

public class Example {

	public static void main(String[] args) {
		
		BytePointer outText;

        TessBaseAPI api = new TessBaseAPI();
        if (api.Init("D:/cheese java/ocr/ocr-cheese/holycheese-ocr/ocr-platform-service/src/main/resources/traindata", 
        		"eng") != 0) {
            System.err.println("Could not initialize tesseract.");
            System.exit(1);
        }

        PIX image = pixRead(args.length > 0 ? args[0] : 
        	"D:/cheese java/ocr/ocr-cheese/holycheese-ocr/ocr-platform-service/src/main/resources/pic/7.png");
        api.SetImage(image);
        outText = api.GetUTF8Text();
        System.out.println("-------OCR output--------\n\n" + outText.getString());

        api.End();
        api.close();
        outText.deallocate();
        pixDestroy(image);
	}

}
