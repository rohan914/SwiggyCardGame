package CardGame;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ShuffleTest {
    @Test
    public void checkShuffle(){
        ArrayList<Card> unShuffled = new ArrayList<>();
        for(Suits suits : Suits.values()){
            for(int i = 1; i <= 13; i++){
                unShuffled.add(new Card(i,suits));
            }
        }
        ArrayList<Card> shuffled = new Deck().getDeck();
        Assert.assertEquals(false,unShuffled.toString() == shuffled.toString());
    }
}
