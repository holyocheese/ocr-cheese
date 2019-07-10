package com.ocr.tesseract;

import java.io.File;
import java.io.IOException;

public class FileUtil {

	public static void main( String[] args ) throws IOException{
    	String path = "D:\\cheese python\\osaka\\ou\\img2012\\";
    	File[] allFiles = new File(path).listFiles();
        for (int i = 20; i < allFiles.length; i++) {
        	File file = allFiles[i];
        	file.renameTo(new File(file.getName().substring(0, 4)));
        	
        }
	}
}
