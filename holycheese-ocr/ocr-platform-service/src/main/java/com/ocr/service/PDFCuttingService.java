package com.ocr.service;

public interface PDFCuttingService {

	//单张椎体pdf切割 返回文件夹路径
	public String cutting4spine(String path);
	
	//腿骨pdf切割 返回文件夹路径
	public String cutting4hip(String path);
	
}
