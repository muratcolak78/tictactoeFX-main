package com.example.tictactoefx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label player;
    @FXML
    private Button XorO;
    String x = "X";
    String y = "0";
    int control = 0;
    @FXML
    private Button eight;

    @FXML
    private Button five;

    @FXML
    private Button four;

    @FXML
    private Button nine;

    @FXML
    private Button one;

    @FXML
    private Button seven;

    @FXML
    private Button sex;

    @FXML
    private Button three;

    @FXML
    private Button two;
    @FXML
    void exitButtonClick(ActionEvent event) {

    }

    @FXML
    void newGameButtonClick(ActionEvent event) {
        buttonClean();
    }

    @FXML
    protected void onHelloButtonClick(ActionEvent ae) {
        String s = ((Button) ae.getSource()).getText();
        System.out.println(s);
        if (s == ""&& control<=9) {

            if (control % 2 == 0) {
                ((Button) ae.getSource()).setText(x);
                player.setText("First Player");
            } else {
                ((Button) ae.getSource()).setText(y);
                player.setText("Second Player");
            }
            if (checkWinner()){
                buttonClean();
            }
            control++;
        }

    }
    public boolean checkWinner() {
        String testX = "XXX", testO = "000";
        String word1 = ""+ one.getText()+ two.getText()+three.getText();
        String word2 = "" + four.getText()+ five.getText()+ sex.getText();
        String word3 = "" + seven.getText()+ eight.getText()+nine.getText();
        String word4 = ""+ one.getText()+ four.getText()+seven.getText();
        String word5 = "" + two.getText()+ five.getText()+ eight.getText();
        String word6 = "" + three.getText()+ sex.getText()+nine.getText();
        String word7 = ""+ one.getText()+ five.getText()+nine.getText();
        String word8 = "" + three.getText()+ five.getText()+ seven.getText();

        if (testX.equals(word1) || testX.equals(word2) || testX.equals(word3) || testX.equals(word4) || testX.equals(word5) || testX.equals(word6) || testX.equals(word7) || testX.equals(word8)) {
            System.out.println("Winner XXX");
            infoBox("Winner XXX", "congratulations", "play again?");
            return true;
        } else if (testO.equals(word1) || testO.equals(word2) || testO.equals(word3) || testO.equals(word4) || testO.equals(word5) || testO.equals(word6) || testO.equals(word7) || testO.equals(word8)) {
            infoBox("Winner 000", "congratulations", "play again?");
            System.out.println("Winner 000");
            return true;
        } else if (this.control == 9) {
            System.out.println("No Winner!!");
            infoBox("No Winner", "sorry", "play again?");
            buttonClean();
            System.out.println("new game");
            return false;
        } else
            return false;
    }
    protected void buttonClean(){
        one.setText("");
        two.setText("");
        three.setText("");
        four.setText("");
        five.setText("");
        sex.setText("");
        seven.setText("");
        eight.setText("");
        nine.setText("");
        control=0;
    }
    public static void infoBox(String infoMessage, String titleBar, String headerMessage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }



}



