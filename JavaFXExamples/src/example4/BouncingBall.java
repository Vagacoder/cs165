package example4;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import javafx.stage.Stage;

import javafx.util.Duration;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.geometry.Insets;


public class BouncingBall extends Application {

    private static final int CANVAS_WIDTH = 800;
    private static final int CANVAS_HEIGHT = 600;
    private static final int UPDATE_PERIOD = 20;

    private Circle ball;
    private int centerX = 280;
    private int centerY = 220;
    private int radius = 100;
    private int xStep = 3;
    private int yStep = 3;

    @Override
    public void start(Stage stage) throws Exception {

        Pane canvas = new Pane();
        canvas.setPrefSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.setBackground(new Background(
            new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)
        ));

        stage.setScene(new Scene(canvas));
        stage.setTitle("Bouncing Ball Example using JavaFX");
        stage.show();

        ball = new Circle(centerX, centerY, radius, Color.LIGHTSKYBLUE);
        canvas.getChildren().addAll(ball);

        Timeline loop = new Timeline(60, new KeyFrame(Duration.millis(UPDATE_PERIOD), evt -> {
            centerX +=xStep;
            centerY +=yStep;
            if(centerX + radius > CANVAS_WIDTH || centerX - radius < 0) {
                xStep = -xStep;
            }
            if(centerY + radius > CANVAS_HEIGHT || centerY - radius < 0) {
                yStep = -yStep;
            }
            ball.setCenterX(centerX);
            ball.setCenterY(centerY);
        }));

        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();
    }

    public static void main(String[] args) {
        BouncingBall.launch(args);
    }
}