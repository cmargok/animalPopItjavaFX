module org.openjfx.AnimalPopIt {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
	requires javafx.graphics;

    opens org.openjfx.AnimalPopIt to javafx.fxml;
    exports org.openjfx.AnimalPopIt;
}
