module com.dariuszsurmacz.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.dariuszsurmacz.tictactoe to javafx.fxml;
    exports com.dariuszsurmacz.tictactoe;
}