import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    // The list of bets of the customer is mutable.
    private final List<CustomerBet> customerBetList = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addCustomerBet(CustomerBet customerBet) {

    }
}
