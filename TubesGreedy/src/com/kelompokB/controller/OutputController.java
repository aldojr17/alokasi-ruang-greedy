package com.kelompokB.controller;

import com.kelompokB.entity.Activity;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class OutputController implements Initializable {
    private MainController mainController;
    @FXML
    private TableView<Activity> tableActivity;
    @FXML
    private TableColumn<Activity, String> colNama, colMulai, colSelesai;
    @FXML
    private GridPane ruangan;
    private ObservableList<Activity> activities;

    public void setMainController(MainController mainController){
        this.mainController = mainController;
        activities = mainController.getActivities();
        Comparator<Activity> comparator = Comparator.comparing(Activity::getWaktuSelesai);
        SortedList<Activity> activitySortedList = new SortedList<>(activities, comparator);
        tableActivity.setItems(activitySortedList);
    }

    public void output(){
        int ruang = 0;
        while (activities.size() > 0){
            printMaxActivities(activities, ruang);
            ruang++;
        }
    }

    public void printMaxActivities(ObservableList<Activity> activities, int ruang)
    {
        ArrayList<Activity> del = new ArrayList<Activity>();
        int row = 0;

        Text text = new Text("Ruang " + (ruang+1));
        GridPane.setMargin(text, new Insets(20));
        ruangan.add(text,ruang,row++);

        //  n   -->  Total number of activities
        //  s[] -->  An array that contains start time of all activities
        //  f[] -->  An array that contains finish time of all activities
        int i, j;

        // The first activity always gets selected
        i = 0;
        text = new Text(activities.get(i).getNamaKegiatan());
        GridPane.setMargin(text, new Insets(20));
        ruangan.add(text,ruang,row++);
        del.add(this.activities.get(i));

        for(j = 1; j < this.activities.size(); j++){
            if (activities.get(j).getWaktuMulai().toSecondOfDay() >= activities.get(i).getWaktuSelesai().toSecondOfDay())
            {
                del.add(this.activities.get(j));
                text = new Text(activities.get(j).getNamaKegiatan());
                GridPane.setMargin(text, new Insets(20));
                ruangan.add(text,ruang,row++);
                i = j;
            }
        }
        this.activities.removeAll(del);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colNama.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNamaKegiatan()));
        colMulai.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getWaktuMulai().toString()));
        colSelesai.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getWaktuSelesai().toString()));
    }
}
