package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.service.EntityService;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.to.MealTo;
import ru.javawebinar.topjava.web.AbstractController;

import java.util.Collection;

@Controller
public class MealRestController extends AbstractController<MealTo> {
    private MealService service;

    public MealRestController(@Qualifier("mealService") EntityService service) {
        super(service);
    }

    @Override
    public Collection<MealTo> getAll() {
        return super.getAll();
    }

    @Override
    public MealTo get(int id) {
        return super.get(id);
    }

    @Override
    public MealTo create(MealTo item) {
        return super.create(item);
    }

    @Override
    public void delete(int id) {
        super.delete(id);
    }

    @Override
    public void update(MealTo item, int id) {
        super.update(item, id);
    }
}