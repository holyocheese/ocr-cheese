package com.ocr;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Stack;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfLayer;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;


public class Test {

	 public static void main(String[] args) throws IOException, DocumentException {

		PdfReader pdfReader = new PdfReader("D:/cheese python/huxi2/0test.pdf");
	    PdfStamper stamper = new PdfStamper(pdfReader, new FileOutputStream("D:/cheese python/huxi2/0test.pdf"));

	    Map<String, PdfLayer> layers = stamper.getPdfLayers();
	    for(String layer: layers.keySet()) {
	            System.out.println(layer);
	        }

	    stamper.close();

    }

}
