package Biblioteca.Controller;

import Biblioteca.Main;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.awt.*;

public class InsertarLibroController {


    @FXML private AnchorPane anchorPaneLibro;
    @FXML private VBox vBoxLibro;
    @FXML private GridPane gridPaneLibro;
    @FXML private Label lblRegistroLibro;
    @FXML private Label lblLibroArticulo;
    @FXML private Label lblTitulo;
    @FXML private Label lblAutor;
    @FXML private Label lblEditorial;
    @FXML private Label lblAnio;
    @FXML private Label lblNumPag;
    @FXML private Label lblISBN;
    @FXML private JFXComboBox JComboBox;
    @FXML private JFXTextField JTxtTitulo;
    @FXML private JFXTextField JTxtAutor;
    @FXML private JFXTextField JTxtEditorial;
    @FXML private JFXTextField JTxtAnio;
    @FXML private JFXTextField JTxtNumPag;
    @FXML private JFXTextField JTxtISBN;
    private Main mainApp;


    public InsertarLibroController(){

    }

    public void setMainApp(Main mainApp){
        this.mainApp = mainApp;
    }

    public void handleCrear(ActionEvent actionEvent) {

    }


}
