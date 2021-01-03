package com.kelompokB.controller;

import com.kelompokB.entity.Activity;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private BorderPane rootBorder;
    @FXML
    private TableView<Activity> tableKegiatan;
    @FXML
    private TableColumn<Activity, String> colNamaKegiatan;
    @FXML
    private TableColumn<Activity, String> colWaktuMulai;
    @FXML
    private TableColumn<Activity, String> colWaktuSelesai;
    @FXML
    private TextArea namaKegiatan;
    @FXML
    private Button btnSaveKegiatan;
    @FXML
    private Button btnUpdateKegiatan;
    @FXML
    private Button btnDeleteKegiatan;
    @FXML
    private TextField waktuMulai;
    @FXML
    private TextField waktuSelesai;
    private ObservableList<Activity> activities;
    private Activity selectedActivity;
    private LocalTime time;

    @FXML
    private void saveAction(ActionEvent actionEvent) {
        if(namaKegiatan.getText().trim().isEmpty() || waktuMulai.getText().trim().isEmpty() || waktuSelesai.getText().trim().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please fill Nama Kegiatan/ Waktu Mulai/ Waktu Selesai");
            alert.showAndWait();
        }else{
//            if(duplicate(namaKegiatan.getText().trim(), waktuMulai.getText().trim(), waktuSelesai.getText().trim())){
//                Alert alert =  new Alert(Alert.AlertType.ERROR);
//                alert.setContentText("Duplicate menu");
//                alert.showAndWait();
//            }else{
            Activity activity = new Activity();
            activity.setNamaKegiatan(namaKegiatan.getText().trim());
            time = LocalTime.parse(waktuMulai.getText().trim());
            activity.setWaktuMulai(time);
            time = LocalTime.parse(waktuSelesai.getText().trim());
            activity.setWaktuSelesai(time);
            activities.add(activity);
            namaKegiatan.clear();
            waktuMulai.clear();
            waktuSelesai.clear();
//            }
        }
    }

    @FXML
    private void resetAction(ActionEvent actionEvent) {
        resetMenu();
    }

    @FXML
    private void closeAction(ActionEvent actionEvent) {
        System.exit(1);
    }

    @FXML
    private void aboutAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Tugas Besar Strategi Algoritmik");
        alert.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        activities = FXCollections.observableArrayList();
        tableKegiatan.setItems(activities);
        colNamaKegiatan.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNamaKegiatan()));
        colWaktuMulai.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getWaktuMulai().toString()));
        colWaktuSelesai.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getWaktuSelesai().toString()));
    }

//    private boolean duplicate(String namaKegiatan, Time){
//        for(int i = 0; i < menus.size(); i++){
//            if(name.equals(menus.get(i).getName()) && category.getName().equals(menus.get(i).getCategory().getName())){
//                return true;
//            }
//        }
//        return false;
//    }

    @FXML
    private void tableMenuAction(MouseEvent mouseEvent) {

    }

    @FXML
    private void updateAction(ActionEvent actionEvent) {
//        if(txtName.getText().trim().isEmpty() || txtPrice.getText().trim().isEmpty() || txtDescription.getText().trim().isEmpty() || comboCategory.getValue() == null){
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setContentText("Please fill name/ price/ description/ category");
//            alert.showAndWait();
//        }else{
//            selectedMenu.setName(txtName.getText().trim());
//            selectedMenu.setPrice(Double.parseDouble(txtPrice.getText().trim()));
//            selectedMenu.setDescription(txtDescription.getText().trim());
//            selectedMenu.setRecommended((byte) (checkboxRecommended.isSelected() ? 1 : 0));
//            selectedMenu.setCategory(comboCategory.getValue());
//            if (menuDao.updateData(selectedMenu) == 1){
//                menus.clear();
//                menus.addAll(menuDao.fetchAll());
//                resetMenu();
//            }
//        }
    }

    @FXML
    private void deleteAction(ActionEvent actionEvent) {
//        deleteObject(selectedMenu);
    }

    private void deleteObject(Object object){
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setContentText("Are you sure want to delete?");
//        alert.showAndWait();
//        if(alert.getResult() == ButtonType.OK){
//            if(object instanceof Menu){
//                if (menuDao.deleteData(selectedMenu) == 1){
//                    menus.clear();
//                    menus.addAll(menuDao.fetchAll());
//                    resetMenu();
//                }
//            }
//        }
    }

    private void resetMenu(){
        namaKegiatan.clear();
        waktuMulai.clear();
        waktuSelesai.clear();
    }

    @FXML
    private void tableKegiatanAction(MouseEvent mouseEvent) {
        selectedActivity = tableKegiatan.getSelectionModel().getSelectedItem();
        if(selectedActivity != null){
            namaKegiatan.setText(selectedActivity.getNamaKegiatan());
            waktuMulai.setText(selectedActivity.getWaktuMulai().toString());
            waktuSelesai.setText(selectedActivity.getWaktuSelesai().toString());
        }
    }
}
