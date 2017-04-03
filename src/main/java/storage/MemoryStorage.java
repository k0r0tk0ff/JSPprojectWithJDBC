package storage;

import models.Pet;
import models.User;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;


import static org.slf4j.LoggerFactory.getLogger;

/**.
 * Class for save users.
 * @author Petr Arsentev
 * site - http://job4j.ru/
 */
public class MemoryStorage implements Storage {

     private static final org.slf4j.Logger Log = getLogger(MemoryStorage.class);

     private final CopyOnWriteArrayList<User> users = new CopyOnWriteArrayList<User>();

    /**.
     * 4 - max id of embedded user (see rvkalau1.setId(4);)
     */
     public AtomicInteger id = new AtomicInteger(4);


    /**.
     * Use singletone conception -
     * https://habrahabr.ru/post/27108/
     */
    public MemoryStorage() {
        User root = new User();
        root.setEmail("rootmail@mail.ru");
        root.setId(0);
        root.setLogin("root");
        root.setRole("ROLE_ADMIN");
        root.setPassword("s");
        root.addPet(new Pet(0, root.petId.incrementAndGet(), "dog", "Rex"));
        this.users.add(root);

        User user = new User();
        user.setEmail("user@mail.ru");
        user.setId(1);
        user.setLogin("v");
        user.setRole("ROLE_USER");
        user.setPassword("v");
        user.addPet(new Pet(0, user.petId.incrementAndGet(), "cat", "Markiz"));
        this.users.add(user);

        User anotherUser = new User();
        anotherUser.setEmail("anotherUser@mail.ru");
        anotherUser.setId(2);
        anotherUser.setLogin("a");
        anotherUser.setRole("ROLE_ADMIN");
        anotherUser.setPassword("a");
        anotherUser.addPet(new Pet(0, anotherUser.petId.incrementAndGet(), "cat", "Murka"));
        this.users.add(anotherUser);

        User mpgonch1 = new User();
        mpgonch1.setEmail("mpgonch1@mpgonch1.mpgonch1");
        mpgonch1.setId(3);
        mpgonch1.setLogin("mpgonch1");
        mpgonch1.setRole("ROLE_ADMIN");
        mpgonch1.setPassword("a");
        mpgonch1.addPet(new Pet(0, mpgonch1.petId.incrementAndGet(), "cat", "THE_CAT"));
        this.users.add(mpgonch1);

        User rvkalau1 = new User();
        rvkalau1.setEmail("rvkalau1@rvkalau1.rvkalau1");
        rvkalau1.setId(4);
        rvkalau1.setLogin("rvkalau1");
        rvkalau1.setRole("ROLE_ADMIN");
        rvkalau1.setPassword("a");
        rvkalau1.addPet(new Pet(0, rvkalau1.petId.incrementAndGet(), "cat", "Umka"));
        this.users.add(rvkalau1);
    }

    private static final MemoryStorage INSTANCE = new MemoryStorage();

    public static MemoryStorage getInstance() {
        return INSTANCE;
    }

    public void add(User user) {
        this.users.add(user);
    }

    public void delUserById(int id) {
        for (User user: this.users) {
            if (user.getId() == id) this.users.remove(user);
        }
    }

    public User getUserById(String id) {
        User findUser = null;
        for (User user: this.users) {
            if (user.getId() == Integer.valueOf(id)) findUser = user;
        }
        return findUser;
    }

    public User getUserByLogin(String loginForFind) {
        User findUser = null;
        for (User user: this.users) {
            if (user.getLogin().equals(loginForFind)) findUser = user;
        }
        return findUser;
    }

    public List<User> getAll() {
        return this.users;
    }

    public void update(User user) {
        this.users.remove(user);
        this.users.add(user);
    }

    public void deleteUser(User user) {
        this.users.remove(user);
    }

    public Optional<User>  findByCredentionals(String username, String password) {

        Optional<User> userForReturn = Optional.empty();

        for (User findUser: this.users) {
            if(findUser.getLogin().equals(username)) {
                if (findUser.getPassword().equals(password)) userForReturn = Optional.of(findUser);
            }
        }
        return userForReturn;
    }

}
