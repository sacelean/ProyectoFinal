package Biblioteca.Controller;

import Biblioteca.Main;
import Biblioteca.Model.Libro;
import dataBaseDAO.DAO;
import dataBaseDAO.DAOFactory;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
    //para poder usar abajo los metodos del libro
    private Libro libro;
    private boolean okCLicked = false;

    //para poner un futuro boton de cancelar
    private Stage dialogStage;

    @FXML
    public void initialize(){
        libro = new Libro();
    }


    public InsertarLibroController(){

    }

    public void setMainApp(Main mainApp){
        this.mainApp = mainApp;
    }

    public void handleCrear(ActionEvent actionEvent) {

    }
    public boolean isOkClicked() {
        return this.okCLicked;
    }


    @FXML

    //metodo para el boton de cancelar
    private void handleCancel() {
        dialogStage.close();
    }

//Control de que no haya titulo, autor o isbn vacios
    private boolean isInputValid() {
        String errorMessage = "";

        if (JTxtTitulo.getText() == null || JTxtTitulo.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (JTxtAutor.getText() == null || JTxtAutor.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }
        if (JTxtISBN.getText() == null || JTxtISBN.getText().length() == 0) {
            errorMessage += "No valid street!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        }else{
            return false;
        }
    }

    private void handleOk() {
        if (isInputValid()) {
            libro.setTitulo(JTxtTitulo.getText());
            libro.setAutor(JTxtAutor.getText());
            libro.setISBN(JTxtISBN.getText());
            DAO<Libro> db = DAOFactory.getInstance().getLibroDAO();
            db.save(libro);
            this.okCLicked = true;
            dialogStage.close();
        }
    }

   /* public void handleInsertarArticulo() {
        JComboBox = InsertarArticuloController;
        mainApp.showInsertarArt();
    }*/
@FXML
    private String getTextTitulo(){
        String s = JTxtTitulo.getText();
        return s;
    }


}
