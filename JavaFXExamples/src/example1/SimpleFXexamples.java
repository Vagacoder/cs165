package example1;

/*
 * This class is an example of javaFX components.
 * 
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SimpleFXexamples extends Application {

  private Button button1;
  private Button button2;

  @Override
  public void start(Stage stage) {

    var panel = new FlowPane();
    var scene = new Scene(panel, 400, 300);
    
    var nodes = panel.getChildren();
    var label1 = new Label("A Simple JavaFX application.");
    label1.setFont(Font.font("Serif", FontWeight.NORMAL, 20));
    nodes.add(label1);

    Label label2 = new Label("Welcome to new GUI");
    nodes.add(label2);

    this.button1 = new Button("Say Hello");
    this.button1.setOnAction(ev -> System.out.println("Hello World!"));
    nodes.add(button1);

    this.button2 = new Button("Welcome!");
    this.button2.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent e) {
        System.out.println("Welcome!");
      }
    });
    nodes.add(button2);
    
    stage.setTitle("Simple JavFX Application");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    System.out.println("Start running!");
    Application.launch(args);
  }

}
