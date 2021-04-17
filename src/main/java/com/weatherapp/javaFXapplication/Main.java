package com.weatherapp.javaFXapplication;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<ActionEvent> {
    private BorderPane layout;
    private Scene scene;
    private Button button;




    @Override
    public void start(Stage primaryStage) throws Exception{

        button= new Button();
        button.setText("Kliknij");
        button.setOnAction(this);



        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene=  new Scene(layout,300,200);

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("hellofx.fxml"));
        primaryStage.setTitle("Weatrher");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource()==button){
            System.out.println("Ooooooooooooooooooo");
        }

    }
}
