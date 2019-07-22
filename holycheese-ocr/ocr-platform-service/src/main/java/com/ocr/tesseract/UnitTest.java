package com.ocr.tesseract;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ocr.OcrApplication;
import com.ocr.dao.client.OcrBoneMapper;
import com.ocr.utils.MsgVo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = OcrApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UnitTest {

	@Autowired
	OcrBoneMapper ocrBoneMapper;
	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private TestRestTemplate restTemplate;

	@Before
	public void before() throws MalformedURLException {
		String url = String.format("http://localhost:%d/", port);
		System.out.println(String.format("port is : [%d]", port));
		this.base = new URL(url);
	}

	//@Test
	public void updatePatientInfor() {
		ResponseEntity<String> response = this.restTemplate
				.getForEntity(this.base.toString() + "/ocrBone/updatePatientInfor", String.class, "");
		System.out.println(String.format("测试结果为：%s", response.getBody()));
	}
	
	//@Test
	public void pDFCuttingController() {
		ResponseEntity<String> response = this.restTemplate
				.getForEntity(this.base.toString() + "/pdfCutting/pdfCutting4ThreePart", String.class, "");
		System.out.println(String.format("测试结果为：%s", response.getBody()));
	}
	
	@Test
	public void breathReportReading() {
		ResponseEntity<MsgVo> response = this.restTemplate
				.getForEntity(this.base.toString() + "/breathReport/reportReading?path=" + "D:\\cheese python\\osaka\\ou\\huxi", 
						MsgVo.class);
		System.out.println(String.format("测试结果为：%s", 	response.getBody().getMessage()));
	}

	public static void main(String[] args) {

	}
}
