/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab03_kourosh;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

/**
 *
 * @author 2440557
 */
public class Lab03_Kourosh extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage){
        //labels and TextFields
        Label firstNameLabel = new Label("First Name:");
        TextField firstNameField = new TextField();
        
        Label LastNameLabel = new Label("Last Name:");
        TextField LastNameField = new TextField();
        
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        
        //Buttons
        Button registerBttn = new Button("Register");
        Button clearBttn = new Button("Clear");
         
        GridPane grid = new GridPane();
        BorderPane root = new BorderPane();
        root.setCenter(grid);
        
        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
    
}
