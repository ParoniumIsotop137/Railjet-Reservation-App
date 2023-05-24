package com.example.ferenc.railjet_reservation_app;

import com.example.ferenc.railjet_reservation_app.train.ClassType;
import com.example.ferenc.railjet_reservation_app.train.Railcar;
import com.example.ferenc.railjet_reservation_app.train.Seat;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;

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
    private Button btnSelectedCar;
    @FXML
    private Label lblNumberOfPersons;
    @FXML
    private Label lblPersons;

    @FXML
    private ChoiceBox<String> chBoxTrainClass;

    @FXML
    private Spinner<Integer> spnNumberOfPersons;

    @FXML
    private ChoiceBox<String> chBoxTrainNumber;

    @FXML
    private Label lblFreePlaces;
    @FXML
    private Label lblShowFreePlaces;

    @FXML
    private Label lblCar;
    @FXML
    private Label lblTrainPath;
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

    private Alert alert;
    private int freePlaces;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        chBoxTrainNumber.getItems().add("RJX162");
        chBoxTrainNumber.getSelectionModel().select(0);

        lblFreePlaces.setVisible(false);
        lblCar.setVisible(false);
        chBoxTrainClass.setVisible(false);
        btnSelectedCar.setVisible(false);
        lblNumberOfPersons.setVisible(false);

        spnNumberOfPersons.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,500, 1));
        spnNumberOfPersons.setVisible(false);

        lblPersons.setVisible(false);
        btnChoose.setVisible(false);

        freePlaces = 0;

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

        chBoxTrainClass.setVisible(true);

        for (Railcar railcar: Rjx162) {
            chBoxTrainClass.getItems().add(railcar.getType()+" - "+railcar.getClassType().toString());
        }
        chBoxTrainClass.getSelectionModel().select(0);
        lblCar.setVisible(true);
        btnSelectedCar.setVisible(true);


    }
    @FXML
    public void NextStep(){

        if(spnNumberOfPersons.getValue() > freePlaces){
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Figyelem!");
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.setContentText("A kiválasztott kocsiban már nincsen elegendő hely "+String.valueOf(spnNumberOfPersons.getValue())+" fő részére! / Ez sind nicht genügend freie Plätze für "+String.valueOf(spnNumberOfPersons.getValue())+" Personen!");
            alert.show();
        }
        else{
            NewWindowOpening();
        }


    }

    private void NewWindowOpening() {

        

    }

    @FXML
    public void ShowFreePlaceNumber(){

        lblFreePlaces.setVisible(true);

        for (Railcar railcar: Rjx162) {
            if(chBoxTrainClass.getValue().equals(railcar.getType()+" - "+railcar.getClassType().toString())){
                freePlaces = railcar.getMaxSeatsNumber() - railcar.getReservedSeatsNumber();
                lblShowFreePlaces.setText(String.valueOf(freePlaces));
                if(freePlaces == 0){
                    WarningThatNoFreePlaces();
                }
            }
        }
        lblNumberOfPersons.setVisible(true);
        spnNumberOfPersons.setVisible(true);
        spnNumberOfPersons.setEditable(true);
        lblPersons.setVisible(true);
        btnChoose.setVisible(true);

    }
    
    private void WarningThatNoFreePlaces(){

        alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Figyelem!");
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.setContentText("A kiválasztott kocsiban nincsen már szabad helye! / Keine freie Plätze mehr in dem ausgewählten Wagen!");
        alert.show();

        
    }

    @FXML
    void ClearFreePlaceLabel() {

        lblShowFreePlaces.setText("");

    }
}