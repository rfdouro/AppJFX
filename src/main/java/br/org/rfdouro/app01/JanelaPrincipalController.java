/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.org.rfdouro.app01;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author romulo
 */
public class JanelaPrincipalController implements Initializable {

 @FXML
 private ScrollPane pane;
 @FXML
 private HBox box;

 /**
  * Initializes the controller class.
  */
 @Override
 public void initialize(URL url, ResourceBundle rb) {
  // TODO
 }

 private void carregaInner(String nomeJanela) {
  try {
   Parent janela = FXMLLoader.load(getClass().getResource(nomeJanela + ".fxml"));
   //box.getChildren().removeAll();
   //box.getChildren().setAll(janela);
   pane.setContent(janela);
  } catch (Exception ex) {
   System.out.println(ex.getMessage());
  }
 }

 @FXML
 private void abreMain() {
  carregaInner("JanelaMain");
 }

}
