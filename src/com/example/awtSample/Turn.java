package com.example.awtSample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Turn {
    Player curPlayer;
    String turnSuit;
    String mainSuit;

    public Turn(Player curPlayer, String mainSuit) {
        this.curPlayer = curPlayer;
        this.turnSuit = null;
        this.mainSuit = mainSuit;
    }

    public Player play() {
        Player winner = null;
        Card winCard = new Card(0, null);
        Card curCard;
        for(int i = 0; i < 4; i++) {
            if(turnSuit == null) {
                curCard = curPlayer.playCard(null);
                turnSuit = curCard.getSuit();
                winCard = curCard;
                winner = curPlayer;
            } else {
                curCard = curPlayer.playCard(turnSuit);
                if (curCard.compareTo(winCard, mainSuit, turnSuit) == 1) {
                    winCard = curCard;
                    winner = curPlayer;
                }
                System.out.println("Current win card is: " + winCard.getSuit() + winCard.getValue());
                System.out.println("Current winnder is: " + winner.getName());
            }

            curPlayer = curPlayer.next;
        }



        return winner;
    }
}
