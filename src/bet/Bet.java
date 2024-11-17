package bet;

import java.util.List;

public abstract sealed class Bet permits BasketballBet, FootballBet {
    // The name of the game. We assume that the name is unique.
    private final String game;
    // The odd of the bet. We assume the same odd, regardless of which team will win
    private final double odd;
    // The available choices of the bet
    private final List<String> choices;
    // The outcome of the bet
    private String outcome;

    public Bet(String game, double odd, List<String> choices) {
        this.game = game;
        this.odd = odd;
        this.choices = choices;
        this.outcome = "";
    }

    // Returns the name of the game
    public String getGame() {
        return game;
    }

    // Returns the odd of the bet
    public double getOdd() {
        return odd;
    }

    // Returns the outcome of the bet
    public String getOutcome() {
        return outcome;
    }

    // Sets the outcome of the bet
    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    // Returns the available choices of the bet
    public List<String> getChoices() {
        return choices;
    }
}
