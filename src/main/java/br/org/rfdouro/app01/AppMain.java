/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.rfdouro.app01;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author romulo
 */
public class AppMain extends Application {

 private static Scene scene;
 
 public static void main(String[] args) {
  launch();
 }

 @Override
 public void start(Stage stage) throws Exception {
  scene = new Scene(loadFXML("JanelaPrincipal"));
  stage.setScene(scene);
  stage.setTitle("Aplicação de Exemplo");
  stage.getIcons().add(new Image(App.class.getResourceAsStream("images/icon.png")));
  stage.setMaximized(true);

  stage.show();
 }

 private static Parent loadFXML(String fxml) throws IOException {
  FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
  return fxmlLoader.load();
 }

}
