package com.airline.ticketing.ticketer.service;

import com.airline.ticketing.ticketer.data.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.NoResultException;
import java.lang.reflect.ParameterizedType;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public abstract class EntityService<ENTITY extends BaseEntity> {

    public abstract JpaRepository<ENTITY, Long> getRepository();

    public ENTITY getEntity(Long id) {
        Optional<ENTITY> optional = getRepository().findById(id);
        if (!optional.isPresent()) {
            String errorMessage;
            try {
                errorMessage = getTopicClass().getSimpleName() + " , id : " + id;
            } catch (Exception e) {
                errorMessage = "id : " + id;
            }
            throw new NoResultException(errorMessage);
        }
        return optional.get();
    }

    private Class<ENTITY> getTopicClass() {
        return (Class<ENTITY>)
                ((ParameterizedType) getClass()
                        .getGenericSuperclass())
                        .getActualTypeArguments()[0];
    }

    public ENTITY update(Long id, ENTITY entity) {
        ENTITY old = getEntity(id);
        entity.setId(id);
        LocalDate now = LocalDate.now();
        entity.setLastUpdateDate(Date.valueOf(now));
        entity.setCreationDate(old.getCreationDate());

        return getRepository().saveAndFlush(entity);
    }

    public ENTITY save(ENTITY entity) {
        LocalDate now = LocalDate.now();
        entity.setCreationDate(Date.valueOf(now));
        entity.setLastUpdateDate(Date.valueOf(now));

        return getRepository().saveAndFlush(entity);
    }

    public List<ENTITY> all() {
        return getRepository().findAll();
    }

    public void deleteById(Long id) {
        getRepository().deleteById(id);
    }

}
