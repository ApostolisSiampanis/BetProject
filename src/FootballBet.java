import java.util.List;

public class FootballBet extends Bet{
    // The class contains the available outcomes of a football match.
    // 1: The first team wins, X: Draw, 2: The second team wins
    // The list of available options is immutable.
    private static final List<String> choices = List.of("1", "X", "2");
    // The outcome of the bet
    private final String outcome;

    public FootballBet(String game, double odd, String outcome){
        super(game, odd);
        this.outcome = outcome;
    }

    public String getOutcome() {
        return outcome;
    }

    public static List<String> getChoices() {
        return choices;
    }
}
