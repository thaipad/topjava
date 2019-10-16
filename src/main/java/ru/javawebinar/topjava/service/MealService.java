package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.to.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.Collection;

import static ru.javawebinar.topjava.util.MealsUtil.createTo;
import static ru.javawebinar.topjava.util.ValidationUtil.checkNotFoundWithId;
import static ru.javawebinar.topjava.web.SecurityUtil.authUserId;

@Service("mealService")
public class MealService implements EntityService<MealTo> {

    private MealRepository repository;

    @Autowired
    public MealService(MealRepository repository) {
        this.repository = repository;
    }

    @Override
    public MealTo create(MealTo mealTo) {
        Meal meal = new Meal(mealTo.getDateTime(), mealTo.getDescription(), mealTo.getCalories(), authUserId());
        return createTo(repository.save(meal), false);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    public MealTo get(int id) throws NotFoundException {
        return checkNotFoundWithId(createTo(repository.get(id), false), id);
    }

    @Override
    public Collection<MealTo> getAll() {
        return MealsUtil.getTos(repository.getAll(authUserId()), MealsUtil.DEFAULT_CALORIES_PER_DAY);
    }

    @Override
    public void update(MealTo mealTo) throws NotFoundException {
        Meal meal = new Meal(mealTo.getId(), mealTo.getDateTime(), mealTo.getDescription(), mealTo.getCalories(), authUserId());
        checkNotFoundWithId(repository.save(meal), meal.getId());
    }
}