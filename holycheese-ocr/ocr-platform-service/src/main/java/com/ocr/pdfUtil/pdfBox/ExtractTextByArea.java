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

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripperByArea;

/**
 * This is an example on how to extract text from a specific area on the PDF document.
 *
 * @author Ben Litchfield
 */
public final class ExtractTextByArea
{
    private ExtractTextByArea()
    {
        //utility class and should not be constructed.
    }


    /**
     * This will print the documents text in a certain area.
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
        	String path = "D:\\cheese python\\osaka\\ou\\huxi\\0000.pdf";
            try (PDDocument document = PDDocument.load(new File(path)))
            {
                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition( true );
                Rectangle rect = new Rectangle( 204, 217, 14, 6 );
                stripper.addRegion( "class1", rect );
                Rectangle rect1 = new Rectangle( 262, 37, 72, 6 );
                stripper.addRegion( "determination_date", rect1 );//测定日
                PDPage firstPage = document.getPage(0);
                stripper.extractRegions( firstPage );
                System.out.println( "Text in the area:" + rect );
                System.out.println( stripper.getTextForRegion( "class1" ) );
                System.out.println( stripper.getTextForRegion( "determination_date" ) );
            }
        }
    }

    /**
     * This will print the usage for this document.
     */
    private static void usage()
    {
        System.err.println( "Usage: java " + ExtractTextByArea.class.getName() + " <input-pdf>" );
    }

}