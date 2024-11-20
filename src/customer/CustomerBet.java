package customer;

import bet.BasketballBet;
import bet.Bet;
import bet.FootballBet;

import java.util.List;

public final class CustomerBet {
    // The class contains the available bet types for a customer.
    // The list of available bet types is immutable.
    private static final List<String> availableBetTypes = List.of("Football", "Basketball");
    // The Bet object representing the details of the bet
    private final Bet bet;
    // The amount of the bet in euros (without decimals)
    private final int stake;
    // The player's betting choice. As mentioned above, it must be checked, depending on the type of game.
    // The available outcomes of a basketball match are, 1: The first team wins, 2: The second team wins
    // The available outcomes of a football match are, 1: The first team wins, X: Draw, 2: The second team wins
    private final String choice;
    // The payout of the bet
    private double payout;
    // The parameter "betType" is the type of the game. It can only take one of the 2 values: "Football" or "Basketball"
    // The given value of the String betType given during the simulation will be checked in the constructor of the CustomerBet class
    // and at the same time it will be checked if the choice, "choice", concerns the available options of the respective type of game.
    public CustomerBet(Bet bet, String betType, int stake, String choice) {
        this.bet = bet;
        this.stake = stake;

        if (!availableBetTypes.contains(betType)){
            throw new IllegalArgumentException("Invalid bet type: " + betType);
        }

        if(betType.equals("Football") && !FootballBet.getChoices().contains(choice)) {
            throw new IllegalArgumentException("Invalid choice for Football: " + choice);
        } else if (betType.equals("Basketball") && !BasketballBet.getChoices().contains(choice)) {
            throw new IllegalArgumentException("Invalid choice for Basketball: " + choice);
        }

        this.choice = choice;
        this.payout = 0.0;
    }

    // Returns the Bet object representing the details of the bet
    public Bet getBet() {
        return bet;
    }

    // Returns the stake of the player in the bet
    public int getStake() {
        return stake;
    }

    // Returns the choice of the player
    public String getChoice() {
        return choice;
    }

    // Sets the payout of the bet based on the outcome
    public void setPayout(double payout) {
        this.payout = payout;
    }
}
