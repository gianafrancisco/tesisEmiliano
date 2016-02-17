package utn.emiliano.repository;

import utn.emiliano.model.User;

import java.util.List;

/**
 * Created by francisco on 17/02/2016.
 */
public interface UserRepository {
    List<User> findAll();
}
