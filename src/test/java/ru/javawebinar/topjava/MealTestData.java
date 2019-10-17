package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.time.LocalDateTime;
import java.util.Arrays;

import static java.time.LocalDateTime.*;
import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

public class MealTestData {
    public static final int USER_ID = START_SEQ;
    public static final int ADMIN_ID = START_SEQ + 1;

    public static final User USER = new User(USER_ID, "User", "user@yandex.ru", "password", Role.ROLE_USER);
    public static final User ADMIN = new User(ADMIN_ID, "Admin", "admin@gmail.com", "admin", Role.ROLE_ADMIN);
    public static final Meal M160800 = new Meal(of(2019,10,16,8,0,0), "Завтрак", 500);
    public static final Meal M161200 = new Meal(of(2019,10,16,12,0,0), "Обед", 1000);
    public static final Meal M161900 = new Meal(of(2019,10,16,19,0,0), "Ужин", 600);
    public static final Meal M170730 = new Meal(of(2019,10,17,7,30,0), "Завтрак", 300);
    public static final Meal M171300 = new Meal(of(2019,10,17,13,0,0), "Обед", 900);
    public static final Meal M171930 = new Meal(of(2019,10,17,19,30,0), "Ужин", 600);
    public static final Meal M160800A = new Meal(of(2019,10,16,8,0,0), "Завтрак админа", 300);
    public static final Meal M161200A = new Meal(of(2019,10,16,12,0,0), "Обед админа", 900);
//    public static final Meal M160800 = new Meal(START_SEQ + 2, of(2019,10,16,8,0,0), "Завтрак", 500);
//    public static final Meal M161200 = new Meal(START_SEQ + 3, of(2019,10,16,12,0,0), "Обед", 1000);
//    public static final Meal M161900 = new Meal(START_SEQ + 4, of(2019,10,16,19,0,0), "Ужин", 600);
//    public static final Meal M170730 = new Meal(START_SEQ + 5, of(2019,10,17,7,30,0), "Завтрак", 300);
//    public static final Meal M171300 = new Meal(START_SEQ + 6, of(2019,10,17,13,0,0), "Обед", 900);
//    public static final Meal M171930 = new Meal(START_SEQ + 7, of(2019,10,17,19,30,0), "Ужин", 600);
//    public static final Meal M160800A = new Meal(START_SEQ + 8, of(2019,10,16,8,0,0), "Завтрак админа", 300);
//    public static final Meal M161200A = new Meal(START_SEQ + 9, of(2019,10,16,12,0,0), "Обед админа", 900);

    public static void assertMatch(Meal actual, Meal expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected);
    }

    public static void assertMatch(Iterable<Meal> actual, Meal... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Meal> actual, Iterable<Meal> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields().isEqualTo(expected);
    }
}
