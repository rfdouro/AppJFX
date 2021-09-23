package br.org.rfdouro.app01;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.StageStyle;

/**
 * JavaFX App
 */
public class App extends Application {

 private static Scene scene;

 @Override
 public void start(Stage stage) throws IOException {
  //scene = new Scene(loadFXML("primary"), 640, 480);
  //scene = new Scene(loadFXML("JanelaMain"), 640, 480);
  scene = new Scene(loadFXML("Janela01"), 640, 480);

  scene.widthProperty().addListener(new ChangeListener<Number>() {
   @Override
   public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
    System.out.println("Width: " + newValue);
    StackPane root = (StackPane) scene.getRoot();
    for (Object o : root.getChildren()) {
     System.out.println("-> : " + o.getClass());
    }
   }
  });

  stage.setScene(scene);
  stage.setTitle("Aplicação de Exemplo");
  //stage.getIcons().add(new Image("file:icon.png"));
  stage.getIcons().add(new Image(App.class.getResourceAsStream("images/icon.png")));
  stage.setMaximized(true);

  stage.show();
 }

 static void setRoot(String fxml) throws IOException {
  scene.setRoot(loadFXML(fxml));
 }

 private static Parent loadFXML(String fxml) throws IOException {
  FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
  return fxmlLoader.load();
 }

 public static void main(String[] args) {
  launch();
 }

 public static void loading() {
  ProgressForm pForm = new ProgressForm();

  // In real life this task would do something useful and return 
  // some meaningful result:
  Task<Void> task = new Task<Void>() {
   @Override
   public Void call() throws InterruptedException {
    for (int i = 0; i < 10; i++) {
     updateProgress(i, 10);
     Thread.sleep(500);
    }
    updateProgress(10, 10);
    return null;
   }
  };

  // binds progress of progress bars to progress of task:
  pForm.activateProgressBar(task);

  // in real life this method would get the result of the task
  // and update the UI based on its value:
  task.setOnSucceeded(event -> {
   pForm.getDialogStage().close();
  });

  pForm.getDialogStage().show();

  Thread thread = new Thread(task);
  thread.start();
 }

 /**
  * **************************
  */
 public static class ProgressForm {

  private final Stage dialogStage;
  private final ProgressBar pb = new ProgressBar();
  private final ProgressIndicator pin = new ProgressIndicator();

  public ProgressForm() {
   dialogStage = new Stage();
   dialogStage.initStyle(StageStyle.UTILITY);
   dialogStage.setResizable(false);
//   dialogStage.setMaximized(true);
   dialogStage.resizableProperty().setValue(Boolean.FALSE);
   dialogStage.initStyle(StageStyle.UNDECORATED);
   dialogStage.initModality(Modality.APPLICATION_MODAL);

   // PROGRESS BAR
   final Label label = new Label();
   label.setText("alerto");

   pb.setProgress(-1F);
   //pin.setProgress(-1F);

   final HBox hb = new HBox();
   hb.setSpacing(5);
   hb.setAlignment(Pos.CENTER);
   hb.getChildren().addAll(pb, pin);

   Scene scene = new Scene(hb);
   dialogStage.setScene(scene);
  }

  public void activateProgressBar(final Task<?> task) {
   pb.progressProperty().bind(task.progressProperty());
   //pin.progressProperty().bind(task.progressProperty());
   dialogStage.show();
  }

  public Stage getDialogStage() {
   return dialogStage;
  }
 }

}
