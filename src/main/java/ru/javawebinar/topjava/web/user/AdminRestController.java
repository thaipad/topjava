package ru.javawebinar.topjava.web.user;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.service.EntityService;
import ru.javawebinar.topjava.web.AbstractController;

import java.util.List;

@Controller
public class AdminRestController extends AbstractController<User> {

    public AdminRestController(@Qualifier("userService") EntityService service) {
        super(service);
    }

    @Override
    public List<User> getAll() {
        return (List<User>) super.getAll();
    }

    @Override
    public User get(int id) {
        return super.get(id);
    }

    @Override
    public User create(User user) {
        return super.create(user);
    }

    @Override
    public void delete(int id) {
        super.delete(id);
    }

    @Override
    public void update(User user, int id) {
        super.update(user, id);
    }

    public User getByMail(String email) {
        return service.getByEmail(email);
    }
}