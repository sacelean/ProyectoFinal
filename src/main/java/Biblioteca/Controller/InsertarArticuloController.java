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

public class InsertarArticuloController {

    @FXML
    private AnchorPane anchorPaneArtic;
    @FXML private VBox vBoxArtic;
    @FXML private GridPane gridPaneArtic;
    @FXML private Label lblRegistroArtic;
    @FXML private Label lblLibroArticulo;
    @FXML private Label lblTitulo;
    @FXML private Label lblAutor;
    @FXML private Label lblNombreRev;
    @FXML private Label lblAnio;
    @FXML private Label lblMes;
    @FXML private Label lblPInicio;
    @FXML private Label lblPFin;
    @FXML private Label lblISSN;
    @FXML private JFXComboBox JComboBox;
    @FXML private JFXTextField JTxtTitulo;
    @FXML private JFXTextField JTxtAutor;
    @FXML private JFXTextField JTxtNombreRev;
    @FXML private JFXTextField JTxtAnio;
    @FXML private JFXTextField JTxtMes;
    @FXML private JFXTextField JTxtPInicio;
    @FXML private JFXTextField JTxtPFin;
    @FXML private JFXTextField JTxtISSN;

    private Main mainApp;



    public InsertarArticuloController(){
    }

    public void setMainApp(Main mainApp){
        this.mainApp = mainApp;
    }

    public void handleCrearArt(ActionEvent actionEvent) {

    }

    public void InsertarEnTextField(){
        JTxtTitulo.setPromptText("Enter your first name.");
    }


}