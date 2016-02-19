package utn.emiliano.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import utn.emiliano.DatosSerial;
import utn.emiliano.model.Ticket;
import utn.emiliano.repository.TicketRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by francisco on 17/02/2016.
 */
@RestController
@Component("ticketController")
public class TicketController {

    @Autowired
    private DatosSerial datosSerial;

    private TicketConsumer ticketConsumer = new TicketConsumer();

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


    @RequestMapping(value = "/serial",method = RequestMethod.GET)
    public List<Ticket> serial(){

        List<String> datos = Arrays.asList(datosSerial.get().toString().split("\\r?\\n"));

        datos.stream().forEach(ticketConsumer);

        return ticketConsumer.get();
    }


    private class TicketConsumer implements Consumer<String>, Supplier<List<Ticket>>{

        private List<Ticket> ticketList = new ArrayList<>();
        private Ticket ticket;

/*
CHOFER: EMA PRADO
Fecha: 17/02/2016
Hora:  22:15:20
REMITO:1-12121212121
TAMBO: 2-12345
SISTERNA: 1
ANTIBIOTICO: NO
CAUDAL:666 L
TEMPERATURA= 21
*********************
 */


        @Override
        public void accept(String s) {
            if(ticket != null){
                if(s.contains("*****")){
                    ticketList.add(ticket);
                    ticket = new Ticket();
                }else if(s.contains("CHOFER:")){
                    ticket.setConductor(s.split(":")[1].trim());
                }else if(s.contains("REMITO:")){
                    ticket.setRemito(s.split(":")[1].trim());
                }else if(s.contains("TAMBO:")){
                    ticket.setTambo(s.split(":")[1].trim());
                }else if(s.contains("SISTERNA:")){
                    ticket.setCisterna(Integer.valueOf(s.split(":")[1].trim()));
                }else if(s.contains("CISTERNA:")){
                    ticket.setCisterna(Integer.valueOf(s.split(":")[1].trim()));
                }else if(s.contains("ANTIBIOTICO:")){
                    ticket.setAntibiotico(s.split(":")[1].trim());
                }else if(s.contains("TEMPERATURA:")){
                    ticket.setTemperatura(Double.valueOf(s.split(":")[1].trim()));
                }else if(s.contains("TEMPERATURA=")){
                    ticket.setTemperatura(Double.valueOf(s.split("=")[1].trim()));
                }else if(s.contains("CAUDAL:")){
                    ticket.setLitros(Double.valueOf(s.split(":")[1].replace("L","").trim()));
                }else if(s.contains("VOLUMEN:")){
                    ticket.setLitros(Double.valueOf(s.split(":")[1].replace("L","").trim()));
                }
            }else{
                if(s.contains("*****")){
                    ticket = new Ticket();
                }
            }
        }

        @Override
        public List<Ticket> get() {
            List<Ticket> tmp = ticketList;
            ticketList = new ArrayList<>();
            return tmp;
        }
    }

}
