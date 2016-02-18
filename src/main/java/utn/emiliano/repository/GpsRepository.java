package utn.emiliano.repository;

import utn.emiliano.model.Gps;

import java.util.List;

/**
 * Created by francisco on 17/02/16.
 */
public interface GpsRepository {
    List<Gps> findAll();
}
