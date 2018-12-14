/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.litinow.hotelmanagement;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Renata
 */
public class CostumersScreenController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXTreeTableView<Costumer> treeView;

    @FXML
    private JFXTextField searchText;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadAllCostumers("SELECT * FROM costumer");
    }  
     public void loadAllCostumers(String sql) {

        com.jfoenix.controls.JFXTreeTableColumn<Costumer, String> id = new com.jfoenix.controls.JFXTreeTableColumn<>("Id");
        id.setPrefWidth(70);
        id.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Costumer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Costumer, String> param) {
                return param.getValue().getValue().id;
            }

        });

        com.jfoenix.controls.JFXTreeTableColumn<Costumer, String> name = new com.jfoenix.controls.JFXTreeTableColumn<>("Name");
        name.setPrefWidth(80);
        name.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Costumer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Costumer, String> param) {
                return param.getValue().getValue().name;
            }

        });

        com.jfoenix.controls.JFXTreeTableColumn<Costumer, String> email = new com.jfoenix.controls.JFXTreeTableColumn<>("Email");
        email.setPrefWidth(110);
        email.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Costumer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Costumer, String> param) {
                return param.getValue().getValue().email;
            }

        });

        com.jfoenix.controls.JFXTreeTableColumn<Costumer, String> address = new com.jfoenix.controls.JFXTreeTableColumn<>("Adress");
        address.setPrefWidth(100);
        address.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Costumer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Costumer, String> param) {
                return param.getValue().getValue().address;
            }

        });

        com.jfoenix.controls.JFXTreeTableColumn<Costumer, String> phone = new com.jfoenix.controls.JFXTreeTableColumn<>("Phone");
        phone.setPrefWidth(100);
        phone.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Costumer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Costumer, String> param) {
                return param.getValue().getValue().phone;
            }

        });

        com.jfoenix.controls.JFXTreeTableColumn<Costumer, String> numOfPeople = new com.jfoenix.controls.JFXTreeTableColumn<>("Number of People");
        numOfPeople.setPrefWidth(80);
        numOfPeople.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Costumer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Costumer, String> param) {
                return param.getValue().getValue().numOfPeople;
            }

        });

        com.jfoenix.controls.JFXTreeTableColumn<Costumer, String> payment = new com.jfoenix.controls.JFXTreeTableColumn<>("Payment Type");
        payment.setPrefWidth(110);
        payment.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Costumer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Costumer, String> param) {
                return param.getValue().getValue().paymentType;
            }

        });
        
          com.jfoenix.controls.JFXTreeTableColumn<Costumer, String> duration = new com.jfoenix.controls.JFXTreeTableColumn<>("Duration");
        duration.setPrefWidth(80);
        duration.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Costumer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Costumer, String> param) {
                return param.getValue().getValue().duration;
            }

        });

        com.jfoenix.controls.JFXTreeTableColumn<Costumer, String> roomType = new com.jfoenix.controls.JFXTreeTableColumn<>("Room Type");
        roomType.setPrefWidth(80);
        roomType.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Costumer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Costumer, String> param) {
                return param.getValue().getValue().roomType;
            }

        });
        
        com.jfoenix.controls.JFXTreeTableColumn<Costumer, String> roomNumber = new com.jfoenix.controls.JFXTreeTableColumn<>("Room Number");
        roomNumber.setPrefWidth(80);
        roomNumber.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Costumer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Costumer, String> param) {
                return param.getValue().getValue().roomNumber;
            }

        });
        
        com.jfoenix.controls.JFXTreeTableColumn<Costumer, String> start = new com.jfoenix.controls.JFXTreeTableColumn<>("Start Date");
        start.setPrefWidth(100);
        start.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Costumer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Costumer, String> param) {
                return param.getValue().getValue().startDate;
            }

        });
        
        com.jfoenix.controls.JFXTreeTableColumn<Costumer, String> end = new com.jfoenix.controls.JFXTreeTableColumn<>("End Date");
        end.setPrefWidth(100);
        end.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Costumer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Costumer, String> param) {
                return param.getValue().getValue().endDate;
            }

        });
        
        com.jfoenix.controls.JFXTreeTableColumn<Costumer, String> price = new com.jfoenix.controls.JFXTreeTableColumn<>("Price");
        price.setPrefWidth(80);
        price.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Costumer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Costumer, String> param) {
                return param.getValue().getValue().price;
            }

        });
        
        com.jfoenix.controls.JFXTreeTableColumn<Costumer, String> services = new com.jfoenix.controls.JFXTreeTableColumn<>("Services");
        services.setPrefWidth(90);
        services.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Costumer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Costumer, String> param) {
                return param.getValue().getValue().services;
            }

        });
        
        com.jfoenix.controls.JFXTreeTableColumn<Costumer, String> total = new com.jfoenix.controls.JFXTreeTableColumn<>("Total");
        total.setPrefWidth(90);
        total.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Costumer, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Costumer, String> param) {
                return param.getValue().getValue().total;
            }

        });
        
        ObservableList<Costumer> costumer = FXCollections.observableArrayList();
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                costumer.add(new Costumer(rs.getInt(1) + "", rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }

        final TreeItem<Costumer> root = new RecursiveTreeItem<>(costumer, RecursiveTreeObject::getChildren);
        treeView.getColumns().setAll(id, name, email, address, phone, numOfPeople, duration, payment, roomType, roomNumber, start, end, price, services, total);
        treeView.setRoot(root);
        treeView.setShowRoot(false);
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
        Stage current = (Stage) searchText.getScene().getWindow();
        Scene scene = new Scene(root);

        home.setScene(scene);
        home.initStyle(StageStyle.TRANSPARENT);

        home.show();
        current.hide();
    }

    @FXML
    private void searchByRoomNumber(MouseEvent event) {
        loadAllCostumers("SELECT * FROM costumer WHERE roomNumber = '"+searchText.getText().toString().trim()+"'");
    }
    
}
