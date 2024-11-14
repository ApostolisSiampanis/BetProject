import java.util.List;

public class CustomerBet {
    // The class contains the available bet types for a customer.
    // The list of available bet types is immutable.
    private static final List<String> availableBetTypes = List.of("Football", "Basketball");
    // The unique name of the game
    // When creating objects of this class, we do not check if the game name given by the player is correct.
    // This will be checked later by the BetOrganization class
    private String betName;
    // The amount of the bet in euros (without decimals)
    private int stake;
    // The player's betting choice. As mentioned above, it must be checked, depending on the type of game.
    // The available outcomes of a basketball match are, 1: The first team wins, 2: The second team wins
    // The available outcomes of a football match are, 1: The first team wins, X: Draw, 2: The second team wins
    private String choice;
    // The parameter "betType" is the type of the game. It can only take one of the 2 values: "Football" or "Basketball"
    // The given value of the String betType given during the simulation will be checked in the constructor of the CustomerBet class
    // and at the same time it will be checked if the choice, "choice", concerns the available options of the respective type of game.
    public CustomerBet(String betName, String betType, int stake, String choice) {
        //TODO: Implement the constructor
    }

    public String getBetName() {
        return betName;
    }

    public int getStake() {
        return stake;
    }

    public String getChoice() {
        return choice;
    }
}
