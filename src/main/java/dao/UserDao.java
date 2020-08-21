package dao;

import model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();
    void save(User user);
    User findById(Long id);
    void deleteById(Long id);
    void update(User user);
}
