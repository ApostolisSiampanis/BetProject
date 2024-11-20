package customer;

import java.util.List;

// The interface represents a customer that gives a list of bets
public sealed interface IGiveBetList permits Customer {
    List<CustomerBet> getCustomerBetList();
}