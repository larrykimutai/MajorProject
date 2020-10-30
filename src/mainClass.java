import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class mainClass extends Application {
    static Department department = new Department();
    static ArrayList<Faculty> faculty = new ArrayList<Faculty>();
    static ArrayList<Course> courseF1 = new ArrayList<Course>();
    static ArrayList<Course> courseF2 = new ArrayList<Course>();

    static ArrayList<TimeBlock> timeBlockF1C1 = new ArrayList<TimeBlock>();
    static ArrayList<TimeBlock> timeBlockF1C2 = new ArrayList<TimeBlock>();
    static ArrayList<TimeBlock> timeBlockF1C3 = new ArrayList<TimeBlock>();

    static ArrayList<TimeBlock> timeBlockOfficeHrsF1 = new ArrayList<TimeBlock>();
    static ArrayList<TimeBlock> timeBlockApptsF1 = new ArrayList<TimeBlock>();

    static ArrayList<TimeBlock> timeBlockF2C1 = new ArrayList<TimeBlock>();
    static ArrayList<TimeBlock> timeBlockF2C2 = new ArrayList<TimeBlock>();

    static ArrayList<TimeBlock> timeBlockOfficeHrsF2 = new ArrayList<TimeBlock>();

    public static void main(String[] args) throws Exception {

        int totalIndex = 0;

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


        for (int i = 0; i < 3; i++) {
            splitList = split(data, (10 + i));
            timeBlockF1C1.add(i, new TimeBlock(setDayofWeek(splitList[0]),
                    Integer.parseInt(splitList[1].substring(1)), Integer.parseInt(splitList[2].substring(1)),
                    null, data.get(8)));
        }
        courseF1.add(0, new Course(data.get(7), data.get(8), timeBlockF1C1));

        for (int i = 0; i < 2; i++) {
            splitList = split(data, (16 + i));
            timeBlockF1C2.add(i, new TimeBlock(setDayofWeek(splitList[0]),
                    Integer.parseInt(splitList[1].substring(1)), Integer.parseInt(splitList[2].substring(1)),
                    null, data.get(14)));
        }
        courseF1.add(1, new Course(data.get(13), data.get(14), timeBlockF1C2));

        for (int i = 0; i < 3; i++){
            splitList = split(data, (21 + i));
            timeBlockF1C3.add(i, new TimeBlock(setDayofWeek(splitList[0]),
                    Integer.parseInt(splitList[1].substring(1)), Integer.parseInt(splitList[2].substring(1)),
                    null, data.get(19)));
        }
        courseF1.add(2, new Course(data.get(18), data.get(19), timeBlockF1C3));

        for (int i = 0; i < 4; i++) {
            splitList = split(data, (25 + i));
            timeBlockOfficeHrsF1.add(i, new TimeBlock(setDayofWeek(splitList[0]),
                    Integer.parseInt(splitList[1].substring(1)), Integer.parseInt(splitList[2].substring(1)),
                    null, data.get(8)));
        }

        int up = 1;
        for(int i = 0; i < 2; i++){

            splitList = split(data, (30 + i) + up);
            timeBlockApptsF1.add(i, new TimeBlock(setDayofWeek(splitList[0]),
                    Integer.parseInt(splitList[1].substring(1)), Integer.parseInt(splitList[2].substring(1)),
                    data.get(30 + i + i), data.get(8)));
            up++;
        }







        for (int i = 0; i < 3; i++) {
            splitList = split(data, (40 + i));
            timeBlockF2C1.add(i, new TimeBlock(setDayofWeek(splitList[0]),
                    Integer.parseInt(splitList[1].substring(1)), Integer.parseInt(splitList[2].substring(1)),
                    null, data.get(38)));
        }
        courseF2.add(0, new Course(data.get(37), data.get(38), timeBlockF2C1));

        for (int i = 0; i < 3; i++) {
            splitList = split(data, (46 + i));
            timeBlockF2C2.add(i, new TimeBlock(setDayofWeek(splitList[0]),
                    Integer.parseInt(splitList[1].substring(1)), Integer.parseInt(splitList[2].substring(1)),
                    null, data.get(44)));
        }
        courseF2.add(1, new Course(data.get(43), data.get(44), timeBlockF2C2));


        for (int i = 0; i < 3; i++) {
            splitList = split(data, (50 + i));
            timeBlockOfficeHrsF2.add(i, new TimeBlock(setDayofWeek(splitList[0]),
                    Integer.parseInt(splitList[1].substring(1)), Integer.parseInt(splitList[2].substring(1)),
                    null, data.get(35)));
        }






        faculty.add(0, new Faculty(data.get(3), data.get(4),
                data.get(5), courseF1, timeBlockOfficeHrsF1, timeBlockApptsF1));
        String [] test = splitForSpace(data, 34);
        faculty.add(1, new Faculty(test[0], test[1], data.get(35),
                courseF2, timeBlockOfficeHrsF2, null));


        department = new Department(data.get(0), data.get(1), data.get(2), faculty);

        System.out.println(department.toString());

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
        String departmetnName = department.getUniversityName();
        Label collageName = new Label("departmentName.toString()");
        Label universityName = new Label("departmentName.toString()");
//        Label firstName = new Label("\t" + faculty.get(0));
//        Label lastName = new Label("\t" + faculty.get(1));
//        Label officeLocation = new Label("\t" + faculty.toString());

        //add nodes
        parent.getChildren().addAll(collageName, universityName);

        //create scene and set it
        Scene scene = new Scene(parent);
        stage.setScene(scene);

        //show stage
        stage.show();

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

    public static String[] splitForSpace(ArrayList<String> list, int cntr) {
        String first = list.get(cntr);
        return first.split(" ");
    }
}
