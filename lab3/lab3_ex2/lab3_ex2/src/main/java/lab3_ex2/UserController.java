package lab3_ex2;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("employees")
public class UserController {

    private UserService userService;


    // build create User REST API
    @PostMapping
    public ResponseEntity<Employee> createUser(@RequestBody Employee user) {
        Employee savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }



    @GetMapping("/search")
    public ResponseEntity<Employee> searchUser(@RequestParam(required=false) String email, @RequestParam(required=false) Long id) 
    {

        if (email == null && id == null) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
        else if (email == null) {
            return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
        }
        else if (id == null) {
            return new ResponseEntity<>(userService.getUserByEmail(email).get(0), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    



    // http://localhost:8080/employees/id/1
    @GetMapping("/id/{id}")
    public ResponseEntity<Employee> getUserById(@PathVariable("id") Long userId) {
        Employee user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // http://localhost:8080/employees/email/xxx
    @GetMapping("/email/{email}")
    public ResponseEntity<List<Employee>> getUserByEmail(@PathVariable("email") String email) {
        List<Employee> user = userService.getUserByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Build Get All Users REST API
    // http://localhost:8080/api/users
    @GetMapping
    public ResponseEntity<List<Employee>> getAllUsers() {
        List<Employee> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Build Update User REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/users/1
    public ResponseEntity<Employee> updateUser(@PathVariable("id") Long userId,
            @RequestBody Employee user) {
        user.setId(userId);
        Employee updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}