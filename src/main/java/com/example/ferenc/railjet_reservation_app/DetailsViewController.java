package com.example.ferenc.railjet_reservation_app;

import com.example.ferenc.railjet_reservation_app.dataholder.DataSingeleton;
import com.example.ferenc.railjet_reservation_app.routes.RJX162Stations;
import com.example.ferenc.railjet_reservation_app.train.Seat;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
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

    private DataSingeleton data;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        spnNumberOfPersons.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100, 1));

        stations = new ArrayList<String>();
        Arrays.stream(RJX162Stations.values()).forEach(e -> stations.add(e.getName()));

        startStations.getItems().setAll(stations);
        startStations.getSelectionModel().select(0);
        endStations.getItems().setAll(stations);
        endStations.getSelectionModel().selectLast();

        data = DataSingeleton.getInstance();


    }
    @FXML
    public void CheckStatus(ActionEvent event){

        if(!startStations.getValue().equals(endStations.getValue())){


            seat = new Seat(RJX162Stations.getStation(startStations.getValue()), RJX162Stations.getStation(endStations.getValue()), spnNumberOfPersons.getValue());

            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Megerősítés / Bestätigung");
            alert.setContentText("Induló állomás / Startbahnhof: "+seat.getStartStation().getName()+"\n"+"Célállomás / Zielbahnhof: "+seat.getEndStation().getName()+"\n"+String.valueOf(seat.getNumberOfPersons())+" fő/ Personen.");
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();

            data.setSeat(seat);

            Node thisNode = (Node) event.getSource();
            Stage thisStage = (Stage) thisNode.getScene().getWindow();
            thisStage.close();

        }
        else{
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Figyelmeztetés! / Warnung!");
            alert.setHeaderText("Helytelen adatok! / Falsche Angaben!");
            alert.setContentText("Válasszon másik célállomást! / Wählen Sie einen anderen Zielbahnhof aus!");
            endStations.getSelectionModel().select(0);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
        }


    }
    @FXML
    public void Closing(ActionEvent event){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Megerősítés / Bestätigung");
        alert.setHeaderText("Nem lesz lefoglalva egy ülőhely sem! / Sitzplatzreservierung wird unterbrochen!");
        alert.setContentText("Biztosan kilép? / Wollen Sie wirklich beenden?");
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        ButtonType buttonTypeYes = new ButtonType("Igen, megszakítom / Ja, beenden");
        ButtonType buttonTypeNo = new ButtonType("Vissza / Zurück");
        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeYes){
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }


    }

    public Seat getSeat() {
        return seat;
    }
}
