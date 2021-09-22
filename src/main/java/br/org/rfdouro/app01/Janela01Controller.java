/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.rfdouro.app01;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author romulo.douro
 */
public class Janela01Controller implements Initializable {

 @FXML
 private StackPane root;

 private StackPane hPane;

 @FXML
 private AnchorPane anchorPane;

 /**
  * Initializes the controller class.
  */
 @Override
 public void initialize(URL url, ResourceBundle rb) {
  // TODO
  //adiciona tela de loading
  Button btn1 = new Button("One"), btn2 = new Button("Two");
  HBox hBox = new HBox(btn1, btn2);
  hBox.setPadding(new Insets(10));
  //hBox.setSpacing(10);
  hPane = new StackPane(hBox);
  //hPane.setMaxHeight(100);
  hPane.setVisible(false);
  hPane.setStyle("-fx-background-color:#55555550");

  root.getChildren().add(hPane);

  btn1.setOnAction((e) -> {
   //hPane.setVisible(false);
   FadeTransition ft = new FadeTransition(Duration.millis(300), hPane);
   ft.setOnFinished(e1 -> hPane.setVisible(false));
   ft.setFromValue(1.0);
   ft.setToValue(0.0);
   ft.play();
  });
 }

 @FXML
 private void sair() {
  System.exit(0);
 }

 @FXML
 private void abre() throws IOException {
  setloading();
  AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("JanelaMain.fxml"));
  System.out.println("" + anchorPane.getBoundsInLocal() + "" + anchorPane.getBoundsInParent());
  System.out.println("" + newLoadedPane.getBoundsInLocal() + "" + newLoadedPane.getBoundsInParent());
  anchorPane.getChildren().setAll(newLoadedPane);
  System.out.println("=" + anchorPane.getChildren().size());
 }

 @FXML
 private void mostraSobre() throws IOException {
  Stage dialogSobre;
  dialogSobre = new Stage();
  TabPane pane = FXMLLoader.load(getClass().getResource("DialogAjuda.fxml"));
  Scene scene = new Scene(pane);
  dialogSobre.setScene(scene);
  dialogSobre.initStyle(StageStyle.DECORATED);
  dialogSobre.setResizable(false);
//   dialogStage.setMaximized(true);
  dialogSobre.resizableProperty().setValue(Boolean.FALSE);
  dialogSobre.setMaximized(false);
  dialogSobre.initModality(Modality.APPLICATION_MODAL);
  dialogSobre.setTitle("Ajuda");
  dialogSobre.show();
 }

 private void setloading() {
  StackPane.setAlignment(hPane, Pos.TOP_CENTER);
  hPane.setVisible(true);
  FadeTransition ft = new FadeTransition(Duration.millis(300), hPane);
  ft.setFromValue(0.0);
  ft.setToValue(1.0);
  ft.play();
 }
}
