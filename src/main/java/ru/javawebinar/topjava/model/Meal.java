package ru.javawebinar.topjava.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Meal extends AbstractBaseEntity {

    private final LocalDateTime dateTime;

    private final String description;

    private final int calories;

    private final int ownerId;

    public Meal(LocalDateTime dateTime, String description, int calories, int ownerId) {
        this(null, dateTime, description, calories, ownerId);
    }

    public Meal(Integer id, LocalDateTime dateTime, String description, int calories, int ownerId) {
        super(id);
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        this.ownerId = ownerId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public LocalDate getDate() {
        return dateTime.toLocalDate();
    }

    public LocalTime getTime() {
        return dateTime.toLocalTime();
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                '}';
    }
}
