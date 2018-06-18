package com.philippthaler.cardgame;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

// TODO Kartensuche einfuehren, Textfeld mit karte und über kartenname ausgeben
// Vor dem Start auswählen was man genau laden will. vielleicht auch spalten und zeilenmenge einstellen
// ob man karten suchen will
// rechtsklick auf eine karte bringt ein textfeld um eine bestimmte karte mit dem namen auszusuchen
// und einen random button
// man kann alle karten anzeigen in zufälliger reihenfolge, also müssen die einzelnen indizes gespeichert werden

public class CardPane extends GridPane {

    private int numOfCards = 10;

    private Card[] cards;
    private Label[] label;

    public CardPane() {

        this("images/playingCards.png");
    }

    public CardPane(String deckPath) {
        cards = new Card[numOfCards];
        label = new Label[numOfCards];
        for (int i = 0; i < cards.length; i++) {

            for (int j = 4; j > 0; j--) {

            }
            cards[i] = new Card(new Image(deckPath));
            cards[i].setRandCard();
            label[i] = new Label(cards[i].getText());
            add(label[i], i, 0);
            add(cards[i], i, 1);
        }
    }

    public void refresh() {
        for (int i = 0; i < cards.length; i++) {
            cards[i].setRandCard();
            label[i].setText(cards[i].getText());
        }
    }


    public Card[] getCards() {
        return cards;
    }

}