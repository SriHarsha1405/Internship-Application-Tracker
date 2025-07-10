package model;

public class Student {
    private int studentId;
    private String name;
    private String email;
    private String phone;
    private String resumeLink;

    public Student(int studentId, String name, String email, String phone, String resumeLink) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.resumeLink = resumeLink;
    }

    public Student(String name, String email, String phone, String resumeLink) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.resumeLink = resumeLink;
    }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getResumeLink() { return resumeLink; }
    public void setResumeLink(String resumeLink) { this.resumeLink = resumeLink; }
}