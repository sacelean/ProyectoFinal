package Biblioteca.Controller;

import Biblioteca.Main;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class InsertarLibroController {

    @FXML private JFXTextField txtTitulo;

    public InsertarLibroController(){

    }
    private Main mainApp;


    public void setMainApp(Main mainApp){
        this.mainApp = mainApp;
    }

    public void handleCrear(ActionEvent actionEvent) {

    }
}
