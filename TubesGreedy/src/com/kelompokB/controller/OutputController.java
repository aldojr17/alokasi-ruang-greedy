package com.kelompokB.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.io.IOException;

public class OutputController {
    @FXML
    private GridPane grid;
    private MainController mainController;

    public void setMainController(MainController mainController){
        this.mainController = mainController;
    }

    public void output() throws IOException {
        int column = 0;
        int row = 0;
        for(int i = 0; i < mainController.getActivities().size(); i++){
            if(column == 3){
                column = 0;
                row++;
            }
            grid.add(new Label(mainController.getActivities().get(i).getNamaKegiatan()),++column,row);
            grid.getColumnConstraints().add(new ColumnConstraints(100));
            grid.getRowConstraints().add(new RowConstraints(100));
        }
    }
}
