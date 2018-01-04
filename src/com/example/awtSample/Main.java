package com.example.awtSample;

public class Main {

    public static void main(String[] args) {
//	//Initialize the deck
//        Deck deck = new Deck();
//        deck.addCards();
//        deck.printCardsInDeck();
//
//        //Create players;
//        Player yongjie = new Player("Yongjie");
//        Player xiyi = new Player("Xiyi");
//        Player junlong = new Player("Junlong");
//        Player jiaming = new Player("Jiaming");
//
//        for(int i = 0; i < 13; i++) {
//            yongjie.drawCard(deck);
//            xiyi.drawCard(deck);
//            junlong.drawCard(deck);
//            jiaming.drawCard(deck);
//        }
//
//        yongjie.printHand();
//        xiyi.printHand();
//        junlong.printHand();
//        jiaming.printHand();
//
//        //Game
//        while(yongjie.getHand().size() > 0) {
//            yongjie.playCard();
//            xiyi.playCard();
//            junlong.playCard();
//            jiaming.playCard();
//        }
////        yongjie.playCard();
////        yongjie.printHand();
////        deck.printCardsInDeck();

        Game newGame = new Game(2);
        newGame.startGame();

    }
}
