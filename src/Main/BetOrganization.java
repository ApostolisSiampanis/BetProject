package Main;

import bet.Bet;
import customer.Customer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public enum BetOrganization {
    // The singleton instance of the BetOrganization
    INSTANCE;
    // The list of customers
    private final List<Customer> customerList = new ArrayList<>();

    // The list of available bets for football and basketball matches
    private final List<Bet> betList = new ArrayList<>();

    // The method adds a customer to the list of customers
    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }
    // The method adds a bet to the list of available bets
    public void addBet(Bet bet) {
        betList.add(bet);
    }

    // Get the list of customers
    public List<Customer> getCustomerList() {
        return customerList;
    }

    // Get the list of bets
    public List<Bet> getBetList() {
        return betList;
    }

    // The method calculates the gains of the customer
    public void calculateGainsPerCustomer(Map<String, String> emulatedGamesResults) {
        customerList.forEach(customer -> {
            customer.getCustomerBetList().forEach(customerBet -> {
                String game = customerBet.getBet().getGame();
                String result = emulatedGamesResults.get(game);

                if (result != null && result.equals(customerBet.getChoice())) {
                    double payout = customerBet.getStake() * customerBet.getBet().getOdd();
                    customerBet.setPayout(payout);
                    customer.addToTotalGains(payout);
                }
            });
        });
    }

    // The method prints the results of the customers
    public void showCustomersResults(){
        StringBuilder builder = new StringBuilder();
        builder.append("------------------Results-------------------\n");
        customerList.forEach(customer -> {
                            builder.append("####################################\n");
                            builder.append(customer).append("\n");
                        });
        builder.append("--------------End-of-Results----------------\n");
        System.out.println(builder);
        printCustomersResultsToTextFile(builder.toString());
    }

    // The method writes the results of the customers to a text file
    public void printCustomersResultsToTextFile(String printableText){
        try {
            String fileName = "bet-results.txt";
            Path filePath = Path.of(fileName);
            Files.writeString(filePath, printableText);
        } catch (IOException e) {
            System.out.printf("Something went wrong while writing to the file. Error: %s%n", e.getMessage());
        }
    }
}
