package com.example.ferenc.railjet_reservation_app;

import com.example.ferenc.railjet_reservation_app.train.Seat;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.Region;

import java.net.URL;
import java.util.ResourceBundle;

public class DetailsViewController implements Initializable {

    @FXML
    private Spinner<Integer> spnNumberOfPersons;

    @FXML
    private ChoiceBox<String> startStations;

    @FXML
    private ChoiceBox<String> endStations;
    private Alert alert;

    private Seat seat;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        spnNumberOfPersons.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,500, 1));
        spnNumberOfPersons.setVisible(false);
    }

    public void CheckStatus(){


    }
}
