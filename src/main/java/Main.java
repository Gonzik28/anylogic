import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.List;

public class Main {
    private static final double PERCENTILE = 90.00;

    public static void main(String[] args) throws IOException, ParseException {
        InputStream is = Main.class.getClassLoader().getResourceAsStream("tickets.json");
        InputStreamReader reader = new InputStreamReader(is);
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(reader);
        JSONArray ticketsArray = (JSONArray) object.get("tickets");
        List<Ticket> ticketList = Parse.parseTickets(ticketsArray);
        TimeFly.avgTime(ticketList);
        System.out.println("Time for percentile " + PERCENTILE + ": " + TimeFly.percentile(ticketList, PERCENTILE) + " sec");
    }
}
