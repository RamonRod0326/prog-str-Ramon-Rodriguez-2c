package com.example.javafx.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;


public class FormController {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtEdad;
    @FXML
    private Button button;
    @FXML
    private Label lblResultado;

    public void OnValidate(ActionEvent event) {
    String nombre = txtNombre.getText() == null ? "" : txtNombre.getText();
    String email = txtEmail.getText() == null ? "" : txtEmail.getText();
    String edad = txtEdad.getText() == null ? "" : txtEdad.getText();

        List<String> errores = new ArrayList<>();

        //Validacion de campo nombre

        if (nombre.isBlank() || nombre.length() < 3) {
            errores.add("El nombre es requerido");
        }
        if (email.isBlank() || !email.contains("@") || !email.contains(".")) {
            errores.add("El email es invalido");
        }
        int edadValidado = 0;
        try{
            edadValidado = Integer.parseInt(edad);
            if (edadValidado <= 0 || edadValidado > 120) {
                System.out.println("Edad fuera de rango");
            }
        }catch(Exception e){
            System.out.println("Dato no numerico");
        }

        if (errores.isEmpty()) {
            lblResultado.setText("El formulario es correcto");
            lblResultado.setStyle("-fx-text-fill: green;");
        }else  {
            lblResultado.setText("Error de: "+String.join(", ", errores));
            lblResultado.setStyle("-fx-text-fill: red;");
        }


    }
}