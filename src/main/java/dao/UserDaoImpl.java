package dao;

import model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("SELECT user FROM User user").getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteById(Long id) {
        String querry = "DELETE FROM User U WHERE U.id = " + id;
        entityManager.createQuery(querry).executeUpdate();

    }

    @Override
    public void update(User user) {
        Query query = entityManager.createQuery("UPDATE User set name = :userName, lastName = :userLastName, age = :userAge WHERE id = :userId");
        query.setParameter("userName", user.getName());
        query.setParameter("userLastName", user.getLastName());
        query.setParameter("userAge", user.getAge());
        query.setParameter("userId", user.getId());

        query.executeUpdate();
    }
}
