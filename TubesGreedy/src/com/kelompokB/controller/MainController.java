package com.kelompokB.controller;

import com.kelompokB.Main;
import com.kelompokB.entity.Activity;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

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
        activities.add(new Activity("A1",LocalTime.of(1,0), LocalTime.of(4,0)));
        activities.add(new Activity("A2",LocalTime.of(3,0), LocalTime.of(5,0)));
        activities.add(new Activity("A3",LocalTime.of(0,0), LocalTime.of(6,0)));
        activities.add(new Activity("A4",LocalTime.of(5,0), LocalTime.of(7,0)));
        activities.add(new Activity("A5",LocalTime.of(3,0), LocalTime.of(9,0)));
        activities.add(new Activity("A6",LocalTime.of(5,0), LocalTime.of(9,0)));
        activities.add(new Activity("A7",LocalTime.of(6,0), LocalTime.of(10,0)));
        activities.add(new Activity("A8",LocalTime.of(8,0), LocalTime.of(11,0)));
        activities.add(new Activity("A9",LocalTime.of(8,0), LocalTime.of(12,0)));
        activities.add(new Activity("A10",LocalTime.of(2,0), LocalTime.of(14,0)));
        activities.add(new Activity("A11",LocalTime.of(12,0), LocalTime.of(16,0)));
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

    public ObservableList<Activity> getActivities() {
        return activities;
    }

    @FXML
    private void outputAction(ActionEvent actionEvent) throws IOException, InterruptedException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/output_layout.fxml"));
        Parent root = loader.load();
        OutputController outputController = loader.getController();
        outputController.setMainController(this);
        outputController.output();

        Stage outputStage = new Stage();
        outputStage.setTitle("Output");
        outputStage.setScene(new Scene(root));
        outputStage.initOwner(rootBorder.getScene().getWindow());
        outputStage.initModality(Modality.WINDOW_MODAL);
        outputStage.show();
    }
}
