package utn.emiliano.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import utn.emiliano.model.Ticket;
import utn.emiliano.repository.TicketRepository;

import java.util.List;

/**
 * Created by francisco on 17/02/2016.
 */
@RestController
@Component("ticketController")
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @RequestMapping(value = "/ticket/{id}",method = RequestMethod.GET)
    public List<Ticket> ticket(@PathVariable(value = "0") long dni){
        return ticketRepository.findByDni(dni);
    }

    @RequestMapping(value = "/ticket",method = RequestMethod.GET)
    public List<Ticket> ticket(){
        return ticketRepository.findAll();
    }

}
