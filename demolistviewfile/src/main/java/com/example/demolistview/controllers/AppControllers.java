package com.example.demolistview.controllers;

import com.example.demolistview.services.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;

public class AppControllers {
    @FXML
    private Label lblMsg;
    @FXML
    private ListView<String> listView;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtEmail;

    @FXML
    private ObservableList<String> data = FXCollections.observableArrayList();
    private PersonService service = new PersonService();

    @FXML
    public void initialize(){
        loadFromFile();
        listView.getSelectionModel().selectedItemProperty().addListener(
                (obs,oldValue,newValue) ->{
                    loadDataToForm(newValue);
                }
        );
        listView.setItems(data);
    }

    @FXML
    public void onReload(){
        loadFromFile();
    }
    {

    }

    @FXML
    private TextField txtAge;

    @FXML
    public void onAdd(){
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            int age = Integer.parseInt(txtAge.getText());

            service.addPerson(name, email, age);

            lblMsg.setText("Usuario ingresado correctamente");
            lblMsg.setStyle("-fx-text-fill: green");
            txtName.clear();
            txtEmail.clear();
            txtAge.clear();
            loadFromFile();

        } catch (NumberFormatException e) {
            lblMsg.setText("La edad debe ser un número válido");
            lblMsg.setStyle("-fx-text-fill: red");
        } catch (IOException | IllegalArgumentException e) {
            lblMsg.setText("Error: " + e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }

    public void onUpdate(){
        try {
            int index= listView.getSelectionModel().getSelectedIndex();
            String name = txtName.getText();
            String email = txtEmail.getText();
            int age = Integer.parseInt(txtAge.getText());

            service.updatePerson(index, name, email, age);

            loadFromFile();
            lblMsg.setText("Usuario ingresado correctamente");
            lblMsg.setStyle("-fx-text-fill: green");
            txtName.clear();
            txtEmail.clear();
            txtAge.clear();

        } catch (NumberFormatException e) {
            lblMsg.setText("La edad debe ser un número válido");
            lblMsg.setStyle("-fx-text-fill: red");
        } catch (IOException | IllegalArgumentException e) {
            lblMsg.setText("Error: " + e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }

    public void onRemove(){
        int index= listView.getSelectionModel().getSelectedIndex();
        if (index<0){
            lblMsg.setText("El indice es menor a 0");
            lblMsg.setStyle("red");
        }
        try {
            service.removePerson(index);
            txtName.clear();
            txtEmail.clear();
            txtAge.clear();

            loadFromFile();

            lblMsg.setText("Persona eliminada");
            lblMsg.setStyle("-fx-text-fill: green");
        } catch (NumberFormatException e) {
            lblMsg.setText("La edad debe ser un número válido");
            lblMsg.setStyle("-fx-text-fill: red");
        } catch (IOException | IllegalArgumentException e) {
            lblMsg.setText("Error: " + e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }

    private void loadFromFile() {
        try{
            List<String> items = service.loadDataForListView();
            data.setAll(items);
            lblMsg.setText("Datos cargados correctamente");
            lblMsg.setStyle("-fx-text-fill: green");
        } catch (IOException e) {
            lblMsg.setText("error al cargar : " + e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }

    }

    private void loadDataToForm(String data){
        if (data==null){
            lblMsg.setText("--------");
        }else{
            String[] parts= data.split(" - ");
            txtName.setText(parts[0]);
            txtEmail.setText(parts[1]);
            txtAge.setText(parts[2]);
        }
    }
}