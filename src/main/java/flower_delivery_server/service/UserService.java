package flower_delivery_server.service;

import flower_delivery_server.entity.User;

public interface UserService {
    User getByID(long id);
    User getUserByEmail(String email);
    User save(User user);
    void remove(long id);
}
