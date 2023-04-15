package CardGame;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    ArrayList<Card> deck;
    public Deck(){
        this.deck=new ArrayList<Card>();
        for (Suits suits : Suits.values()){
            for (int i=1;i<=13;i++){
                deck.add(new Card(i,suits));
            }
        }

        Collections.shuffle(deck);
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }
}
