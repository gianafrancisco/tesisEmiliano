package utn.emiliano.repository;

import org.springframework.stereotype.Component;
import utn.emiliano.model.User;

import java.util.ArrayList;
import java.util.List;

@Component("userRepository")
public class MemoryUserRepository implements UserRepository {
    private List<User> userList = new ArrayList<User>();

    public MemoryUserRepository() {
        userList.add(new User(32317260L,"HAO129","Emanuel","Prado","Sancor"));
        userList.add(new User(31669160L,"HAO130","Gabriel","Zampa","Sancor"));
        userList.add(new User(29843624L,"HAO131","Emiliano","Grande","Sancor"));
        userList.add(new User(31623864L,"HAO132","Pablo","Bongiovanni","Sancor"));
    }

    public List<User> findAll() {
        return userList;
    }
}