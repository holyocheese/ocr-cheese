package com.ocr.dao.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table ocr_base
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class OcrBase {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ocr_base.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ocr_base.file_name
     *
     * @mbg.generated
     */
    private String fileName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ocr_base.title
     *
     * @mbg.generated
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ocr_base.patient_name
     *
     * @mbg.generated
     */
    private String patientName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ocr_base.patient_id
     *
     * @mbg.generated
     */
    private String patientId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ocr_base.sex
     *
     * @mbg.generated
     */
    private String sex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ocr_base.height
     *
     * @mbg.generated
     */
    private BigDecimal height;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ocr_base.ethnicity
     *
     * @mbg.generated
     */
    private String ethnicity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ocr_base.weight
     *
     * @mbg.generated
     */
    private BigDecimal weight;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ocr_base.birthday
     *
     * @mbg.generated
     */
    private Date birthday;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ocr_base.age
     *
     * @mbg.generated
     */
    private Integer age;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ocr_base.file_year
     *
     * @mbg.generated
     */
    private Integer fileYear;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ocr_base.id
     *
     * @return the value of ocr_base.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ocr_base.id
     *
     * @param id the value for ocr_base.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ocr_base.file_name
     *
     * @return the value of ocr_base.file_name
     *
     * @mbg.generated
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ocr_base.file_name
     *
     * @param fileName the value for ocr_base.file_name
     *
     * @mbg.generated
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ocr_base.title
     *
     * @return the value of ocr_base.title
     *
     * @mbg.generated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ocr_base.title
     *
     * @param title the value for ocr_base.title
     *
     * @mbg.generated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ocr_base.patient_name
     *
     * @return the value of ocr_base.patient_name
     *
     * @mbg.generated
     */
    public String getPatientName() {
        return patientName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ocr_base.patient_name
     *
     * @param patientName the value for ocr_base.patient_name
     *
     * @mbg.generated
     */
    public void setPatientName(String patientName) {
        this.patientName = patientName == null ? null : patientName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ocr_base.patient_id
     *
     * @return the value of ocr_base.patient_id
     *
     * @mbg.generated
     */
    public String getPatientId() {
        return patientId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ocr_base.patient_id
     *
     * @param patientId the value for ocr_base.patient_id
     *
     * @mbg.generated
     */
    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ocr_base.sex
     *
     * @return the value of ocr_base.sex
     *
     * @mbg.generated
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ocr_base.sex
     *
     * @param sex the value for ocr_base.sex
     *
     * @mbg.generated
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ocr_base.height
     *
     * @return the value of ocr_base.height
     *
     * @mbg.generated
     */
    public BigDecimal getHeight() {
        return height;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ocr_base.height
     *
     * @param height the value for ocr_base.height
     *
     * @mbg.generated
     */
    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ocr_base.ethnicity
     *
     * @return the value of ocr_base.ethnicity
     *
     * @mbg.generated
     */
    public String getEthnicity() {
        return ethnicity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ocr_base.ethnicity
     *
     * @param ethnicity the value for ocr_base.ethnicity
     *
     * @mbg.generated
     */
    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity == null ? null : ethnicity.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ocr_base.weight
     *
     * @return the value of ocr_base.weight
     *
     * @mbg.generated
     */
    public BigDecimal getWeight() {
        return weight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ocr_base.weight
     *
     * @param weight the value for ocr_base.weight
     *
     * @mbg.generated
     */
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ocr_base.birthday
     *
     * @return the value of ocr_base.birthday
     *
     * @mbg.generated
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ocr_base.birthday
     *
     * @param birthday the value for ocr_base.birthday
     *
     * @mbg.generated
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ocr_base.age
     *
     * @return the value of ocr_base.age
     *
     * @mbg.generated
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ocr_base.age
     *
     * @param age the value for ocr_base.age
     *
     * @mbg.generated
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ocr_base.file_year
     *
     * @return the value of ocr_base.file_year
     *
     * @mbg.generated
     */
    public Integer getFileYear() {
        return fileYear;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ocr_base.file_year
     *
     * @param fileYear the value for ocr_base.file_year
     *
     * @mbg.generated
     */
    public void setFileYear(Integer fileYear) {
        this.fileYear = fileYear;
    }
}