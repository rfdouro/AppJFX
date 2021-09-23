/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.rfdouro.app01;

import br.org.rfdouro.app01.model.Pessoa;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
 @FXML
 private TableView tabela;
 @FXML
 private TableColumn<Pessoa, String> colunaNome;
 @FXML
 private TableColumn<Pessoa, String> colunaSobreNome;

 private ObservableList<Pessoa> dadosPessoas = FXCollections.observableArrayList();

 /**
  * Initializes the controller class.
  */
 @Override
 public void initialize(URL url, ResourceBundle rb) {
  // TODO
  lb01.setText("okok");

  dadosPessoas.add(new Pessoa("ana", "maria"));
  dadosPessoas.add(new Pessoa("maria", "joana"));
  dadosPessoas.add(new Pessoa("beatriz", "souza"));
  dadosPessoas.add(new Pessoa("maria", "clara"));
  
  
  colunaNome.setCellValueFactory(cellData -> cellData.getValue().getNome());
  colunaSobreNome.setCellValueFactory(cellData -> cellData.getValue().getSobreNome());
  
  tabela.setItems(getPersonData());
  
  //coloca percentual na largura das colunas
  //não podem ser resizeable
  colunaNome.prefWidthProperty().bind(tabela.widthProperty().multiply(0.4));
  colunaSobreNome.prefWidthProperty().bind(tabela.widthProperty().multiply(0.6));
  
  tabela.setOnMouseClicked(e -> {
   System.out.println(e);
   System.out.println(tabela.selectionModelProperty().get());
   ObservableList selectedItems = tabela.getSelectionModel().getSelectedItems();
   Pessoa pessoa = (Pessoa) tabela.getSelectionModel().getSelectedItem();
   System.out.println(pessoa.getNome().get());
  });

  System.out.println(tabela.getColumns().toArray()[0]);
 }

 public ObservableList<Pessoa> getPersonData() {
  return dadosPessoas;
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
 private void execLoadind() {
  App.loading();
 }

 @FXML
 private void sair() {
  System.exit(0);
 }

}
