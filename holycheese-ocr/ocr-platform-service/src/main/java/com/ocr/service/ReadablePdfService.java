package com.ocr.service;

import com.ocr.utils.MsgVo;

public interface ReadablePdfService {

	//呼吸报告PDF （目录下所有PDF）
	MsgVo<String> readingPdf4BreathReports(String path);
}
