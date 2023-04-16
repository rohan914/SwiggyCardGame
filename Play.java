package CardGame;

import java.util.ArrayList;
import java.util.Scanner;

public class Play {
    Scanner sc=new Scanner(System.in);
    ArrayList<Player> players=new ArrayList<>();
    ArrayList<Card> deck;
    ArrayList<Card> discarded=new ArrayList<>();

    public void startGame() throws Exception {
        deck=new ArrayList<>();
        deck=new Deck().getDeck();
        System.out.println("Enter number of players: ");
        int n=sc.nextInt();
        addPlayers(n);
        System.out.println(players.size());
        distributeCards();

        int turn=0;
        discarded.add(deck.get(0));
        deck.remove(0);
        while(true){
            if(deck.size()==0){
                check();
                return;
            }
            turn=turn%n;
            System.out.println("Player "+(turn+1)+"'s turn");
            Player p=players.get(turn);
            Card c=discarded.get(discarded.size()-1);
            int match=0;
            System.out.println("Card on top is "+c.cardNumber+ " of "+c.suit);
            for (int i=0;i<p.cards.size();i++){
                if(p.cards.get(i).suit==c.suit || p.cards.get(i).cardNumber == c.cardNumber) {
                    discarded.add(p.cards.get(i));
                    System.out.println("Player "+(turn+1)+ " plays "+p.cards.get(i).cardNumber+" of "+ p.cards.get(i).suit);
                    p.cards.remove(i);
                    match = 1;
                    break;
                }
            }
            if(p.cards.size()==0){
                System.out.println("Player "+(turn+1)+" has won the game");
                return;
            }
            if(match==0){
                p.addCard(deck.get(deck.size()-1));
                deck.remove(deck.size()-1);
                System.out.println("Player "+(turn +1 )+" has no matching card so he takes one from the deck");
            }
            turn++;
        }
    }
    public void check(){

            int ind=-1,max=0;
            for(int i=0;i<players.size();i++){
                if(players.get(i).cards.size() > max){
                    max=players.get(i).cards.size();
                    ind=i;
                }
            }
            System.out.println("Player "+(ind+1) + " has won the game as there are no more cards left in the deck");

    }
    public void addPlayers(int n) throws Exception{
        if(n<2 || n>4){
            throw new Exception("Invalid player count");
        }
        for(int i=1;i<=n;i++)
            players.add(new Player(i));
    }

    public void distributeCards(){
        for (int i=0;i<players.size();i++){
            Player p=players.get(i);
            p.cards=new ArrayList<Card>();
            for (int j=0;j<5;j++){
                p.addCard(deck.get(deck.size()-1));
                deck.remove(deck.size()-1);
            }
        }
    }
}
