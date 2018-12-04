package com.litinow.hotelmanagement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.TextField;
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
public class LoginScreenController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private StackPane stackerpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void loginbutton(MouseEvent event) {

        if (username.getText().equals("")) {
            errorNotification("Username Is Empty");

        } else if (password.getText().equals("")) {
            errorNotification("Password Is Empty");

        } else {
            boolean isExist = false;
            String userPass = "";
            String userType = "";
            String sql = "select * from users where username = '" + username.getText().trim() + "'";
            Connection connection = DBConnection.getConnection();
            try {
                PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    isExist = true;
                    userPass = rs.getString(3);
                    userType = rs.getString(9);
                }
                if (isExist) {

                    if (password.getText().trim().equals(userPass)) {

                        if (userType.equals("admin")) {
                            //admin screen

                            Stage adminScreen = new Stage();
                            Parent root = null;
                            try {
                                root = FXMLLoader.load(getClass().getResource("/fxml/AdminScreen.fxml"));
                            } catch (IOException ex) {
                                Logger.getLogger(LoginScreenController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            Stage current = (Stage) username.getScene().getWindow();
                            Scene scene = new Scene(root, 1366, 730);

                            adminScreen.setScene(scene);
                            adminScreen.initStyle(StageStyle.TRANSPARENT);

                            adminScreen.show();
                            current.hide();

                        } else {
                            //home screen

                            Stage homeScreen = new Stage();
                            Parent root = null;
                            try {
                                root = FXMLLoader.load(getClass().getResource("/fxml/HomeScreen.fxml"));
                            } catch (IOException ex) {
                                Logger.getLogger(LoginScreenController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            Stage current = (Stage) username.getScene().getWindow();
                            Scene scene = new Scene(root, 1366, 730);

                            homeScreen.setScene(scene);
                            homeScreen.initStyle(StageStyle.TRANSPARENT);

                            homeScreen.show();
                            current.hide();
                            
                        }
                    } else {
                        errorNotification("Check Your password again");
                    }

                } else {
                    errorNotification("Check Your username and password again");

                }

            } catch (SQLException ex) {
                Logger.getLogger(LoginScreenController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    @FXML
    private void cancelButton(MouseEvent event) {

        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        dialogLayout.setHeading(new Text("Close"));
        dialogLayout.setBody(new Text("Do you want to exit?"));

        JFXButton ok = new JFXButton("OK");
        JFXButton cancel = new JFXButton("Cancel");

        JFXDialog dialog = new JFXDialog(stackerpane, dialogLayout, JFXDialog.DialogTransition.CENTER);

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

    private void errorNotification(String message) {
        Image image = new Image("img/delete.png");
        Notifications notification = Notifications.create()
                .title("Error")
                .text(message)
                .hideAfter(Duration.seconds(3))
                .position(Pos.BOTTOM_LEFT)
                .graphic(new ImageView(image));
        notification.darkStyle();
        notification.show();
    }
}
