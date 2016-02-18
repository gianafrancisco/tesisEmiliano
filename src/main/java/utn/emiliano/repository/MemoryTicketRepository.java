package utn.emiliano.repository;

import org.springframework.stereotype.Component;
import utn.emiliano.model.Ticket;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Component("tickerRepository")
public class MemoryTicketRepository implements TicketRepository {
    private List<Ticket> ticketList = new ArrayList<>();

    public MemoryTicketRepository() {
        ticketList.add(new Ticket(32317260L, Instant.parse("2015-10-20T17:55:00Z"),"Prado, Emanuel","1-222222222221","2-22231",1, "Si", 35000.0,4.1));
        ticketList.add(new Ticket(32317260L, Instant.parse("2015-10-24T16:35:00Z"),"Prado, Emanuel","1-222222222222","2-22232",1, "No", 33000.0,4.6));
        ticketList.add(new Ticket(32317260L, Instant.parse("2015-10-30T19:05:00Z"),"Prado, Emanuel","1-222222222223","2-22233",1, "Si", 36000.0,4.2));

        ticketList.add(new Ticket(31669160L, Instant.parse("2015-08-20T17:55:00Z"),"Gabriel, Zampa","1-222222222224","2-22234",1, "No", 33000.0,4.0));
        ticketList.add(new Ticket(31669160L, Instant.parse("2015-08-24T16:25:00Z"),"Gabriel, Zampa","1-222222222225","2-22235",1, "Si", 32000.0,4.8));
        ticketList.add(new Ticket(31669160L, Instant.parse("2015-08-30T19:05:00Z"),"Gabriel, Zampa","1-222222222226","2-22236",1, "Si", 31000.0,3.9));

        ticketList.add(new Ticket(29843624L, Instant.parse("2015-09-20T17:55:00Z"),"Emiliano, Grande","1-222222222227","2-22237",1, "Si", 39800.0,4.1));
        ticketList.add(new Ticket(29843624L, Instant.parse("2015-09-24T16:55:00Z"),"Emiliano, Grande","1-222222222228","2-22238",1, "Si", 37800.0,4.5));
        ticketList.add(new Ticket(29843624L, Instant.parse("2015-09-30T19:05:00Z"),"Emiliano, Grande","1-222222222229","2-22239",1, "No", 35600.0,3.6));

        ticketList.add(new Ticket(31623864L, Instant.parse("2015-11-20T17:55:00Z"),"Pablo, Bongiovanni","1-222222222210","2-22210",1, "Si", 33000.0,4.5));
        ticketList.add(new Ticket(31623864L, Instant.parse("2015-11-24T16:55:00Z"),"Pablo, Bongiovanni","1-222222222211","2-22211",1, "No", 36000.0,4.3));
        ticketList.add(new Ticket(31623864L, Instant.parse("2015-11-30T19:05:00Z"),"Pablo, Bongiovanni","1-222222222212","2-22212",1, "No", 35123.0,4.8));
    }


    public List<Ticket> findByDni(long dni) {
        return ticketList;
    }

    public List<Ticket> findAll() {
        return ticketList;

    }
}