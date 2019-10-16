package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.model.AbstractBaseEntity;
import ru.javawebinar.topjava.service.EntityService;

import java.util.Collection;

import static ru.javawebinar.topjava.util.ValidationUtil.assureIdConsistent;
import static ru.javawebinar.topjava.util.ValidationUtil.checkNew;

public abstract class AbstractController <Entity extends AbstractBaseEntity> {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    protected EntityService<Entity> service;

    @Autowired
    public AbstractController(EntityService service) {
        this.service = service;
    }

    public Collection<Entity> getAll() {
        log.info("getAll");
        return service.getAll();
    }

    public Entity get(int id) {
        log.info("get {}", id);
        return service.get(id);
    }

    public Entity create(Entity item) {
        log.info("create {}", item);
        checkNew(item);
        return service.create(item);
    }

    public void delete(int id) {
        log.info("delete {}", id);
        service.delete(id);
    }

    public void update(Entity item, int id) {
        log.info("update {} with id={}", item, id);
        assureIdConsistent(item, id);
        service.update(item);
    }
}