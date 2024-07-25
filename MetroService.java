package metrocard;

public class MetroService {
    public static void main(String[] args) {
        MetroStation central = new MetroStation("Central");
        MetroStation airport = new MetroStation("Airport");

        // Create MetroCards
        MetroCard card1 = new MetroCard("MC001", 100);
        MetroCard card2 = new MetroCard("MC002", 50);
        MetroCard card3 = new MetroCard("MC003", 200);

        // Create Passengers
        Passenger passenger1 = new Passenger(PassengerType.ADULT, card1);
        Passenger passenger2 = new Passenger(PassengerType.SENIOR_CITIZEN, card2);
        Passenger passenger3 = new Passenger(PassengerType.KID, card3);

        // Process Journeys
        central.processJourney(passenger1, false);  // Single journey for passenger1
        airport.processJourney(passenger1, true);   // Return journey for passenger1
        central.processJourney(passenger2, false);  // Single journey for passenger2
        airport.processJourney(passenger3, false);  // Single journey for passenger3

        // Print Summary
        central.printSummary();
        airport.printSummary();
    }
}
