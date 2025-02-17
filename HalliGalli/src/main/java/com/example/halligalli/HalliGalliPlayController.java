package com.example.halligalli;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class HalliGalliPlayController {

    @FXML
    private AnchorPane p1bananaPane;
    @FXML
    private ImageView p1banana1;
    @FXML
    private ImageView p1banana2;
    @FXML
    private ImageView p1banana3;
    @FXML
    private ImageView p1banana4;
    @FXML
    private ImageView p1banana5;

    @FXML
    private AnchorPane p1limePane;
    @FXML
    private ImageView p1lime1;
    @FXML
    private ImageView p1lime2;
    @FXML
    private ImageView p1lime3;
    @FXML
    private ImageView p1lime4;
    @FXML
    private ImageView p1lime5;

    @FXML
    private AnchorPane p1plumPane;
    @FXML
    private ImageView p1plum1;
    @FXML
    private ImageView p1plum2;
    @FXML
    private ImageView p1plum3;
    @FXML
    private ImageView p1plum4;
    @FXML
    private ImageView p1plum5;

    @FXML
    private AnchorPane p1strawPane;
    @FXML
    private ImageView p1straw1;
    @FXML
    private ImageView p1straw2;
    @FXML
    private ImageView p1straw3;
    @FXML
    private ImageView p1straw4;
    @FXML
    private ImageView p1straw5;

    @FXML
    private AnchorPane p2bananaPane;
    @FXML
    private ImageView p2banana1;
    @FXML
    private ImageView p2banana2;
    @FXML
    private ImageView p2banana3;
    @FXML
    private ImageView p2banana4;
    @FXML
    private ImageView p2banana5;

    @FXML
    private AnchorPane p2limePane;
    @FXML
    private ImageView p2lime1;
    @FXML
    private ImageView p2lime2;
    @FXML
    private ImageView p2lime3;
    @FXML
    private ImageView p2lime4;
    @FXML
    private ImageView p2lime5;

    @FXML
    private AnchorPane p2plumPane;
    @FXML
    private ImageView p2plum1;
    @FXML
    private ImageView p2plum2;
    @FXML
    private ImageView p2plum3;
    @FXML
    private ImageView p2plum4;
    @FXML
    private ImageView p2plum5;

    @FXML
    private AnchorPane p2strawPane;
    @FXML
    private ImageView p2straw1;
    @FXML
    private ImageView p2straw2;
    @FXML
    private ImageView p2straw3;
    @FXML
    private ImageView p2straw4;
    @FXML
    private ImageView p2straw5;




    @FXML
    private ImageView p1deckImg;  //플레이어 1 카드 덱 이미지
    @FXML
    private Text p1deckNumText;  //플레이어 1 카드 덱 남은 수 표시하는 텍스트
    @FXML
    private ImageView p1frontBack;  //플레이어 1 내는 카드 뒷면 이미지
    @FXML
    private Rectangle p1frontWhite;  //플레이어 1 내는 카드 하얀 앞면 이미지

    @FXML
    private ImageView p2deckImg;
    @FXML
    private Text p2deckNumText;
    @FXML
    private ImageView p2frontBack;
    @FXML
    private Rectangle p2frontWhite;

    @FXML
    private ImageView hitImg;  //종 칠 때 뜨는 이미지
    @FXML
    private Text winnerText;  //게임 종료 시 보이는 텍스트
    @FXML
    private Text restartText;  //재시작 텍스트
    @FXML
    private Text scoreText;  //점수 표출 텍스트
    int p1Score = 0;  //플레이어 1 점수
    int p2Score = 0;  //플레이어 2 점수

    @FXML
    private AnchorPane root;  //키보드 입력 받기 위한 닻 역할(?)

    int p1DeckNum = 28;  //p1의 남은 카드 수
    int p2DeckNum = 28;  //p2의 남은 카드 수

    int p1FrontNum = 0;  //p1이 낸 카드 수
    int p2FrontNum = 0;  //p2가 낸 카드 수

    int p1fruitKind = -1;  // 0=banana, 1=lime, 2=plum, 3=straw
    int p1fruitNum = -1;
    int p2fruitKind = -1;  // 0=banana, 1=lime, 2=plum, 3=straw
    int p2fruitNum = -1;
    //게임을 막 시작해서 낸 카드가 아직 없을 때 종을 쳐서 이벤트가 발생하는 것을 방지하기 위해 기본값을 -1로 설정

    int pTurn = 1;  // 플레이 순서

    Random random = new Random();  //랜덤 클래스 사용하여 무작위 정수 받기 위한 변수명

    ImageView[] p1Banana;
    ImageView[] p2Banana;
    ImageView[] p1Lime;
    ImageView[] p2Lime;
    ImageView[] p1Plum;
    ImageView[] p2Plum;
    ImageView[] p1Straw;
    ImageView[] p2Straw;
    //각 플레이어 및 과일 별 개수 어레이

    ImageView[][] p1Fruits;
    ImageView[][] p2Fruits;
    //각 플레이어 별 과일 이차원 어레이


    public void initialize() {
        p1Banana = new ImageView[]{p1banana1, p1banana2, p1banana3, p1banana4, p1banana5};
        p2Banana = new ImageView[]{p2banana1, p2banana2, p2banana3, p2banana4, p2banana5};
        p1Lime = new ImageView[]{p1lime1, p1lime2, p1lime3, p1lime4, p1lime5};
        p2Lime = new ImageView[]{p2lime1, p2lime2, p2lime3, p2lime4, p2lime5};
        p1Plum = new ImageView[]{p1plum1, p1plum2, p1plum3, p1plum4, p1plum5};
        p2Plum = new ImageView[]{p2plum1, p2plum2, p2plum3, p2plum4, p2plum5};
        p1Straw = new ImageView[]{p1straw1, p1straw2, p1straw3, p1straw4, p1straw5};
        p2Straw = new ImageView[]{p2straw1, p2straw2, p2straw3, p2straw4, p2straw5};
        //각 과일 어레이에 과일 이미지 넣기

        p1Fruits = new ImageView[][]{p1Banana, p1Lime, p1Plum, p1Straw};
        p2Fruits = new ImageView[][]{p2Banana, p2Lime, p2Plum, p2Straw};
        //각 플레이어 과일 이차원 어레이에 과일 종류별로 어레이 넣기


        root.setOnKeyPressed(event -> {  // 키보드 입력을 받기 위한 이벤트 처리
            if (event.getCode() == KeyCode.A) {  // 플레이어 1 카드 키
                System.out.println("A key was pressed in Controller!");
                if (pTurn==1) {
                    p1frontBack.setVisible(true);  //키 프레스 상태에서 뒷면 이미지 표출
                    p1frontWhite.setVisible(true);  //카드 흰면 표출

                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 5; j++) {
                            p1Fruits[i][j].setVisible(false);
                        }
                    }  //모든 과일 이미지 투명화

                    p1fruitKind = random.nextInt(4);
                    p1fruitNum = random.nextInt(4)+1;
                    if (random.nextInt(100) < 16) {
                        p1fruitNum=5; // 15% 확률로 5 생성
                    }
                    //과일 종류 및 개수 랜덤하게(과일 개수 5 나올 확률만 줄여서) 설정
                }
            }

            else if (event.getCode() == KeyCode.L) {  // 플레이어 2 카드 키(이하 플레이어 1과 동일)
                System.out.println("L key was pressed in Controller!");
                if (pTurn==2) {
                    p2frontBack.setVisible(true);
                    p2frontWhite.setVisible(true);

                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 5; j++) {
                            p2Fruits[i][j].setVisible(false);
                        }
                    }

                    p2fruitKind = random.nextInt(4);
                    p2fruitNum = random.nextInt(4)+1;
                    if (random.nextInt(100) < 16) {
                        p2fruitNum=5; // 15% 확률로 5 생성
                    }
                    //과일 종류 및 개수 랜덤하게(과일 개수 5 나올 확률만 줄여서) 설정
                }
            }

            else if (event.getCode() == KeyCode.F) {  // 플레이어 1 종치기 키
                System.out.println("F key was pressed in Controller!");
                if((pTurn==1||pTurn==2) && !(p1fruitKind == -1)) {
                    hitImg.setVisible(true);
                    pTurn = 1;  //맞게 쳤든 틀리게 쳤든 종 친 사람에게 차례 돌아감
                    System.out.println("p1FrontNum is "+p1FrontNum+" and p1fruitKind is "+p1fruitKind + " and p1fruitNum is "+p1fruitNum);
                    System.out.println("p2FrontNum is "+p2FrontNum+" and p2fruitKind is "+p2fruitKind + " and p2fruitNum is "+p2fruitNum);

                    if(p1FrontNum!=0 && p2FrontNum!=0) {  //플레이어 두명 모두 앞에 낸 카드가 있는 경우
                        if(p1fruitKind==p2fruitKind) {  //앞에 낸 두 카드의 과일 종류가 같은 경우
                            if((p1fruitNum+p2fruitNum)==5) {  //두 카드에 그려진 과일의 개수가 5인 경우
                                p1DeckNum = p1DeckNum+p1FrontNum+p2FrontNum;
                                p1deckNumText.setText(""+p1DeckNum);
                                //플레이어 1의 덱에 앞에 낸 카드의 수만큼 추가
                                p1FrontNum=0;
                                p2FrontNum=0;
                                p1fruitKind = -1;
                                p1fruitNum = -1;
                                p2fruitKind = -1;
                                p2fruitNum = -1;
                                p1frontWhite.setVisible(false);
                                p2frontWhite.setVisible(false);
                                for (int i = 0; i < 4; i++) {
                                    for (int j = 0; j < 5; j++) {
                                        p1Fruits[i][j].setVisible(false);
                                        p2Fruits[i][j].setVisible(false);
                                    }
                                }
                                //앞에 낸 카드들 상태 초기화
                            }
                            else {  //두 카드에 그려진 과일의 개수의 합이 5가 아닌 경우
                                p1DeckNum-=1;
                                p2DeckNum+=1;
                                p1deckNumText.setText(""+p1DeckNum);
                                p2deckNumText.setText(""+p2DeckNum);
                            }
                        }
                        else{  //앞에 낸 두 카드의 과일 종류가 다른 경우
                            if(!(p1fruitNum==5) && !(p2fruitNum==5)){  //두 카드 모두 그려진 과일의 개수가 5가 아닌 경우
                                p1DeckNum-=1;
                                p2DeckNum+=1;
                                p1deckNumText.setText(""+p1DeckNum);
                                p2deckNumText.setText(""+p2DeckNum);
                            }
                            else {  //과일의 개수가 5인 카드가 한 장이라도 있는 경우
                                p1DeckNum = p1DeckNum+p1FrontNum+p2FrontNum;
                                p1deckNumText.setText(""+p1DeckNum);
                                //플레이어 1의 덱에 앞에 낸 카드의 수만큼 추가
                                p1FrontNum=0;
                                p2FrontNum=0;
                                p1fruitKind = -1;
                                p1fruitNum = -1;
                                p2fruitKind = -1;
                                p2fruitNum = -1;
                                p1frontWhite.setVisible(false);
                                p2frontWhite.setVisible(false);
                                for (int i = 0; i < 4; i++) {
                                    for (int j = 0; j < 5; j++) {
                                        p1Fruits[i][j].setVisible(false);
                                        p2Fruits[i][j].setVisible(false);
                                    }
                                }
                                //앞에 낸 카드들 상태 초기화
                            }
                        }
                    }
                    else if(p1FrontNum!=0 || p2FrontNum!=0){  //플레이어 둘 중 한명만 카드를 낸 경우
                        if(p1fruitNum==5 || p2fruitNum==5) {  //과일의 개수가 5인 카드가 한 장이라도 있는 경우
                            p1DeckNum = p1DeckNum+p1FrontNum+p2FrontNum;
                            p1deckNumText.setText(""+p1DeckNum);
                            //플레이어 1의 덱에 앞에 낸 카드의 수만큼 추가
                            p1FrontNum=0;
                            p2FrontNum=0;
                            p1fruitKind = -1;
                            p1fruitNum = -1;
                            p2fruitKind = -1;
                            p2fruitNum = -1;
                            p1frontWhite.setVisible(false);
                            p2frontWhite.setVisible(false);
                            for (int i = 0; i < 4; i++) {
                                for (int j = 0; j < 5; j++) {
                                    p1Fruits[i][j].setVisible(false);
                                    p2Fruits[i][j].setVisible(false);
                                }
                            }
                            //앞에 낸 카드들 상태 초기화
                        }
                        else {  //두 카드 모두 그려진 과일의 개수가 5가 아닌 경우
                            p1DeckNum-=1;
                            p2DeckNum+=1;
                            p1deckNumText.setText(""+p1DeckNum);
                            p2deckNumText.setText(""+p2DeckNum);
                        }
                    }
                }
            }
            else if (event.getCode() == KeyCode.H) {  // 플레이어 2 종치기 키
                System.out.println("H key was pressed in Controller!");
                if((pTurn==1||pTurn==2) && !(p1fruitKind == -1)) {
                    hitImg.setVisible(true);
                    pTurn = 2;  //맞게 쳤든 틀리게 쳤든 종 친 사람에게 차례 돌아감
                    System.out.println("p1FrontNum is "+p1FrontNum+" and p1fruitKind is "+p1fruitKind + " and p1fruitNum is "+p1fruitNum);
                    System.out.println("p2FrontNum is "+p2FrontNum+" and p2fruitKind is "+p2fruitKind + " and p2fruitNum is "+p2fruitNum);

                    if(p1FrontNum!=0 && p2FrontNum!=0) {  //플레이어 두명 모두 앞에 낸 카드가 있는 경우
                        if(p1fruitKind==p2fruitKind) {  //앞에 낸 두 카드의 과일 종류가 같은 경우
                            if((p1fruitNum+p2fruitNum)==5) {  //두 카드에 그려진 과일의 개수가 5인 경우
                                p2DeckNum = p2DeckNum+p1FrontNum+p2FrontNum;
                                p2deckNumText.setText(""+p2DeckNum);
                                //플레이어 2의 덱에 앞에 낸 카드의 수만큼 추가
                                p1FrontNum=0;
                                p2FrontNum=0;
                                p1fruitKind = -1;
                                p1fruitNum = -1;
                                p2fruitKind = -1;
                                p2fruitNum = -1;
                                p1frontWhite.setVisible(false);
                                p2frontWhite.setVisible(false);
                                for (int i = 0; i < 4; i++) {
                                    for (int j = 0; j < 5; j++) {
                                        p1Fruits[i][j].setVisible(false);
                                        p2Fruits[i][j].setVisible(false);
                                    }
                                }
                                //앞에 낸 카드들 상태 초기화
                            }
                            else {  //두 카드에 그려진 과일의 개수의 합이 5가 아닌 경우
                                p1DeckNum+=1;
                                p2DeckNum-=1;
                                p1deckNumText.setText(""+p1DeckNum);
                                p2deckNumText.setText(""+p2DeckNum);
                            }
                        }
                        else{  //앞에 낸 두 카드의 과일 종류가 다른 경우
                            if(!(p1fruitNum==5) && !(p2fruitNum==5)){  //두 카드 모두 그려진 과일의 개수가 5가 아닌 경우
                                p1DeckNum+=1;
                                p2DeckNum-=1;
                                p1deckNumText.setText(""+p1DeckNum);
                                p2deckNumText.setText(""+p2DeckNum);
                            }
                            else {  //과일의 개수가 5인 카드가 한 장이라도 있는 경우
                                p2DeckNum = p2DeckNum+p1FrontNum+p2FrontNum;
                                p2deckNumText.setText(""+p2DeckNum);
                                //플레이어 2의 덱에 앞에 낸 카드의 수만큼 추가
                                p1FrontNum=0;
                                p2FrontNum=0;
                                p1fruitKind = -1;
                                p1fruitNum = -1;
                                p2fruitKind = -1;
                                p2fruitNum = -1;
                                p1frontWhite.setVisible(false);
                                p2frontWhite.setVisible(false);
                                for (int i = 0; i < 4; i++) {
                                    for (int j = 0; j < 5; j++) {
                                        p1Fruits[i][j].setVisible(false);
                                        p2Fruits[i][j].setVisible(false);
                                    }
                                }
                                //앞에 낸 카드들 상태 초기화
                            }
                        }
                    }
                    else if(p1FrontNum!=0 || p2FrontNum!=0){  //플레이어 둘 중 한명만 카드를 낸 경우
                        if(p1fruitNum==5 || p2fruitNum==5) {  //과일의 개수가 5인 카드가 한 장이라도 있는 경우
                            p2DeckNum = p2DeckNum+p1FrontNum+p2FrontNum;
                            p2deckNumText.setText(""+p2DeckNum);
                            //플레이어 2의 덱에 앞에 낸 카드의 수만큼 추가
                            p1FrontNum=0;
                            p2FrontNum=0;
                            p1fruitKind = -1;
                            p1fruitNum = -1;
                            p2fruitKind = -1;
                            p2fruitNum = -1;
                            p1frontWhite.setVisible(false);
                            p2frontWhite.setVisible(false);
                            for (int i = 0; i < 4; i++) {
                                for (int j = 0; j < 5; j++) {
                                    p1Fruits[i][j].setVisible(false);
                                    p2Fruits[i][j].setVisible(false);
                                }
                            }
                            //앞에 낸 카드들 상태 초기화
                        }
                        else {  //두 카드 모두 그려진 과일의 개수가 5가 아닌 경우
                            p1DeckNum+=1;
                            p2DeckNum-=1;
                            p1deckNumText.setText(""+p1DeckNum);
                            p2deckNumText.setText(""+p2DeckNum);
                        }
                    }
                }
            }
        });

        root.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.A) {  // 플레이어 1 카드 키
                System.out.println("A key was released in Controller, and player " + pTurn + "'s turn!");

                if (pTurn==1) {
                    if(p1fruitNum == 1){
                        p1Fruits[p1fruitKind][2].setVisible(true);
                    }
                    else if(p1fruitNum == 2){
                        p1Fruits[p1fruitKind][0].setVisible(true);
                        p1Fruits[p1fruitKind][4].setVisible(true);
                    }
                    else if(p1fruitNum == 3){
                        p1Fruits[p1fruitKind][0].setVisible(true);
                        p1Fruits[p1fruitKind][2].setVisible(true);
                        p1Fruits[p1fruitKind][4].setVisible(true);
                    }
                    else if(p1fruitNum == 4){
                        p1Fruits[p1fruitKind][0].setVisible(true);
                        p1Fruits[p1fruitKind][1].setVisible(true);
                        p1Fruits[p1fruitKind][3].setVisible(true);
                        p1Fruits[p1fruitKind][4].setVisible(true);
                    }
                    else {
                        for (int i = 0; i < 5; i++) {
                            p1Fruits[p1fruitKind][i].setVisible(true);
                        }
                    }
                    p1DeckNum-=1;
                    p1deckNumText.setText(""+p1DeckNum);
                    p1FrontNum+=1;
                    System.out.println("p1FrontNum = "+p1FrontNum);
                    pTurn = 2;
                    p1frontBack.setVisible(false);
                }
                if(p1DeckNum==0){
                    pTurn = -1;
                    p1deckImg.setVisible(false);
                    restartText.setVisible(true);

                    if (p2DeckNum==1) {
                        winnerText.setText("Draw!");
                    }
                    else {
                        p2Score+=1;
                        winnerText.setText("Player 2 wins!");
                    }

                    winnerText.setVisible(true);
                    scoreText.setText(p1Score+" : "+p2Score);
                }  //플레이어 1의 카드덱 수가 0이 되는 승부의 경우
                if(p2DeckNum==0){
                    pTurn = -1;
                    p2deckImg.setVisible(false);
                    restartText.setVisible(true);

                    p1Score+=1;
                    winnerText.setText("Player 1 wins!");

                    winnerText.setVisible(true);
                    scoreText.setText(p1Score+" : "+p2Score);
                }  //플레이어 2의 카드덱 수가 0이 되는 승부의 경우
            }

            else if (event.getCode() == KeyCode.L) {  // 플레이어 2 카드 키
                System.out.println("L key was released in Controller, and player" + pTurn + "'s !");
                if(pTurn==2) {
                    if(p2fruitNum == 1){
                        p2Fruits[p2fruitKind][2].setVisible(true);
                    }
                    else if(p2fruitNum == 2){
                        p2Fruits[p2fruitKind][0].setVisible(true);
                        p2Fruits[p2fruitKind][4].setVisible(true);
                    }
                    else if(p2fruitNum == 3){
                        p2Fruits[p2fruitKind][0].setVisible(true);
                        p2Fruits[p2fruitKind][2].setVisible(true);
                        p2Fruits[p2fruitKind][4].setVisible(true);
                    }
                    else if(p2fruitNum == 4){
                        p2Fruits[p2fruitKind][0].setVisible(true);
                        p2Fruits[p2fruitKind][1].setVisible(true);
                        p2Fruits[p2fruitKind][3].setVisible(true);
                        p2Fruits[p2fruitKind][4].setVisible(true);
                    }
                    else {
                        for (int i = 0; i < 5; i++) {
                            p2Fruits[p2fruitKind][i].setVisible(true);
                        }
                    }
                    p2DeckNum-=1;
                    p2deckNumText.setText(""+p2DeckNum);
                    p2FrontNum+=1;
                    System.out.println("p2FrontNum = "+p2FrontNum);
                    pTurn = 1;
                    p2frontBack.setVisible(false);
                }
                if(p1DeckNum==0){
                    pTurn = -1;
                    p1deckImg.setVisible(false);
                    restartText.setVisible(true);

                    if (p2DeckNum==1) {
                        winnerText.setText("Draw!");
                    }
                    else {
                        p2Score+=1;
                        winnerText.setText("Player 2 wins!");
                    }

                    winnerText.setVisible(true);
                    scoreText.setText(p1Score+" : "+p2Score);
                }  //플레이어 1의 카드덱 수가 0이 되는 승부의 경우
                if(p2DeckNum==0){
                    pTurn = -1;
                    p2deckImg.setVisible(false);
                    restartText.setVisible(true);

                    p1Score+=1;
                    winnerText.setText("Player 1 wins!");

                    winnerText.setVisible(true);
                    scoreText.setText(p1Score+" : "+p2Score);
                }  //플레이어 2의 카드덱 수가 0이 되는 승부의 경우
            }

            else if (event.getCode() == KeyCode.F) {  // 플레이어 1 종치기 키
                System.out.println("F key was released in Controller!");
                if(pTurn==1||pTurn==2) {
                    hitImg.setVisible(false);
                }
                if(p1DeckNum==0){
                    pTurn = -1;
                    p1deckImg.setVisible(false);
                    restartText.setVisible(true);

                    if (p2DeckNum==1) {
                        winnerText.setText("Draw!");
                    }
                    else {
                        p2Score+=1;
                        winnerText.setText("Player 2 wins!");
                    }

                    winnerText.setVisible(true);
                    scoreText.setText(p1Score+" : "+p2Score);
                }  //플레이어 1의 카드덱 수가 0이 되는 승부의 경우
                if(p2DeckNum==0){
                    pTurn = -1;
                    p2deckImg.setVisible(false);
                    restartText.setVisible(true);

                    p1Score+=1;
                    winnerText.setText("Player 1 wins!");

                    winnerText.setVisible(true);
                    scoreText.setText(p1Score+" : "+p2Score);
                }  //플레이어 2의 카드덱 수가 0이 되는 승부의 경우
            }

            else if (event.getCode() == KeyCode.H) {  // 플레이어 2 종치기 키
                System.out.println("H key was released in Controller!");
                if(pTurn==1||pTurn==2) {
                    hitImg.setVisible(false);
                }
                if(p1DeckNum==0){
                    pTurn = -1;
                    p1deckImg.setVisible(false);
                    restartText.setVisible(true);

                    if (p2DeckNum==1) {
                        winnerText.setText("Draw!");
                    }
                    else {
                        p2Score+=1;
                        winnerText.setText("Player 2 wins!");
                    }

                    winnerText.setVisible(true);
                    scoreText.setText(p1Score+" : "+p2Score);
                }  //플레이어 1의 카드덱 수가 0이 되는 승부의 경우
                if(p2DeckNum==0){
                    pTurn = -1;
                    p2deckImg.setVisible(false);
                    restartText.setVisible(true);

                    p1Score+=1;
                    winnerText.setText("Player 1 wins!");

                    winnerText.setVisible(true);
                    scoreText.setText(p1Score+" : "+p2Score);
                }  //플레이어 2의 카드덱 수가 0이 되는 승부의 경우
            }
        });

        // 포커스를 AnchorPane root로 주어서 키 입력을 받을 수 있도록 함
        Platform.runLater(() -> {
            root.requestFocus();  // Scene이 렌더링된 후 포커스를 요청
        });
        // 추가적으로 FocusTraversable을 명시적으로 설정 (기본값이 true이지만, 안전을 위해 설정)
        root.setFocusTraversable(true);
    }

    @FXML
    void restartClicked(MouseEvent event) {
        p1DeckNum = 28;  //p1의 남은 카드 수
        p2DeckNum = 28;  //p2의 남은 카드 수

        p1FrontNum = 0;  //p1이 낸 카드 수
        p2FrontNum = 0;  //p2가 낸 카드 수

        p1fruitKind = -1;  // 0=banana, 1=lime, 2=plum, 3=straw
        p1fruitNum = -1;
        p2fruitKind = -1;  // 0=banana, 1=lime, 2=plum, 3=straw
        p2fruitNum = -1;

        pTurn = 1;

        p1frontBack.setVisible(false);
        p1frontWhite.setVisible(false);
        p2frontBack.setVisible(false);
        p2frontWhite.setVisible(false);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                p1Fruits[i][j].setVisible(false);
                p2Fruits[i][j].setVisible(false);
            }
        }

        p1deckImg.setVisible(true);
        p2deckImg.setVisible(true);

        winnerText.setVisible(false);
        restartText.setVisible(false);
        p1deckNumText.setText(""+p1DeckNum);
        p2deckNumText.setText(""+p2DeckNum);
    }

    @FXML
    void backToMenuText(MouseEvent event) throws IOException {
        FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("halligalliMenu.fxml"));
        Scene menu_scene = new Scene(menuLoader.load(), 1200, 850); //로그인 화면
        Stage stage = (Stage) scoreText.getScene().getWindow();  // 현재 버튼의 Scene에서 Stage를 가져옵니다.
        stage.setTitle("Halli Galli");
        stage.setScene(menu_scene);
    }

}
