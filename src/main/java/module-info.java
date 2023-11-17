module com.example.advjavaassignment2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;

    opens com.example.advjavaassignment2 to javafx.fxml;
    exports com.example.advjavaassignment2;
}