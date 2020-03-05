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
    
   private TextArea area1;
   private TextArea area2;
   private PrintWriter pw;
   private Stage stage;
   private FileChooser fc = new FileChooser();
   private Scanner scanner;
   private File selectedFile = null;
   private FileWriter fw;
      
   public ProjectMethods(TextArea area1, TextArea area2, Stage stage){
      this.area1 = area1;
      this.area2 = area2;
      this.stage = stage;
   }
     
   public void handle(ActionEvent evt){      // Handler
     
      MenuItem item = (MenuItem)evt.getSource();
      Button btn = (Button)evt.getSource();
      
      switch(item.getText()){
                     
         case "New":          // Case 1                                
            
            doNew();
          
            break;
         
         case "Open":         // Case 2                                
            
            doOpen();
          
            break;
         
         case "Save":         // Case 3                                
            
            doSave();
          
            break;
         
         case "Save As":      // Case 4                                
            
            doSaveAs();
          
            break;
      
         case "Exit":         // Case 5                                
            
            System.exit(1);
          
            break;
      
      
      }
      
      switch(btn.getText()) {
      
         case "Log":
         
            doLog();
            
            break;
      
      }
   
   }
   
   
   
   
   // Methods for the Handler
   public void doNew(){
   
      area1.setText("");
      stage.setTitle("Editor");
   
   }
   
   public void doOpen(){
      
      area1.setText("");
      stage.setTitle("Editor");
      
      fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
      
      File selectedFile = fc.showOpenDialog(stage);
      String absolutePath = selectedFile.getAbsolutePath();
      
      if (selectedFile == null) {
         return;
      }
      
      try { 
         scanner = new Scanner(new FileInputStream(selectedFile));
         
         while (scanner.hasNext()){
            area1.appendText(scanner.nextLine() + "\n");
         }
      }catch(Exception e){
         Alert alert = new Alert(AlertType.ERROR);
         alert.showAndWait();
      }
    
      stage.setTitle("Editor: " + "<" + absolutePath + ">");
      
   }
   
   public void doSave(){
   
   
      String absolutePath = selectedFile.getAbsolutePath();
   
      
      try{  // Trying to print the data to the file and close the printer
         
         fw = new FileWriter(selectedFile, false);
         pw = new PrintWriter(fw);
         pw.printf("%s", area1.getText());
         pw.flush();
         pw.close();      
                                
      }
      catch(Exception e) {         
         Alert alert = new Alert(AlertType.ERROR, "File Name? \nPlease use Save As!\n");
         alert.showAndWait();             
      }
      stage.setTitle("Editor: " + "<" + absolutePath + ">");
   
   }
   
   public void doSaveAs(){
   
   
      String absolutePath = selectedFile.getAbsolutePath();
   
   
      fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
      
      File selectedFile = fc.showSaveDialog(stage);
   
   
      try{  // Trying to print the data to the file and close the printer
            
         pw = new PrintWriter(new FileWriter(selectedFile, false));
         pw.printf("%s", area1.getText());
         pw.flush();
         pw.close();      
                                
      }
      catch(Exception e) {         
         Alert alert = new Alert(AlertType.ERROR, "Issue Saving!\n");
         alert.showAndWait();             
      }
      
      stage.setTitle("Editor: " + "<" + absolutePath + ">");
        
   }
   
   public void doLog() {
   
   }
   
}