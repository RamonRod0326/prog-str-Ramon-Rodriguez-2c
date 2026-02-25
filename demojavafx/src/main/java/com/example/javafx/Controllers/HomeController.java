package com.example.javafx.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomeController {
    public void onGoToForm(ActionEvent actionEvent) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo/form-view.fxml"));
            Scene scene = new Scene(loader.load(),520,350);
            Stage stage = (Stage) ((javafx.scene.Node)actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}