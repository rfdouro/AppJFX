/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.rfdouro.app01;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author romulo
 */
public class JanelaMainController implements Initializable {

 @FXML
 private AnchorPane anchorPane;
 @FXML
 private Label lb01;
 @FXML
 private TextField edtNome;
 @FXML
 private ToggleGroup group;

 /**
  * Initializes the controller class.
  */
 @Override
 public void initialize(URL url, ResourceBundle rb) {
  // TODO
  lb01.setText("okok");
 }

 @FXML
 private void mostraDigitado() {
  String n = edtNome.getText();
  Alert alert = new Alert(AlertType.INFORMATION);
  alert.setTitle("Information Dialog");
  alert.setHeaderText("Look, an Information Dialog");
  alert.setContentText("Texto - > " + n);

  alert.showAndWait();
 }
 
 @FXML
 private void execLoadind(){
  App.loading();
 }
 
 @FXML
 private void sair(){
  System.exit(0);
 }

}
