module org.openjfx.AnimalPopIt {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens org.openjfx.AnimalPopIt to javafx.fxml;
    exports org.openjfx.AnimalPopIt;
}
