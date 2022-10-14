module com.leo.td4_tutorial {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.leo.td4_tutorial to javafx.fxml;
    exports com.leo.td4_tutorial;
}