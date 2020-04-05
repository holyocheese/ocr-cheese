package com.ocr.dao.client;

import com.ocr.dao.model.PdfLinedata;
import com.ocr.dao.model.PdfLinedataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PdfLinedataMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pdf_linedata
     *
     * @mbg.generated
     */
    int insert(PdfLinedata record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pdf_linedata
     *
     * @mbg.generated
     */
    int insertSelective(PdfLinedata record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pdf_linedata
     *
     * @mbg.generated
     */
    List<PdfLinedata> selectByExample(PdfLinedataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pdf_linedata
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") PdfLinedata record, @Param("example") PdfLinedataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pdf_linedata
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") PdfLinedata record, @Param("example") PdfLinedataExample example);
}