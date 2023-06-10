module com.example.ferenc.railjet_reservation_app {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.ferenc.railjet_reservation_app to javafx.fxml;
    exports com.example.ferenc.railjet_reservation_app;
    exports com.example.ferenc.railjet_reservation_app.dataholder;
    opens com.example.ferenc.railjet_reservation_app.dataholder to javafx.fxml;
}