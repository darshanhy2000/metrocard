package metrocard;



public class Passenger {
    private PassengerType type;
    private MetroCard metroCard;

    public Passenger(PassengerType type, MetroCard metroCard) {
        this.type = type;
        this.metroCard = metroCard;
    }

    public PassengerType getType() {
        return type;
    }

    public MetroCard getMetroCard() {
        return metroCard;
    }

    public double calculateFare(boolean isReturn) {
        double fare;
        switch (type) {
            case ADULT:
                fare = 200;
                break;
            case SENIOR_CITIZEN:
                fare = 100;
                break;
            case KID:
                fare = 50;
                break;
            default:
                fare = 0;
        }
        if (isReturn) {
            fare *= 0.5;
        }
        return fare;
    }
}
