import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import javax.swing.JFileChooser;

import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Time;
import java.util.*;

import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Main extends Application {

    //creat static member variable
    static Department department1;


    static ArrayList<TimeBlock> timeBlock_officeHrs = new ArrayList<TimeBlock>();
    static ArrayList<TimeBlock> timeBlock_appointments = new ArrayList<TimeBlock>();
    static Appointment appointment = new Appointment();
    static ArrayList<Appointment> Appointment = new ArrayList<Appointment>();
    static ArrayList<Course> CourseFact1 = new ArrayList<Course>();
    static Course Course1 = new Course();
    static Course Course2 = new Course();
    static Course Course3 = new Course();
    static Course Course4 = new Course();
    static ArrayList<TimeBlock> timeblock1 = new ArrayList<TimeBlock>();
    static ArrayList<TimeBlock> timeblock2 = new ArrayList<TimeBlock>();
    static ArrayList<TimeBlock> timeblock3 = new ArrayList<TimeBlock>();
    static ArrayList<TimeBlock> timeblock4 = new ArrayList<TimeBlock>();
    static ArrayList<Course> Course1array = new ArrayList<Course>();
    static ArrayList<Faculty> faculty = new ArrayList<Faculty>();
    static int NumberOfAppointments = 0, NumberOfOfficeHrs = 0, NumberOfFaculty = 1, NumberOfCourses;
    static ArrayList<Integer> NubmerOfClasses = new ArrayList<Integer>();
    static int NumberOfMeetingDays = 0;
    static int totalIndex = 0;
    static ArrayList<String> TimeBlockHolder = new ArrayList<String>();
    static ArrayList<TimeBlock> timeBlock_classes = new ArrayList<TimeBlock>();
    static ArrayList<TimeBlock> timeBlock = new ArrayList<TimeBlock>();
    static List<TimeBlock> time_Block  = new ArrayList<TimeBlock>();

    public static void main(String[] args) throws IOException {

        TimeBlock[] timeblocks_ = new TimeBlock[0];

        //ArrayList<ArrayList<TimeBlock>> timeBlock = new ArrayList<ArrayList<TimeBlock>>();


        File file;
        Scanner scnr;
        ArrayList<String> data = new ArrayList<>();
        //create button to be able to open up box for file chooser
        JButton open = new JButton();
        //create file chooser
        JFileChooser fileChooser = new JFileChooser();
        String[] splitList;
        String[] test1 = new String[0];

        //check if file in file path is empty
        if (!(args.length < 1)) {
            //read from file and write to arraylist
            file = new File(args[0]);
            scnr = new Scanner(file);
            do {
                data.add(scnr.nextLine());
            } while (scnr.hasNextLine());
            scnr.close();
        } else {
            //set properties of file chooser: set current directory to project location (".")
            fileChooser.setCurrentDirectory(new java.io.File("."));
            fileChooser.setDialogTitle("Choose File");
            //filechooser will show only directories
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            if (fileChooser.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
                //print out something
            }
            //read from selected file
            System.out.println(fileChooser.getSelectedFile().getAbsoluteFile());
            scnr = new Scanner(fileChooser.getSelectedFile().getAbsoluteFile());
            do {
                data.add(scnr.nextLine());
            } while (scnr.hasNextLine());
            scnr.close();

        }


        //set department name from file
        ArrayList<String> test = new ArrayList<String>();
        System.out.println(data.get(3) + " " + data.get(4) + " " + data.get(5));
        //android.util.Log.d(TAG, "main: ");

        //faculty.add(0,"NameF", "NameL", "Locatoin", "null", "null","null");

       /* faculty.add(0, new Faculty(data.get(3), data.get(4), data.get(5), null, null,
                null));
        faculty.add(1, new Faculty("FName", "LName", "Loc", null,
                null, null));*/
        department1 = new Department(data.get(0), data.get(1), data.get(2), faculty);
        String numCourses = data.get(6);
        //course.setCourseName(data.get(7));
        //course.setLocation(data.get(8));
        int facultyi = 0;
        String testing;
        int numTest;
        boolean vali;




                faculty.add(facultyi, new Faculty(data.get(totalIndex + 3), data.get(totalIndex + 4),
                        data.get(totalIndex + 5), null, null, null));
                System.out.println(facultyi);


              /**  test1 = splitForSpace(data, totalIndex - 1);
                faculty.add(facultyi, new Faculty(test1[0], test1[1], data.get(totalIndex), null, null, null));
                System.out.println(faculty.get(facultyi));**/

            /**COURSES TIMEBLOCK**/

            int indexNumClasses = getIndexNumClasses(data, totalIndex);
            int NumClasses = Integer.parseInt(data.get(indexNumClasses));
            int lastIndex_Classes = indexNumClasses + 7;

            int value = 0;

            int indexNumDays = getIndexNumClasses(data, totalIndex) + 3;
            int NumDays = Integer.parseInt(data.get(indexNumDays));
            timeblocks_ = new TimeBlock[NumDays];

            //loops for each course
            int inti;
            timeBlock_classes = new ArrayList<TimeBlock>();
            //creat file to temporarly hold data
            ArrayList<TimeBlock> tempList = new ArrayList<TimeBlock>();
            for (int i = 0; i < NumClasses; i++) {
                //tempList.clear();
                inti = 0;
                if(i == 0){
                //CourseFact1 (new Course(data.get(indexNumDays - 2), data.get(indexNumDays - 1), null));
                    for (int in = 0; in < NumDays; in++) {
                        splitList = split(data, (indexNumClasses + 4) + inti);
                        timeblock1.add(in, new TimeBlock(setDayofWeek(splitList[0]),
                                Integer.parseInt(splitList[1].substring(1)), Integer.parseInt(splitList[2].substring(1)),
                                null, faculty.get(facultyi).getOfficeLocation()));
                        //timeblocks_[in] = new TimeBlock(setDayofWeek(splitList[0]),
                        //      Integer.parseInt(splitList[1].substring(1)), Integer.parseInt(splitList[2].substring(1)),
                        //    null, null);

                        lastIndex_Classes++;
                        NumberOfMeetingDays++;
                        //timeBlock.add(i, timeBlock_classes.get(in));

                       // Course1.setTime_Block(timeBlock);
                       /* indexNumClasses = indexNumClasses + 3;
                        indexNumClasses = Integer.parseInt(data.get(indexNumClasses)) + indexNumClasses;
                        if (!(NumClasses == (i + 1))) {
                            NumDays = Integer.parseInt(data.get(indexNumClasses + 3));
                        } else if (NumClasses > i) {
                            totalIndex = indexNumClasses + 1;
                        }


                        NubmerOfClasses.add(i, NumberOfMeetingDays);
                        value = value + (NumDays + 3);*/
                        inti++;
                    }

                }else if(i == 1){
                    Course2 = new Course(data.get(indexNumDays - 2), data.get(indexNumDays -1), null);
                    for (int in = 0; in < NumDays; in++) {
                        splitList = split(data, (indexNumClasses + 4) + inti);
                        timeblock2.add(in, new TimeBlock(setDayofWeek(splitList[0]),
                                Integer.parseInt(splitList[1].substring(1)), Integer.parseInt(splitList[2].substring(1)),
                                null, faculty.get(facultyi).getOfficeLocation()));
                        //timeblocks_[in] = new TimeBlock(setDayofWeek(splitList[0]),
                        //      Integer.parseInt(splitList[1].substring(1)), Integer.parseInt(splitList[2].substring(1)),
                        //    null, null);

                        lastIndex_Classes++;
                        NumberOfMeetingDays++;
                        ///timeBlock.add(i, timeBlock_classes.get(in));
                        //Course2.setTime_Block(timeblock2);
                        /*indexNumClasses = indexNumClasses + 3;
                        indexNumClasses = Integer.parseInt(data.get(indexNumClasses)) + indexNumClasses;
                        if (!(NumClasses == (i + 1))) {
                            NumDays = Integer.parseInt(data.get(indexNumClasses + 3));
                        } else if (NumClasses > i) {
                            totalIndex = indexNumClasses + 1;
                        }


                        NubmerOfClasses.add(i, NumberOfMeetingDays);
                        value = value + (NumDays + 3);*/
                        inti++;
                    }
                }else if(i == 2){
                    Course3 = new Course(data.get(indexNumDays - 2), data.get(indexNumDays -1), null);
                    for (int in = 0; in < NumDays; in++) {
                        splitList = split(data, (indexNumClasses + 4) + inti);
                        timeblock3.add(in, new TimeBlock(setDayofWeek(splitList[0]),
                                Integer.parseInt(splitList[1].substring(1)), Integer.parseInt(splitList[2].substring(1)),
                                null, faculty.get(facultyi).getOfficeLocation()));
                        //timeblocks_[in] = new TimeBlock(setDayofWeek(splitList[0]),
                        //      Integer.parseInt(splitList[1].substring(1)), Integer.parseInt(splitList[2].substring(1)),
                        //    null, null);

                        lastIndex_Classes++;
                        NumberOfMeetingDays++;
                        //timeBlock.add(i, timeBlock_classes.get(in));
                       // Course3.setTime_Block(timeblock3);
                       /* indexNumClasses = indexNumClasses + 3;
                        indexNumClasses = Integer.parseInt(data.get(indexNumClasses)) + indexNumClasses;
                        if (!(NumClasses == (i + 1))) {
                            NumDays = Integer.parseInt(data.get(indexNumClasses + 3));
                        } else if (NumClasses > i) {
                            totalIndex = indexNumClasses + 1;
                        }


                        NubmerOfClasses.add(i, NumberOfMeetingDays);
                        value = value + (NumDays + 3);*/
                        inti++;
                    }
                } else if(i == 3){
                    Course4 = new Course(data.get(indexNumDays - 2), data.get(indexNumDays -1), null);
                    for (int in = 0; in < NumDays; in++) {
                        splitList = split(data, (indexNumClasses + 4) + inti);
                        timeblock4.add(in, new TimeBlock(setDayofWeek(splitList[0]),
                                Integer.parseInt(splitList[1].substring(1)), Integer.parseInt(splitList[2].substring(1)),
                                null, faculty.get(facultyi).getOfficeLocation()));
                        //timeblocks_[in] = new TimeBlock(setDayofWeek(splitList[0]),
                        //      Integer.parseInt(splitList[1].substring(1)), Integer.parseInt(splitList[2].substring(1)),
                        //    null, null);

                        lastIndex_Classes++;
                        NumberOfMeetingDays++;
                        //timeBlock.add(i, timeBlock_classes.get(in));
                        //Course4.setTime_Block(timeblock4);
                        /*indexNumClasses = indexNumClasses + 3;
                        indexNumClasses = Integer.parseInt(data.get(indexNumClasses)) + indexNumClasses;
                        if (!(NumClasses == (i + 1))) {
                            NumDays = Integer.parseInt(data.get(indexNumClasses + 3));
                        } else if (NumClasses > i) {
                            totalIndex = indexNumClasses + 1;
                        }


                        NubmerOfClasses.add(i, NumberOfMeetingDays);
                        value = value + (NumDays + 3);*/

                        inti++;
                    }

                    //faculty.add(facultyi, faculty.get(facultyi).setCourses(Course4));
                }


                //loops each timeblock for current course

                //timeBlock = new ArrayList<ArrayList<TimeBlock>>();
                //timeBlock.add(i, timeBlock_classes);
                //FileWriter tempFile = new FileWriter("CourseX_Timeblock.txt");

               /* for (int hi = 0; hi < NumDays; hi++) {
                    tempFile.write(String.valueOf(timeBlock_classes.get(hi).getDay()));
                    tempFile.write(",");
                    tempFile.write(String.valueOf(timeBlock_classes.get(hi).getStartTime()));
                    tempFile.write(",");
                    tempFile.write(String.valueOf(timeBlock_classes.get(hi).getEndTime()));
                    tempFile.write("\n");
                }
                tempFile.close();*/


               indexNumClasses = indexNumClasses + 3;
                indexNumClasses = Integer.parseInt(data.get(indexNumClasses)) + indexNumClasses;
                if (!(NumClasses == (i + 1))) {
                    NumDays = Integer.parseInt(data.get(indexNumClasses + 3));
                } else if (NumClasses > i) {
                    totalIndex = indexNumClasses + 1;
                }


                NubmerOfClasses.add(i, NumberOfMeetingDays);
                value = value + (NumDays + 3);
                //time_Block = timeBlock_classes.subList((timeBlock_classes.size()) - NumberOfMeetingDays,
                        //((timeBlock_classes.size()) - NumberOfMeetingDays ) + (NumDays +  1));

               // Course.get(i).setTime_Block(timeBlock);
            }
            int contr = 1;
            for (int i = 0; i < Integer.parseInt(data.get(totalIndex)); i++) {
                splitList = split(data, (totalIndex + 1 + i));
                timeBlock.add(i, new TimeBlock(setDayofWeek(splitList[0]),
                        Integer.parseInt(splitList[1].substring(1)), Integer.parseInt(splitList[2].substring(1)),
                        null, null));
                contr++;
            }
            totalIndex = totalIndex + contr;

            int a = 2;
            for (int i = 0; i < Integer.parseInt(data.get(totalIndex)); i++) {
                splitList = split(data, (totalIndex + i + a));
                timeBlock.add(i, new TimeBlock(setDayofWeek(splitList[0]),
                        Integer.parseInt(splitList[1].substring(1)), Integer.parseInt(splitList[2].substring(1)),
                        data.get((totalIndex + i + a) - 1), null));
                a++;
            }
            totalIndex = totalIndex + Integer.parseInt(data.get(totalIndex)) + a;
            System.out.println("Okay for classes");
            System.out.println(lastIndex_Classes);

            /**OFFICEHRS TIMEBLOCK**/
            int lastIndex_officeHrs = 0;

//        for(int i = 0; i < Integer.parseInt(data.get(lastIndex_Classes)); i++){
//            splitList = split(data, lastIndex_Classes + 1 + i);
//            timeBlock_officeHrs.add(i, new TimeBlock(setDayofWeek(splitList[0]),
//                    Integer.parseInt(splitList[1].substring(1)), Integer.parseInt(splitList[2].substring(1)),
//                    null, null));
//            lastIndex_officeHrs++;
//            NumberOfOfficeHrs++;
//        }
            lastIndex_officeHrs = lastIndex_officeHrs + lastIndex_Classes + 1;

            System.out.println("Okay for office hours");
            System.out.println(lastIndex_officeHrs);

            /**APPOINTMENT TIMEBLOCK**/

           /* int in = 1;
            for (int i = 0; i < Integer.parseInt(data.get(lastIndex_officeHrs)); i++) {
                splitList = split(data, lastIndex_officeHrs + 1 + i + in);
                timeBlock_appointments.add(i, new TimeBlock(setDayofWeek(splitList[0]), Integer.parseInt(splitList[1].substring(1)),
                        Integer.parseInt(splitList[2].substring(1)), data.get(lastIndex_officeHrs + i + in), null));
                in++;
                NumberOfAppointments++;
            }

            int lastIndex_officeApmts = lastIndex_officeHrs + 1 + (Integer.parseInt(data.get(lastIndex_officeHrs)) * 2);
            System.out.println(lastIndex_officeApmts);
            int nextIndex = 0;
            boolean bool = true;
            do {
                String check = data.get(lastIndex_officeApmts + nextIndex);
                if (!(check.length() == 1)) {
                    nextIndex++;
                    bool = false;
                } else bool = true;
                //NumberOfFaculty++;

            } while (!bool);
            totalIndex = (data.indexOf(data.get(lastIndex_officeApmts)) + nextIndex);
            System.out.println(totalIndex);
            NumberOfFaculty++;*/

            facultyi++;
            vali = true;
            try{
                int testere;
           testere = data.get(totalIndex).length();
           System.out.println(testere);

            }catch (IndexOutOfBoundsException ite){
                vali = false;
            }


        //totalIndex = (((NubmerOfClasses.size() + 1) + (NumberOfMeetingDays + (NubmerOfClasses.size() * 3)) + (NumberOfOfficeHrs + 1) + ((NumberOfAppointments * 2) + 1)) + 3);


        //String string = department.setDepartmentName();
        System.out.println("Number of appointments: " + NumberOfAppointments);
        System.out.println("Number of Office Hour Sessions: " + NumberOfOfficeHrs);
        System.out.println("Total Number of Class Meetings per week: " + NumberOfMeetingDays);
        System.out.println("Number of classes per week:  " + NubmerOfClasses.size());
        System.out.println("Index of Next Teacher Name: " +
                totalIndex);

        launch();

    }


    @Override
    public void start(Stage stage) throws Exception {
        //set tile and size
        stage.setTitle("Course Information");
        stage.setHeight(800);
        stage.setWidth(800);

        //creat root node, child node
        VBox parent = new VBox();
        Label departmentName = new Label(department1.getDepartmentName());
        Label collageName = new Label(department1.getUnitNames());
        Label universityName = new Label(department1.getUniversityName());
        Label firstName = new Label("\t" + faculty.get(0));
        Label lastName = new Label("\t" + faculty.get(1));
        Label officeLocation = new Label("\t" + faculty.toString());

        //add nodes
        parent.getChildren().addAll(departmentName, collageName, universityName,
                firstName, lastName, officeLocation);

        //create scene and set it
        Scene scene = new Scene(parent);
        stage.setScene(scene);

        //show stage
        stage.show();

    }

    public static int getIndexNumClasses(ArrayList<String> list, int index) {
        boolean test = true;
        int i = index;
        do {
            if (list.get(i).length() == 1) {
                test = true;
            } else {
                test = false;
                i++;
            }
        } while (!test);
        return i;
    }

    public static String[] split(ArrayList<String> list, int cntr) {
        String first = list.get(cntr);
        String[] split_, split3;
        ArrayList<String> finalList = new ArrayList<>();
        if (first.contains(".")) {
            split_ = first.split("\\.");
            finalList.add(0, split_[0]);
            split3 = split_[1].split(",");
            finalList.add(1, split3[0]);
            finalList.add(2, split3[1]);
            split_ = new String[finalList.size()];
            for (int i = 0; i < finalList.size(); i++) {
                split_[i] = finalList.get(i);
            }
        } else split_ = first.split(",");

        return split_;
    }

    public static String[] splitForSpace(ArrayList<String> list, int cntr) {
        String first = list.get(cntr);
        return first.split(" ");
    }

    public static TimeBlock.DaysOfWeek setDayofWeek(String dayofWeek) {
        //enhanced switch block
        return switch (dayofWeek) {
            case "Tuesday" -> TimeBlock.DaysOfWeek.TUESDAY;
            case "Wednesday" -> TimeBlock.DaysOfWeek.WEDNESDAY;
            case "Thursday" -> TimeBlock.DaysOfWeek.THURSDAY;
            case "Friday" -> TimeBlock.DaysOfWeek.FRIDAY;
            default -> TimeBlock.DaysOfWeek.MONDAY;
        };

    }

    public static int getIndexNumOffice() {
        return 3;
    }

    public static void nextStaff(ArrayList<String> data) {

    }
}
