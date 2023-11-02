package lab3_ex2;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<Employee, Long> {

    List <Employee> findByEmail(String email);



}
