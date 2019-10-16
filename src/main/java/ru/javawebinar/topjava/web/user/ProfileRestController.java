package ru.javawebinar.topjava.web.user;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.service.EntityService;
import ru.javawebinar.topjava.web.AbstractController;

import static ru.javawebinar.topjava.web.SecurityUtil.authUserId;

@Controller
public class ProfileRestController extends AbstractController<User> {

    public ProfileRestController(@Qualifier("userService") EntityService service) {
        super(service);
    }

    public User get() {
        return super.get(authUserId());
    }

    public void delete() {
        super.delete(authUserId());
    }

    public void update(User user) {
        super.update(user, authUserId());
    }
}