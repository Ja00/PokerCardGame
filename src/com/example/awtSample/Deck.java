package com.example.awtSample;

//import java.util.HashSet;
import java.util.*;

public class Deck {
    List<Card> deck = new ArrayList<>();

    String[] suits = {"HEART", "SPADE", "CLUB", "DIAMOND"};


    public void addCards() {
        for(String suit : suits) {
            for(int i = 1; i <= 13; i++) {
                deck.add(new Card(i, suit));
            }
        }
    }

    public void printCardsInDeck() {
        for(Card card : deck) {
            System.out.println(card);
        }
    }

    public Card draw() {
        int rnd = new Random().nextInt(deck.size());
        Card getCard = deck.get(rnd);
        deck.remove(rnd);
        return getCard;
    }

}
