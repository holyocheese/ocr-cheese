/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ocr.pdfUtil.pdfBox;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

/**
 * This is an example on how to get some x/y coordinates of text.
 *
 * @author Ben Litchfield
 */
public class PrintTextLocations extends PDFTextStripper
{
    /**
     * Instantiate a new PDFTextStripper object.
     *
     * @throws IOException If there is an error loading the properties.
     */
    public PrintTextLocations() throws IOException
    {
    }

    /**
     * This will print the documents data.
     *
     * @param args The command line arguments.
     *
     * @throws IOException If there is an error parsing the document.
     */
    public static void main( String[] args ) throws IOException
    {
        if( args.length != 0 )
        {
            usage();
        }
        else
        {
            try (PDDocument document = PDDocument.load(new File("D:\\cheese python\\huxi\\0001_M004k004_呼吸機能検査_170707_システム_呼吸記録検査報告書_1.pdf")))
        	//try (PDDocument document = PDDocument.load(new File("D:\\cheese python\\10.1.1.148.349.pdf")))
            {
                PDFTextStripper stripper = new PrintTextLocations();
                stripper.setSortByPosition( true );
                stripper.setStartPage( 0 );
                stripper.setEndPage( document.getNumberOfPages() );

                Writer dummy = new OutputStreamWriter(new ByteArrayOutputStream());
                stripper.writeText(document, dummy);
                //System.out.println(stripper.getText(document));
                for (int p = 1; p <= 1; ++p){
                	String text = stripper.getText(document);
                    String pageStr = String.format("page %d:", p);
                     System.out.println(pageStr);
                    for (int i = 0; i < pageStr.length(); ++i)
                    {
                    System.out.print("-");
                    }
                    System.out.println();
                    System.out.println(text.trim());
                    System.out.println();
                }
            }
        }
    }

    /**
     * Override the default functionality of PDFTextStripper.
     */
    @Override
    protected void writeString(String string, List<TextPosition> textPositions) throws IOException
    {
    	float lastTextY = Float.parseFloat("0.00");
    	float lastLineY = Float.parseFloat("0.00");
        for (TextPosition text : textPositions)
        {
        	lastTextY = text.getYDirAdj();
        	lastLineY = text.getYDirAdj();
        	//读取
            System.out.println( "String[" + text.getXDirAdj() + "," +
                    text.getYDirAdj() + " fs=" + text.getFontSize() + " xscale=" +
                    text.getXScale() + " height=" + text.getHeightDir() + " space=" +
                    text.getWidthOfSpace() + " width=" +
                    text.getWidthDirAdj() + "]" + text.getUnicode() );
        }
    }
    
    /**
     * This will print the usage for this document.
     */
    private static void usage()
    {
        System.err.println( "Usage: java " + PrintTextLocations.class.getName() + " <input-pdf>" );
    }
}