import java.util.Date;

public class Ticket {
    private String origin;
    private String originName;
    private String destination;
    private String destinationName;
    private Date departureDate;
    private Date arrivalDate;
    private String carrier;
    private Long stops;
    private Long price;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public void setStops(Long stops) {
        this.stops = stops;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

}
