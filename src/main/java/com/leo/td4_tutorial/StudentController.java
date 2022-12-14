package com.leo.td4_tutorial;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StudentController implements Initializable {

    @FXML
    private ComboBox<String> cmbGender;

    @FXML
    private Label lblGender;

    @FXML
    private Label lblName;

    @FXML
    private Label lblStudentDetails;

    @FXML
    private Label lblStudentList;

    @FXML
    private ListView<Student> lvStudentList;

    @FXML
    private TextField txtName;

    DBManager dbManager;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dbManager = new DBManager();
        List<String> gvalues = new ArrayList<String>();
        gvalues.add("Male");
        gvalues.add("Female");
        ObservableList<String> gender = FXCollections.observableArrayList(gvalues);
        cmbGender.setItems(gender);

        fetchStudents();
    }

    private void displayStudentDetails(Student selectedStudent) {
        if(selectedStudent!=null){
            txtName.setText(selectedStudent.getName());
            cmbGender.setValue(selectedStudent.getGender());
        }
    }

    public void fetchStudents() {
        List<Student> listStudents = dbManager.loadStudents();
        if (listStudents != null) {
            ObservableList<Student> students;
            students = FXCollections.observableArrayList(listStudents);
            lvStudentList.setItems(students);
        }
    }
}