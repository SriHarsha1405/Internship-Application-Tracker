import dao.*;
import model.*;

import java.sql.Date;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO();
        InternshipDAO internshipDAO = new InternshipDAO();
        ApplicationDAO applicationDAO = new ApplicationDAO();

        while (true) {
            System.out.println("\n👋 Welcome to Internship Application Tracker");
            System.out.println("Select Role:");
            System.out.println("1. Student");
            System.out.println("2. Admin");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            int roleChoice = sc.nextInt();
            sc.nextLine();

            switch (roleChoice) {
                case 1:
                    while (true) {
                        System.out.println("\n📘 Student Menu");
                        System.out.println("1. Register as Student");
                        System.out.println("2. View All Internships");
                        System.out.println("3. Apply to Internship");
                        System.out.println("4. View My Applications");
                        System.out.println("5. Back to Main Menu");
                        System.out.print("Choose option: ");
                        int studentChoice = sc.nextInt();
                        sc.nextLine();

                        switch (studentChoice) {
                            case 1:
                                System.out.print("Name: ");
                                String name = sc.nextLine();
                                System.out.print("Email: ");
                                String email = sc.nextLine();
                                System.out.print("Phone: ");
                                String phone = sc.nextLine();
                                System.out.print("Resume Link: ");
                                String resume = sc.nextLine();
                                Student student = new Student(name, email, phone, resume);
                                studentDAO.addStudent(student);
                                break;
                            case 2:
                                List<Internship> internships = internshipDAO.getAllInternships();
                                System.out.println("\nAvailable Internships:");
                                for (Internship i : internships) {
                                    System.out.println("ID: " + i.getInternshipId() +
                                            " | Title: " + i.getTitle() +
                                            " | Company: " + i.getCompanyName());
                                }
                                break;
                            case 3:
                                System.out.print("Enter your Student ID: ");
                                int studentId = sc.nextInt();
                                System.out.print("Enter Internship ID to apply: ");
                                int internshipId = sc.nextInt();
                                Date today = new Date(System.currentTimeMillis());
                                Application app = new Application(studentId, internshipId, today, "Applied");
                                applicationDAO.applyToInternship(app);
                                break;
                            case 4:
                                System.out.print("Enter your Student ID: ");
                                int sid = sc.nextInt();
                                List<Application> apps = applicationDAO.getApplicationsByStudent(sid);
                                System.out.println("\nYour Applications:");
                                for (Application a : apps) {
                                    System.out.println("Application ID: " + a.getApplicationId() +
                                            " | Internship ID: " + a.getInternshipId() +
                                            " | Date: " + a.getApplyDate() +
                                            " | Status: " + a.getStatus());
                                }
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("❌ Invalid option!");
                        }
                        if (studentChoice == 5) break;
                    }
                    break;

                case 2:
                    while (true) {
                        System.out.println("\n🛠️ Admin Menu");
                        System.out.println("1. Add Internship");
                        System.out.println("2. View All Applications (by Student ID)");
                        System.out.println("3. Update Application Status");
                        System.out.println("4. Back to Main Menu");
                        System.out.print("Choose option: ");
                        int adminChoice = sc.nextInt();
                        sc.nextLine();

                        switch (adminChoice) {
                            case 1:
                                System.out.print("Title: ");
                                String title = sc.nextLine();
                                System.out.print("Company: ");
                                String company = sc.nextLine();
                                System.out.print("Location: ");
                                String location = sc.nextLine();
                                System.out.print("Duration: ");
                                String duration = sc.nextLine();
                                System.out.print("Description: ");
                                String desc = sc.nextLine();
                                Internship internship = new Internship(title, company, location, duration, desc);
                                internshipDAO.addInternship(internship);
                                break;
                            case 2:
                                System.out.print("Enter Student ID: ");
                                int sid = sc.nextInt();
                                List<Application> apps = applicationDAO.getApplicationsByStudent(sid);
                                System.out.println("\nApplications by Student " + sid + ":");
                                for (Application a : apps) {
                                    System.out.println("Application ID: " + a.getApplicationId() +
                                            " | Internship ID: " + a.getInternshipId() +
                                            " | Date: " + a.getApplyDate() +
                                            " | Status: " + a.getStatus());
                                }
                                break;
                            case 3:
                                System.out.print("Enter Application ID: ");
                                int appId = sc.nextInt();
                                sc.nextLine();
                                System.out.print("Enter new status (e.g., Accepted, Rejected): ");
                                String newStatus = sc.nextLine();
                                applicationDAO.updateApplicationStatus(appId, newStatus);
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("❌ Invalid option!");
                        }
                        if (adminChoice == 4) break;
                    }
                    break;

                case 3:
                    System.out.println("👋 Exiting... Thank you!");
                    return;

                default:
                    System.out.println("❌ Invalid role selection!");
            }
        }
    }
}