package lab3_ex2;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;


import java.util.List;

import java.util.Optional;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public Employee createUser(Employee user) {
        return userRepository.save(user);
    }

    @Override
    public Employee getUserById(Long userId) {
        Optional<Employee> optionalUser = userRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<Employee> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<Employee> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Employee updateUser(Employee user) {
        Employee existingUser = userRepository.findById(user.getId()).get();
        existingUser.setName(user.getName());
        existingUser.setRole(user.getRole());
        existingUser.setEmail(user.getEmail());
        Employee updatedUser = userRepository.save(existingUser);
        return updatedUser;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }


}
