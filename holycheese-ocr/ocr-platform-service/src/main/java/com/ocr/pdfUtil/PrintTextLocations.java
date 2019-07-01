package com.ocr.pdfUtil;

import java.io.*;

import org.apache.commons.collections.CollectionUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.IOException;
import java.util.List;

public class PrintTextLocations extends PDFTextStripper {

    public PrintTextLocations() throws IOException {
        super.setSortByPosition(true);
    }

    public static void main(String[] args) throws Exception {
    	 String formTemplate = "C:\\Users\\54329\\Desktop\\data'\\output_2.pdf"; 
         PDDocument pdfDocument = PDDocument.load(new File(formTemplate)); 
         PDDocumentCatalog docCatalog = pdfDocument.getDocumentCatalog(); 
         PDAcroForm acroForm = docCatalog.getAcroForm(); 
         List<PDField> fieldList = acroForm.getFields();
         if (CollectionUtils.isNotEmpty(fieldList)) { 
        	 for(PDField f:fieldList){
        		 List<PDAnnotationWidget> pda = f.getWidgets();
                 for(PDAnnotationWidget pf:pda){
					PDRectangle r = pf.getRectangle();
					System.out.println(f.getFullyQualifiedName());
					System.out.println(r.getLowerLeftX());
					System.out.println(r.getLowerLeftY());
					System.out.println(r.getUpperRightX());
					System.out.println(r.getUpperRightY());
                 }
        	 }
         } 
    }
}
