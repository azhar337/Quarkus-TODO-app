package org.azhar.database;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class DatabaseRepository extends PanacheEntity {

    public String email;

    public String todo;

    public boolean status = false;

}
