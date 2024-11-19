package Main;

import data.MockData;

public class BetMain {
    public static void main(String[] args) {
        // Create instance of BetOrganization
        final BetOrganization betOrganization = BetOrganization.INSTANCE;
        // Create instance of GameEmulator
        final GameEmulator gameEmulator = GameEmulator.INSTANCE;

        // Add all bets to the BetOrganization
        MockData.generateMockFootballBets().forEach(betOrganization::addBet);
        MockData.generateMockBasketballBets().forEach(betOrganization::addBet);

        // Add all customers to the BetOrganization
        MockData.generateMockCustomers().forEach(betOrganization::addCustomer);

        // Add bets to the customers
        MockData.generateRandomBets(betOrganization.getCustomerList(), betOrganization.getBetList());

        // Perform the game emulation to generate the results of the games
        gameEmulator.doGameEmulation(betOrganization.getBetList());

        // Calculate the gains of the customers
        betOrganization.calculateGainsPerCustomer(gameEmulator.getEmulatedGamesResults());

        // Show the results of the customers
        betOrganization.showCustomersResults();
    }
}