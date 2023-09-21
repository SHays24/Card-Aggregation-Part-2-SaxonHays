//Complete the methods for the card class 

/**
* An object of type Card represents a playing card from a
* standard Poker deck, including Jokers. The card has a suit, which
* can be spades, hearts, diamonds, clubs, or joker. A spade, heart,
* diamond, or club has one of the 13 values: ace, 2, 3, 4, 5, 6, 7,
* 8, 9, 10, jack, queen, or king. Note that "ace" is considered to be
* the smallest value. A joker can also have an associated value;
* this value can be anything and can be used to keep track of several
* different jokers.
*/

public class Card {

  public final static int SPADES = 0;
  public final static int HEARTS = 1;
  public final static int DIAMONDS = 2;
  public final static int CLUBS = 3;
  public final static int JOKER = 4;

  //non-numeric cards
  public final static int ACE = 1;
  public final static int JACK = 11;
  public final static int QUEEN = 12;
  public final static int KING = 13;
  
  private final int suit;
  private final int value;
  
  public Card() {
    //constructor with no value creates a Joker
    suit = JOKER;
    value = 1;

  }

   public Card(int theValue, int theSuit) {
    if (theSuit != SPADES && theSuit != HEARTS && theSuit != DIAMONDS && theSuit != CLUBS && theSuit != JOKER)
      throw new IllegalArgumentException("Illegal playing card suit");
    if (theSuit != JOKER && (theValue < 1 || theValue > 13))
      throw new IllegalArgumentException("Illegal playing card value");
    value = theValue;
    suit = theSuit;
  }
  public int getSuit() {
    return suit;
  }
  public int getBJkValue() {
    if (value < 11) {
      return value;
    }
    else {
      return 10;
    }
  }
  public int getValue() {
    return value;
  }
  
  public String getSuitAsString() {
    switch ( suit ) {
        case SPADES: return "Spades";
        case HEARTS: return "Hearts";
        case DIAMONDS: return "Diamonds";
        case CLUBS: return "Clubs";
        default: return "Joker";
    }
  }

  public String getValueAsString() {
    if (suit == JOKER)
      return "" + value;
    else {
      switch ( value ) {
      case 1: return "Ace";
      case 2: return "2";
      case 3: return "3";
      case 4: return "4";
      case 5: return "5";
      case 6: return "6";
      case 7: return "7";
      case 8: return "8";
      case 9: return "9";
      case 10: return "10";
      case 11: return "Jack";
      case 12: return "Queen";
      default: return "King";
      }
    }
  }
  public String toString() {
    if (suit == JOKER) {
      if (value == 1)
        return "Joker";
      else
        return "Joker #" + value;
      }
    else
      return getValueAsString() + " of " + getSuitAsString();
  }
  public char[] cardString() {
    int card;
    switch ( suit ) {
    case SPADES: card = 0x1F0A1;
    case HEARTS: card = 0x1F0B1;
    case DIAMONDS: card = 0x1F0C1;
    case CLUBS: card = 0x1F0D1;
    default: card = 0x1F0BF;
    }
    card = card + getValue()+1;
    //System.out.println(card);
    return Character.toChars(card);
  }
}