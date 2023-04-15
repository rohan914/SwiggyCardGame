package CardGame;

import java.util.ArrayList;

public class Player {
    int id;
    ArrayList<Card> cards;

    public int getId() {
        return id;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Player(int id) {
        this.id = id;
    }

    public void addCard(Card card){
        cards.add(card);
    }
    public void remove(Card card) {
        cards.remove(card);
    }
}
