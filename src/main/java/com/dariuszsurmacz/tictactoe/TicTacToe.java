package com.dariuszsurmacz.tictactoe;

import com.dariuszsurmacz.tictactoe.logic.EasyComputer;
import com.dariuszsurmacz.tictactoe.logic.MediumComputer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.dariuszsurmacz.tictactoe.Buttons.*;

public class TicTacToe extends Application {

    private static final Image back = new Image("file:src/main/resources/background.gif");
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

        easyComputerPlay();
        mediumComputerPlay();
        playerVsPlayerPlay();

        counting(root);
        getPlayAgain().setOnAction(action -> GameReset.gameReset());
        getQuit().setOnAction(action -> Platform.exit());

        startLabel(label, "X turn", root, 610);

        startLabel(vsWho, "player vs. computer easy (LMB for X)", root, 670);

        root.getChildren().addAll(Arrays.stream(board.fields).flatMap(Arrays::stream).collect(Collectors.toList()));
        root.getChildren().addAll(quit, vsPlay, mediumLevel, easyLevel, playAgain, label, counter, vsWho);
        return root;
    }

    private static void playerVsPlayerPlay() {
        getVsPlay().setOnAction(action -> {
            vsComputer = false;
            playerX.setCount(0);
            playerO.setCount(0);
            counter.setText("X  " + playerX.getCount()
                    + ":" + playerO.getCount() + "  O");
            vsWho.setText("player vs. player (LMB for X, RMB for O)");
            GameReset.gameReset(null);
        });
    }

    private static void mediumComputerPlay() {
        getMediumLevel().setOnAction(action -> {
            vsComputer = true;
            playerO.setCount(0);
            playerX.setCount(0);
            counter.setText("X  " + playerX.getCount()
                    + ":" + playerO.getCount() + "  O");
            vsWho.setText("player vs. computer medium (LMB for X)");
            GameReset.gameReset(new MediumComputer());
        });
    }

    private static void easyComputerPlay() {
        getEasyLevel().setOnAction(action -> {
            vsComputer = true;
            playerO.setCount(0);
            playerX.setCount(0);
            counter.setText("X  " + playerX.getCount()
                    + ":" + playerO.getCount() + "  O");
            vsWho.setText("player vs. computer easy (LMB for X)");
            GameReset.gameReset(new EasyComputer());
        });
    }

    private static void startLabel(Label vsWho, String value, Pane root, int value1) {
        vsWho.setText(value);
        vsWho.setTextFill(Color.BLACK);
        vsWho.setFont(new Font("Arial", 20));
        vsWho.layoutXProperty().bind(root.widthProperty().subtract(vsWho.widthProperty()).divide(2));
        vsWho.setLayoutY(value1);
    }

    private static void counting(Pane root) {
        startLabel(counter, "X  " + playerX.getCount() + ":" + playerO.getCount() + "  O", root, 640);
    }

    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(TicTacToe.createScene());
        primaryStage.setTitle("Tic-Tac-Toe (Xs and Os)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}