package bet;

import java.util.List;

public final class FootballBet extends Bet{
    // The class contains the available outcomes of a football match.
    // 1: The first team wins, X: Draw, 2: The second team wins
    // The list of available options is immutable.
    private static final List<String> choices = List.of("1", "X", "2");

    // Constructor
    public FootballBet(String game, double odd){
        super(game, odd);
    }

    // Returns the available outcomes of a football match
    public static List<String> getChoices() {
        return choices;
    }
}
