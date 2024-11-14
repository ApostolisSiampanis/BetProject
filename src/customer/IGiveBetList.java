package customer;

import java.util.List;

public sealed interface IGiveBetList permits Customer {
    List<CustomerBet> getCustomerBetList();
}