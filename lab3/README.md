## Lab 3 

### Web Servers with Springboot

Using Springboot to create a web server that can handle GET and POST requests.
Anotations:

- @RestController - This is a combination of @Controller and @ResponseBody. This is used to create a RESTful controller.
- @RequestMapping - This is used to map web requests onto specific handler classes and/or handler methods.
- @GetMapping - This is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).
- @PostMapping - This is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.POST).
- @RequestParam - This is used to bind the value of a query string parameter or form field to a method parameter in a controller.
- @RequestBody - This is used to bind the HTTP request body to an object in the method parameter.
- @Repository - This is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.
- @Service - This is used to indicate that the class provides some business functionalities.
- @Autowired - This is used to mark a dependency which Spring is going to resolve and inject automatically.
- @Table - This is used to provide the details of the table that this entity will be mapped to (ORM).
- @Entity - This is used to mark the class as an entity (ORM).



### 3.1 Questions

1. **Instantiation of UserRepository:**
   - The `UserController` class gets an instance of the `UserRepository` through its constructor.
   - The `UserRepository` is instantiated and managed by Spring Data JPA. It's automatically created by Spring based on the configuration and the entity it's supposed to manage.

2. **Methods Invoked in UserRepository:**
   - The `UserController` invokes various methods on the `UserRepository` to interact with the database. These methods typically include CRUD (Create, Read, Update, Delete) operations, as well as custom queries.
   - The methods invoked in the `UserRepository` are defined by Spring Data JPA. They are generated based on naming conventions, and you can also define custom queries using Spring Data JPA query methods.

3. **Data Storage Location:**
   - The data is being saved in a relational database. In this example, the H2 Database is used, which is an in-memory database.

4. **Rule for "Not Empty" Email Address:**
   - The rule for ensuring that the email address is not empty is typically defined in the `User` entity class. You can find this rule as a constraint annotation on the email field in the entity class. Most likely equal to a NOT NULL in SQL.
