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
import java.util.ArrayList;

public class ProjectMethods implements EventHandler<ActionEvent> {

   ArrayList<FlowPane> flowList = new ArrayList<FlowPane>();
   
   int counter = 1;
   boolean backCheck;
   boolean addCheck;

   private VBox root;
   private Stage stage;
   private Scene scene;
   private FileManager fileManager = new FileManager();

   public ProjectMethods(VBox root, Stage stage, Scene scene) {
      this.root = root;
      this.stage = stage;
      this.scene = scene;
   }

   ProjectUI pui = new ProjectUI();
   
   public void handle(ActionEvent evt) { // Handler
   
      Button btn = (Button) evt.getSource();
   
      switch (btn.getText()) {
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
      
         case "Back":
            if (backCheck) {
               doViewCatalog();
               counter = 1;
            } else {
               doTodaysLog();
               counter = 1;
            }
            break;
      
         case "Add New Log":
            doAddNewLog();
            break;
      
         case "Add":
            if (addCheck) {
               addFoodLog();
            } else {
               doAdd2();
            }
            break;
            
         case "Add recipe":
            doAddRecipe();
            break;
            
      
      }
   
   }

   // METHODS

   public void doViewCatalog() {
      root.getChildren().clear();
   
      FlowPane topPane = new FlowPane();
      FlowPane midPane = new FlowPane();
      FlowPane botPane = new FlowPane();
   
      Label lblCatalog = new Label("Catalog");
   
      // POPIS HRANE
      Button btnHome = new Button("Home");
      Button btnAddFood = new Button("Add food");
      Button btnAddRecipe = new Button("Add recipe");
      btnHome.setOnAction(this);
      btnAddFood.setOnAction(this);
      btnAddRecipe.setOnAction(this);
   
      // Top FlowPane features
      topPane.setAlignment(Pos.TOP_CENTER);
      lblCatalog.setFont(new Font("Arial", 30));
      topPane.getChildren().add(lblCatalog);
   
      // TODO: GRAPH = Mid FlowPane, features
      TextArea foodTextArea = new TextArea();
      foodTextArea.appendText(fileManager.getFromFoods());
      
      midPane.setAlignment(Pos.CENTER);
      foodTextArea.setPrefHeight(250);
      foodTextArea.setPrefWidth(350);
      midPane.getChildren().add(foodTextArea);
   
      // Bottom FlowPane features
      botPane.setAlignment(Pos.BOTTOM_CENTER);
      botPane.setPadding(new Insets(10, 0, 0, 0));
      botPane.setHgap(100);
      botPane.getChildren().addAll(btnHome, btnAddFood, btnAddRecipe);
   
      root.getChildren().addAll(topPane, midPane, botPane);
      
   }

   public void doTodaysLog() {
      root.getChildren().clear();
   
      FlowPane topPane = new FlowPane();
      FlowPane midPane = new FlowPane();
      FlowPane botPane = new FlowPane();
   
      Label lblTodaysLog = new Label("Todays Log");
   
      // POPIS HRANE
      Button btnHome = new Button("Home");
      Button btnAddNewLog = new Button("Add New Log");
      btnHome.setOnAction(this);
      btnAddNewLog.setOnAction(this);
   
      // Top FlowPane features
      topPane.setAlignment(Pos.TOP_CENTER);
      lblTodaysLog.setFont(new Font("Arial", 30));
      topPane.getChildren().add(lblTodaysLog);
   
      // TODO: GRAPH = Mid FlowPane, features
      TextArea testArea = new TextArea();
   
      midPane.setAlignment(Pos.CENTER);
      testArea.setPrefHeight(250);
      testArea.setPrefWidth(350);
      midPane.getChildren().add(testArea);
   
      // Bottom FlowPane features
      botPane.setAlignment(Pos.BOTTOM_CENTER);
      // botPane.setPadding(new Insets(20, 0, 0, 0));
      botPane.setHgap(100);
      botPane.getChildren().addAll(btnHome, btnAddNewLog);
   
      root.getChildren().addAll(topPane, midPane, botPane);
   
   }

   // TODO
   public void doHome() {
      root.getChildren().clear();
      pui.start(stage);
   }

