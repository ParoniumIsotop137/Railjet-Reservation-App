package com.example.ferenc.railjet_reservation_app;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BrowserWindowController implements Initializable {

    @FXML
    private ScrollPane scrPane;

    @FXML
    private WebView webView;

    private String webLink;
    private WebEngine engine;

    private ScheduledExecutorService service;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        engine = webView.getEngine();
        String link = getWebLink();

    }
    public void LoadPage(){
        engine.load(getWebLink());
    }

    public void setWebLink(String webLink) {
        this.webLink = webLink;
    }

    public String getWebLink() {
        return webLink;
    }
}
