package com.ocr.dao.client;

import com.ocr.dao.model.OcrBase;
import com.ocr.dao.model.OcrBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OcrBaseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ocr_base
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ocr_base
     *
     * @mbg.generated
     */
    int insert(OcrBase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ocr_base
     *
     * @mbg.generated
     */
    int insertSelective(OcrBase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ocr_base
     *
     * @mbg.generated
     */
    List<OcrBase> selectByExample(OcrBaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ocr_base
     *
     * @mbg.generated
     */
    OcrBase selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ocr_base
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") OcrBase record, @Param("example") OcrBaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ocr_base
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") OcrBase record, @Param("example") OcrBaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ocr_base
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(OcrBase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ocr_base
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(OcrBase record);
}