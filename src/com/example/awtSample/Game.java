package com.example.awtSample;

import java.util.*;

public class Game {
    private String mainSuit = "Unknown";
    private final int rank;
//    private LinkedList<Player> players;
    private int playerNum = 0;
    private Scanner scanner = new Scanner(System.in);
    private Player headPlayer = new Player("HEAD");
    private Player curPlayer = headPlayer;
    private Player startPlayer = null;
    private Team t1 = new Team();
    private Team t2 = new Team();
    private boolean f;

    public Game(int rank) {
        this.rank = rank;
//        players = new LinkedList<>();
    }

    public void playerJoin(Player newPlayer) {
//        players.add(newPlayer);
        curPlayer.next = newPlayer;
        curPlayer = newPlayer;
        System.out.println("Player " + newPlayer.getName() + " join!");
        playerNum++;
        //divide players into 2 teams
        if(f) {
            t1.getMembers().add(curPlayer.getName());
            curPlayer.setTeam(t1);
            System.out.println("Team 1 add: " + curPlayer.getName() );
        } else {
            t2.getMembers().add(curPlayer.getName());
            curPlayer.setTeam(t2);
            System.out.println("Team 2 add: " + curPlayer.getName() );

        }
        f = !f;
    }

//    public LinkedList<Player> getPlayers() {
//        return players;
//    }

    public String getMainSuit() {
        return mainSuit;
    }

    public int getRank() {
        return rank;
    }

    public void waitForPlayer() {
        System.out.println("waiting for player....");
        String playerName = scanner.nextLine();
        playerJoin(new Player(playerName));
    }


    public void startGame() {
        while(playerNum < 4) {
            waitForPlayer();
        }
        curPlayer.next = headPlayer.next;

        //All players are ready now, we need a circle. THAT'S WHY I THINK ABOUT LINKEDLIST RATHER THAN ARRAYLIST.

        //prepare the deck
        Deck deck = new Deck();
        deck.addCards();
        System.out.println("Deck is ready!");


        System.out.println("Game gonna start!");
        //Players draw cards
        curPlayer = headPlayer.next;
        for(int i = 0; i < 13; i++) {
            for(int j = 0; j < 4; j++) {
                curPlayer.drawCard(deck);
                curPlayer = curPlayer.next;
            }
        }

        //print hands
        curPlayer = headPlayer.next;
        for(int i = 0; i < 4; i++) {
            curPlayer.printHand();
            curPlayer = curPlayer.next;
        }

        //Game logic starts from here.


        //get MAIN-SUIT
        curPlayer = headPlayer.next;
        for(int i = 0; i < 4; i++) {
            if(mainSuit.equals("Unknown")) {
                System.out.println(curPlayer.getName() + ", do you want to be the main?");
                String choice = scanner.nextLine();
                if (choice.toLowerCase().equals("yes")) {
                    setMainSuit(curPlayer.showMain(rank));
                    startPlayer = curPlayer;
                    startPlayer.next.getTeam().setScoreTeam(true);
                }
            }
            curPlayer = curPlayer.next;
        }

        System.out.println("Finally, the main suit is " + mainSuit);
        curPlayer = startPlayer;
        //When the whole logic is ready, add the while loop.
        while(curPlayer.getHand().size() > 0) {
//        int i = 0;
//        while(i < 2){
            System.out.println(curPlayer.getName() + " GO FIRST!");
            Turn newTurn = new Turn(curPlayer, mainSuit);
            Player winner = newTurn.play();
            System.out.println("Winner is " + winner.getName());
            curPlayer = winner;
//            i++;
        }
    }

    public void setMainSuit(String mainSuit) {
        this.mainSuit = mainSuit;
    }
}
