module com.example.cookieclicker {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.cookieclicker to javafx.fxml;
    exports com.example.cookieclicker;
}