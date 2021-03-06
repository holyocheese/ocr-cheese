package com.ocr.dao.client;

import com.ocr.dao.model.OcrBone;
import com.ocr.dao.model.OcrBoneExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "ocrBoneMapper")
public interface OcrBoneMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ocr_bone
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ocr_bone
     *
     * @mbg.generated
     */
    int insert(OcrBone record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ocr_bone
     *
     * @mbg.generated
     */
    int insertSelective(OcrBone record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ocr_bone
     *
     * @mbg.generated
     */
    List<OcrBone> selectByExample(OcrBoneExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ocr_bone
     *
     * @mbg.generated
     */
    OcrBone selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ocr_bone
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") OcrBone record, @Param("example") OcrBoneExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ocr_bone
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") OcrBone record, @Param("example") OcrBoneExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ocr_bone
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(OcrBone record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ocr_bone
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(OcrBone record);
}