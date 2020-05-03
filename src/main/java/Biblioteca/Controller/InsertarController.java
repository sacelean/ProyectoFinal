package Biblioteca.Controller;

import Biblioteca.Main;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class InsertarController {


    @FXML private AnchorPane anchorPaneLibro;
    @FXML private JFXComboBox JComboBox;
    @FXML private AnchorPane pane;
    private Main mainApp;

    @FXML
    private void initialize(){
        ObservableList comboBoxList = FXCollections.observableArrayList("Libro", "Articulo");
        JComboBox.setItems(comboBoxList);
    }

    public void handleSelectLibroArticulo(){
        if(JComboBox.getValue().equals("Libro")){
            showInsertarLibro();
        }else{
            showInsertarArt();
        }
    }

    private void showInsertarLibro() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("View/InsertarLibro.fxml"));
        AnchorPane insertarArticulo = null;
        try {
            InsertarLibroController insertarLibroController = loader.load();
            pane.getChildren().setAll(insertarArticulo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public InsertarController(){

    }

    public void setMainApp(Main mainApp){
        this.mainApp = mainApp;
    }

    public void handleCrear(ActionEvent actionEvent) {

    }
   /* public void handleInsertarArticulo() {
        JComboBox = InsertarArticuloController;
        mainApp.showInsertarArt();
    }*/


    public void showInsertarArt(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("View/InsertarArticulo.fxml"));
        AnchorPane insertarArticulo = null;
        try {
            insertarArticulo = loader.load();
            pane.getChildren().setAll(insertarArticulo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
