package com.ocr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ocr.service.OcrBoneService;

@RestController
@RequestMapping("/ocrBone")
public class SqlController {

	@Autowired
    private OcrBoneService ocrBoneService;
	
	@RequestMapping(value = "/updatePatientInfor", method = RequestMethod.GET)
    public String updatePatientInfor() {
		ocrBoneService.updatePatientInfor();
		return null;
	}
}
