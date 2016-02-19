package utn.emiliano.repository;

import org.springframework.stereotype.Component;
import utn.emiliano.model.Gps;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by francisco on 17/02/16.
 */
@Component("gpsRepository")
public class MemoryGpsRepository implements GpsRepository {

    private List<Gps> gpsList = new ArrayList<>();
    {
        gpsList.add(new Gps(32317260L,-31.4219772,-64.1877145,""));
        gpsList.add(new Gps(32317260L,-31.4262126,-64.1860127,""));
        gpsList.add(new Gps(32317260L,-31.4294566,-64.1847146,""));
        gpsList.add(new Gps(32317260L,-31.4431871,-64.194063,""));


        gpsList.add(new Gps(31669160L,-31.4300505,-64.1843458,""));
        gpsList.add(new Gps(31669160L,-31.430899,-64.1842425,""));
        gpsList.add(new Gps(31669160L,-31.4316556,-64.1842511,""));
        gpsList.add(new Gps(31669160L,-31.4431871,-64.194063,""));

        gpsList.add(new Gps(29843624L,-31.4256883,-64.1877521,""));
        gpsList.add(new Gps(29843624L,-31.425164,-64.1891782,""));
        gpsList.add(new Gps(29843624L,-31.424687,-64.1905491,""));
        gpsList.add(new Gps(29843624L,-31.4431871,-64.194063,""));

        gpsList.add(new Gps(31623864L,-31.425091,-64.1905002,""));
        gpsList.add(new Gps(31623864L,-31.427033,-64.1913775,""));
        gpsList.add(new Gps(31623864L,-31.4313334,-64.1933603,""));
        gpsList.add(new Gps(31623864L,-31.4431871,-64.194063,""));

    }

    @Override
    public List<Gps> findAll() {
        return gpsList;
    }
}
