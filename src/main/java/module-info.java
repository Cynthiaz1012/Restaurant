module com.mycompany.lab10 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.lab10 to javafx.fxml;
    exports com.mycompany.lab10;
}
