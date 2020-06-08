package com.airline.ticketing.ticketer.controller;

import com.airline.ticketing.ticketer.controller.mapper.EntityMapper;
import com.airline.ticketing.ticketer.data.BaseEntity;
import com.airline.ticketing.ticketer.resource.EntityResource;
import com.airline.ticketing.ticketer.service.EntityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public abstract class EntityController<DTO, ENTITY extends BaseEntity, RESOURCE extends EntityResource> {

    public abstract EntityService<ENTITY> getService();

    public abstract EntityMapper<DTO, ENTITY, RESOURCE> getMapper();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<RESOURCE> get(@PathVariable("id") Long id) {
        RESOURCE resource = getMapper().toResource(getService().getEntity(id));
        resource.addLinks(getService().getTopicClass().getSimpleName().toLowerCase());
        return ResponseEntity.ok(resource);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<RESOURCE> update(@PathVariable("id") Long id, @RequestBody DTO dto) {
        ENTITY entity = getMapper().toEntity(dto);
        RESOURCE resource = getMapper().toResource(getService().update(id, entity));
        resource.addLinks(getService().getTopicClass().getSimpleName().toLowerCase());
        return ResponseEntity.ok(resource);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<RESOURCE> save(@RequestBody DTO dto) {
        ENTITY entity = getMapper().toEntity(dto);
        RESOURCE resource = getMapper().toResource(getService().save(entity));
        resource.addLinks(getService().getTopicClass().getSimpleName().toLowerCase());
        return ResponseEntity.ok(resource);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<RESOURCE>> all() {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") Long id) {
        getService().deleteById(id);
        return ResponseEntity.ok().build();
    }
}
