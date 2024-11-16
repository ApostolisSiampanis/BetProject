package customer;

import java.util.ArrayList;
import java.util.List;

public sealed class Customer implements IGiveBetList permits GoldCustomer, PlatinumCustomer {
    // The name of the customer.
    private final String name;
    // The category of the customer.
    private final CustomerCategory category;
    // The maximum stake the customer can place on any bet.
    private final int maxStake;
    // The list of bets of the customer is mutable.
    private final List<CustomerBet> customerBetList = new ArrayList<>();
    // The total gains of the customer.
    private double totalGains = 0.0;
    // Total stake of the customer.
    private double totalStake = 0.0;

    public Customer(String name) {
        this.name = name;
        this.category = CustomerCategory.STANDARD;
        this.maxStake = setMaxStake(this.category);
    }

    public Customer(String name, CustomerCategory category) {
        this.name = name;
        this.category = category;
        this.maxStake = setMaxStake(category);
    }

    // Sets the maximum stake the customer can place on any bet based on the category of the customer.
    protected int setMaxStake(CustomerCategory category) {
        return switch (category) {
            case STANDARD -> 100;
            case GOLD -> 1000;
            case PLATINUM -> 2000;
        };
    }

    // Gets the maximum stake the customer can place on any bet.
    public int getMaxStake(){
        return maxStake;
    }

    // Adds a new bet to the customer's list of bets.
    public void addCustomerBet(CustomerBet customerBet) {
        customerBetList.add(customerBet);
    }

    // Returns the list of bets of the customer.
    @Override
    public List<CustomerBet> getCustomerBetList() {
        return customerBetList;
    }

    // Adds the gains to the total gains of the customer.
    public void addToTotalGains(double gains) {
        totalGains += gains;
    }

    // Adds the stake to the total stake of the customer.
    public void addToTotalStake(double stake) {
        totalStake += stake;
    }

    // Returns a string representation of the customer, including the name, total stake, and total gains.
    @Override
    public String toString() {
        return "Customer name: " + name +
                "\n Customer money paid: " + totalStake +
                "\n Customer gains: " + totalGains;
    }
}
