package com.ocr.pdfUtil;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class GetWordsAndPositionFromPDF extends PDFTextStripper{
    
    //用来记录，PDF中读到的词
    static List<String> words = new ArrayList<String>();

    public GetWordsAndPositionFromPDF() throws IOException {
        super();
    }
    
    /**
     * 解析PDF文档
     * 从PDF中读取文字以及文字的位置
     */
    public static void main( String[] args ) throws IOException {
        PDDocument document = null;
        String fileName = "C:\\Users\\54329\\Desktop\\data'\\output_1.pdf";
        try {
            document = PDDocument.load( new File(fileName) );
            
            PDFTextStripper stripper = new GetWordsAndPositionFromPDF();
            stripper.setSortByPosition( true );
            stripper.setStartPage( 0 );
            stripper.setEndPage( document.getNumberOfPages() );
            
            Writer dummy = new OutputStreamWriter(new ByteArrayOutputStream());
            stripper.writeText(document, dummy);

            // print words
            for(String word:words){
                System.out.println(word); 
            }
        }
        finally {
            if( document != null ) {
                document.close();
            }
        }
    }
    
    @Override
    protected void writeString(String text) throws IOException{
        String[] wordsInStream = text.split(getWordSeparator());
        if(wordsInStream!=null){
            for(String word :wordsInStream){
                words.add(word);
            }
        }
    }
    

}
