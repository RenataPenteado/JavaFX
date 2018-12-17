/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.litinow.hotelmanagement;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Renata
 */
public class ReservationScreenController implements Initializable {

    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField phone;
    @FXML
    private JFXTextField address;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField duration;
    @FXML
    private JFXTextField num_of_people;
    @FXML
    private JFXTextField paymentType;
    @FXML
    private JFXTextField roomType;
    @FXML
    private JFXTextField roomNumber;
    @FXML
    private JFXTextField price;
    @FXML
    private JFXTextField services;
    @FXML
    private JFXTextField total;
    @FXML
    private JFXDatePicker startDate;
    @FXML
    private StackPane stackpane;
    @FXML
    private JFXDatePicker endDate;

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void back(MouseEvent event) {
        Stage home = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/HomeScreen.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AdminScreenController.class.getName()).log(Level.SEVERE, null, ex);

        }
        Stage current = (Stage) roomNumber.getScene().getWindow();
        Scene scene = new Scene(root);

        home.setScene(scene);
        home.initStyle(StageStyle.TRANSPARENT);

        home.show();
        current.hide();
    }
    

    @FXML
    private void close(MouseEvent event) {
         JFXDialogLayout dialogLayout = new JFXDialogLayout();
        dialogLayout.setHeading(new Text("Close"));
        dialogLayout.setBody(new Text("Do you want to exit?"));

        JFXButton ok = new JFXButton("OK");
        JFXButton cancel = new JFXButton("Cancel");

        JFXDialog dialog = new JFXDialog(stackpane, dialogLayout, JFXDialog.DialogTransition.CENTER);

        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });

        dialogLayout.setActions(ok, cancel);
        dialog.show();
    }

    @FXML
    private void rest(MouseEvent event) {
        name.setText("");
        email.setText("");
        address.setText("");
        phone.setText("");
        paymentType.setText("");
        num_of_people.setText("");
        roomNumber.setText("");
        roomType.setText("");
        price.setText("");
        total.setText("");
        startDate.setValue(LocalDate.now());
        endDate.setValue(LocalDate.now());
        services.setText("");
        duration.setText("");
        
        
    }

    @FXML
    private void book(MouseEvent event) {
        int res = 0;
        String sql = "INSERT INTO customer(name,email,address,phone,numOfPeople,paymentType,duration,roomType,roomNumber,startDate,endDate,price,services,total)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement ps = (PreparedStatement)connection.prepareStatement(sql);
            ps.setString(1, name.getText().toString());
            ps.setString(2, email.getText().toString());
            ps.setString(3, address.getText().toString());
            ps.setString(4, phone.getText().toString());
            ps.setString(5, num_of_people.getText().toString());
            ps.setString(6, paymentType.getText().toString());
            ps.setString(7, duration.getText().toString());
            ps.setString(8, roomType.getText().toString());
            ps.setString(9, roomNumber.getText().toString());
            ps.setString(10, startDate.getValue().toString());
            ps.setString(11, endDate.getValue().toString());
            ps.setString(12, price.getText().toString());
            ps.setString(13, services.getText().toString());
            ps.setString(14, total.getText().toString());
            
            res = ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ReservationScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(res>0){
            Image image = new Image("img/mooo.png");
        Notifications notification = Notifications.create()
                .title("Done")
                .text("Data Added Scussfully")
                .hideAfter(Duration.seconds(3))
                .position(Pos.BOTTOM_LEFT)
                .graphic(new ImageView(image));
        notification.darkStyle();
        notification.show();
        updateStatus();
        }else{
            Image image = new Image("img/delete.png");
        Notifications notification = Notifications.create()
                .title("Error")
                .text("Something wrong")
                .hideAfter(Duration.seconds(3))
                .position(Pos.BOTTOM_LEFT)
                .graphic(new ImageView(image));
        notification.darkStyle();
        notification.show();
        }
    }

    @FXML
    private void print(MouseEvent event) {
    }

    private void updateStatus() {
      String text = roomNumber.getText().toString().trim();
      String sql = "UPDATE room SET roomStatus=? WHERE roomNumber=?";
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement ps = (PreparedStatement)connection.prepareStatement(sql);
            ps.setString(1, "busy");
            ps.setString(2, text);
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(RoomScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
