package src.betting;
import java.util.*;

public class Bet {
    private Scanner scanner = new Scanner(System.in);
    private Set<String> players = new HashSet<String>();

    private Map<String, Double> playersMoney = new HashMap<String, Double>();
    private double initialEntrance = 0;

    private int minimumBet = 0;

    private double secondBet = 0;
    public int askForAmount(final String msg) {
        System.out.println(msg);
        int amount = scanner.nextInt();
        //System.out.println(amount);
        return amount;
    } // here ends

    public void enterPlayers(final int amount) {
        for (int i = amount; i > 0; i--) {
            String player = scanner.nextLine();
            this.players.add(player);
        } // here ends the for loop

    } // here ends enterPLayers

    public void setEntrance(final double entrance) {
        this.initialEntrance = entrance;
    }

    public void setMinimumBet(final int bet) {
        this.minimumBet = bet;
        this.secondBet = bet/2;
    }

    // this function should only be used when a new player enters the game
    public void addPlayer(String player) {
        this.players.add(player);
        this.playersMoney.put(player, this.initialEntrance);
    } // here ends addPlayer

    public void convertSetToMap() {
        for (final String player : players) {
            this.playersMoney.put(player, this.initialEntrance);
        } // here ends the for loop

    } // here ends convert set to map

    public void betForPlayer(final String player, final double amount) {
        final double balance = this.playersMoney.get(player);
        if (balance < amount) {
            // Betting is not possible
            System.out.println("No betting possible for " + " " + player);
            return;
        }
        // take the money out of the account
        final double updatedBalance = balance - amount;
        this.playersMoney.replace(player, updatedBalance);
        System.out.println(player + " bet " + amount + " successfully");
    } // here ends betForPlayer

    public void playerWonPool(final String player, final double amount) {
        final double balance = this.playersMoney.get(player);
        // increase the money in the account
        final double updatedBalance = balance + amount;
        this.playersMoney.replace(player, updatedBalance);
        System.out.println(player + " won " + updatedBalance + " congratulations");

    } // here ends the method

    
} // here ends the class Bet

