package Client;

import java.util.*;

public class User {
    private String name;
    private ArrayList<Card> UserCards;
    private Liar liar;

    public User(String name){
        UserCards = new ArrayList<>();
        this.name = name;
    }

    public int countCards(){
        return UserCards.size();
    }

    public void died(Died died){
        if (died == Died.DIED){
            // Пользователь не может выполнять действий
        }
    }

    public void shots(byte countShots){
        System.out.println("Your shots: " + countShots + " / 6");
    }

    public Liar askLiar() throws Exception {
        while (true){
            System.out.println("Choose, previous player is liar?\n1 - Yes\n2 - No");
            byte choose = new Scanner(System.in).nextByte();
            if (choose == 1){
                this.liar = Liar.LIAR;
                return liar;
            } else if (choose == 2) {
                this.liar = Liar.NOT_LIAR;
                return liar;
            } else {
                throw new Exception("Wrong choose");
            }
        }
    }

    public void seeCards(){
        int r = 0;
        for (Card card : UserCards){
            System.out.println((++r) + " " + card.getSuit() + " " + card.getRank());
        }
    }

    public ArrayList<Card> chooseCard() throws Exception{
        Scanner in = new Scanner(System.in);
        ArrayList<Card> choosenCards = new ArrayList<>();
        TreeSet<Integer> choosen = new TreeSet<>();
        int choose;
        boolean r = true;

        while (r){
            if (choosen.size() > 4){
                break;
            }
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
                            }   else {
                                throw new Exception("Wrong choose");
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

    public ArrayList<Card> removeSelectedCards(ArrayList<Card> cards){
        for (int i = 0 ; i < cards.size(); i++){
            UserCards.remove(cards.get(i));
        }
        return cards;
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
