package utn.emiliano.repository;

import utn.emiliano.model.Ticket;

import java.util.List;

/**
 * Created by francisco on 17/02/2016.
 */
public interface TicketRepository {
    List<Ticket> findAll();
    List<Ticket> findByDni(long dni);
}
