module com.example.dsahw2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.dsahw2 to javafx.fxml;
    exports com.example.dsahw2;
}