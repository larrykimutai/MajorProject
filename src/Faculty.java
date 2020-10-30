import com.sun.javafx.binding.StringFormatter;

import java.util.ArrayList;

public class Faculty {
    private String FirstName, LastName, OfficeLocation;
    private ArrayList<Course> Courses;
    private ArrayList<TimeBlock> OfficeHours;
    private ArrayList<Appointment> Appointments;

    //default constructor
    public Faculty(){
        this(null,null,null,null,null,null);
    }
    //constructor
    public Faculty(String firstname, String lastname, String officelocation, ArrayList courses,
                   ArrayList officehours, ArrayList appointments){
        FirstName = firstname;
        LastName = lastname;
        OfficeLocation = officelocation;
        Courses = courses;
        OfficeHours = officehours;
        Appointments = appointments;

    }

    //mutators
    public void setFirstName(String firstName){
        FirstName = firstName;
    }
    public void setLastName(String lastName){
        LastName = lastName;
    }
    public void setOfficeLocation(String officeLocation){
        OfficeLocation = officeLocation;
    }
    public void setCourses(ArrayList courses){
        Courses = courses;
    }
    public void setOfficeHours(ArrayList officeHours){
        OfficeHours = OfficeHours;
    }
    public void setAppointments(ArrayList appointments){
        Appointments = appointments;
    }

    //accessors
    public String getFirstName(){
        return FirstName;
    }
    public String getLastName(){
        return LastName;
    }
    public String getOfficeLocation(){
        return OfficeLocation;
    }

    //format and return string
    public String toString(){
        String lastNFirstN = String.format(LastName, FirstName);
        return FirstName + " " + LastName + "\n" +
                "\t Office Location: " + OfficeLocation + "\n"
                + "\t Office hours: " + OfficeHours + "\n"
                + "\t Appointmetns: " + Appointments + "\n"
                + "\t Courses: " + Courses;
    }
}
