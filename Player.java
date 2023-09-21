public class Player {
  protected String Name;
  protected Hand hand;
  protected Deck deck;
  protected Boolean active;
  public Player(String name){
    this.Name = name;
    this.active = true;
  }
  public String getName() {
    return Name;
  }
  public Hand setupHand() {
    this.hand = new Hand();
    this.hand.addCard(this.deck.dealCard());
    this.hand.addCard(this.deck.dealCard());
    return this.hand;
  }
  public Hand getHand() {
    return this.hand;
  }
  public void setInactive() {
    this.active = false;
  }
  public void hitMe() {
    if (this.hand.getScore(this.getHandSize())==21) {
      Main.setWinner(this.Name);
    }
    else if (this.hand.getScore(this.getHandSize()) > 21) {
      this.active = false;
    }
    this.hand.addCard(deck.dealCard());
    this.play();
  }
  public int getHandSize() {
    return this.hand.getCardCount();
  }
  public void giveDeck(Deck deck) {
    this.deck = deck;
  }
  public void play() {
    System.out.println("Hand: " + this.getHand().getCards(this.getHand().getCardCount()));
    System.out.println("score: " + this.getHand().getScore(this.getHand().getCardCount()));
    if (this.hand.getScore(this.getHandSize())==21) {
      Main.setWinner(this.Name);
    }
  }
  public boolean isActive() {
    return active;
  }
  public int getScore() {
    return this.hand.getScore(this.getHandSize());
  }
}