package com.dariuszsurmacz.tictactoe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    private Image board = new Image("file:src/main/resources/board.png");
    private Image xImage = new Image("file:src/main/resources/x.gif");
    private Image oImage = new Image("file:src/main/resources/o.gif");
    private FlowPane images = new FlowPane(Orientation.HORIZONTAL); // uklad kolejnych o i x


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true,
                true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(board, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER); // skąd zaczynamy układać x i o
        grid.setPadding(new Insets(0, 5, 5, 5)); //przesuwanie x i o
        grid.setHgap(10); // odleglosc miedzy rzędami poziom ???
        grid.setVgap(10); // odleglosc miedzy rzędami pion ???
        grid.setBackground(background);

        ImageView xImg = new ImageView(xImage);
        ImageView oImg = new ImageView(oImage);
        ImageView xImg2 = new ImageView(xImage);
        images.getChildren().add(xImg);
        images.getChildren().add(oImg);
        images.getChildren().add(xImg2);


        grid.add(images, 0, 0, 3, 1);   // ???

        Scene scene = new Scene(grid, 300, 400, Color.WHEAT); // wielkość kraty
        primaryStage.setTitle("Tic-Tac-Toe");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

//public class TicTacToe extends Application {
//
//    private Parent createContent() {
//        Pane root = new Pane();
//        root.setPrefSize(600, 600);
//
//        return root;
//    }
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        primaryStage.setScene(new Scene(createContent()));
//        primaryStage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}