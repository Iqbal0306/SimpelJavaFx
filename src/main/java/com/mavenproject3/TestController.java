/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mavenproject3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author iqbal imanudin
 */
public class TestController implements Initializable {

    @FXML
    private Button test;
    @FXML
    private TextField txtNama;
    @FXML
    private TextField txtKode;
    @FXML
    private Button btnTamba;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnHapus;
    
    private ObservableList<buah> data = FXCollections.observableArrayList();
    @FXML
    private TableView<buah> table;
    @FXML
    private TableColumn<buah, String> colNama;
    @FXML
    private TableColumn<buah, String> colKode;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colKode.setCellValueFactory(new PropertyValueFactory<>("kode"));

        table.setItems(data);
    }    

    @FXML
    private void clicked(ActionEvent event) {
         System.out.println("Button ditekan!");
        test.setText("Clicked!");

    }

    @FXML
    private void tambah(ActionEvent event) {
        String nama = txtNama.getText();
        String kode = txtKode.getText();

        if (!nama.isEmpty() && !kode.isEmpty()) {
            data.add(new buah(nama, kode));
            clearInput();
        }
    }
    @FXML
    private void edit(ActionEvent event) {
        buah selected = table.getSelectionModel().getSelectedItem();

    if (selected == null) {
        System.out.println("Pilih data dulu untuk diedit!");
        return;
    }

 
    String newNama = txtNama.getText();
    String newKode = txtKode.getText();


    if (newNama.isEmpty() || newKode.isEmpty()) {
        System.out.println("Nama dan kode tidak boleh kosong saat edit!");
        return;
    }

    selected.setNama(newNama);
    selected.setKode(newKode);


    table.refresh();


    clearInput();

    System.out.println("Data berhasil diedit.");
    }
    

    @FXML
    private void hapus(ActionEvent event) {
         buah selected = table.getSelectionModel().getSelectedItem();
        if (selected != null) {
            data.remove(selected);
            clearInput();
        }
    }

    private void clearInput() {
        txtNama.clear();
        txtKode.clear();
    }
    
    private void clicked() {
        System.out.println("Button test ditekan!");
    }

}