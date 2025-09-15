/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab03_kourosh;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.KeyEvent;

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
        //grid pane and border pane
        GridPane grid = new GridPane();
        BorderPane root = new BorderPane();
        
        //labels and TextFields
        Label firstNameLabel = new Label("First Name:");
        TextField firstNameField = new TextField();
        
        Label lastNameLabel = new Label("Last Name:");
        TextField lastNameField = new TextField();
        
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        
        //Buttons
        Button registerBttn = new Button("Register");
        registerBttn.setDisable(true);
        Button clearBttn = new Button("Clear");
         
        //setting nodes into Grid Pane
        grid.add(firstNameLabel, 0, 0);
        grid.add(firstNameField, 1, 0);
        grid.add(lastNameLabel, 0, 1);
        grid.add(lastNameField, 1, 1);
        grid.add(emailLabel, 0, 2);
        grid.add(emailField, 1, 2);
        grid.add(passwordLabel, 0, 3);
        grid.add(passwordField, 1, 3);
        grid.add(registerBttn, 0, 4);
        grid.add(clearBttn, 1, 4);
        
        //setting grid seettings
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        //Text Field Array
        TextField[] textFields = {firstNameField, lastNameField, emailField, passwordField};
        for (TextField field : textFields) {
            field.setOnKeyPressed(e -> {
                for (TextField textField : textFields) {
                    if (textField.getText().isEmpty()) {
                        registerBttn.setDisable(true);
                    } else {
                        registerBttn.setDisable(false);
                    }
                }
            });
        }
        
        root.setCenter(grid);
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
