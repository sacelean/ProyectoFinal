package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.Main;

public class RootLayoutController {

    @FXML
    private BorderPane borderPane;
    @FXML
    private Label lblTitulo;
    @FXML
    private Button btnInsertarLibro;
    @FXML
    private Button btnBuscarReferencia;
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

    public void handleInsertarLibro() {

    }

    public void handleBuscarReferencia() {

    }
}
