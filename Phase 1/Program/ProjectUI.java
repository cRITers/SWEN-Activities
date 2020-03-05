import javafx.application.Application;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.stage.FileChooser.*;
import javafx.geometry.*;
import java.io.*;
import java.util.*;

public class ProjectUI extends Application {
      
   // Window setup
   Stage stage = null;
   Scene scene = null;
   VBox root = null;  
   
   // MenuBar and Menu setup
   private MenuBar mBar = new MenuBar();
    
   private Menu menu1 = new Menu("File");
  
   private MenuItem miNew = new MenuItem("New");
   private MenuItem miOpen = new MenuItem("Open");
   private MenuItem miSave = new MenuItem("Save");
   private MenuItem miSaveAs = new MenuItem("Save As");
   private MenuItem miExit = new MenuItem("Exit");
   
   private FlowPane areaPane = new FlowPane();
   private TextArea area1 = new TextArea();
   private TextArea area2 = new TextArea();
   
   private FlowPane buttonPane = new FlowPane();
   private Button log = new Button("Log");
   private Button button = new Button("Button");
    
   // Start method
   public void start(Stage _stage) {
      stage = _stage;
      stage.setTitle("ProjectUI");
      
      // Adding Menu Items to the Menus
      menu1.getItems().addAll(miNew, miOpen, miSave, miSaveAs, miExit);
      
      // Adding the Menus to the Menu Bar
      mBar.getMenus().addAll(menu1);
      root = new VBox(mBar);
      
      // Adding Actions to the buttons
      ProjectMethods pm = new ProjectMethods(area1, area2, stage);
      
      miNew.setOnAction(pm);
      miOpen.setOnAction(pm);
      miSave.setOnAction(pm);
      miSaveAs.setOnAction(pm);
      miExit.setOnAction(pm);
   
      // Text Area features
      area1.setPrefHeight(400);
      area1.setPrefWidth(250);
      area1.setFont(Font.font("Courier", 16));
      area1.setWrapText(true);
      
      area2.setPrefHeight(400);
      area2.setPrefWidth(250);
      area2.setFont(Font.font("Courier", 16));
      area2.setWrapText(true);
      
      areaPane.getChildren().addAll(area1, area2);
      
      // Flow Pane
      buttonPane.setAlignment(Pos.CENTER);
      buttonPane.setPadding(new Insets(20, 0, 0, 0));
      buttonPane.setHgap(100);
      buttonPane.getChildren().addAll(log, button);
      
      // Making everything visible  
      //root.setSpacing(10);
      
      root.getChildren().addAll(areaPane, buttonPane);                
      scene = new Scene(root, 500, 500);
      stage.setScene(scene);
      stage.show();           
   }

}