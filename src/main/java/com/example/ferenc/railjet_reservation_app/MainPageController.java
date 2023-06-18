package com.example.ferenc.railjet_reservation_app;

import com.example.ferenc.railjet_reservation_app.dataholder.DataSingeleton;
import com.example.ferenc.railjet_reservation_app.db.DBController;
import com.example.ferenc.railjet_reservation_app.routes.Station;
import com.example.ferenc.railjet_reservation_app.train.Railcar;
import com.example.ferenc.railjet_reservation_app.train.Seat;
import javafx.event.ActionEvent;
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
import java.sql.SQLException;
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
    private static List<Railcar> railjet;
    private Alert alert;
    private Seat seat;
    @FXML
    private MenuItem mniDbHun;
    private String mniDbHunLink;
    @FXML
    private MenuItem mniMavHu;
    private String mniMavHuLink;
    @FXML
    private MenuItem mniObbHu;
    private String mniObbHuLink;
    @FXML
    private MenuItem mniSbbHun;
    private String mniSbbHunLink;
    @FXML
    private MenuItem miniSbbDe;
    private String miniSbbDeLink;
    @FXML
    private MenuItem mniDbDe;
    private String mniDbDeLink;
    @FXML
    private MenuItem mniMavDe;
    private String mniMavDeLink;
    @FXML
    private MenuItem mniObbDe;
    private String mniObbDeLink;
    DataSingeleton data;
    private String ticket;
    private String db_url;
    private String userName;
    private String password;
    private DBController dbcontroller;

    private List<Station> stations;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        db_url = "jdbc:postgresql://localhost/railjet_db";
        userName = "postgres";
        password = "Plutonium-36";

        Connect();
        railjet = new ArrayList<Railcar>();
        stations = new ArrayList<Station>();
        chBoxTrainNumber.getItems().add("RJX162");
        chBoxTrainNumber.getSelectionModel().select(0);

        lblCar.setVisible(false);
        chBoxTrainClass.setVisible(false);
        btnSelectedCar.setVisible(false);
        btnShoppingCart.setVisible(false);
        btnChoose.setVisible(false);
        btnChoose.setOnMouseClicked(mouseEvent -> AddSeatToTrain());
        ticket = "";

        /*
        A vonat adatai már a posgtresql adatbázisból érkeznek:

        Afmpz = new Railcar("27/1.","Első Osztály / First Class",ClassType.PREMIUM, 16);
        AfmpzSecondPart = new Railcar("27/2.","Első Osztály / First Class",ClassType.BUSINESS, 11);
        Ampz = new Railcar("26.","Első Osztály / First Class",ClassType.BUSINESS, 55);
        ARbmpz = new Railcar("25.","Első Osztály (Étkezőkocsi)/ First Class (Restaurant)",ClassType.BUSINESS, 10);
        Bmpz_1 = new Railcar("24.","Másodsztály / Second Class",ClassType.ECONOMY, 80);
        Bmpz_2 = new Railcar("23.","Másodsztály / Second Class",ClassType.ECONOMY, 76);
        Bmpz_3 = new Railcar("22.","Másodsztály / Second Class",ClassType.ECONOMY, 80);
        Bmpvz= new Railcar("21.","Másodsztály / Second Class",ClassType.ECONOMY, 72);
        */

        //CreateTest();
        //GetTrainDataFromDB();
        data = DataSingeleton.getInstance();

        mniDbHunLink ="https://www.bahn.de/service/fahrplaene/aktuell";
        mniMavHuLink ="https://www.mavcsoport.hu/mav-start/belfoldi-utazas/vaganyzar";
        mniObbHuLink ="https://fahrplan.oebb.at/webapp/#!P|HimSearch!histId|6!histKey|H135457";
        mniSbbHunLink = "https://www.sbb.ch/en/timetable/rail-traffic-information.html";
        miniSbbDeLink = "https://www.sbb.ch/de/fahrplan/bahnverkehrsinformation.html";
        mniDbDeLink = "https://www.bahn.de/service/fahrplaene/aktuell";
        mniMavDeLink = "https://www.mavcsoport.hu/en/mav-start/domestic-travels/dear-passenger";
        mniObbDeLink = "https://fahrplan.oebb.at/webapp/#!P|HimSearch!histId|1!histKey|H369172";


    }

    private void GetTrainDataFromDB() {

        try {
            railjet = dbcontroller.GetTrainData();
        } catch (SQLException e) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hiba! / Störung!");
            alert.setHeaderText("Sikertelen adatbetöltés! / Zugdaten konnten nicht geladen werden!");
            alert.setContentText(e.getMessage());
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
        }

    }

    /*
    private void CreateTest() {

        try {

            for (Railcar car :Rjx162) {
                dbcontroller.CreateCar(car);
            }

            dbcontroller.StartSaving();
        } catch (SQLException e) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hiba! / Störung!");
            alert.setHeaderText("Sikertelen mentés! / Speichern fehlgeschlagen!");
            alert.setContentText(e.getMessage());
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
        }

    }
    */
    private void Connect() {

        try {
            dbcontroller = new DBController(db_url, userName, password);

        } catch (SQLException e) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hiba! / Störung!");
            alert.setHeaderText("Sikertelen csatlakozás! / Verbindung fehlgeschlagen!");
            alert.setContentText(e.getMessage());
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
        }

    }

    @FXML
    public void LoadTrainData(){

        String timeTable;
        try{
            if(chBoxTrainNumber.getSelectionModel().getSelectedItem().equals("RJX162")){
                timeTable = "TimeTable_Rjx162";
                stations = dbcontroller.getTimeTable(timeTable);

            }
        } catch(SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hiba! / Störung!");
            alert.setHeaderText("Hiba történt! / Ein Fehler ist aufgetreten!");
            alert.setContentText(e.getMessage());
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
        }

        GetTrainDataFromDB();
        chBoxTrainClass.setVisible(true);

        for (Railcar railcar: railjet) {
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
    @FXML
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

        for (Railcar train : railjet) {
            if (chBoxTrainClass.getValue().contains(train.getCarNumber())) {
                int index = chBoxTrainClass.getSelectionModel().getSelectedIndex();
                try {
                    train.setReservedSeatNumberAndSeat(seat);
                    UpdateDB(index);
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
                    errorAlert.setTitle("Hiba! / Fehler");
                    errorAlert.setContentText(e.getMessage());
                    errorAlert.setHeaderText("Hiba történt! / Ein Fehler ist aufgetreten!");
                    errorAlert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                    errorAlert.show();
                }
            }

        }

    }

    private void UpdateDB(int index) {

        try {
            dbcontroller.setReservations(railjet.get(index));
        } catch (SQLException e) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hiba! / Störung!");
            alert.setHeaderText("Hiba az adatok frissítésekor! / Fehler bei der Aktualisierung der Daten!");
            alert.setContentText(e.getMessage());
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
        }

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

        Parent root;
        ticket = this.seat.toString();


        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("ShoppingCardView.fxml"));
            root = loader.load();

            String css = this.getClass().getResource("listview.css").toExternalForm();

            ShoppingCardController scc = loader.getController();
            scc.setTicket(ticket);
            Stage secondStage = new Stage();
            Scene scene = new Scene(root);
            scene.setUserData(data.getSeat());
            scene.getStylesheets().add(css);
            secondStage.setScene(scene);
            secondStage.setTitle("Kosár tartalma / Tickets im Warenkorb");
            secondStage.initModality(Modality.APPLICATION_MODAL);
            secondStage.show();

        } catch (IOException e) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hiba! / Störung!");
            alert.setHeaderText("Hiba történt! / Ein Fehler ist aufgetreten!");
            alert.setContentText(e.getMessage()+"Hiba történt, kérjük próbálja meg később! / Ein Fehler ist aufgetreten, bitte versuchen es später erneut!");
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
        }
    }

    @FXML
    void StartBrowser(ActionEvent event) {

        String id = ((MenuItem) event.getSource()).getId();

        switch (id){
            case "mniDbHun":
                OpenInfoPage(mniDbHunLink);
                break;
            case "mniMavHu":
                OpenInfoPage(mniMavHuLink);
                break;
            case "mniObbHu":
                OpenInfoPage(mniObbHuLink);
                break;
            case "mniSbbHun":
                OpenInfoPage(mniSbbHunLink);
                break;
            case "miniSbbDe":
                OpenInfoPage(miniSbbDeLink);
                break;
            case "mniDbDe":
                OpenInfoPage(mniDbDeLink);
                break;
            case "mniMavDe":
                OpenInfoPage(mniMavDeLink);
                break;
            case "mniObbDe":
                OpenInfoPage(mniObbDeLink);
                break;
        }


    }

    private void OpenInfoPage(String link) {

        Parent root;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("BrowserViewWindow.fxml"));

        try {
            root = loader.load();
            BrowserWindowController bwcontroller = loader.getController();
            bwcontroller.setWebLink(link);
            Stage secondStage = new Stage();
            secondStage.setScene(new Scene(root));
            secondStage.setTitle("Pályainformációk / Streckeninformationen");
            secondStage.initModality(Modality.APPLICATION_MODAL);
            bwcontroller.LoadPage();
            secondStage.show();



        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hiba! / Störung!");
            alert.setHeaderText("Hiba történt! / Ein Fehler ist aufgetreten!");
            alert.setContentText("Hiba történt, kérjük próbálja meg később! / Ein Fehler ist aufgetreten, bitte versuchen es später erneut!");
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
        }


    }
}