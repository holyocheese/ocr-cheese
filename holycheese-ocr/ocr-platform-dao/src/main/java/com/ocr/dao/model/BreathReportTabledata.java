package com.ocr.dao.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table breath_report_tabledata
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class BreathReportTabledata {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column breath_report_tabledata.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column breath_report_tabledata.breath_report_id
     *
     * @mbg.generated
     */
    private Integer breathReportId;

    /**
     * Database Column Remarks:
     *   预测
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column breath_report_tabledata.prediction
     *
     * @mbg.generated
     */
    private BigDecimal prediction;

    /**
     * Database Column Remarks:
     *   实测
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column breath_report_tabledata.actual
     *
     * @mbg.generated
     */
    private BigDecimal actual;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column breath_report_tabledata.percentage
     *
     * @mbg.generated
     */
    private BigDecimal percentage;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column breath_report_tabledata.unit
     *
     * @mbg.generated
     */
    private String unit;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column breath_report_tabledata.column_name
     *
     * @mbg.generated
     */
    private String columnName;

    /**
     * Database Column Remarks:
     *   三个表格分组
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column breath_report_tabledata.group_name
     *
     * @mbg.generated
     */
    private String groupName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column breath_report_tabledata.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column breath_report_tabledata.id
     *
     * @return the value of breath_report_tabledata.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column breath_report_tabledata.id
     *
     * @param id the value for breath_report_tabledata.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column breath_report_tabledata.breath_report_id
     *
     * @return the value of breath_report_tabledata.breath_report_id
     *
     * @mbg.generated
     */
    public Integer getBreathReportId() {
        return breathReportId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column breath_report_tabledata.breath_report_id
     *
     * @param breathReportId the value for breath_report_tabledata.breath_report_id
     *
     * @mbg.generated
     */
    public void setBreathReportId(Integer breathReportId) {
        this.breathReportId = breathReportId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column breath_report_tabledata.prediction
     *
     * @return the value of breath_report_tabledata.prediction
     *
     * @mbg.generated
     */
    public BigDecimal getPrediction() {
        return prediction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column breath_report_tabledata.prediction
     *
     * @param prediction the value for breath_report_tabledata.prediction
     *
     * @mbg.generated
     */
    public void setPrediction(BigDecimal prediction) {
        this.prediction = prediction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column breath_report_tabledata.actual
     *
     * @return the value of breath_report_tabledata.actual
     *
     * @mbg.generated
     */
    public BigDecimal getActual() {
        return actual;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column breath_report_tabledata.actual
     *
     * @param actual the value for breath_report_tabledata.actual
     *
     * @mbg.generated
     */
    public void setActual(BigDecimal actual) {
        this.actual = actual;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column breath_report_tabledata.percentage
     *
     * @return the value of breath_report_tabledata.percentage
     *
     * @mbg.generated
     */
    public BigDecimal getPercentage() {
        return percentage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column breath_report_tabledata.percentage
     *
     * @param percentage the value for breath_report_tabledata.percentage
     *
     * @mbg.generated
     */
    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column breath_report_tabledata.unit
     *
     * @return the value of breath_report_tabledata.unit
     *
     * @mbg.generated
     */
    public String getUnit() {
        return unit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column breath_report_tabledata.unit
     *
     * @param unit the value for breath_report_tabledata.unit
     *
     * @mbg.generated
     */
    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column breath_report_tabledata.column_name
     *
     * @return the value of breath_report_tabledata.column_name
     *
     * @mbg.generated
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column breath_report_tabledata.column_name
     *
     * @param columnName the value for breath_report_tabledata.column_name
     *
     * @mbg.generated
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName == null ? null : columnName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column breath_report_tabledata.group_name
     *
     * @return the value of breath_report_tabledata.group_name
     *
     * @mbg.generated
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column breath_report_tabledata.group_name
     *
     * @param groupName the value for breath_report_tabledata.group_name
     *
     * @mbg.generated
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column breath_report_tabledata.create_time
     *
     * @return the value of breath_report_tabledata.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column breath_report_tabledata.create_time
     *
     * @param createTime the value for breath_report_tabledata.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}