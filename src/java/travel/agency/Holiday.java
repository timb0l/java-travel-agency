package java.travel.agency;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Holiday {
    private String destination;
    private  LocalDate departure;
    private LocalDate arrival;

    public Holiday (String destination, LocalDate departure, LocalDate arrival) throws RuntimeException {
        if(destination == null || departure == null || arrival == null){
        throw new RuntimeException("Invalid Destination and dates");
        } if (departure.isBefore(LocalDate.now())){
            throw new RuntimeException("Invalid date");
        } if (arrival.isBefore(departure)){
            throw new RuntimeException("Invalid date");
        }
        this.destination = destination;
        this.departure = departure;
        this.arrival = arrival;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDate departure) {
        this.departure = departure;
    }

    public LocalDate getArrival() {
        return arrival;
    }

    public void setArrival(LocalDate arrival) {
        this.arrival = arrival;
    }

    public long estimate(){
        return departure.until(arrival, ChronoUnit.DAYS);
    }

}
