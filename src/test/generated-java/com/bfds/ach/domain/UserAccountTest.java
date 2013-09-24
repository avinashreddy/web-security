/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/test/java/domain/ModelTest.e.vm.java
 */
package com.bfds.ach.domain;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static org.fest.assertions.Assertions.assertThat;

import java.io.*;
import java.io.Serializable;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import org.junit.Test;

import com.bfds.ach.domain.UserRole;
import com.bfds.ach.util.*;

/**
 * Basic tests for UserAccount
 */
@SuppressWarnings("unused")
public class UserAccountTest {

    // test unique primary key
    @Test
    public void newInstanceHasNoPrimaryKey() {
        UserAccount model = new UserAccount();
        assertThat(model.isIdSet()).isFalse();
    }

    @Test
    public void isIdSetReturnsTrue() {
        UserAccount model = new UserAccount();
        model.setId(ValueGenerator.getUniqueLong());
        assertThat(model.getId()).isNotNull();
        assertThat(model.isIdSet()).isTrue();
    }

    //-------------------------------------------------------------
    // Pure Many to Many
    //-------------------------------------------------------------

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @Test
    public void manyToMany_addRole() {
        UserAccount many1 = new UserAccount();
        UserRole many2 = new UserRole();

        // add it
        many1.addRole(many2);

        // check it is propagated
        assertThat(many1.getRoles()).contains(many2);
        // now let's remove it
        many1.removeRole(many2);

        // check it is propagated
        assertThat(many1.getRoles().contains(many2)).isFalse();
    }

    /*
     public void equalsUsingPk() {
     UserAccount model1 = new UserAccount();
     UserAccount model2 = new UserAccount();

     Long id = ValueGenerator.getUniqueLong();
     model1.setId(id);
     model2.setId(id);

     model1.setPassword("a");
     model2.setPassword("a");

     model1.setUserName("a");
     model2.setUserName("a");

     model1.setVersion(1);
     model2.setVersion(1);
     assertThat(model1.isIdSet()).isTrue();
     assertThat(model2.isIdSet()).isTrue();
     assertThat(model1.hashCode()).isEqualTo(model2.hashCode());
     assertThat(model1).isEqualTo(model2);
     assertThat(model2).isEqualTo(model1);
     }
     */
}