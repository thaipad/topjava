package ru.javawebinar.topjava.web.meal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.MealTestData;
import ru.javawebinar.topjava.UserTestData;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.inmemory.InMemoryMealRepository;
import ru.javawebinar.topjava.repository.inmemory.InMemoryUserRepository;
import ru.javawebinar.topjava.to.MealTo;
import ru.javawebinar.topjava.util.exception.NotFoundException;
import ru.javawebinar.topjava.web.user.AdminRestController;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static ru.javawebinar.topjava.MealTestData.*;
import static ru.javawebinar.topjava.UserTestData.ADMIN;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-mock.xml"
})
@RunWith(SpringRunner.class)
public class InMemoryMealRestControllerSpringTest {

    @Autowired
    private MealRestController controller;

    @Autowired
    private InMemoryMealRepository repository;

    @Before
    public void setUp() throws Exception {
        repository.init();
    }

    @Test
    public void delete() throws Exception {
        controller.delete(M161200.getId());
        List<Meal> meals = controller.getAll().stream()
                .map( m -> new Meal(m.getId(), m.getDateTime(), m.getDescription(), m.getCalories()))
                .collect(Collectors.toList());
        assertEquals(meals.size(), 5);
        Iterator<Meal> iterator = meals.iterator();
        assertEquals(iterator.next(), M171930);
        assertEquals(iterator.next(), M171300);
        assertEquals(iterator.next(), M170730);
        assertEquals(iterator.next(), M161900);
        assertEquals(iterator.next(), M160800);
    }

    @Test(expected = NotFoundException.class)
    public void deleteNotFound() throws Exception {
        controller.delete(10);
    }
}
