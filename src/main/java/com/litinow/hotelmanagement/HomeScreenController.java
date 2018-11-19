/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.litinow.hotelmanagement;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Renata
 */
public class HomeScreenController implements Initializable {

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
    
}
