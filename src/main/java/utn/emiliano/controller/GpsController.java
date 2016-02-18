package utn.emiliano.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import utn.emiliano.model.Gps;
import utn.emiliano.model.User;
import utn.emiliano.repository.GpsRepository;
import utn.emiliano.repository.UserRepository;

import java.util.List;

/**
 * Created by francisco on 17/02/2016.
 */
@RestController
@Component("gpsController")
public class GpsController {

    @Autowired
    private GpsRepository gpsRepository;

    @RequestMapping(value = "/gps",method = RequestMethod.GET)
    public List<Gps> gps(){
        return gpsRepository.findAll();
    }

}
