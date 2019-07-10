package com.ocr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ocr.service.OcrBoneService;
import com.ocr.service.PDFCuttingService;

@RestController
@RequestMapping("/pdfCutting")
public class PDFCuttingController {
	
	@Autowired
    private PDFCuttingService pDFCuttingService;
	
	@RequestMapping(value = "/pdfCutting4ThreePart", method = RequestMethod.GET)
    public String pdfCutting4HeadPart(@RequestParam String path) {
		pDFCuttingService.readAndSave4head(path);
		return null;
	}
}
