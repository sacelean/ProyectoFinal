package Biblioteca;

import Biblioteca.Controller.BuscarController;
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

    public void showInsertarArt(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("View/InsertarArticulo.fxml"));
        AnchorPane insertarArticulo = null;
        try {
            insertarArticulo = loader.load();
            rootLayout.setCenter(insertarArticulo);
            InsertarLibroController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showBuscar() {
        //Se podran buscar libros por ejemplo libros por fecha, autor o titulo, y sus notas asociadas.
        //Buscar todas las notas de un tema determinado. Ej tema ciencia todas las notas.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("View/Buscar.fxml"));
        AnchorPane buscar = null;
        try {
            buscar = loader.load();
            rootLayout.setCenter(buscar);
            BuscarController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
