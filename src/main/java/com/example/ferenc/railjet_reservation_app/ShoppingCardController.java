package com.example.ferenc.railjet_reservation_app;

import com.example.ferenc.railjet_reservation_app.dataholder.DataSingeleton;
import com.example.ferenc.railjet_reservation_app.train.Seat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ShoppingCardController implements Initializable {

    private List<String> tickets;

    @FXML
    private ListView<String> lstTickets;

    @FXML
    private Button btnTickets;

    private ObservableList<String> listItems;

    private String ticket;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tickets = new ArrayList<String>();
        listItems = FXCollections.observableArrayList();

        lstTickets.setItems(listItems);

    }

    @FXML
    public void FillTheListView(ActionEvent event) {

        int n = 1;
        for (String ticket : tickets){
            listItems.add(String.valueOf(n)+". "+ticket);
            n++;
        }
        btnTickets.setDisable(true);
    }

    public List<String> getTickets() {
        return tickets;
    }

    public void setTickets(List<String> tickets) {
        this.tickets = tickets;
    }
}
