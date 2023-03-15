import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Parse {
    private static String formatDate = "dd.MM.yy HH:mm";

    public static List<Ticket> parseTickets(JSONArray ticketsArray) {

        List<Ticket> ticketList = new ArrayList<>();
        ticketsArray.forEach(lineObject -> {
            JSONObject jsonObject = (JSONObject) lineObject;

            Ticket ticket = new Ticket();
            ticket.setOrigin(jsonObject.get("origin").toString());
            ticket.setOriginName(jsonObject.get("origin_name").toString());
            ticket.setDestination(jsonObject.get("destination").toString());
            ticket.setDestinationName(jsonObject.get("destination_name").toString());
            ticket.setCarrier(jsonObject.get("carrier").toString());
            ticket.setStops((Long) jsonObject.get("stops"));
            ticket.setPrice((Long) jsonObject.get("price"));
            String departureDate = jsonObject.get("departure_date").toString()
                    + " " + jsonObject.get("departure_time").toString();
            String arrivalDate = jsonObject.get("arrival_date").toString()
                    + " " + jsonObject.get("arrival_time").toString();
            try {
                ticket.setDepartureDate(new SimpleDateFormat(formatDate).parse(departureDate));
                ticket.setArrivalDate(new SimpleDateFormat(formatDate).parse(arrivalDate));
            } catch (java.text.ParseException e) {
                throw new RuntimeException(e);
            }

            ticketList.add(ticket);
        });
        return ticketList;
    }
}
