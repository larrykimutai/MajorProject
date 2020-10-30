import java.util.ArrayList;
import java.util.List;

public class Course {
    String CourseName, Location;
    ArrayList<TimeBlock> timeBlock = new ArrayList<TimeBlock>();


    //default constructor
    public Course(){
        this(null,null, null);
    }

    //constructor
    public Course(String courseName, String location, ArrayList tmblck){
        CourseName = courseName;
        Location = location;
        timeBlock = tmblck;
    }

    //mutators
    public void setCourseName(String courseName){
        CourseName = courseName;
    }
    public void setLocation(String location){
        Location = location;
    }
    public void setTimeBlock(ArrayList timeblock){
        timeBlock = timeblock;
    }


    //accessors
    public String getCourseName(){
        return CourseName;
    }
    public String getLocation(){
        return Location;
    }
    public ArrayList gettimeBLock(){
        return timeBlock;
    }


    //TimeBlock Array methods

    //mutator method(arraylist length)
    //get courses time(start and end), and day of week
    public void setTimeBlock(int i, int time){
        //timeBlock.get()
    }

    //return string
    public String toString(){
        return "Course Name: " + CourseName + "\n"
                + "Course Location: " + Location + "\n"
                + "\t Course TimeBLock: " + timeBlock;
    }
}
