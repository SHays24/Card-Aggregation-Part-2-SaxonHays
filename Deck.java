/*
First, we’ll design the deck class in detail. When a deck of cards is first created, it contains 52 cards in some standard order. The Deck class will need a constructor to create a new deck. 
The constructor needs no parameters because any new deck is the same as any other. There will be an instance method called shuffle() that will rearrange the 52 cards into a random order.
The dealCard() instance method will get the next card from the deck. This will be a function with a return type of Card, since the caller needs to know what card is being dealt. It has no parameters—when you deal the next card from the deck, you don’t provide any information to the deck; you just get the next card, whatever it is. What will happen if there are no more cards in the deck when its dealCard() method is called? It should probably be considered an error to try to deal a card from an empty deck, so the deck can throw an exception in that case.
But this raises another question: How will the rest of the program know whether the deck is empty? Of course, the program could keep track of how many cards it has used. But the deck itself should know how many cards it has left, so the program should just be able to ask the deck object. We can make this possible by specifying another instance method, cardsLeft(), that returns the number of cards remaining in the deck. This leads to a full specification of all the subroutines in the Deck class:
Constructor and instance methods in class Deck:
*/


class Deck {
  /**
    * An array of 52 or 54 cards.  A 54-card deck contains two Jokers,
    * in addition to the 52 cards of a regular poker deck.
    */
   private Card[] deck;
   
   /**
    * Keeps track of the number of cards that have been dealt from
    * the deck so far.
    */
   private int cardsUsed;
    
 /**
    * Constructs a poker deck of playing cards, The deck contains
    * the usual 52 cards and can optionally contain two Jokers
    * in addition, for a total of 54 cards.   Initially the cards
    * are in a sorted order.  The shuffle() method can be called to
    * randomize the order.
    * @param includeJokers if true, two Jokers are included in the deck; if false,
    * there are no Jokers in the deck.
    */
   public Deck(boolean includeJokers) {
      if (includeJokers)
         deck = new Card[54];
      else
         deck = new Card[52];
      int cardCount = 0; // How many cards have been created so far.
      for ( int suit = 0; suit <= 3; suit++ ) {
         for ( int value = 1; value <= 13; value++ ) {
            deck[cardCount] = new Card(value,suit);
            cardCount = cardCount+1;
         }
      }
      if (includeJokers) {
         deck[52] = new Card(1,Card.JOKER);
         deck[53] = new Card(2,Card.JOKER);
      }
      cardsUsed = 0;
   }
  
  /**
  * Put all the used cards back into the deck,
  * and shuffle it into a random order.
  */
  public void shuffle()
    {
      for ( int i = deck.length-1; i > 0; i-- ) {
         int rand = (int)(Math.random()*(deck.length));
         Card temp = deck[i];
         deck[i] = deck[rand];
         deck[rand] = temp;
      }
      cardsUsed = 0;
   }

  /**
  * As cards are dealt from the deck, the number of
  * cards left decreases. This function returns the
  * number of cards that are still left in the deck.
  */
  public int cardsLeft() {
      return deck.length - cardsUsed;
   }
  /**
  * Deals one card from the deck and returns it.
  * @throws IllegalStateException if no more cards are left.
  */
  public Card dealCard() {
    // if (cardsUsed == deck.length)
    //    throw new IllegalStateException("No cards are left in the deck.");
    cardsUsed++;
    return deck[cardsUsed - 1];
    // Programming note:  Cards are not literally removed from the array
    // that represents the deck.  We just keep track of how many cards
    // have been used.
 }
}
