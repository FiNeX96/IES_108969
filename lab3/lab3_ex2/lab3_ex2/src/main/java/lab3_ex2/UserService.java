package lab3_ex2;

import java.util.List;

public interface UserService {
    Employee createUser(Employee user);

    Employee getUserById(Long userId);

    List<Employee> getAllUsers();

    Employee updateUser(Employee user);

    void deleteUser(Long userId);

    List<Employee> getUserByEmail(String email);
}