package com.ocr.dao.client;

import com.ocr.dao.model.BreathReportTabledata;
import com.ocr.dao.model.BreathReportTabledataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BreathReportTabledataMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table breath_report_tabledata
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table breath_report_tabledata
     *
     * @mbg.generated
     */
    int insert(BreathReportTabledata record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table breath_report_tabledata
     *
     * @mbg.generated
     */
    int insertSelective(BreathReportTabledata record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table breath_report_tabledata
     *
     * @mbg.generated
     */
    List<BreathReportTabledata> selectByExample(BreathReportTabledataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table breath_report_tabledata
     *
     * @mbg.generated
     */
    BreathReportTabledata selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table breath_report_tabledata
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") BreathReportTabledata record, @Param("example") BreathReportTabledataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table breath_report_tabledata
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") BreathReportTabledata record, @Param("example") BreathReportTabledataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table breath_report_tabledata
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(BreathReportTabledata record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table breath_report_tabledata
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(BreathReportTabledata record);
}