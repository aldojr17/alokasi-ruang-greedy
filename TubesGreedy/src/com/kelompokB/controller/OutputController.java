package com.kelompokB.controller;

import com.kelompokB.entity.Activity;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Callback;
import javafx.util.Duration;

import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class OutputController implements Initializable {
    private MainController mainController;
    @FXML
    private TableView<Activity> tableActivity;
    @FXML
    private TableColumn<Activity, String> colNama, colMulai, colSelesai;
    @FXML
    private GridPane ruangan;
    private ObservableList<Activity> activities;
    private ObservableList<Activity> listActivity;

    public void setMainController(MainController mainController){
        this.mainController = mainController;
        listActivity = mainController.getActivities();

        Comparator<Activity> comparator = Comparator.comparing(Activity::getWaktuSelesai);
        SortedList<Activity> activitySortedList = new SortedList<>(listActivity, comparator);
        activities.addAll(activitySortedList);
        tableActivity.setItems(activitySortedList);
    }

    public void output() throws InterruptedException {
        System.out.println("Daftar Aktivitas :");
        TimeUnit.SECONDS.sleep(2);
        for(Activity a : activities){
            System.out.println("- " + a.getNamaKegiatan() +
                    "\t( " + a.getWaktuMulai() + "-" + a.getWaktuSelesai() + " ) ");
            TimeUnit.SECONDS.sleep(2);
        }
        System.out.println();

        int ruang = 0;
        while (activities.size() > 0){
            greedyAlgorithm(activities, ruang);
            ruang++;
        }
    }

    public void greedyAlgorithm(ObservableList<Activity> activities, int ruang) throws InterruptedException {
        ArrayList<Activity> del = new ArrayList<Activity>();
        int row = 0;

        Text text = new Text("Ruang " + (ruang+1));
        GridPane.setMargin(text, new Insets(20));
        ruangan.add(text,ruang,row++);
        System.out.println("Ruang " + (ruang+1));

        TimeUnit.SECONDS.sleep(2);

        int i = 0;
        text = new Text(activities.get(i).getNamaKegiatan());
        GridPane.setMargin(text, new Insets(20));
        ruangan.add(text,ruang,row++);
        del.add(this.activities.get(i));
        System.out.println("- " + activities.get(i).getNamaKegiatan() +
                "\t( " + activities.get(i).getWaktuMulai() + "-" + activities.get(i).getWaktuSelesai() + " ) ");

        TimeUnit.SECONDS.sleep(2);

        for(int j = 1; j < this.activities.size(); j++){
            if (activities.get(j).getWaktuMulai().toSecondOfDay() >= activities.get(i).getWaktuSelesai().toSecondOfDay())
            {
                del.add(this.activities.get(j));
                text = new Text(activities.get(j).getNamaKegiatan());
                GridPane.setMargin(text, new Insets(20));
                ruangan.add(text,ruang,row++);
                System.out.println("- " + activities.get(j).getNamaKegiatan() +
                        "\t( " + activities.get(j).getWaktuMulai() + "-" + activities.get(j).getWaktuSelesai() + " ) ");
                i = j;
                TimeUnit.SECONDS.sleep(2);
            }
        }
        System.out.println();
        this.activities.removeAll(del);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        activities = FXCollections.observableArrayList();
        colNama.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNamaKegiatan()));
        colMulai.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getWaktuMulai().toString()));
        colSelesai.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getWaktuSelesai().toString()));
    }
}
