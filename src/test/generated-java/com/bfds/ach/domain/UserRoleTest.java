/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/test/java/domain/ModelTest.e.vm.java
 */
package com.bfds.ach.domain;

import static org.fest.assertions.Assertions.assertThat;

import java.io.*;
import java.io.Serializable;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import org.junit.Test;

import com.bfds.ach.util.*;

/**
 * Basic tests for UserRole
 */
@SuppressWarnings("unused")
public class UserRoleTest {

    // test unique primary key
    @Test
    public void newInstanceHasNoPrimaryKey() {
        UserRole model = new UserRole();
        assertThat(model.isIdSet()).isFalse();
    }

    @Test
    public void isIdSetReturnsTrue() {
        UserRole model = new UserRole();
        model.setId(ValueGenerator.getUniqueLong());
        assertThat(model.getId()).isNotNull();
        assertThat(model.isIdSet()).isTrue();
    }

    /*
     public void equalsUsingPk() {
     UserRole model1 = new UserRole();
     UserRole model2 = new UserRole();

     Long id = ValueGenerator.getUniqueLong();
     model1.setId(id);
     model2.setId(id);

     model1.setRoleName("a");
     model2.setRoleName("a");

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