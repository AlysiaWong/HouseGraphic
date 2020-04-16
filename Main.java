package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    int rotateAmount = 0;
    int houseX = 1;

    @Override
    public void start(Stage primaryStage) throws Exception{
    Line line1 = new Line(150,100,100,150);
    Line line2 = new Line(150,100,200,150);

    Line chimmney1 = new Line(170,100,185,100);
    Line chimmneyleft = new Line(170,100,170,120);
    Line chimmneyright = new Line(185,100,185,135);

    Rectangle house = new Rectangle(100,150,100,50);
    house.setFill(Color.WHITE);
    house.setStroke(Color.BLACK);

    Rectangle door = new Rectangle(110,170,20,30);
    door.setFill(Color.WHITE);
    door.setStroke(Color.BLACK);

    Circle knob = new Circle (125,185,2);
    knob.setFill(Color.WHITE);
    knob.setStroke(Color.BLACK);

    Rectangle window1 = new Rectangle(140,160,20,20);
    window1.setFill(Color.WHITE);
    window1.setStroke(Color.BLACK);

    Rectangle window2 = new Rectangle(170,160,20,20);
    window2.setFill(Color.WHITE);
    window2.setStroke(Color.BLACK);

        door.setOnMouseEntered(event -> {
            door.setFill(Color.GOLD);
            knob.setFill(Color.BLACK);

        });
        door.setOnMouseExited(event -> {
            door.setFill(Color.WHITE);
            knob.setFill(Color.WHITE);
        });
        window1.setOnMouseClicked(event -> {
            if (rotateAmount == 0) {
                rotateAmount = 18;
                window1.setFill(Color.BURLYWOOD);
            }
            else if (rotateAmount == 18) {
                rotateAmount = 0;
                window1.setFill(Color.WHITE);
            }
            window1.setRotate(rotateAmount);
        });
        window2.setOnMouseExited(event -> {
            window2.setFill(Color.BURLYWOOD);
            window2.setRotate(20);
        });
        house.setOnMousePressed(event -> {
            house.setFill(Color.CORNFLOWERBLUE);
            if(houseX == 1)
                houseX = 2;
            else if (houseX == 2)
                houseX = 1;
            house.setScaleX(houseX);
        });

    Pane pane = new Pane(line1, line2, house, door, knob, window1, window2, chimmney1, chimmneyleft, chimmneyright);
        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
