package CardGame;

public class Card {
    int cardNumber;
    Suits suit;

    public Card(int cardNumber, Suits suit) {
        this.cardNumber = cardNumber;
        this.suit = suit;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Suits getSuit() {
        return suit;
    }

    public void setSuit(Suits suit) {
        this.suit = suit;
    }
}
