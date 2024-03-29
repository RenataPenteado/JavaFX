/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.litinow.hotelmanagement;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Renata
 */
public class RoomScreenController implements Initializable {

    /**
     * Initializes the controller class.
     */
    String status = null;
   
    @FXML
    private JFXTreeTableView<Customers> treeView;
    @FXML
    private JFXTextField search_text;
    @FXML
    private JFXCheckBox busy;
    @FXML
    private JFXCheckBox available;
    @FXML
    private StackPane stackpane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadAllRooms("SELECT * FROM room");
    }

    public void loadAllRooms(String sql) {

        JFXTreeTableColumn<Customers, String> room_id = new JFXTreeTableColumn<>("Room Id");
        room_id.setPrefWidth(100);
        room_id.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customers, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customers, String> param) {
                return param.getValue().getValue().id;
            }

        });

        JFXTreeTableColumn<Customers, String> room_type = new JFXTreeTableColumn<>("Room Type");
        room_type.setPrefWidth(110);
        room_type.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customers, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customers, String> param) {
                return param.getValue().getValue().roomType;
            }

        });

        JFXTreeTableColumn<Customers, String> room_number = new JFXTreeTableColumn<>("Room Number");
        room_number.setPrefWidth(110);
        room_number.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customers, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customers, String> param) {
                return param.getValue().getValue().roomNumber;
            }

        });

        JFXTreeTableColumn<Customers, String> num_of_people = new JFXTreeTableColumn<>("Number Of People");
        num_of_people.setPrefWidth(130);
        num_of_people.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customers, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customers, String> param) {
                return param.getValue().getValue().numberOfPeople;
            }

        });

        JFXTreeTableColumn<Customers, String> floor_number = new JFXTreeTableColumn<>("Floor Number");
        floor_number.setPrefWidth(120);
        floor_number.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customers, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customers, String> param) {
                return param.getValue().getValue().floorNumber;
            }

        });

        JFXTreeTableColumn<Customers, String> room_phone = new JFXTreeTableColumn<>("Room Number");
        room_phone.setPrefWidth(110);
        room_phone.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customers, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customers, String> param) {
                return param.getValue().getValue().roomNumber;
            }

        });

        JFXTreeTableColumn<Customers, String> room_price = new JFXTreeTableColumn<>("Room Price");
        room_price.setPrefWidth(110);
        room_price.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customers, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customers, String> param) {
                return param.getValue().getValue().roomPrice;
            }

        });

        JFXTreeTableColumn<Customers, String> room_status = new JFXTreeTableColumn<>("Room Status");
        room_status.setPrefWidth(110);
        room_status.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Customers, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Customers, String> param) {
                return param.getValue().getValue().roomStatus;
            }

        });
        ObservableList<Customers> rooms = FXCollections.observableArrayList();
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                rooms.add(new Customers(rs.getInt(1) + "", rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }

        final TreeItem<Customers> root = new RecursiveTreeItem<>(rooms, RecursiveTreeObject::getChildren);
        treeView.getColumns().setAll(room_id, room_type,room_number, num_of_people, floor_number, room_phone, room_price, room_status);
        treeView.setRoot(root);
        treeView.setShowRoot(false);
    }

    @FXML
    private void searchByRoomNumber(MouseEvent event) {
        loadAllRooms("SELECT * FROM room WHERE roomNumber = '"+search_text.getText().toString().trim()+"'");
    }

    @FXML
    private void makeItAvailable(MouseEvent event) {
        
        String text = search_text.getText().toString().trim();
        int res = 0;
        String sql = "UPDATE room SET roomStatus=? WHERE roomNumber=?";
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement ps = (PreparedStatement)connection.prepareStatement(sql);
            ps.setString(1, "available");
            ps.setString(2, text);
            
            res = ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(RoomScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(res>0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Data update");
                alert.setHeaderText("Information Dialog");
                alert.setContentText("Record update sucessfully!");
                alert.showAndWait();
            loadAllRooms("SELECT * FROM `room` WHERE 1");
        }else{
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Data update");
                alert.setHeaderText("Information Dialog");
                alert.setContentText("Error!");
                alert.showAndWait();
                       
        }
    }

    @FXML
    private void searchByStatus(MouseEvent event) {
        loadAllRooms(status);
    }

    @FXML
    private void goBack(MouseEvent event) {
        Stage home = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/HomeScreen.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AdminScreenController.class.getName()).log(Level.SEVERE, null, ex);

        }
        Stage current = (Stage) search_text.getScene().getWindow();
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
    private void searchBusy(ActionEvent event) {
        available.setSelected(false);
        status = "SELECT * FROM room WHERE roomStatus = 'busy'";
    }
    
    @FXML
    private void searchAvailable(ActionEvent event) {
        busy.setSelected(false);
        status = "SELECT * FROM room WHERE roomStatus = 'available'";
    }

}
