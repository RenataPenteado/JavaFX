package com.litinow.hotelmanagement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Renata
 */
public class LoginScreenController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private TextField password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginbutton(MouseEvent event) {
        
        boolean isExist = false;
        String userPass = "";
        String userType = "";
        String sql = "select * from users where username = '"+username.getText().trim()+"'";
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement ps = (PreparedStatement)connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                isExist = true;
                userPass = rs.getString(3);
                userType = rs.getString(9);
            }
            if(isExist){
                
                if(password.getText().trim().equals(userPass)){
                    
                    if(userType.equals("admin")){
                        //admin screen
                        
                        Stage adminScreen = new Stage();
                        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/fxml/AdminScreen.fxml"));
                        } catch (IOException ex) {
                            Logger.getLogger(LoginScreenController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        Stage current = (Stage)username.getScene().getWindow();
                        Scene scene = new Scene(root,1366,730);
                        
                        adminScreen.setScene(scene);
                        adminScreen.initStyle(StageStyle.TRANSPARENT);
                        
                        current.hide();
                        
                        adminScreen.show();
                        
                        
                    }else{
                        //home screen
                        
                         Stage homeScreen = new Stage();
                        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/fxml/HomeScreen.fxml"));
                        } catch (IOException ex) {
                            Logger.getLogger(LoginScreenController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        Stage current = (Stage)username.getScene().getWindow();
                        Scene scene = new Scene(root,1366,730);
                        
                        homeScreen.setScene(scene);
                        homeScreen.initStyle(StageStyle.TRANSPARENT);
                        
                        current.hide();
                        
                        homeScreen.show();
                    }
                }
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
