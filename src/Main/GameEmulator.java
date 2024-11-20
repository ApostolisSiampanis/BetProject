package Main;

import bet.BasketballBet;
import bet.Bet;
import bet.FootballBet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public enum GameEmulator {
    // The singleton instance of the GameEmulator
    INSTANCE;

    // Used to generate random numbers for selecting the results of the games
    final Random r = new Random();
    // This HashMap will help us map each game to a result.
    // Specifically, for each unique game name (first parameter String),
    // we will map a unique result (1-X-2) or (1-2), depending on the type of game (football or basketball)
    private final Map<String, String> emulatedGamesResults = new HashMap<>();
    // Available choices for football
    private final String[] footballChoices = FootballBet.getChoices().toArray(new String[0]);
    // Available choices for basketball
    private final String[] basketballChoices = BasketballBet.getChoices().toArray(new String[0]);

    // This method generates the results of the games
    public void doGameEmulation(List<Bet> bets) {
        bets.forEach(bet -> {
            if (bet instanceof FootballBet) {
                emulatedGamesResults.put(bet.getGame(), footballChoices[r.nextInt(footballChoices.length)]);
            } else if (bet instanceof BasketballBet) {
                emulatedGamesResults.put(bet.getGame(), basketballChoices[r.nextInt(basketballChoices.length)]);
            }
        });
    }

    // Get the results of the games
    public Map<String, String> getEmulatedGamesResults(){
        return emulatedGamesResults;
    }
}
