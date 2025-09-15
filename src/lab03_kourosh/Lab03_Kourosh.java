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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    
    /**
     * method to validate the email
     * @param email
     * @return true or false according to the validity of the email
     */
    private boolean checkEmail(String email) {
        int index = email.indexOf('@');
        if (!(index > 0)) return false;
        
        if (email.indexOf('.', index + 2) != -1) {
            return true;
        }
        
        return false;
    }
    
    /**
     * method to validate the password
     * @param password
     * @return true or false according to the validity of the password
     */
    private boolean checkPassword(String password) {
        boolean digit = false,  letter = false;
        
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) digit = true;
            else if (Character.isLetter(c)) letter = true;
        }
        
        return digit && letter;
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
        
        Label message = new Label();
        
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
        grid.add(message, 0,5);
        
        //setting grid seettings
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        //Text Field Array
        TextField[] textFields = {firstNameField, lastNameField, emailField, passwordField};
        
        //button disabled when all text fields are not filled
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
        
        //clear button event
        clearBttn.setOnAction(e ->{
            for (TextField field : textFields) {
                field.clear();   
            }message.setText("");
        });
        
        //Register button event
        registerBttn.setOnAction(e ->{     
            message.setText(checkEmail(emailField.getText()) && checkPassword(passwordField.getText()) ? "Welcome" : "Error");
        });
        
        
        root.setCenter(grid);
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
