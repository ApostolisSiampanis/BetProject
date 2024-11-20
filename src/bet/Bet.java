package bet;

public abstract sealed class Bet permits BasketballBet, FootballBet {
    // The name of the game. We assume that the name is unique.
    private final String game;
    // The odd of the bet. We assume the same odd, regardless of which team will win
    private final double odd;

    // Constructor
    public Bet(String game, double odd) {
        this.game = game;
        this.odd = odd;
    }

    // Returns the name of the game
    public String getGame() {
        return game;
    }

    // Returns the odd of the bet
    public double getOdd() {
        return odd;
    }
}
