package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private BorderPane rootLayout;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        rootLayout = FXMLLoader.load(getClass().getResource("RootLayout.fxml"));
        primaryStage.setTitle("Hello World");
        this.primaryStage = primaryStage;
        primaryStage.setScene(new Scene(rootLayout, 300, 275));
        primaryStage.show();
        showHomeOverview();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void showHomeOverview(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HomeLayout.fxml"));
        try {
            AnchorPane homeOverView = loader.load();
            rootLayout.setCenter(homeOverView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showInsertarLayout(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("InsertarLibro.fxml"));
        AnchorPane insertarLibro = null;
        try {
            insertarLibro = loader.load();
            rootLayout.setCenter(insertarLibro);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
