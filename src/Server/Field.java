package Server;

import Client.Card;
import Client.User;
import java.util.ArrayList;
import java.util.Random;

public class Field {
    private ArrayList<User> players = new ArrayList<>();
    TableCards tableCards;

    public void addPlayers(User player){
        players.add(player);
    }

    public void deletePlayer(User player){
        players.remove(player);
    }

    public byte loopTransactionMove(byte iterator){
        return iterator = 0;
    }

    public boolean AreThereCards(User user){
        if (user.countCards() == 0){
            return false;
        } else {
            return true;
        }
    }


    public void tableCards(){
        Random random = new Random();
        int res = random.nextInt(3 - 1 + 1) + 1;
        switch (res){
            case 1: tableCards = TableCards.QUEEN_TABLE;
            case 2: tableCards = TableCards.KING_TABLE;
            case 3: tableCards = TableCards.ACE_TABLE;
            default: tableCards = TableCards.KING_TABLE;
        }
    }


    public TableCards getTableCards() {
        return tableCards;
    }

    public void showLayOutsCard(ArrayList<Card> layOutCards, User user){
        switch (tableCards){
            case ACE_TABLE -> System.out.println("Player " + user.getName() + " lay out " + layOutCards.size() + " ace's");
            case KING_TABLE -> System.out.println("Player " + user.getName() + " lay out " + layOutCards.size() + " king's");
            case QUEEN_TABLE -> System.out.println("Player " + user.getName() + " lay out " + layOutCards.size() + " queen's");
        }
    }

}
