package bet;

import java.util.List;

public final class BasketballBet extends Bet{
    // The class contains the available outcomes of a basketball match.
    // 1: The first team wins, 2: The second team wins
    // The list of available options is immutable.
    private static final List<String> choices = List.of("1", "2");

    // Constructor
    public BasketballBet(String game, double odd){
        super(game, odd);
    }

    // Returns the available outcomes of a basketball match
    public static List<String> getChoices() {
        return choices;
    }
}
