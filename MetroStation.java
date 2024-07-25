package metrocard;



import java.util.HashMap;
import java.util.Map;

public class MetroStation {
    private static final double RECHARGE_FEE_PERCENTAGE = 0.02;
    private String name;
    private double totalCollection;
    private double totalDiscount;
    private Map<PassengerType, Integer> passengerCount;

    public MetroStation(String name) {
        this.name = name;
        this.totalCollection = 0;
        this.totalDiscount = 0;
        this.passengerCount = new HashMap<>();
        for (PassengerType type : PassengerType.values()) {
            passengerCount.put(type, 0);
        }
    }

    public void processJourney(Passenger passenger, boolean isReturn) {
        double fare = passenger.calculateFare(isReturn);
        MetroCard card = passenger.getMetroCard();
        if (!card.hasSufficientBalance(fare)) {
            double rechargeAmount = fare - card.getBalance();
            double serviceFee = rechargeAmount * RECHARGE_FEE_PERCENTAGE;
            totalCollection += rechargeAmount + serviceFee;
            card.recharge(rechargeAmount);
        }
        card.deduct(fare);
        totalCollection += fare;
        if (isReturn) {
            totalDiscount += fare * 0.5;
        }
        passengerCount.put(passenger.getType(), passengerCount.get(passenger.getType()) + 1);
    }

    public void printSummary() {
        System.out.println("Collection Summary for " + name + " Station:");
        System.out.println("Total Collection: ₹" + totalCollection);
        System.out.println("Total Discount: ₹" + totalDiscount);
        System.out.println("Passenger Summary:");
        passengerCount.entrySet().stream()
            .sorted((e1, e2) -> {
                int countCompare = e2.getValue().compareTo(e1.getValue());
                if (countCompare == 0) {
                    return e1.getKey().name().compareTo(e2.getKey().name());
                }
                return countCompare;
            })
            .forEach(entry -> System.out.println(entry.getKey().name() + " " + entry.getValue()));
    }
}
