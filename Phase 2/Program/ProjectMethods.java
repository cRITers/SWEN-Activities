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

public class ProjectMethods implements EventHandler<ActionEvent> {

   boolean backCheck;
   boolean addCheck;

   private VBox root;
   private Stage stage;
   private FileManager fileManager = new FileManager();

   public ProjectMethods(VBox root, Stage stage) {
      this.root = root;
      this.stage = stage;
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
            } else {
               doTodaysLog();
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
      btnHome.setOnAction(this);
      btnAddFood.setOnAction(this);

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
      botPane.getChildren().addAll(btnHome, btnAddFood);

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
      TabPane tabPane = new TabPane();
      FlowPane botPane = new FlowPane();

      Label lblCatalog = new Label("Add New Food");

      Button btnBack = new Button("Back");
      Button btnAdd = new Button("Add");
      btnBack.setOnAction(this);
      btnAdd.setOnAction(this);

      // Top FlowPane features
      topPane.setAlignment(Pos.TOP_CENTER);
      lblCatalog.setFont(new Font("Arial", 30));
      topPane.getChildren().add(lblCatalog);

      // TABBED
      Tab tab1 = new Tab("Food", new Label("Name:\nCalories:\nFat:\nCarb:\nProtein:\n"));
      Tab tab2 = new Tab("Recipe", new Label("Name:\nCalories:\nFat:\nCarb:\nProtein:\n"));

      tabPane.getTabs().add(tab1);
      tabPane.getTabs().add(tab2);

      tabPane.setPrefHeight(250);
      tabPane.setPadding(new Insets(20, 20, 20, 20));

      // Primjer kako da dobijes odabrani Tab: Tab selectedTab =
      // tabPane.getSelectionModel().getSelectedItem();

      // Bottom FlowPane features
      botPane.setAlignment(Pos.BOTTOM_CENTER);
      botPane.setPadding(new Insets(10, 0, 0, 0));
      botPane.setHgap(100);
      botPane.getChildren().addAll(btnBack, btnAdd);

      root.getChildren().addAll(topPane, tabPane, botPane);

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

}