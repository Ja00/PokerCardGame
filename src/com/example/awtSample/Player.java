package com.example.awtSample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Player {
    public Player next;
    private String name;
    private List<Card> hand;
    private Scanner scanner = new Scanner(System.in);
    public Team team;

    public void setTeam(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public Player(String name) {
        this.hand = new ArrayList<>();
        this.name = name;
    }

    public void drawCard(Deck deck) {
        hand.add(deck.draw());
    }

    public Card playCard(String curSuit) {
        System.out.println(name + "'s turn.");
        while(true) {
            printHand();
            System.out.println("Select the card you want to play: ");
            String choice = scanner.nextLine();
            Card chosenCard = null;
            int removeIndex = -1;
            for(int i = 0; i < hand.size(); i++) {
                String curCard = hand.get(i).getSuit() + hand.get(i).getValue();
                if( curCard.equals(choice)) {
                    chosenCard = hand.get(i);
//                    hand.remove(i); //not sure can play this card yet.
                    removeIndex = i;
                    break;
                }
            }
            if(chosenCard != null) {
                if (curSuit != null) {
                    if (!hasSuit(curSuit) || chosenCard.getSuit().equals(curSuit)) {
                        System.out.println(name + " played " + choice);
                        hand.remove(removeIndex);
                        return chosenCard;
                    } else {
                        System.out.println("You have card with suit " + curSuit + ". You have to play it.");
                    }
                } else {
                    hand.remove(removeIndex);
                    return chosenCard;
                }
            } else {
                System.out.println("You don't have that card...");
            }

        }
    }

    public void printHand() {
        System.out.println("Cards on " + name + " :");
        for(Card card : hand) {
            System.out.print(card + " ");
        }
        System.out.println();
    }

    public String showMain(int rank) {
        String chosenSuit = "Unknown";
            ArrayList<String> ava = new ArrayList<>();
            for(Card card : hand) {
                if(card.getValue() == rank) {
//                    System.out.println(card.getSuit() + " is available to be main suit.");
                    ava.add(card.getSuit());
                }
            }
            if(ava.size() > 0) {
                int rnd = new Random().nextInt(ava.size());
                chosenSuit = ava.get(rnd);
//                System.out.println("randomly picked " + chosenSuit + " as main suit");
            } else {
                System.out.println("You don't have any " + rank + ", so you can't pick main suit.");
            }

        return chosenSuit;
    }

    public boolean hasSuit(String curSuit) {
        for(Card card : hand) {
            if(card.getSuit().equals(curSuit)) {
                return true;
            }
        }
        return false;
    }
}
