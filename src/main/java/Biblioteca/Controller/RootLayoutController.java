package Biblioteca.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import Biblioteca.Main;

public class RootLayoutController {

    @FXML
    private BorderPane borderPane;
    @FXML
    private Label lblTitulo;
    @FXML
    private Button btnInsertarLibro;
    @FXML
    private Button btnBuscar;
    @FXML private Button btnHome;
    private Button selectedButton;
    private Main mainApp;
    private Stage dialogStage;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    public void setDialogStage (Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    private void initialize(){
        selectedButton = btnHome;
        btnHome.setDisable(true);
    }

    private void selectButtonMenu(Button btn){
        selectedButton.setDisable(false);
        selectedButton = btn;
        selectedButton.setDisable(true);
    }

    public void handleInsertarLibro() {
        selectButtonMenu(btnInsertarLibro);
        mainApp.showInsertarLayout();
    }

    public void handleBuscar() {
        selectButtonMenu(btnBuscar);
        mainApp.showBuscar();
    }

    public void handleHome(){
        selectButtonMenu(btnHome);
        mainApp.showHomeOverview();
    }
}
