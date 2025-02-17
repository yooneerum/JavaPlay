package com.example.halligalli;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HalliGalliHelpController {

    @FXML
    private Text backToMenuText;

    @FXML
    void backToMenuText(MouseEvent event) throws IOException {
        FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("halligalliMenu.fxml"));
        Scene menu_scene = new Scene(menuLoader.load(), 1200, 850); //로그인 화면
        Stage stage = (Stage) backToMenuText.getScene().getWindow();  // 현재 버튼의 Scene에서 Stage를 가져옵니다.
        stage.setTitle("Halli Galli");
        stage.setScene(menu_scene);
    }

}
