package com.example.halligalli;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HalliGalliMenuController {

    @FXML
    private Text startText;

    @FXML
    void helpClicked(MouseEvent event) throws IOException {
        FXMLLoader helpLoader = new FXMLLoader(getClass().getResource("halligalliHelp.fxml"));
        Scene help_scene = new Scene(helpLoader.load(), 1200, 850); //로그인 화면
        Stage stage = (Stage) startText.getScene().getWindow();  // 현재 버튼의 Scene에서 Stage를 가져옵니다.
        stage.setTitle("How to play");
        stage.setScene(help_scene);
    }

    @FXML
    void startClicked(MouseEvent event) throws IOException {
        FXMLLoader playLoader = new FXMLLoader(getClass().getResource("halligalliPlay.fxml"));
        Scene play_scene = new Scene(playLoader.load(), 1200, 850); //로그인 화면
        Stage stage = (Stage) startText.getScene().getWindow();  // 현재 버튼의 Scene에서 Stage를 가져옵니다.
        stage.setTitle("Halli Galli");
        stage.setScene(play_scene);
    }

    @FXML
    void settingClicked(MouseEvent event) throws IOException {
        FXMLLoader settingLoader = new FXMLLoader(getClass().getResource("halligalliSetting.fxml"));
        Scene setting_scene = new Scene(settingLoader.load(), 1200, 850); //로그인 화면
        Stage stage = (Stage) startText.getScene().getWindow();  // 현재 버튼의 Scene에서 Stage를 가져옵니다.
        stage.setTitle("Settings");
        stage.setScene(setting_scene);
    }

}