package ru.javawebinar.topjava.repository.inmemory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.UserRepository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class InMemoryUserRepository implements UserRepository {
    private static final Logger log = LoggerFactory.getLogger(InMemoryUserRepository.class);
    private static Map<Integer, User> users = new ConcurrentHashMap<>();
    private static AtomicInteger lastId = new AtomicInteger(2);

    static {
        users.put(1,
            new User(1, "admin", "admin@mail.ru", "admin", Role.ROLE_ADMIN, Role.ROLE_USER));
        users.put(1,
            new User(2, "user", "user@mail.ru", "user", Role.ROLE_USER));
    }

    @Override
    public boolean delete(int id) {
        log.info("delete {}", id);
        return users.remove(id) != null;
    }

    @Override
    public User save(User user) {
        log.info("save {}", user);
        if (user.isNew()) {
            user.setId(lastId.incrementAndGet());
            users.put(user.getId(), user);
        } else {
            users.computeIfPresent(user.getId(), (i, u) -> user);
        }
        return user;
    }

    @Override
    public User get(int id) {
        log.info("get {}", id);
        return users.get(id);
    }

    @Override
    public List<User> getAll() {
        log.info("getAll");
        return users.values().stream()
            .sorted(Comparator.comparing(User::getName))
            .collect(Collectors.toList());
    }

    @Override
    public User getByEmail(String email) {
        log.info("getByEmail {}", email);
        if (email == null) return null;
        return users.values().stream()
            .filter(u -> email.equals(u.getEmail()))
            .findAny()
            .get();
    }
}
