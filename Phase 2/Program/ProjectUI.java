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
import javafx.scene.image.Image;

public class ProjectUI extends Application {
      
   // Window setup
   Stage stage = null;
   Scene scene = null;
   VBox root = null;  
   
   // MenuBar and Menu setup
   private MenuBar mBar = new MenuBar(); 
   private Menu menu = new Menu("File");
   private MenuItem miAbout = new MenuItem("About");
   private MenuItem miExit = new MenuItem("Exit");
   
   // Initializing all objects for all pages
   private FlowPane topPane = new FlowPane();
   private FlowPane midPane = new FlowPane();
   private FlowPane botPane = new FlowPane();
   
   // Home page
   private Label lblWelcome = new Label("Welcome, Domagoj!");   
   // TODO: ADD GRAPH HERE IDK HOW BUT YOU GOT THIS
   private TextArea testArea = new TextArea();
   
   private Button btnCatalog = new Button("View Catalog");
   private Button btnTodaysLog = new Button("Todays Log");
    
   // Start method
   public void start(Stage _stage) {
   
      stage = _stage;
      stage.setTitle("jHealth");
      
      stage.getIcons().add(new Image("file:jhIcon.png"));
      
      // Adding Menu Items to the Menus
      menu.getItems().addAll(miAbout, miExit);
      
      // Adding the Menus to the Menu Bar
      mBar.getMenus().add(menu);
      root = new VBox(mBar);
      
      // Inner class for the about menu item 
      miAbout.setOnAction(
         new EventHandler<ActionEvent>(){
            public void handle(ActionEvent evt){
               
               Alert alert = new Alert(AlertType.INFORMATION);
               alert.setTitle("About");
               alert.setHeaderText("About our app...");
               alert.setContentText("jHealth was created by RIT students Antonio Butigan & Josip Muzic.");
            
               alert.showAndWait();
            
                                       
            }
         });
      
      // Inner class for the exit menu item
      miExit.setOnAction(
         new EventHandler<ActionEvent>(){
            public void handle(ActionEvent evt){
               
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
         });
              
         
      // Adding Actions to the menu items buttons
      ProjectMethods pm = new ProjectMethods(root, stage);
      btnCatalog.setOnAction(pm);
      btnTodaysLog.setOnAction(pm);
            
      // Top FlowPane features
      topPane.setAlignment(Pos.TOP_CENTER);
      lblWelcome.setFont(new Font("Arial", 30));
      topPane.getChildren().add(lblWelcome);
      
      // TODO: GRAPH = Mid FlowPane, features
      midPane.setAlignment(Pos.CENTER);  
      testArea.setPrefHeight(250);
      testArea.setPrefWidth(350);
      midPane.getChildren().add(testArea);
      
      // Bottom FlowPane features
      botPane.setAlignment(Pos.BOTTOM_CENTER);
      botPane.setPadding(new Insets(10, 0, 0, 0));
      botPane.setHgap(100);
      botPane.getChildren().addAll(btnCatalog, btnTodaysLog);
      
      // Making everything visible  
      root.getChildren().addAll(topPane, midPane, botPane);     
      root.setSpacing(10);           
      scene = new Scene(root, 400, 400);
      stage.setScene(scene);
      stage.show();        
         
   }

}