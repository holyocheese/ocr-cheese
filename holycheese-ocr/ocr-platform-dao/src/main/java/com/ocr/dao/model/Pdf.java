package com.ocr.dao.model;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table pdf
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class Pdf {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pdf.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pdf.file_name
     *
     * @mbg.generated
     */
    private String fileName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pdf.path
     *
     * @mbg.generated
     */
    private String path;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pdf.id
     *
     * @return the value of pdf.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pdf.id
     *
     * @param id the value for pdf.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pdf.file_name
     *
     * @return the value of pdf.file_name
     *
     * @mbg.generated
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pdf.file_name
     *
     * @param fileName the value for pdf.file_name
     *
     * @mbg.generated
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pdf.path
     *
     * @return the value of pdf.path
     *
     * @mbg.generated
     */
    public String getPath() {
        return path;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pdf.path
     *
     * @param path the value for pdf.path
     *
     * @mbg.generated
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }
}