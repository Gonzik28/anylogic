import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class TimeFly {
    public static final int CONVERTER_MILLISECOND_SEC = 1_000;

    public static void avgTime(List<Ticket> ticketList) {
        AtomicLong summ = new AtomicLong();
        AtomicLong avg = new AtomicLong();
        ticketList.forEach(ticket -> {
            if ((ticket.getOrigin().equals("VVO") | ticket.getOrigin().equals("TLV")) &
                    (ticket.getDestination().equals("VVO") | ticket.getDestination().equals("TLV"))) {
                summ.set(summ.get() + (ticket.getArrivalDate().getTime() - ticket.getDepartureDate().getTime()));
            }
        });
        avg.set(summ.get() / (ticketList.size() * CONVERTER_MILLISECOND_SEC));
        System.out.println("Average flight time: " + avg.get() + " sec");
    }

    private static List<Long> avgTimeList(List<Ticket> ticketList) {
        List<Long> timeList = new ArrayList<>();
        ticketList.forEach(ticket -> {
            if ((ticket.getOrigin().equals("VVO") | ticket.getOrigin().equals("TLV")) &
                    (ticket.getDestination().equals("VVO") | ticket.getDestination().equals("TLV"))) {
                long l = (ticket.getArrivalDate().getTime() - ticket.getDepartureDate().getTime()) / CONVERTER_MILLISECOND_SEC;
                timeList.add(l);
            }
        });
        return timeList;
    }

    public static double percentile(List<Ticket> ticketList, double percentile) {
        List<Long> timeList = avgTimeList(ticketList);
        Collections.sort(timeList);
        int index = (int) Math.ceil(percentile / 100.0 * timeList.size());
        return timeList.get(index - 1);
    }
}
