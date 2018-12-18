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
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.sql.PreparedStatement;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Renata
 */
public class EmployeesScreenController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXTreeTableView<Employee> treeView;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXTextField password;

    @FXML
    private JFXTextField fullName;

    @FXML
    private JFXTextField address;

    @FXML
    private JFXTextField phone;

    @FXML
    private JFXTextField salary;

    @FXML
    private JFXTextField userType;

    @FXML
    private JFXDatePicker startDate;

    @FXML
    private JFXTextField search_text;

    @FXML
    private StackPane stackepane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        startDate.setValue(LocalDate.now());
        loadAllUsers("select id, username, password, fullname, address, phone, startDate, salary, userType from users;");

    }

    @FXML
    void back(MouseEvent event) {
        Stage home = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/AdminScreen.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AdminScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Stage current = (Stage) userType.getScene().getWindow();
        Scene scene = new Scene(root);

        home.setScene(scene);
        home.initStyle(StageStyle.TRANSPARENT);

        current.hide();
        home.show();
    }

    @FXML
    void clear(MouseEvent event) {

        username.setText("");
        password.setText("");
        fullName.setText("");
        phone.setText("");
        address.setText("");
        startDate.setValue(LocalDate.now());
        salary.setText("");
        userType.setText("");

    }

    @FXML
    void close(MouseEvent event) {

       JFXDialogLayout dialogLayout = new JFXDialogLayout();
        dialogLayout.setHeading(new Text("Close"));
        dialogLayout.setBody(new Text("Do you want to exit?"));

        JFXButton ok = new JFXButton("OK");
        JFXButton cancel = new JFXButton("Cancel");

        JFXDialog dialog = new JFXDialog(stackepane, dialogLayout, JFXDialog.DialogTransition.CENTER);

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
    void delete(MouseEvent event) {
        int res = 0;
        String text = search_text.getText();
        try {
            String sql = "DELETE FROM users WHERE id=?";
            Connection con = DBConnection.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
            preparedStatement.setString(1, text);

            res = preparedStatement.executeUpdate();

            con.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (res > 0) {
            Image image = new Image("img/mooo.png");
            Notifications notifications = Notifications.create()
                    .title("Comlete")
                    .text("User Deleted Successfuly")
                    .hideAfter(Duration.seconds(5))
                    .graphic(new ImageView(image))
                    .position(Pos.BOTTOM_RIGHT);
            notifications.darkStyle();
            notifications.show();
            loadAllUsers("SELECT * FROM users");
        } else {

            Image image = new Image("img/delete.png");
            Notifications notifications = Notifications.create()
                    .title("Error")
                    .text("Sorry Some Thing Error")
                    .hideAfter(Duration.seconds(5))
                    .graphic(new ImageView(image))
                    .position(Pos.BOTTOM_RIGHT);
            notifications.darkStyle();
            notifications.show();

        }

    }

    @FXML
    void insert(MouseEvent event) {
        int res = 0;

        try {
            String sql = "INSERT INTO users( username, password, fullName, address, phone, startDate, salary, userType) VALUES (?,?,?,?,?,?,?,?)";
            Connection con = DBConnection.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
            preparedStatement.setString(1, username.getText());
            preparedStatement.setString(2, password.getText());
            preparedStatement.setString(3, fullName.getText());
            preparedStatement.setString(4, address.getText());
            preparedStatement.setString(5, phone.getText());
            preparedStatement.setString(6, startDate.getValue().toString());
            preparedStatement.setString(7, salary.getText());
            preparedStatement.setString(8, userType.getText());

            res = preparedStatement.executeUpdate();
            loadAllUsers("SELECT * FROM users");
            con.close();

            if (res > 0) {
                Image image = new Image("img/mooo.png");
                Notifications notifications = Notifications.create()
                        .title("Comlete")
                        .text("User Added Successfuly")
                        .hideAfter(Duration.seconds(5))
                        .graphic(new ImageView(image))
                        .position(Pos.BOTTOM_RIGHT);
                notifications.darkStyle();
                notifications.show();
            } else {
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

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @FXML
    void search(MouseEvent event) {

        String text = search_text.getText();
        String sql = "SELECT * FROM users WHERE id=?";
        Connection con = DBConnection.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = (PreparedStatement) con.prepareStatement(sql);
            preparedStatement.setString(1, text);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                username.setText(resultSet.getString(2));
                password.setText(resultSet.getString(3));
                fullName.setText(resultSet.getString(5));
                address.setText(resultSet.getString(4));
                salary.setText(resultSet.getString(7));
                userType.setText(resultSet.getString(8));
                //txt_date.setText(resultSet.getString(2));
            }
        } catch (SQLException ex) {
        }
        loadAllUsers("SELECT * FROM users WHERE id='" + search_text.getText().toString().trim() + "'");

    }

    @FXML
    void update(MouseEvent event) {
        String text = search_text.getText().toString().trim();
        int res = 0;

        try {//username, password, fullName, address, phone, startDate, salary, userType
            String sql = "UPDATE users SET username=?,password=?,fullName=?,address=?,phone=?,startDate=?,salary=?,userType=? WHERE id= ?";
            Connection con = DBConnection.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
            preparedStatement.setString(1, username.getText());
            preparedStatement.setString(2, password.getText());
            preparedStatement.setString(3, fullName.getText());
            preparedStatement.setString(4, address.getText());
            preparedStatement.setString(5, phone.getText());
            preparedStatement.setString(6, startDate.getValue().toString());
            preparedStatement.setString(7, salary.getText());
            preparedStatement.setString(8, userType.getText());
            preparedStatement.setString(9, text);

            res = preparedStatement.executeUpdate();

            con.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //return st;
        if (res > 0) {
            Image image = new Image("img/mooo.png");
            Notifications notifications = Notifications.create()
                    .title("Complete")
                    .text("User Updated Successfully")
                    .hideAfter(Duration.seconds(5))
                    .graphic(new ImageView(image))
                    .position(Pos.BOTTOM_RIGHT);
            notifications.darkStyle();
            notifications.show();
            loadAllUsers("SELECT * FROM users");
            // System.out.println(" Record saved successfully! ");
        } else {

            Image image = new Image("img/delete.png");
            Notifications notifications = Notifications.create()
                    .title("Error")
                    .text("Sorry Some Thing Error")
                    .hideAfter(Duration.seconds(5))
                    .graphic(new ImageView(image))
                    .position(Pos.BOTTOM_RIGHT);
            notifications.darkStyle();
            notifications.show();

        }

    }

    private void loadAllUsers(String sql) {
        com.jfoenix.controls.JFXTreeTableColumn<Employee, String> emp_id = new com.jfoenix.controls.JFXTreeTableColumn<>("Id");
        emp_id.setPrefWidth(50);
        emp_id.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Employee, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Employee, String> param) {
                return param.getValue().getValue().emp_id;
            }
        });
        com.jfoenix.controls.JFXTreeTableColumn<Employee, String> emp_username = new com.jfoenix.controls.JFXTreeTableColumn<>("Username");
        emp_username.setPrefWidth(100);
        emp_username.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Employee, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Employee, String> param) {
                return param.getValue().getValue().emp_username;
            }
        });
        com.jfoenix.controls.JFXTreeTableColumn<Employee, String> emp_password = new com.jfoenix.controls.JFXTreeTableColumn<>("Password");
        emp_password.setPrefWidth(95);
        emp_password.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Employee, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Employee, String> param) {
                return param.getValue().getValue().emp_password;
            }
        });
        com.jfoenix.controls.JFXTreeTableColumn<Employee, String> emp_fullname = new com.jfoenix.controls.JFXTreeTableColumn<>("Full Name");
        emp_fullname.setPrefWidth(120);
        emp_fullname.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Employee, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Employee, String> param) {
                return param.getValue().getValue().emp_fullname;
            }
        });
        com.jfoenix.controls.JFXTreeTableColumn<Employee, String> emp_address = new com.jfoenix.controls.JFXTreeTableColumn<>("Address");
        emp_address.setPrefWidth(95);
        emp_address.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Employee, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Employee, String> param) {
                return param.getValue().getValue().emp_address;
            }
        });
        com.jfoenix.controls.JFXTreeTableColumn<Employee, String> emp_phone = new com.jfoenix.controls.JFXTreeTableColumn<>("Phone");
        emp_phone.setPrefWidth(100);
        emp_phone.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Employee, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Employee, String> param) {
                return param.getValue().getValue().emp_phone;
            }
        });
        com.jfoenix.controls.JFXTreeTableColumn<Employee, String> emp_startdate = new com.jfoenix.controls.JFXTreeTableColumn<>("Start Date");
        emp_startdate.setPrefWidth(100);
        emp_startdate.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Employee, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Employee, String> param) {
                return param.getValue().getValue().emp_start_date;
            }
        });
        com.jfoenix.controls.JFXTreeTableColumn<Employee, String> emp_salary = new com.jfoenix.controls.JFXTreeTableColumn<>("Salary");
        emp_salary.setPrefWidth(90);
        emp_salary.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Employee, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Employee, String> param) {
                return param.getValue().getValue().emp_salary;
            }
        });
        com.jfoenix.controls.JFXTreeTableColumn<Employee, String> emp_usertype = new com.jfoenix.controls.JFXTreeTableColumn<>("User Type");

        emp_usertype.setPrefWidth(100);
        emp_usertype.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Employee, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Employee, String> param) {
                return param.getValue().getValue().emp_usertype;
            }
        });

        ObservableList<Employee> employees = FXCollections.observableArrayList();
        

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                employees.add(new Employee(rs.getInt(1) + "", rs.getString(2), rs.getString(3), rs.getString(4) + "", rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));

            }

            con.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        final TreeItem<Employee> root = new RecursiveTreeItem<>(employees, RecursiveTreeObject::getChildren);
        treeView.getColumns().setAll(emp_id, emp_username, emp_password, emp_fullname, emp_address, emp_phone, emp_startdate, emp_salary, emp_usertype);
        treeView.setRoot(root);
        treeView.setShowRoot(false);

    }

}
