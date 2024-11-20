package data;

import bet.BasketballBet;
import bet.Bet;
import bet.FootballBet;
import customer.Customer;
import customer.CustomerBet;
import customer.GoldCustomer;
import customer.PlatinumCustomer;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public final class MockData {
    private static final Random random = new Random();

    // Returns a list of mock football bets
    public static List<FootballBet> generateMockFootballBets(){
        return List.of(
            new FootballBet("Aston Villa - Manchester United", 1.8),
            new FootballBet("Liverpool - Chelsea", 2.1),
            new FootballBet("Arsenal - Tottenham", 1.9),
            new FootballBet("Real Madrid - Barcelona", 2.2),
            new FootballBet("Bayern Munich - Borussia Dortmund", 1.7),
            new FootballBet("Juventus - Inter", 2.3),
            new FootballBet("Paris Saint-Germain - Olympique Marseille", 1.6),
            new FootballBet("Benfica - Porto", 2.4),
            new FootballBet("Ajax - PSV", 1.5),
            new FootballBet("Fenerbahce - Galatasaray", 2.5),
            new FootballBet("Panathinaikos - Olympiakos", 1.4),
            new FootballBet("PAOK - AEK", 2.6),
            new FootballBet("Atletico Madrid - Sevilla", 1.3),
            new FootballBet("Valencia - Villarreal", 2.7),
            new FootballBet("Roma - Lazio", 1.2)
        );
    }

    // Returns a list of mock basketball bets
    public static List<BasketballBet> generateMockBasketballBets(){
        return List.of(
            new BasketballBet("Los Angeles Lakers - Boston Celtics", 1.8),
            new BasketballBet("Golden State Warriors - Miami Heat", 2.1),
            new BasketballBet("Chicago Bulls - New York Knicks", 1.9),
            new BasketballBet("Toronto Raptors - Houston Rockets", 2.2),
            new BasketballBet("San Antonio Spurs - Dallas Mavericks", 1.7),
            new BasketballBet("Phoenix Suns - Portland Trail Blazers", 2.3),
            new BasketballBet("Utah Jazz - Denver Nuggets", 1.6),
            new BasketballBet("Indiana Pacers - Philadelphia 76ers", 2.4),
            new BasketballBet("Milwaukee Bucks - Atlanta Hawks", 1.5),
            new BasketballBet("Sacramento Kings - New Orleans Pelicans", 2.5),
            new BasketballBet("Minnesota Timberwolves - Oklahoma City Thunder", 1.4),
            new BasketballBet("Memphis Grizzlies - Brooklyn Nets", 2.6),
            new BasketballBet("Orlando Magic - Charlotte Hornets", 1.3),
            new BasketballBet("Detroit Pistons - Cleveland Cavaliers", 2.7),
            new BasketballBet("Washington Wizards - Miami Heat", 1.2)
        );
    }

    // Returns a list of mock customers, including regular, gold, and platinum customers
    public static List<Customer> generateMockCustomers() {
        return List.of(
            new Customer("John Papadopoulos"),
            new Customer("Maria Georgiou"),
            new Customer("George Papandreou"),
            new Customer("Kostas Mitsikostas"),
            new GoldCustomer("George Papadopoulos"),
            new GoldCustomer("Nikos Georgakopoulos"),
            new GoldCustomer("Marilena Giannakopoulou"),
            new GoldCustomer("Michalis Papadakis"),
            new PlatinumCustomer("Paraskevas Michalopoulos"),
            new PlatinumCustomer("Sofoklis Roussos"),
            new PlatinumCustomer("Antonis Papanikolaou")
        );
    }

    // Generates random bets for each customer
    public static void generateRandomBets(List<Customer> customerList, List<Bet> betList){
        customerList.forEach(customer -> {
            IntStream.range(0, random.nextInt(1,7)).forEach(i -> {
                Bet bet = betList.get(random.nextInt(betList.size()));
                String betType = (bet instanceof FootballBet) ? "Football" : "Basketball";
                String choice = (betType.equals("Football")) ?
                                FootballBet.getChoices().get(random.nextInt(FootballBet.getChoices().size())) :
                                BasketballBet.getChoices().get(random.nextInt(BasketballBet.getChoices().size()));
                int stake = random.nextInt(1, customer.getMaxStake());
                CustomerBet customerBet = new CustomerBet(bet, betType, stake, choice);
                customer.addCustomerBet(customerBet);
                customer.addToTotalStake(stake);
            });
        });
    }
}
