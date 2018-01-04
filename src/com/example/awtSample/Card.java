package com.example.awtSample;

public class Card implements Comparable<Card> {
    private int value;
    private String suit;

    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    @Override
    public int compareTo(Card o) {
        if(o.getValue() > this.value) {
            return -1;
        } else if (o.getValue() < this.value) {
            return 1;
        } else {
            return 0;
        }
    }

    public int compareTo(Card card, String mainSuit, String turnSuit) {
        if(card.getSuit() == null) {
            return 1;
        }
        if(card.getSuit().equals(this.suit)) {
            return this.compareTo(card);
        } else {
            if(this.getSuit().equals(mainSuit)) {
                return 1;
            } else if (this.getSuit().equals(turnSuit) && !card.getSuit().equals(turnSuit) && !card.getSuit().equals(mainSuit)) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return suit + value;
    }
}


