module com.dariuszsurmacz.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.dariuszsurmacz.tictactoe to javafx.fxml;
    exports com.dariuszsurmacz.tictactoe;
    exports com.dariuszsurmacz.tictactoe.logic;
    opens com.dariuszsurmacz.tictactoe.logic to javafx.fxml;
}