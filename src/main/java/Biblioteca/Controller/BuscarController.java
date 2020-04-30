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

public class BuscarController {

    @FXML
    private AnchorPane anchorPane;
    @FXML private VBox vBox;
    @FXML private GridPane gridPane;
    @FXML private Label lblBuscar;
    @FXML private Label lblOpciones;
    @FXML private Label lblTitulo;
    @FXML private Label lblAutor;
    @FXML private Label lblISBNISSN;
    @FXML private Label lblAnio;
    @FXML private Label lblTemaNota;
    @FXML private JFXComboBox JComboBoxOpciones;
    @FXML private JFXComboBox JComboCodigos;
    @FXML private JFXComboBox JComboTemas;
    @FXML private JFXTextField JTxtTitulo;
    @FXML private JFXTextField JTxtAutor;
    @FXML private JFXTextField JTxtAnio;
    @FXML private JFXTextField JTxtMes;


    private Main mainApp;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    public void handleBuscar(ActionEvent actionEvent) {

    }
}

