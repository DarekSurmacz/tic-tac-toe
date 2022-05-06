package com.dariuszsurmacz.tictactoe;;

import com.dariuszsurmacz.tictactoe.logic.EasyComputer;
import com.dariuszsurmacz.tictactoe.logic.MediumComputer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.stream.Collectors;


public class TicTacToe extends Application {

    private static Image back = new Image("file:src/main/resources/background.gif");
    public static Board board = new Board(new EasyComputer());
    public static boolean turnX = true;
    public static boolean possibleMove = true;
    public static Label label = new Label();
    public static Label vsWho = new Label();
    public static Label counter = new Label();
    public static Counter playerX = new Counter(0);
    public static Counter playerO = new Counter(0);
    public static boolean vsComputer = true;

    public static void main(String[] args) {
        launch(args);
    }

    public static Parent createScene() {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true,
                true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(back, BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, backgroundSize);
        Background background = new Background(backgroundImage);

        Pane root = new Pane();
        root.setPrefSize(600, 750);
        root.setBackground(background);

        Button easyLevel = new Button();
        easyLevel.setText("vs. computer easy");
        easyLevel.setFont(new Font("Arial", 15));
        easyLevel.setLayoutX(0);
        easyLevel.setLayoutY(600);
        easyLevel.setPrefSize(200, 50);
        easyLevel.setOnAction(action -> {
            vsComputer = true;
            playerO.setCount(0);
            playerX.setCount(0);
            counter.setText("X  " + playerX.getCount()
                    + ":" + playerO.getCount() + "  O");
            vsWho.setText("player vs. computer easy (LMB for X)");
            State.gameReset(new EasyComputer());
        });

                Button mediumLevel = new Button();
        mediumLevel.setText("vs. computer medium");
        mediumLevel.setFont(new Font("Arial", 15));
        mediumLevel.setLayoutX(0);
        mediumLevel.setLayoutY(700);
        mediumLevel.setPrefSize(200, 50);
        mediumLevel.setOnAction(action -> {
            vsComputer = true;
            playerO.setCount(0);
            playerX.setCount(0);
            counter.setText("X  " + playerX.getCount()
                    + ":" + playerO.getCount() + "  O");
            vsWho.setText("player vs. computer medium (LMB for X)");
            State.gameReset(new MediumComputer());
        });

        Button playAgain = new Button();
        playAgain.setText("New Game");
        playAgain.setFont(new Font("Arial", 15));
        playAgain.setLayoutX(200);
        playAgain.setLayoutY(700);
        playAgain.setPrefSize(200, 50);
        playAgain.setOnAction(action -> {
            State.gameReset();
        });

        Button vsPlay = new Button();
        vsPlay.setText("2 players");
        vsPlay.setWrapText(true);
        vsPlay.setFont(new Font("Arial", 15));
        vsPlay.setLayoutX(400);
        vsPlay.setLayoutY(600);
        vsPlay.setPrefSize(200, 50);
        vsPlay.setOnAction(action -> {
            vsComputer = false;
            playerX.setCount(0);
            playerO.setCount(0);
            counter.setText("X  " + playerX.getCount()
                    + ":" + playerO.getCount() + "  O");
            vsWho.setText("player vs. player (LMB for X, RMB for O)");
            State.gameReset(null);
        });

        Button quit = new Button();
        quit.setText("Quit");
        quit.setFont(new Font("Arial", 15));
        quit.setLayoutX(400);
        quit.setLayoutY(700);
        quit.setPrefSize(200, 50);
        quit.setOnAction(action -> {
            Platform.exit();
        });

        label.setText("X turn");
        label.setTextFill(Color.BLACK);
        label.setFont(new Font("Arial", 20));
        label.layoutXProperty().bind(root.widthProperty().subtract(label.widthProperty()).divide(2));
        label.setLayoutY(610);

        counter.setText("X  " + playerX.getCount() + ":" + playerO.getCount() + "  O");
        counter.setTextFill(Color.BLACK);
        counter.setFont(new Font("Arial", 20));
        counter.layoutXProperty().bind(root.widthProperty().subtract(counter.widthProperty()).divide(2));
        counter.setLayoutY(640);

        vsWho.setText("player vs. computer easy (LMB for X)");
        vsWho.setTextFill(Color.BLACK);
        vsWho.setFont(new Font("Arial", 20));
        vsWho.layoutXProperty().bind(root.widthProperty().subtract(vsWho.widthProperty()).divide(2));
        vsWho.setLayoutY(670);

        root.getChildren().addAll(Arrays.stream(board.fields).flatMap(Arrays::stream).collect(Collectors.toList()));
        root.getChildren().addAll(quit, vsPlay, mediumLevel, easyLevel, playAgain, label, counter, vsWho);
        return root;
    }

    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(TicTacToe.createScene());

        primaryStage.setTitle("Tic-Tac-Toe (Xs and Os)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}