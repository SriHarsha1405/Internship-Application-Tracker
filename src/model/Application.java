package model;

import java.sql.Date;

public class Application {
    private int applicationId;
    private int studentId;
    private int internshipId;
    private Date applyDate;
    private String status;

    public Application(int applicationId, int studentId, int internshipId, Date applyDate, String status) {
        this.applicationId = applicationId;
        this.studentId = studentId;
        this.internshipId = internshipId;
        this.applyDate = applyDate;
        this.status = status;
    }

    public Application(int studentId, int internshipId, Date applyDate, String status) {
        this.studentId = studentId;
        this.internshipId = internshipId;
        this.applyDate = applyDate;
        this.status = status;
    }

    public int getApplicationId() { return applicationId; }
    public void setApplicationId(int applicationId) { this.applicationId = applicationId; }
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }
    public int getInternshipId() { return internshipId; }
    public void setInternshipId(int internshipId) { this.internshipId = internshipId; }
    public Date getApplyDate() { return applyDate; }
    public void setApplyDate(Date applyDate) { this.applyDate = applyDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}