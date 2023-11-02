package deti.ua.ies.example;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UserRepository  extends CrudRepository<MyUser, Long> {
    List<MyUser> findByName(String name);
}

