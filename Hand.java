/** 
When a hand object is first created, it
has no cards in it. An addCard() instance method will add a card to the hand. This method needs a parameter of type Card to specify which card is being added. For the removeCard() method, a parameter is needed to specify which card to remove. But should we specify the
card itself (“Remove the ace of spades”), or should we specify the card by its position in the hand (“Remove the third card in the hand”)? Actually, we don’t have to decide, since we can allow for both options. We’ll have two removeCard() instance methods, one with a parameter of type Card specifying the card to be removed and one with a parameter of type int specifying the position of the card in the hand. (Remember that you can have two methods in a class with the same name, provided they have different numbers or types of parameters.) Since a hand can contain a variable number of cards, it’s convenient to be able to ask a hand object how many cards it contains. So, we need an instance method getCardCount() that returns the number of cards in the hand. When I play cards, I like to arrange the cards in my hand so that cards of the same value are next to each other. Since this is a generally useful thing to be
able to do, we can provide instance methods for sorting the cards in the hand. 

Here is a full specification for a reusable Hand class:
*/
import java.util.ArrayList;

class Hand {
    /**
  * Constructor. Create a Hand object that is initially empty.
  */
	ArrayList<Card> hand;
  public Hand()
  {
      hand = new ArrayList<Card>();
  }
  
  /**
  * Discard all cards from the hand, making the hand empty.
  */
  public void clear()
  {
    hand.clear();
  }
  
  /**
  * Add the card c to the hand. c should be non-null.
  * @throws NullPointerException if c is null.
  */
  public void addCard(Card c)
  {
    // if (c == null)
    //      throw new NullException("Can't add a null card to a hand.");
      hand.add(c);
  }
  
  /**
  * If the specified card is in the hand, it is removed.
  */
  public void removeCard(Card c)
  {
    hand.remove(c);
  }
  
  /**
  * Remove the card in the specified position from the
  * hand. Cards are numbered counting from zero.
  * @throws IllegalArgumentException if the specified
  * position does not exist in the hand.
  */
  public void removeCard(int position)
  {
    // if (position < 0 || position >= hand.size())
    //      throw new IllegalPosException("Position does not exist in hand: "
    //            + position);
      hand.remove(position);
  }
  
    /**
  * Return the number of cards in the hand.
  */
    public int getCardCount()
  {
    return hand.size();
  }
  
  /**
  * Get the card from the hand in given position, where
  * positions are numbered starting from 0.
  * @throws IllegalArgumentException if the specified
  * position does not exist in the hand.
  */
  public Card getCard(int position)
  {
    // if (position < 0 || position >= hand.size())
    //      throw new IllegalPosException("Position does not exist in hand: "
    //            + position);
       return (Card)hand.get(position);
  }
  
  /**
  * Sorts the cards in the hand so that cards of the same
  * suit are grouped together, and within a suit the cards
  * are sorted by value.
  */
  public void sortBySuit()
  {
    ArrayList newHand = new ArrayList();
    while (hand.size() > 0) {
       int pos = 0;  // Position of minimal card.
       Card c = (Card)hand.get(0);  // Minimal card.
       for (int i = 1; i < hand.size(); i++) {
          Card c1 = (Card)hand.get(i);
          if ( c1.getSuit() < c.getSuit() ||
                  (c1.getSuit() == c.getSuit() && c1.getValue() < c.getValue()) ) {
              pos = i;
              c = c1;
          }
       }
       hand.remove(pos);
       newHand.add(c);
    }
    hand = newHand;
  }
  
  /**
  * Sorts the cards in the hand so that cards are sorted into
  * order of increasing value. Cards with the same value
  * are sorted by suit. Note that aces are considered
  * to have the lowest value.
  */
  public void sortByValue()
  {
    ArrayList newHand = new ArrayList();
    while (hand.size() > 0) {
       int pos = 0;  // Position of minimal card.
       Card c = (Card)hand.get(0);  // Minimal card.
       for (int i = 1; i < hand.size(); i++) {
          Card c1 = (Card)hand.get(i);
          if ( c1.getValue() < c.getValue() ||
                  (c1.getValue() == c.getValue() && c1.getSuit() < c.getSuit()) ) {
              pos = i;
              c = c1;
          }
       }
       hand.remove(pos);
       newHand.add(c);
    }
    hand = newHand;
  }
  public int getScore(int cardNum) {
    cardNum = cardNum-1;
    if (cardNum == 0) {
      return getCard(0).getBJkValue();
    }
    else {
      return getCard(cardNum).getBJkValue() + getScore(cardNum);
    }
  }
  public String getCards(int cardNum) {
    cardNum = cardNum -1;
    if (cardNum == 0 ) {
      return String.valueOf(getCard(0).cardString());
    }
    else {
      return String.valueOf(getCard(cardNum).cardString()) + getCards(cardNum);
    }
  }
}

