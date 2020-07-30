package dev.astamur.geekbrains.lessons.lesson4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFxExample extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/example.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("JavaFX Example");
        primaryStage.setScene(new Scene(root, 400, 50));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}