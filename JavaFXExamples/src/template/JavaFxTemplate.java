package template;

import javafx.application.Application;
import javafx.scene.layout.FlowPane;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class JavaFxTemplate extends Application {
   // * Private variables, components need to be accessed in methods.

   @Override
   public void start(Stage primaryStage) {
      // * Other non instance components

      // * Construct a scene graph of nodes
      var root = new FlowPane();  // Construct the root of the scene graph
      root.getChildren().add(null);       // Root node add child node
      root.getChildren().addAll(null, null);  // Root node add child nodes

      
      // * Construct a sence with the root of the scene graph, width and height
      Scene scene = new Scene(root, 300, 100);

      // * Set the scene of the stage
      primaryStage.setScene(scene);
      // * Set the window title
      primaryStage.setTitle("Hello");
      // * Show the stage
      primaryStage.show();
   }

   public static void main(String[] args) {
      // * Launch the application by invoking start()
      launch(args);
   }
}