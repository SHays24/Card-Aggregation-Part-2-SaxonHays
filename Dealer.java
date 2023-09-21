public class Dealer extends Player {
  int Score;
  Dealer (String name) {
    super(name);
  }
  void play (int playnum) {
    switch (playnum){
      case 1: 
        System.out.print("Hand: " + this.getHand().getCards(1));
        System.out.println("🂠");
        break;

      case 2:
        this.Score = this.getHand().getScore(this.getHand().getCardCount());
        if (this.Score <= 16) {
          this.Score = this.getHand().getScore(this.getHand().getCardCount());
          System.out.println(Main.dealerTag);
          System.out.println("Hand: " + this.getHand().getCards(this.getHand().getCardCount()));
          System.out.println("score: " + this.Score);
          this.hitMe();
          this.Score = this.getHand().getScore(this.getHand().getCardCount());
          System.out.println("Hand: " + this.getHand().getCards(this.getHand().getCardCount()));
          System.out.println("score: " + this.Score);
        }
        this.Score = this.getHand().getScore(this.getHand().getCardCount());
        if (this.Score >= 17) {
          this.Score = this.getHand().getScore(this.getHand().getCardCount());
          System.out.println(Main.dealerTag);
          System.out.println("Hand: " + this.getHand().getCards(this.getHand().getCardCount()));
          System.out.println("score: " + this.Score);
          this.setInactive();
        }
        
        break;

    }
  }
  void setActive() {
    this.active = true;
  }
  public void hitMe() {
    if (this.hand.getScore(this.getHandSize())==21) {
      Main.setWinner(this.Name);
    }
    else if (this.hand.getScore(this.getHandSize()) > 21) {
      this.active = false;
    }
    this.hand.addCard(deck.dealCard());
    this.play(2);
  }
}