   public void doAddFood() {
      backCheck = true;
      addCheck = true;
   
      root.getChildren().clear();
   
      FlowPane topPane = new FlowPane();
      
      FlowPane midPane = new FlowPane();
      
      FlowPane fpName = new FlowPane();
      FlowPane fpCalories = new FlowPane();
      FlowPane fpFat = new FlowPane();
      FlowPane fpCarbs = new FlowPane();
      FlowPane fpProtein = new FlowPane();
      
      fpName.setAlignment(Pos.CENTER);
      fpCalories.setAlignment(Pos.CENTER);
      fpFat.setAlignment(Pos.CENTER);
      fpCarbs.setAlignment(Pos.CENTER);
      fpProtein.setAlignment(Pos.CENTER);
      
      fpName.setPadding(new Insets(30, 0, 0, 0));
      fpCalories.setPadding(new Insets(20, 0, 0, 0));
      fpFat.setPadding(new Insets(20, 0, 0, 0));
      fpCarbs.setPadding(new Insets(20, 0, 0, 0));
      fpProtein.setPadding(new Insets(20, 0, 30, 0));
      
      FlowPane botPane = new FlowPane();
   
      Label lblCatalog = new Label("Add New Food");
      
      Label lblName = new Label("Name:");
      lblName.setPadding(new Insets(0, 26, 0, 0));
      TextField tfName = new TextField();
      fpName.getChildren().addAll(lblName, tfName);
      
      Label lblCalories = new Label("Calories:");
      lblCalories.setPadding(new Insets(0, 16, 0, 0));
      TextField tfCalories = new TextField();
      fpCalories.getChildren().addAll(lblCalories, tfCalories);
      
      Label lblFat = new Label("Fat:");
      lblFat.setPadding(new Insets(0, 48, 0, 0));
      TextField tfFat = new TextField();
      fpFat.getChildren().addAll(lblFat, tfFat);
      
      Label lblCarbs = new Label("Carbs:");
      lblCarbs.setPadding(new Insets(0, 30, 0, 0));
      TextField tfCarbs = new TextField();
      fpCarbs.getChildren().addAll(lblCarbs, tfCarbs);
      
      Label lblProtein = new Label("Protein:");
      lblProtein.setPadding(new Insets(0, 20, 0, 0));
      TextField tfProtien = new TextField();
      fpProtein.getChildren().addAll(lblProtein, tfProtien);
   
      Button btnBack = new Button("Back");
      Button btnAdd = new Button("Add");
      btnBack.setOnAction(this);
      btnAdd.setOnAction(this);
   
      // Top FlowPane features
      topPane.setAlignment(Pos.TOP_CENTER);
      lblCatalog.setFont(new Font("Arial", 30));
      topPane.getChildren().add(lblCatalog);
      
      // Mid FlowPane features
      midPane.setAlignment(Pos.CENTER);
      midPane.getChildren().addAll(fpName, fpCalories, fpFat, fpCarbs, fpProtein);
      
      // Bottom FlowPane features
      botPane.setAlignment(Pos.BOTTOM_CENTER);
      botPane.setPadding(new Insets(10, 0, 0, 0));
      botPane.setHgap(100);
      botPane.getChildren().addAll(btnBack, btnAdd);
      
      root.getChildren().addAll(topPane, midPane, botPane);
   
   }

   // METHOD WHICH TAKES THE USER TO THE FINAL SCREEN OF TODAYS LOG
   public void doAddNewLog() {
      backCheck = false;
      addCheck = false;
   
      root.getChildren().clear();
   
      FlowPane topPane = new FlowPane();
      FlowPane midPane = new FlowPane();
      FlowPane botPane = new FlowPane();
   
      VBox h1 = new VBox();
      VBox h2 = new VBox();
      VBox h3 = new VBox();
   
      Label lblTodaysLog = new Label("Your New Log");
   
      Button btnBack = new Button("Back");
      Button btnAddLogBackend = new Button("Add");
      btnBack.setOnAction(this);
      btnAddLogBackend.setOnAction(this);
   
      // Top FlowPane features
      topPane.setAlignment(Pos.TOP_CENTER);
      lblTodaysLog.setFont(new Font("Arial", 30));
      topPane.getChildren().add(lblTodaysLog);
   
      // Mid flowpane
      Label lType = new Label("Type:");
      TextField tfType = new TextField();
      h1.getChildren().addAll(lType, tfType);
      h1.setPrefWidth(250);
   
      Label lID = new Label("ID:");
      TextField tfID = new TextField();
      h2.getChildren().addAll(lID, tfID);
      h2.setPrefWidth(250);
   
      Label lQuantity = new Label("Quantity:");
      TextField tfQuantity = new TextField();
      h3.getChildren().addAll(lQuantity, tfQuantity);
      h3.setPrefWidth(250);
   
      midPane.setAlignment(Pos.CENTER);
      midPane.getChildren().addAll(h1, h2, h3);
   
      // Bottom FlowPane features
      botPane.setAlignment(Pos.BOTTOM_CENTER);
      // botPane.setPadding(new Insets(20, 0, 0, 0));
      botPane.setHgap(100);
      botPane.getChildren().addAll(btnBack, btnAddLogBackend);
   
      root.getChildren().addAll(topPane, midPane, botPane);
   
   }

   // METHOD WHICH ADDS THE NEW FOOD
   public void addFoodLog() {
   
      System.out.println("Make the food magic happen :D");
   
   }

