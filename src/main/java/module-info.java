module com.mavenproject3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mavenproject3 to javafx.fxml;
    exports com.mavenproject3;
}
