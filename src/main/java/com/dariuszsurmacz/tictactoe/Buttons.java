package com.dariuszsurmacz.tictactoe;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class Buttons {

    static Button easyLevel = new Button();

    public static Button getEasyLevel() {
        easyLevel.setText("vs. computer easy");
        easyLevel.setFont(new Font("Arial", 15));
        easyLevel.setLayoutX(0);
        easyLevel.setLayoutY(600);
        easyLevel.setPrefSize(200, 50);
        return easyLevel;
    }

    static Button mediumLevel = new Button();

    public static Button getMediumLevel() {
        mediumLevel.setText("vs. computer medium");
        mediumLevel.setFont(new Font("Arial", 15));
        mediumLevel.setLayoutX(0);
        mediumLevel.setLayoutY(700);
        mediumLevel.setPrefSize(200, 50);
        return mediumLevel;
    }

     static Button playAgain = new Button();

    public static Button getPlayAgain() {
        playAgain.setText("New Game / Play Again");
        playAgain.setFont(new Font("Arial", 15));
        playAgain.setLayoutX(200);
        playAgain.setLayoutY(700);
        playAgain.setPrefSize(200, 50);
        return playAgain;
    }

    static Button vsPlay = new Button();

    public static Button getVsPlay() {
        vsPlay.setText("2 players");
        vsPlay.setWrapText(true);
        vsPlay.setFont(new Font("Arial", 15));
        vsPlay.setLayoutX(400);
        vsPlay.setLayoutY(600);
        vsPlay.setPrefSize(200, 50);
        return vsPlay;
    }

    static Button quit = new Button();

    public static Button getQuit() {
        quit.setText("Quit");
        quit.setFont(new Font("Arial", 15));
        quit.setLayoutX(400);
        quit.setLayoutY(700);
        quit.setPrefSize(200, 50);
        return quit;
    }
}
