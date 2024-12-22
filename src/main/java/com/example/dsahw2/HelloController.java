package com.example.dsahw2;

import Entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {
    @FXML
    private TextField nameField;

    @FXML
    private TextField ageField;

    @FXML
    private TextField scoreField;

    @FXML
    private TableView<Student> studentTable;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TableColumn<Student, Integer> ageColumn;

    @FXML
    private TableColumn<Student, Double> scoreColumn;

    private final ObservableList<Student> studentList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Liên kết cột với dữ liệu
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));

        studentTable.setItems(studentList);
    }

    @FXML
    public void onAddButtonClick() {
        try {
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            double score = Double.parseDouble(scoreField.getText());

            Student student = new Student(name, age, score);
            studentList.add(student);

            // Xóa dữ liệu sau khi thêm
            nameField.clear();
            ageField.clear();
            scoreField.clear();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Vui lòng nhập đúng định dạng!");
            alert.showAndWait();
        }
    }

    @FXML
    public void onSortButtonClick() {
        // Áp dụng thuật toán Insertion Sort
        Student[] students = studentList.toArray(new Student[0]);
        InsertionSort.sort(students);

        // Cập nhật danh sách đã sắp xếp
        studentList.setAll(students);

        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Danh sách đã được sắp xếp!");
        alert.showAndWait();
    }
}
