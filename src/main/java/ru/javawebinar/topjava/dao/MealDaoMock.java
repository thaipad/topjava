package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MealDaoMock implements MealDao {
    private static final List<Meal> meals;

    static {
        meals = Stream.of(
                new Meal(LocalDateTime.of(2019, 10, 14, 8, 00), "Омлет", 450),
                new Meal(LocalDateTime.of(2019, 10, 14, 14, 30), "Стейк", 1500),
                new Meal(LocalDateTime.of(2019, 10, 14, 21, 00), "Творог", 80),
                new Meal(LocalDateTime.of(2019, 10, 15, 7, 00), "Овсяная каша", 150),
                new Meal(LocalDateTime.of(2019, 10, 15, 13, 40), "Пицца", 900),
                new Meal(LocalDateTime.of(2019, 10, 15, 19, 10), "Салат", 20)
        ).collect(Collectors.toList());
    }

    @Override
    public void add(Meal meal) {
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Meal meal) {

    }

    @Override
    public Meal getById(int id) {
        return null;
    }

    @Override
    public List<Meal> getAll() {
        return new ArrayList<>(meals);
    }
}
