package com.airline.ticketing.ticketer.controller;

import com.airline.ticketing.ticketer.controller.mapper.EntityMapper;
import com.airline.ticketing.ticketer.data.BaseEntity;
import com.airline.ticketing.ticketer.resource.EntityResource;
import com.airline.ticketing.ticketer.service.EntityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(path = "/search/{text}", method = RequestMethod.GET)
    public ResponseEntity<Page<RESOURCE>> search(@PathVariable("text") String text,
                                                 @RequestParam(defaultValue = "0", required = false) Integer pageNo,
                                                 @RequestParam(defaultValue = "10", required = false) Integer pageSize,
                                                 @RequestParam(defaultValue = "id", required = false) String sortBy,
                                                 @RequestParam(defaultValue = "ASC", required = false) String direction) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.Direction.valueOf(direction), sortBy);
        return ResponseEntity.ok(
                getService().pageableSearch(pageable, text).map(
                        entity -> {
                            RESOURCE resource = getMapper().toResource(entity);
                            resource.addLinks(getService().getTopicClass().getSimpleName().toLowerCase());
                            return resource;
                        }
                )
        );
    }
}
