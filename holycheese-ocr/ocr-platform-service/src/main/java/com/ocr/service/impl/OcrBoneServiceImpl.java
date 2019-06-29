package com.ocr.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocr.dao.client.OcrBoneMapper;
import com.ocr.dao.model.OcrBone;
import com.ocr.dao.model.OcrBoneExample;
import com.ocr.service.OcrBoneService;

@Service
public class OcrBoneServiceImpl implements OcrBoneService{
	
	@Autowired
	OcrBoneMapper ocrBoneMapper;

	@Override
	public void updatePatientInfor() {
		OcrBoneExample example = new OcrBoneExample();
		OcrBoneExample.Criteria criteria = example.createCriteria();
		criteria.andIdGreaterThanOrEqualTo(534);
		List<OcrBone> ocrList = ocrBoneMapper.selectByExample(example);
		for(OcrBone ob:ocrList){
			//这个ID+1的行更新病人ID和性别生日等
			OcrBone ocrBone = ocrBoneMapper.selectByPrimaryKey(ob.getId()+1);
			if(ocrBone!=null&&!StringUtils.isNotEmpty(ocrBone.getPatientId())){
				OcrBone record = new OcrBone();
				record.setPatientId(ob.getPatientId());
				record.setInsertDate(ob.getInsertDate());
				record.setSex(ob.getSex());
				record.setBirthday(ob.getBirthday());
				OcrBoneExample inExample = new OcrBoneExample();
				OcrBoneExample.Criteria inCriteria = inExample.createCriteria();
				inCriteria.andIdEqualTo(ocrBone.getId());
				ocrBoneMapper.updateByExampleSelective(record, inExample);
			}
		}
	}

}
