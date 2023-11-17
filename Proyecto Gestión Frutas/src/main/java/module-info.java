module com.example.proyectoentradafrutasjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.proyectoentradafrutasjavafx to javafx.fxml;
    exports com.example.proyectoentradafrutasjavafx;
}