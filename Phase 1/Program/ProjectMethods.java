import javafx.application.Application;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.stage.FileChooser.*;
import javafx.geometry.*;
import java.util.Timer;
import java.io.*;
import javafx.scene.text.*;
import java.util.*;

public class ProjectMethods implements EventHandler<ActionEvent>{
   
   private VBox root;
   private Stage stage;
      
   public ProjectMethods(VBox root, Stage stage){
      this.root = root;
      this.stage = stage;
   }
     
   public void handle(ActionEvent evt){      // Handler
     
      //MenuItem item = (MenuItem)evt.getSource();
      Button btn = (Button)evt.getSource();
      
      //switch(item.getText()){
                     
      //   case "About":          // Case 1                                
            
      //     doAbout();
          
      //      break;
         
      //   case "Exit":         // Case 2                                
            
      //      doExit();
          
      //      break;  
                
      //}
      
      switch(btn.getText()) {
      
         case "View Catalog":
         
            doViewCatalog();
           
            break;
            
         case "Todays Log":
            
            doTodaysLog();
            
            break;
            
         case "Home":
            
            doHome();
            
            break;
         
         case "Add food":
            
            doAddFood();
            
            break;
      
      
            
      }
   
   }
   
   // Methods for the Handler
   
   public void doAbout(){
      
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle("About");
      alert.setHeaderText("About our app...");
      alert.setContentText("You chose the wrong dialog, press Exit and kill me!");
   
      alert.showAndWait();
   
   }
   
   public void doExit(){
   
      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("Exit");
      alert.setHeaderText(null);
      alert.setContentText("Are you sure you want to exit?");
   
      ButtonType btExit = new ButtonType("Exit");
      ButtonType btCancel = new ButtonType("Cancel");
   
      alert.getButtonTypes().setAll(btExit, btCancel);
   
      Optional<ButtonType> result = alert.showAndWait();
      if (result.get() == btExit){
         System.exit(0);
      }else {
         
      }
   
   }
   
   public void doViewCatalog(){
      
      root.getChildren().clear();
      
      FlowPane topPane = new FlowPane();
      FlowPane midPane = new FlowPane();
      FlowPane botPane = new FlowPane();
   
      Label lblCatalog = new Label("Catalog");
      
      // POPIS HRANE   
   
      Button btnHome = new Button("Home");
      Button btnAddFood = new Button("Add food");
      
       // Top FlowPane features
      topPane.setAlignment(Pos.TOP_CENTER);
      lblCatalog.setFont(new Font("Arial", 30));
      topPane.getChildren().add(lblCatalog);
      
      // TODO: GRAPH = Mid FlowPane, features
      TextArea testArea = new TextArea();
      
      midPane.setAlignment(Pos.CENTER);
      testArea.setPrefHeight(250);
      testArea.setPrefWidth(350);
      midPane.getChildren().add(testArea);
      
      // Bottom FlowPane features
      botPane.setAlignment(Pos.BOTTOM_CENTER);
      botPane.setPadding(new Insets(10, 0, 0, 0));
      botPane.setHgap(100);
      botPane.getChildren().addAll(btnHome, btnAddFood);
   
      root.getChildren().addAll(topPane, midPane, botPane);
   
   
   }
   
   public void doTodaysLog(){
      
      root.getChildren().clear();
      
      FlowPane topPane = new FlowPane();
      FlowPane midPane = new FlowPane();
      FlowPane botPane = new FlowPane();
   
      Label lblTodaysLog = new Label("Todays Log");
      
      // POPIS HRANE   
   
      Button btnHome = new Button("Home");
      Button btnAddLog = new Button("Add Log");
      
       // Top FlowPane features
      topPane.setAlignment(Pos.TOP_CENTER);
      lblTodaysLog.setFont(new Font("Arial", 30));
      topPane.getChildren().add(lblTodaysLog);
      
      // TODO: GRAPH = Mid FlowPane, features
      
      
      // Bottom FlowPane features
      botPane.setAlignment(Pos.BOTTOM_CENTER);
      //botPane.setPadding(new Insets(20, 0, 0, 0));
      botPane.setHgap(100);
      botPane.getChildren().addAll(btnHome, btnAddLog);
   
      root.getChildren().addAll(topPane, midPane, botPane);
   
   }
   
   
   // TODO
   public void doHome() {
   
      root.getChildren().clear();
      
      
   
   }
   
   public void doAddFood() {
   
      root.getChildren().clear();
      
      
   }
   
}