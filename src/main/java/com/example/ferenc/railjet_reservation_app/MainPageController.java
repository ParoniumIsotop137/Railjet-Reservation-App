package com.example.ferenc.railjet_reservation_app;

import com.example.ferenc.railjet_reservation_app.train.ClassType;
import com.example.ferenc.railjet_reservation_app.train.Railcar;
import com.example.ferenc.railjet_reservation_app.train.Seat;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {

    @FXML
    private Button btnChoose;

    @FXML
    private Button btnSelectedTrain;

    @FXML
    private ChoiceBox<String> chBoxTrainClass;

    @FXML
    private Spinner<?> chBoxNumberOfPersons;

    @FXML
    private ChoiceBox<String> chBoxTrainNumber;

    @FXML
    private Label lblFreePlaces;

    @FXML
    private Label lblTrainPath;
    @FXML
    private Label lblClassType;

    @FXML
    private AnchorPane mainAnchorPane;


    private Railcar Afmpz;
    private Railcar AfmpzSecondPart;
    private Railcar Ampz;
    private Railcar ARbmpz;
    private Railcar Bmpz_1;

    private Railcar Bmpz_2;

    private Railcar Bmpz_3;

    private Railcar Bmpvz;

    private Seat seat;

    private static List<Railcar> Rjx162;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        chBoxTrainNumber.getItems().add("RJX162");

        Afmpz = new Railcar("27. Első Osztály / First Class",ClassType.PREMIUM, 16);
        AfmpzSecondPart = new Railcar("27. Első Osztály / First Class",ClassType.BUSINESS, 11);
        Ampz = new Railcar("26. Első Osztály / First Class",ClassType.BUSINESS, 55);
        ARbmpz = new Railcar("25. Első Osztály (Étkezőkocsi)/ First Class (Restaurant)",ClassType.BUSINESS, 10);
        Bmpz_1 = new Railcar("24. Másodsztály / Second Class",ClassType.ECONOMY, 80);
        Bmpz_2 = new Railcar("23. Másodsztály / Second Class",ClassType.ECONOMY, 76);
        Bmpz_3 = new Railcar("22. Másodsztály / Second Class",ClassType.ECONOMY, 80);
        Bmpvz= new Railcar("21. Másodsztály / Second Class",ClassType.ECONOMY, 72);

        Rjx162 = new ArrayList<Railcar>();

        Rjx162.add(Afmpz);
        Rjx162.add(AfmpzSecondPart);
        Rjx162.add(Ampz);
        Rjx162.add(ARbmpz);
        Rjx162.add(Bmpz_1);
        Rjx162.add(Bmpz_2);
        Rjx162.add(Bmpz_3);
        Rjx162.add(Bmpvz);


    }
    @FXML
    public void LoadTrainData(){

        for (Railcar railcar: Rjx162) {
            chBoxTrainClass.getItems().add(railcar.getType());
        }



    }
    @FXML
    public void NextStep(){


    }
    @FXML
    public void ChooseTrainData(){

        for (Railcar railcar: Rjx162) {
            if(chBoxTrainClass.getValue().equals(railcar.getType())){
                lblClassType.setText(railcar.getClassType().toString());
                int freePlaces = railcar.getMaxSeatsNumber() - railcar.getReservedSeatsNumber();
                lblFreePlaces.setText(String.valueOf(freePlaces));
            }
        }

    }
}