class Main {
  private static String winner = "";
  protected static String dealerTag = "𝒅𝒆𝒂𝒍𝒆𝒓";
  protected static String playerTag = "𝓟𝓵𝓪𝔂𝓮𝓻";
  private static Player player1;
  private static Dealer dealer;
  public static void main(String[] args) {
    System.out.println("Welcome to Black Jack!");
    Deck deck = new Deck(false);
    player1 = new Player("player1");
    dealer = new Dealer("dealer");
    deck.shuffle();
    player1.giveDeck(deck);
    player1.setupHand();
    dealer.giveDeck(deck);
    dealer.setupHand();
    System.out.println(playerTag);
    player1.play();
    System.out.println(dealerTag);
    //System.out.println(dealer.getHand());
    dealer.play(1);
    loop(player1, deck, dealer);
  }
  public static void loop(Player player, Deck deck, Dealer dealer  ) {
    java.util.Scanner kitScanner = new java.util.Scanner(System.in);
    while (winner == ""){
      checkForWinner();
      if (kitScanner.hasNext() && player.isActive()) {
        String cmd = kitScanner.nextLine();
        switch (cmd) {
        case "hit": 
          player.hitMe();
          if (player.getScore() > 21) {
            player.setInactive();
            dealer.setActive();
            dealer.play(2);
            checkForWinner();
          }
          break;
        case "stand": 
          player.play();
          player.setInactive();
          dealer.setActive();
          dealer.play(2);
          checkForWinner();
          break;
        }
      }
      else if (dealer.isActive()) {
        dealer.play(2);
      }
    }
    System.out.println(winner +" wins, 🎉congratulations🎉.");
  }
  public static void setWinner (String Winner) {
    winner = Winner;
  }
  public static void printScores() {
    System.out.println(playerTag);
    player1.play();
    System.out.println(dealerTag);
    dealer.play();
  }
  public static void checkForWinner() {
    if (player1.isActive() == false && dealer.isActive() == false) {
      if (player1.getScore() > dealer.getScore() && player1.getScore() <= 21) {
        setWinner("player");
      }
      else if (dealer.getScore() <= 21) {
        setWinner("dealer");
      }
      else if (player1.getScore() <= 21) {
        setWinner("player");
      }
      else {
        setWinner("no one");
      }
    }
  }
}