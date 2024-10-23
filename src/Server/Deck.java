package Server;

import Client.Card;

import java.util.ArrayList;
import java.util.*;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"Queen", "King", "Ace"};

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }

        cards.add(new Card("Red", "Joker"));
        cards.add(new Card("Grey", "Joker"));
        cards.add(new Card("Red", "Joker"));
    }

    public Card dealCard() {
        if (!cards.isEmpty()) {
            return cards.removeFirst();
        } else {
            return null; // если карты закончились
        }
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public int getRemainingCards() {
        return cards.size();
    }
}
