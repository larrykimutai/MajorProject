public class Appointment {

    String Appointment;
    TimeBlock timeblock;

    //default constructor
    public Appointment(){
        this(null, null);
    }

    //constructor
    public Appointment(String apmt, TimeBlock tmblck){
        Appointment = apmt;
        timeblock = tmblck;
    }

    //mutators
    public void setAppointment(String apmt){
        Appointment = apmt;
    }
    public void setTimeblock(TimeBlock tb){
        timeblock = tb;
    }

    //accessors
    public String getAppointment(){
        return Appointment;
    }
    public TimeBlock getTimeblock(){
        return timeblock;
    }

    //return string
    public String toString(){
        return "Appointments: " + Appointment + "\n"
                + "\t TimeBlock: " + timeblock;
    }
}
