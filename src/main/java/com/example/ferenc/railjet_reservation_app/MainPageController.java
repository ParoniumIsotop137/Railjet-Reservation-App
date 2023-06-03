package com.example.ferenc.railjet_reservation_app;

import com.example.ferenc.railjet_reservation_app.dataholder.DataSingeleton;
import com.example.ferenc.railjet_reservation_app.train.ClassType;
import com.example.ferenc.railjet_reservation_app.train.Railcar;
import com.example.ferenc.railjet_reservation_app.train.Seat;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
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
    private Button btnShoppingCart;
    @FXML
    private Button btnSelectedCar;

    @FXML
    private ChoiceBox<String> chBoxTrainClass;

    @FXML
    private ChoiceBox<String> chBoxTrainNumber;



    @FXML
    private Label lblCar;
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

    private final List<Railcar> Rjx162 = new ArrayList<Railcar>();
    private Alert alert;
    private int freePlaces;

    private Seat seat;

    private DataSingeleton data;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        chBoxTrainNumber.getItems().add("RJX162");
        chBoxTrainNumber.getSelectionModel().select(0);

        lblCar.setVisible(false);
        chBoxTrainClass.setVisible(false);
        btnSelectedCar.setVisible(false);
        btnShoppingCart.setVisible(false);
        btnChoose.setVisible(false);
        btnChoose.setOnMouseClicked(mouseEvent -> AddSeatToTrain());

        freePlaces = 0;
        //a adatbázisból érkező adatok
        Afmpz = new Railcar("27/1.","Első Osztály / First Class",ClassType.PREMIUM, 16);
        AfmpzSecondPart = new Railcar("27/2.","Első Osztály / First Class",ClassType.BUSINESS, 11);
        Ampz = new Railcar("26.","Első Osztály / First Class",ClassType.BUSINESS, 55);
        ARbmpz = new Railcar("25.","Első Osztály (Étkezőkocsi)/ First Class (Restaurant)",ClassType.BUSINESS, 10);
        Bmpz_1 = new Railcar("24.","Másodsztály / Second Class",ClassType.ECONOMY, 80);
        Bmpz_2 = new Railcar("23.","Másodsztály / Second Class",ClassType.ECONOMY, 76);
        Bmpz_3 = new Railcar("22.","Másodsztály / Second Class",ClassType.ECONOMY, 80);
        Bmpvz= new Railcar("21.","Másodsztály / Second Class",ClassType.ECONOMY, 72);


        Rjx162.add(Afmpz);
        Rjx162.add(AfmpzSecondPart);
        Rjx162.add(Ampz);
        Rjx162.add(ARbmpz);
        Rjx162.add(Bmpz_1);
        Rjx162.add(Bmpz_2);
        Rjx162.add(Bmpz_3);
        Rjx162.add(Bmpvz);

        data = DataSingeleton.getInstance();

    }
    @FXML
    public void LoadTrainData(){

        chBoxTrainClass.setVisible(true);

        for (Railcar railcar: Rjx162) {
            chBoxTrainClass.getItems().add(railcar.getCarNumber()+" "+railcar.getType()+" - "+railcar.getClassType().toString());
        }
        chBoxTrainClass.getSelectionModel().select(0);
        lblCar.setVisible(true);
        btnSelectedCar.setVisible(true);


    }
    @FXML
    public void NextStep(){

        NewWindowOpening();


    }

    private void NewWindowOpening() {

        Parent root;

        try {
            root = FXMLLoader.load(getClass().getResource("NewWindowForDetails.fxml"));
            Stage secondStage = new Stage();
            secondStage.setScene(new Scene(root));
            secondStage.setTitle("Helyfoglalás / Platzreservierung");
            secondStage.initModality(Modality.APPLICATION_MODAL);
            secondStage.show();



        } catch (IOException e) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hiba! / Störung!");
            alert.setHeaderText("Hiba történt! / Ein Fehler ist aufgetreten!");
            alert.setContentText("Hiba történt, kérjük próbálja meg később! / Ein Fehler ist aufgetreten, bitte versuchen es später erneut!");
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
        }
        btnChoose.setVisible(true);


    }

    private void AddSeatToTrain() {

        seat = data.getSeat();

        if(seat != null){
            Reservation();
            btnShoppingCart.setVisible(true);
        }
        else{
            SendWarningMessage();
            SetBackButton();
        }


    }

    private void SendWarningMessage() {

        Alert wMessage = new Alert(Alert.AlertType.WARNING);
        wMessage.setTitle("Információ / Information");
        wMessage.setHeaderText("Nincsen még foglalása! / Sie haben noch keine Sitzplatzreservierung!");
        wMessage.setContentText("Először foglaljon egy ülőhelyet! / Bitte zuerst einen Sitzplatz reservieren!");
        wMessage.show();
    }

    private void SetBackButton() {

        btnChoose.setVisible(false);


    }

    private void Reservation() {

        for (Railcar train : Rjx162) {
            if (chBoxTrainClass.getValue().contains(train.getCarNumber())) {
                try {
                    train.setReservedSeatNumberAndSeat(seat);
                    SendMessage();
                    SetBackButton();
                } catch (IllegalArgumentException e) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Figyelmeztetés! / Warnung!");
                    alert.setHeaderText("Sikertelen foglalás! / Sitzplatzreservierung war nicht erfolgreich!");
                    alert.setContentText(e.getMessage());
                    alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                    alert.show();
                } catch (Exception e) {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Hiba! / Fehler");
                    errorAlert.setContentText(e.getMessage());
                    errorAlert.setHeaderText("Hiba történt! / Ein Fehler ist aufgetreten!");
                    errorAlert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                    errorAlert.show();
                }
            }

        }
        seat = null;
    }


    private void SendMessage() {

        btnShoppingCart.setVisible(false);
        Alert orderMessage = new Alert(Alert.AlertType.INFORMATION);
        orderMessage.setTitle("Információ / Information");
        orderMessage.setHeaderText("Megerősítés / Bestätigung");
        orderMessage.setContentText("Sikeres ülőhelyfoglalás! / Sitzplatzreservierung erfolgreich!");
        orderMessage.show();

    }
    @FXML
    private void showShoppingCart(){

    }
}