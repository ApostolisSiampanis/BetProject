public abstract class Bet {
    // The name of the game. We assume that the name is unique.
    private final String game;
    // The odd of the bet. We assume the same odd, regardless of which team will win
    private final double odd;
    public Bet(String game, double odd) {
        this.game = game;
        this.odd = odd;
    }

    public String getGame() {
        return game;
    }

    public double getOdd() {
        return odd;
    }
}
