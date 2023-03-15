import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {
    private static final double PERCENTILE = 90.00;

    public static void main(String[] args) throws IOException, ParseException {
        File jsonFile = new File("src/main/resources/tickets.json");
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(new FileReader(jsonFile));
        JSONArray ticketsArray = (JSONArray) object.get("tickets");
        List<Ticket> ticketList = Parse.parseTickets(ticketsArray);
        TimeFly.avgTime(ticketList);
        System.out.println("Time for percentile " + PERCENTILE + ": " + TimeFly.percentile(ticketList, PERCENTILE) + " sec");
    }
}
