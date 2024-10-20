package Client;

import java.util.*;

public class User {
    private String name;
    private ArrayList<Card> UserCards;

    public User(String name){
        UserCards = new ArrayList<>();
        this.name = name;
    }

    public void seeCards(){

        System.out.println("Your cards: ");
        for (Card suit : UserCards){
            System.out.print(suit.getSuit().toString());
        }
        System.out.println();
        for (Card rank : UserCards){
            System.out.print(rank.getRank().toString());
        }
        for (int i = 0; i < UserCards.size(); i++){
            int r = i;
            System.out.print(++r);
        }
    }



    public ArrayList<Card> chooseCard(){
        Scanner in = new Scanner(System.in);
        ArrayList<Card> choosenCards = new ArrayList<>();
        TreeSet<Integer> choosen = new TreeSet<>();
        int choose;
        boolean r = true;

        while (r == true){
            System.out.println("Select the card number you want to send");
            choose = in.nextInt();
            choosen.add(choose);
            choosenCards.add(UserCards.get(--choose));
            System.out.println("Choosen card : ");
            for (int num : choosen) System.out.print(num + " ");
            System.out.println();
            System.out.println();
            System.out.println("1 - remove last choose");
            System.out.println("2 - Lay out the selected cards");
            System.out.println("Any - choose next");
            byte remove = in.nextByte();
            switch (remove){
                case 1: choosenCards.removeLast();
                        choosen.removeLast();
                        if (!choosenCards.isEmpty()){
                            System.out.println("Lay out the selected cards?");
                            System.out.println("1 - yes");
                            remove = in.nextByte();
                            if (remove == 1){
                                r = false;
                            }
                        }
                        break;
                case 2: r = false;
                        break;
                default: break;
            }
        }

        return choosenCards;
    }

    public String getName() {
        return name;
    }

    public void remove_card (int index){
        UserCards.remove(index);
    }

    public void addCard (Card card){
        UserCards.add(card);
    }

    public Card getCard(int index){
        return UserCards.get(index);
    }
}
