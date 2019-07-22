package com.ocr.service.impl;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocr.dao.client.BreathReportMapper;
import com.ocr.dao.client.BreathReportTabledataMapper;
import com.ocr.dao.model.BreathReport;
import com.ocr.dao.model.BreathReportTabledata;
import com.ocr.service.ReadablePdfService;
import com.ocr.utils.MsgVo;

@Service
public class ReadablePdfServiceImpl implements ReadablePdfService {

	@Autowired
	private BreathReportMapper breathReportMapper;
	@Autowired
	private BreathReportTabledataMapper breathReportTabledataMapper;

	@Override
	public MsgVo<String> readingPdf4BreathReports(String path) {
		MsgVo<String> msg = new MsgVo<String>();
		File dirfile = new File(path);
		if (dirfile.exists() && dirfile.isDirectory()) {
			String[] filelist = dirfile.list();
			for (int i = 0; i < filelist.length; i++) {
				// 目标路径
				File readfile = new File(path + "\\" + filelist[i]);
				if (!readfile.isDirectory()) {
					String fileType = filelist[i].substring(filelist[i].lastIndexOf("."), filelist[i].length());
					String fileName = filelist[i].substring(0, filelist[i].lastIndexOf("."));
					if (fileType.indexOf("pd") >= 0) {// pdf
						BreathReport breathReport = readIntoBreathObject(path, fileName);
						breathReport.setCraeteTime(new Date());
						breathReportMapper.insert(breathReport);
						List<BreathReportTabledata> breathReportTabledataList = readIntoBreathTableObject(path, fileName);
						for(BreathReportTabledata item : breathReportTabledataList){
							item.setBreathReportId(breathReport.getId());
							item.setCreateTime(new Date());
							breathReportTabledataMapper.insertSelective(item);
						}
					} else {
						continue;
					}
				} else if (readfile.isDirectory()) {
					continue;
				}
			}
		} else {
			msg.setMessage("Path is not exist");
		}
		return msg;
	}

