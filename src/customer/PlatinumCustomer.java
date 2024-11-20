package customer;

public final class PlatinumCustomer extends Customer {
    // The class represents a Platinum customer.
    public PlatinumCustomer(String name) {
        super(name, CustomerCategory.PLATINUM);
    }
}
