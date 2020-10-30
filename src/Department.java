import java.util.ArrayList;

public class Department {
    String DepartmentName, UnitName, UniversityName;
    ArrayList<Faculty> faculty;

    //default constructor
    public Department(){
        this(null,null,null,null);
    }

    //constructor
    public Department(String departmentName, String unitName,
                      String universityName, ArrayList<Faculty> fac){
        DepartmentName = departmentName;
        UnitName = unitName;
        UniversityName = universityName;
        faculty = fac;
    }

    //mutator
    public void setDepartmentName(String departmentName){
        DepartmentName = departmentName;
    }
    public void setUnitName(String unitName){
        UnitName = unitName;
    }
    public void setUniversityName(String universityName){
        UniversityName = universityName;
    }



    //accessor
    public String getDepartmentName(){
        return DepartmentName;
    }
    public String getUnitNames(){
        return UnitName;
    }
    public String getUniversityName(){
        return UniversityName;
    }

    public String toString() {
        return "Department: " + DepartmentName + "\n" +
                "Collage: " + UnitName + "\n" +
                "University: " + UniversityName + "\n" +
                "\t Faculty: " + faculty.toString();
    }
}