   // METHOD WHICH WILL ADD THE NEW LOG
   public void doAdd2() {
   
      System.out.println("Make the log magic happen :D");
   
   }
   
   public void doAddRecipe(){
      backCheck = true;
      addCheck = true;
       
   
   
      FlowPane generatedPane = new FlowPane();
      root.getChildren().clear();
   
      FlowPane topPane = new FlowPane();
      
      FlowPane midPane = new FlowPane();
      
      FlowPane fpName = new FlowPane();
      Label lblName = new Label("Name:"); 
      lblName.setPadding(new Insets(0, 70, 0, 0));
      TextField tfName = new TextField();
      fpName.setAlignment(Pos.CENTER);
      fpName.setPadding(new Insets(10, 0, 0, 0));
      fpName.getChildren().addAll(lblName, tfName);  
      
      FlowPane firstPane = new FlowPane();
      Label lblFoodName1 = new Label("Food Name #1");
      lblFoodName1.setPadding(new Insets(0, 30, 0, 0)); 
      TextField tfFoodName1 = new TextField();
      firstPane.setAlignment(Pos.CENTER);
      firstPane.setPadding(new Insets(10, 0, 0, 0));
      firstPane.getChildren().addAll(lblFoodName1, tfFoodName1);
      
      FlowPane secondPane = new FlowPane();
      Label lblQuantity1 = new Label("Quantity #1");
      lblQuantity1.setPadding(new Insets(0, 40, 0, 0));
      TextField tfQuantity1 = new TextField();
      secondPane.setAlignment(Pos.CENTER);
      secondPane.setPadding(new Insets(10, 0, 0, 0));
      secondPane.getChildren().addAll(lblQuantity1, tfQuantity1);
      
      
      midPane.getChildren().addAll(fpName, firstPane, secondPane);
      midPane.setAlignment(Pos.CENTER);
            
      FlowPane botPane = new FlowPane();
   
      Label lblCatalog = new Label("Add New Recipe");
   
      Button btnBack = new Button("Back");
      Button btnAdd = new Button("Add New Recipe");
      btnBack.setOnAction(this);
      
      Button btnRemoveFood = new Button("Remove Newly added");
      btnRemoveFood.setVisible(false);
      
      btnAdd.setOnAction(
         new EventHandler<ActionEvent>() {
            public void handle(ActionEvent evt) {
               
               counter++;
               btnRemoveFood.setVisible(true);       
               
               FlowPane dynamicMother = new FlowPane();
               FlowPane firstDynamicPane = new FlowPane();
               FlowPane secondDynamicPane = new FlowPane();
               
               Label lblFoodName = new Label("Food Name #" + counter);
               lblFoodName.setPadding(new Insets(0, 30, 0, 0)); 
               TextField tfFoodName = new TextField();
               firstDynamicPane.setAlignment(Pos.CENTER);
               firstDynamicPane.setPadding(new Insets(10, 0, 0, 0));
               firstDynamicPane.getChildren().addAll(lblFoodName, tfFoodName);
            
               Label lblQuantity = new Label("Quantity #" + counter);
               lblQuantity.setPadding(new Insets(0, 40, 0, 0));
               TextField tfQuantity = new TextField();
               secondDynamicPane.setAlignment(Pos.CENTER);
               secondDynamicPane.setPadding(new Insets(10, 0, 0, 0));
               secondDynamicPane.getChildren().addAll(lblQuantity, tfQuantity);
               
               
               dynamicMother.getChildren().addAll(firstDynamicPane, secondDynamicPane);
               dynamicMother.setAlignment(Pos.CENTER);
            
               generatedPane.getChildren().add(dynamicMother);
               generatedPane.setAlignment(Pos.CENTER);
               
               flowList.add(dynamicMother);
               
        
            }
         });
   
      
      
      btnRemoveFood.setOnAction(
         new EventHandler<ActionEvent>() {
            public void handle(ActionEvent evt) {
            
               flowList.remove(flowList.size() - 1);
               generatedPane.getChildren().clear();
               
               System.out.println("removed");
               counter = 1;
               
            
            }
         });
         
         
      // Top FlowPane features
      topPane.setAlignment(Pos.TOP_CENTER);
      lblCatalog.setFont(new Font("Arial", 30));
      topPane.getChildren().add(lblCatalog);
      
      // Mid FlowPane features
   
      
      // Bottom FlowPane features
      botPane.setAlignment(Pos.BOTTOM_CENTER);
      botPane.setPadding(new Insets(10, 0, 0, 0));
      botPane.setHgap(30);
      botPane.getChildren().addAll(btnBack, btnRemoveFood, btnAdd);
      
      root.getChildren().addAll(topPane, midPane, generatedPane, botPane);
   }

}