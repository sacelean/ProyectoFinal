package Biblioteca;

import Biblioteca.Controller.RootLayoutController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import Biblioteca.Controller.HomeLayoutController;
import Biblioteca.Controller.InsertarLibroController;

import java.io.IOException;

public class Main extends Application {

    private BorderPane rootLayout;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Biblioteca");
        this.primaryStage = primaryStage;
        primaryStage.setScene(new Scene(rootLayout));
        primaryStage.show();
        showHomeOverview();
    }

    @Override
    public void init() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("View/RootLayout.fxml"));
        rootLayout = loader.load();
        RootLayoutController controller = loader.getController();
        controller.setMainApp(this);
        controller.setDialogStage(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void showHomeOverview(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("View/HomeLayout.fxml"));
        try {
            AnchorPane homeOverView = loader.load();
            rootLayout.setCenter(homeOverView);
            HomeLayoutController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showInsertarLayout(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("View/InsertarLibro.fxml"));
        AnchorPane insertarLibro = null;
        try {
            insertarLibro = loader.load();
            rootLayout.setCenter(insertarLibro);
            InsertarLibroController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showBuscarReferencia() {
    }
}
