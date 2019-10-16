package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.model.AbstractBaseEntity;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.Collection;

import static ru.javawebinar.topjava.util.ValidationUtil.checkNotFoundWithId;

public interface EntityService<Entity> {

    Entity create(Entity item);
    void delete(int id) throws NotFoundException;
    Entity get(int id) throws NotFoundException;
    Collection<Entity> getAll();
    void update(Entity item) throws NotFoundException;
    default Entity getByEmail(String email) throws NotFoundException {
        throw new NotFoundException("Not implemented");
    }
}