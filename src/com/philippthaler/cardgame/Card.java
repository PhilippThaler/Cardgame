package com.philippthaler.cardgame;

import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Random;

/**
 * Card
 */
public class Card extends Pane {

    public static final int NUMOFCARDS = 52;
    private static final String[] ranks = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Jack", "Queen", "King"};
    private static final String[] suits = {"Spades", "Hearts", "Diamond", "Clubs"};
    // A Pair object, that saves the indices of the cards already shown
    private static ArrayList<Pair<Integer, Integer>> alreadyUsed;
    private static Image cardSheet = new Image("images/playingCards.png");
    private final int COLUMNS = ranks.length;
    private final int ROWS = suits.length;
    private int rank;
    private int suit;
    private ImageView card;

    public Card() {
        this(cardSheet);
    }

    public Card(Image cardSheet) {
        setPadding(new Insets(5));
        card = new ImageView(cardSheet);
        setRandCard();
        getChildren().add(card);
    }

    public Card(int ranks, int columns) {
        this(ranks, columns, cardSheet);
    }

    public Card(int ranks, int columns, Image cardSheet) {
        setPadding(new Insets(10));
        Card.cardSheet = cardSheet;
        card = new ImageView(cardSheet);
        setCard(ranks, columns);
        getChildren().add(card);
    }

    public static Image getCardSheet() {
        return cardSheet;
    }

    public static void setCardSheet(Image cardSheet) {
        Card.cardSheet = cardSheet;

    }

    public static String getText(int rank, int suit) {
        return ranks[rank] + " of " + suits[suit];
    }

    public void setRandCard() {
        double width = cardSheet.getWidth() / COLUMNS;
        double height = cardSheet.getHeight() / ROWS;

        Random rand = new Random();
        rank = rand.nextInt(COLUMNS);
        suit = rand.nextInt(ROWS);
        card.setViewport(new Rectangle2D(rank * width, suit * height, width, height));
    }

    public void setCard(int ranks, int columns) {
        double width = cardSheet.getWidth() / COLUMNS;
        double height = cardSheet.getHeight() / ROWS;

        rank = ranks;
        suit = columns;

        card.setViewport(new Rectangle2D(rank * width, suit * height, width, height));
    }

    public String getText() {
        return ranks[rank] + " of " + suits[suit];
    }

}