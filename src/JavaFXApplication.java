/**
 * I created a class for the stage in order to avoid having to create objects and
 * different instances. Also makes the code look cleaner and less cluttered
 **/

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;

public class JavaFXApplication extends Application {

    String test;

    //default contructor
    public JavaFXApplication(){
        test = null;
    }
    //constructor
    public JavaFXApplication(String s){
        test = s;
    }

    //initialzation method(code that runs before application opens)
    @Override
    public void init() throws Exception {
        System.out.println("Before");
    }

    //implement abstract method
    //This is where the stage(Window for GUI) is created when program starts
    @Override
    public void start(Stage stage) throws Exception {

        //stage title
        stage.setTitle("Parent Stage");

        //set stage size
        stage.setWidth(800);
        stage.setHeight(800);

        //creat Root Nodes aka layout manager(top layer node, only things can go under that not over)
        //VBox(labels thing vertically, hence VBox)
        VBox parent = new VBox();

        //create a child node
        Label lable1 = new Label("This is a text label");
        Label lable2 = new Label("Another label");

        //set cursor when hovering over text
        lable1.setCursor(Cursor.TEXT);
        lable2.setCursor(Cursor.TEXT);

        //add nodes(lable1 and lable2 to scene
        parent.getChildren().addAll(lable1, lable2);

        //creat a Scene(layout manager(contorls how componets(nodes) are displayed in stage))
        Scene scene1 = new Scene(parent);

        //set scene to stage
        stage.setScene(scene1);

        //show stage
        stage.show();

//---------------------------------------------------------------------------------------------------------------------
/**
        //create new stage
        Stage stage2 = new Stage();
        stage2.setTitle("Stage 2");

        //change size
        stage2.setWidth(400);
        stage2.setHeight(300);

        //change location windows appears
        stage2.setX(5);
        stage2.setY(5);

        //other windows cannot be used until this application is done
        stage2.initModality(Modality.APPLICATION_MODAL);

        //show stage
        stage2.show();

//---------------------------------------------------------------------------------------------------------------------

        //modality(how stages interact with each other)
        Stage newWindow = new Stage();

        //set title
        newWindow.setTitle("Child Stage");

        //other windows cannot be messed with window that owns this window
        newWindow.initModality(Modality.WINDOW_MODAL);

        //create owner of window
        newWindow.initOwner(stage);

        //change stage style
        /*DECORATED: default
        * TRANSPARENT: inivisible
        * UTILITY: window with only one option(only has exit option for example)
        * UNDECORATED: only show content of the window
        * UNIFIED: remove boarder between decoration area and content area
        * newWindow.toFront/.toBack*//**
        newWindow.initStyle(StageStyle.DECORATED);

        //set to fullscreen(must have content in GUI)
        newkWindow.setFullScreen(true);

        //show stage
        newWindow.show();

**/
    }

    //stop method, method that runs after application stops
    @Override
    public void stop() throws Exception {
        System.out.println("After");
    }
}
