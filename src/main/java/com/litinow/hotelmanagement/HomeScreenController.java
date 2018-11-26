/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.litinow.hotelmanagement;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Renata
 */
public class HomeScreenController implements Initializable {

    @FXML
    private StackPane stackpane;
    @FXML
    private Pane pane_2;
    @FXML
    private Pane pane_1;
    @FXML
    private Pane pane_3;
    @FXML
    private Pane pane_4;
    @FXML
    private Pane pane_5;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void mouse_hover_1(MouseEvent event) {
        pane_1.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
    }

    @FXML
    private void mouse_exit_1(MouseEvent event) {
        pane_1.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    }

    @FXML
    private void mouse_hover_2(MouseEvent event) {
        pane_2.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
    }

    @FXML
    private void mouse_exit_2(MouseEvent event) {
        pane_2.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    }

    @FXML
    private void mouse_hover_3(MouseEvent event) {
        pane_3.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
    }

    @FXML
    private void mouse_exit_3(MouseEvent event) {
        pane_3.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    }

    @FXML
    private void mouse_hover_4(MouseEvent event) {
        pane_4.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
    }

    @FXML
    private void mouse_exit_4(MouseEvent event) {
        pane_4.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    }

    @FXML
    private void mouse_hover_5(MouseEvent event) {
        pane_5.setStyle("-fx-background-color: #377ce8; -fx-background-radius: 6px;");
    }

    @FXML
    private void mouse_exit_5(MouseEvent event) {
        pane_5.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
    }

    @FXML
    private void roomScreen(MouseEvent event) {
        Stage room = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/RoomScreen.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AdminScreenController.class.getName()).log(Level.SEVERE, null, ex);

        }
        Stage current = (Stage) pane_1.getScene().getWindow();
        Scene scene = new Scene(root);

        room.setScene(scene);
        room.initStyle(StageStyle.TRANSPARENT);

        current.hide();
        room.show();

    }

    @FXML
    private void reservationScreen(MouseEvent event) {
        Stage reservation = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/ReservationScreen.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AdminScreenController.class.getName()).log(Level.SEVERE, null, ex);

        }
        Stage current = (Stage) pane_1.getScene().getWindow();
        Scene scene = new Scene(root);

        reservation.setScene(scene);
        reservation.initStyle(StageStyle.TRANSPARENT);

        current.hide();
        reservation.show();

    }

    @FXML
    private void costumerScreen(MouseEvent event) {
        Stage costumer = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/CostumerInfoScreen.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AdminScreenController.class.getName()).log(Level.SEVERE, null, ex);

        }
        Stage current = (Stage) pane_1.getScene().getWindow();
        Scene scene = new Scene(root);

        costumer.setScene(scene);
        costumer.initStyle(StageStyle.TRANSPARENT);

        current.hide();
        costumer.show();

    }

    @FXML
    private void logout(MouseEvent event) {
                JFXDialogLayout dialogLayout = new JFXDialogLayout();
        dialogLayout.setHeading(new Text("Alert"));
        dialogLayout.setBody(new Text("Do you want to logout?"));

        JFXButton ok = new JFXButton("OK");
        JFXButton cancel = new JFXButton("Cancel");

        JFXDialog dialog = new JFXDialog(stackpane, dialogLayout, JFXDialog.DialogTransition.CENTER);

        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage login = new Stage();
                Parent root = null;

                try {
                    root = FXMLLoader.load(getClass().getResource("/fxml/LoginScreen.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(AdminScreenController.class.getName()).log(Level.SEVERE, null, ex);

                }
                Stage current = (Stage) pane_1.getScene().getWindow();
                Scene scene = new Scene(root);

                login.setScene(scene);
                login.initStyle(StageStyle.TRANSPARENT);

                current.hide();
                login.show();
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
    private void exit(MouseEvent event) {
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

}
