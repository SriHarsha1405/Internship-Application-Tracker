package model;

public class Internship {
    private int internshipId;
    private String title;
    private String companyName;
    private String location;
    private String duration;
    private String description;

    public Internship(int internshipId, String title, String companyName, String location, String duration, String description) {
        this.internshipId = internshipId;
        this.title = title;
        this.companyName = companyName;
        this.location = location;
        this.duration = duration;
        this.description = description;
    }

    public Internship(String title, String companyName, String location, String duration, String description) {
        this.title = title;
        this.companyName = companyName;
        this.location = location;
        this.duration = duration;
        this.description = description;
    }

    public int getInternshipId() { return internshipId; }
    public void setInternshipId(int internshipId) { this.internshipId = internshipId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}