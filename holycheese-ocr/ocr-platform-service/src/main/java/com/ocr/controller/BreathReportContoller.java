package com.ocr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ocr.service.ReadablePdfService;
import com.ocr.utils.MsgVo;

@RestController
@RequestMapping("/breathReport")
public class BreathReportContoller {
	
	@Autowired
	private ReadablePdfService readablePdfService;

	@RequestMapping(value = "/reportReading", method = RequestMethod.GET)
    public MsgVo<String> pdfCutting4HeadPart(@RequestParam String path) {
		return readablePdfService.readingPdf4BreathReports(path);
	}
}
