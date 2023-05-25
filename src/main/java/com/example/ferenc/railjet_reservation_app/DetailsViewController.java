package com.example.ferenc.railjet_reservation_app;

import com.example.ferenc.railjet_reservation_app.routes.RJX162Stations;
import com.example.ferenc.railjet_reservation_app.train.Seat;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Region;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class DetailsViewController implements Initializable {

    @FXML
    private Spinner<Integer> spnNumberOfPersons;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnReservation;
    @FXML
    private ComboBox<String> startStations;

    @FXML
    private ComboBox<String> endStations;
    private Alert alert;

    private ArrayList<String> stations;

    private Seat seat;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        spnNumberOfPersons.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,500, 1));
        stations = new ArrayList<String>();
        Arrays.stream(RJX162Stations.values()).forEach(e -> stations.add(e.getName()));
        startStations.getItems().setAll(stations);
        endStations.getItems().setAll(stations);


    }

    public void CheckStatus(){


    }
}
