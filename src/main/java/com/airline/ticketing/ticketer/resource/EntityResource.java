package com.airline.ticketing.ticketer.resource;

import com.airline.ticketing.ticketer.controller.EntityController;
import com.airline.ticketing.ticketer.data.BaseEntity;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.sql.Date;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
public abstract class EntityResource<ENTITY extends BaseEntity> extends RepresentationModel<EntityResource<ENTITY>> {

    private Long id;

    private Date creationDate;

    private Date lastUpdateDate;

    private String name;

    private String desc;

    public void addLinks(String entityName) {
        add(linkTo(EntityController.class)
                .slash(entityName)
                .slash(id)
                .withRel("get").withType("GET"));
        add(linkTo(EntityController.class)
                .slash(entityName)
                .slash(id)
                .withRel("delete").withType("DELETE"));
        add(linkTo(EntityController.class)
                .slash(entityName)
                .slash(id)
                .withRel("update").withType("PUT"));
        add(linkTo(EntityController.class)
                .slash(entityName)
                .withRel("create new").withType("POST"));
    }

}
