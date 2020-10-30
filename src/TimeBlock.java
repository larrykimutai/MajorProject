public class TimeBlock {

    enum DaysOfWeek{
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
    }
    private DaysOfWeek Day;
    private int StartTime, EndTime;
    private String Comments, Locations;

    //default constructor
    public TimeBlock(){
        this(null,0,0,null,null);
    }

    //constructor
    public TimeBlock(DaysOfWeek day, int startTime, int endTime,
                     String comments, String locations){
        Day = day;
        StartTime = startTime;
        EndTime = endTime;
        Comments = comments;
        Locations = locations;
    }

    //mutators
    public void setDay(){

    }
    public void setStartTime(int startTime){
        StartTime = startTime;
    }
    public void setEndTime(int endTime){
        EndTime = endTime;
    }
    public void setComments(String comments){
        Comments = comments;
    }
    public void setLocations(String locations){
        Locations = locations;
    }



    //accessors
    public DaysOfWeek getDay(){
        return Day;
    }
    public int getStartTime(){
        return StartTime;
    }
    public int getEndTime(){
        return EndTime;
    }
    public String getComments(){
        return Comments;
    }
    public String getLocations(){
        return Locations;
    }

    //return string in specific format
    public String getFormatedTimeBlock(){
        return StartTime + " - " + EndTime + " " + Comments + " " + Locations;
    }

    //return string
    public String toString(){
        return Day.toString() + ", " + StartTime + ", " + EndTime + "\n";
    }

}