	private BreathReport readIntoBreathObject(String dirpath, String fileName) {
		BreathReport breathReport = new BreathReport();
		breathReport.setFileName(fileName);// 文件名
		// 路径可能有日语 要先转换
		PDDocument document;
		try {
			String originFileName = fileName;
			File file = new File(dirpath + "\\" + fileName + ".pdf");
			String newPath = dirpath + "\\" + file.getName().substring(0, 4) + ".pdf";
			file.renameTo(new File(newPath));// 重命名
			file.renameTo(new File(dirpath + "\\" + originFileName + ".pdf"));// 改回去 
			document = PDDocument.load(new File(newPath));
			PDFTextStripperByArea stripper = new PDFTextStripperByArea();
			stripper.setSortByPosition(true);
			Rectangle rect = new Rectangle(262, 37, 72, 6);
			stripper.addRegion("determination_date", rect);// 测定日
			Rectangle rect1 = new Rectangle(283, 50, 20, 6);
			stripper.addRegion("temperature", rect1);// 温度
			Rectangle rect2 = new Rectangle(374, 52, 15, 6);
			stripper.addRegion("humidity", rect2);// 湿度
			Rectangle rect3 = new Rectangle(443, 52, 13, 6);
			stripper.addRegion("pressure", rect3);// 湿度
			Rectangle rect4 = new Rectangle(286, 65, 9, 7);
			stripper.addRegion("age", rect4);// 年龄
			Rectangle rect5 = new Rectangle(370, 80, 18, 6);
			stripper.addRegion("weight", rect5);// 体重
			Rectangle rect6 = new Rectangle(456, 80, 14, 7);
			stripper.addRegion("BSA", rect6);// BSA
			Rectangle rect7 = new Rectangle(405, 108, 40, 7);
			stripper.addRegion("determination_type", rect7);// 检查种类
			Rectangle rect8 = new Rectangle(276, 80, 18, 7);
			stripper.addRegion("height", rect8);// 身高
			Rectangle rect9 = new Rectangle(378, 66, 11, 7);
			stripper.addRegion("sex", rect9);// 性别
			Rectangle rect10 = new Rectangle(210, 108, 50, 7);
			stripper.addRegion("building", rect10);// building
			PDPage firstPage = document.getPage(0);
			stripper.extractRegions(firstPage);
			try {
				String temperature = stripper.getTextForRegion("temperature");
				temperature = temperature.substring(0, temperature.indexOf("°")).trim();
				breathReport.setTemperature(new BigDecimal(temperature));
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				String humidity = stripper.getTextForRegion("humidity");
				if (humidity.indexOf("\r") >= 0) {
					humidity = humidity.substring(0, humidity.indexOf("\r"));
				}
				breathReport.setHumidity(new BigDecimal(humidity));
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				String pressure = stripper.getTextForRegion("pressure");
				if (pressure.indexOf("\r") >= 0) {
					pressure = pressure.substring(0, pressure.indexOf("\r")).trim();
				}
				breathReport.setPressure(new BigDecimal(pressure));
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				String weight = stripper.getTextForRegion("weight");
				if (weight.indexOf("\r") >= 0) {
					weight = weight.substring(0, weight.indexOf("\r")).trim();
				}
				breathReport.setWeight(new BigDecimal(weight));
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				String age = stripper.getTextForRegion("age");
				if (age.indexOf("\r") >= 0) {
					age = age.substring(0, age.indexOf("\r")).trim();
				}
				breathReport.setAge(Integer.parseInt(age));
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				String BSA = stripper.getTextForRegion("BSA");
				if (BSA.indexOf("\r") >= 0) {
					BSA = BSA.substring(0, BSA.indexOf("\r")).trim();
				}
				breathReport.setBsa(new BigDecimal(BSA));
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				String height = stripper.getTextForRegion("height");
				if (height.indexOf("\r") >= 0) {
					height = height.substring(0, height.indexOf("\r")).trim();
				}
				breathReport.setHeight(new BigDecimal(height));
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				String sex = stripper.getTextForRegion("sex");
				if (sex.indexOf("\r") >= 0) {
					sex = sex.substring(0, sex.indexOf("\r")).trim();
				}
				breathReport.setSex(sex);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				breathReport.setDeterminationType(stripper.getTextForRegion("determination_type"));
				breathReport.setBuilding(stripper.getTextForRegion("building"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Text in the area:" + rect);
			System.out.println(stripper.getTextForRegion("determination_date"));
		} catch (InvalidPasswordException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return breathReport;
	}

	private List<BreathReportTabledata> readIntoBreathTableObject(String dirpath, String fileName) {
		List<BreathReportTabledata> returnList = new ArrayList<BreathReportTabledata>();
		PDDocument document;
		try {
			File file = new File(dirpath + "\\" + fileName + ".pdf");
			String newPath = dirpath + "\\" + file.getName().substring(0, 4) + ".pdf";
			file.renameTo(new File(newPath));// 重命名
			document = PDDocument.load(new File(newPath));
			file.renameTo(new File(dirpath + "\\" + fileName + ".pdf"));// 改回去
			PDFTextStripperByArea stripper = new PDFTextStripperByArea();
			stripper.setSortByPosition(true);
			Integer yBegin = 217;
			Integer xBegin = 102;
			//
			for(int y = 0;y<10;y++){
				yBegin += y * 13;
				Rectangle rect = new Rectangle(1, yBegin, 55, 6);
				stripper.addRegion("line"+y, rect);// 行名
				for(int x=0;x<4;x++){
					xBegin += x * 35;
					Rectangle rect2 = new Rectangle(xBegin, yBegin, 22, 6);
					stripper.addRegion("column"+y+x, rect2);// 测定日
					xBegin = 102;
				}
				yBegin = 217;
			}
			for(int y = 0;y<10;y++){
				PDPage firstPage = document.getPage(0);
				stripper.extractRegions(firstPage);
				BreathReportTabledata breathReportTabledata = new BreathReportTabledata();
				breathReportTabledata.setGroupName("flow_volume");
				String columnName = stripper.getTextForRegion("line"+y);
				if(columnName.indexOf("^")>0){
					columnName = columnName.substring(0,columnName.indexOf("^"));
				}
				if(columnName.indexOf("__")>0){
					columnName = columnName.substring(0,columnName.indexOf("__"));
				}
				if(columnName.indexOf("I.O")>0){
					columnName = columnName.replace("I.O","1.0");
				}
				breathReportTabledata.setColumnName(columnName);
				for(int x=0;x<4;x++){
					if(x==0){
						try {
							String prediction = stripper.getTextForRegion("column"+y+x);
							if (prediction.indexOf("\r") >= 0) {
								prediction = prediction.substring(0, prediction.indexOf("\r"));
							}
							if (StringUtils.isNotEmpty(prediction)){
								breathReportTabledata.setPrediction(new BigDecimal(prediction));
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					if(x==1){
						try {
							String actual = stripper.getTextForRegion("column"+y+x);
							if (actual.indexOf("\r") >= 0) {
								actual = actual.substring(0, actual.indexOf("\r"));
							}
							if (StringUtils.isNotEmpty(actual)){
								breathReportTabledata.setActual(new BigDecimal(actual));
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					if(x==2){
						try {
							String percentage = stripper.getTextForRegion("column"+y+x);
							if (percentage.indexOf("\r") >= 0) {
								percentage = percentage.substring(0, percentage.indexOf("\r"));
							}
							if (StringUtils.isNotEmpty(percentage)){
								breathReportTabledata.setPercentage(new BigDecimal(percentage));
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					if(x==3){
						try {
							String unit = stripper.getTextForRegion("column"+y+x);
							if(unit.indexOf("し")>=0){
								unit = unit.replace("し", "L");
							}
							unit.replace("し", "L");
							breathReportTabledata.setUnit(unit);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					
				}
				returnList.add(breathReportTabledata);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return returnList;
	}
}
