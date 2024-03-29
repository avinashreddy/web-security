/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/test/java/service/ModelGenerator.e.vm.java
 */
package com.bfds.ach.repository;

import javax.inject.Named;
import javax.inject.Singleton;

import com.bfds.ach.domain.UserAccount;

/**
 * Helper class to create transient entities instance for testing purposes.
 * Simple properties are pre-filled with random values.
 */
@Named
@Singleton
public class UserAccountGenerator {

    /**
     * Returns a new UserAccount instance filled with random values.
     */
    public UserAccount getUserAccount() {
        UserAccount userAccount = new UserAccount();

        // simple attributes follows
        userAccount.setPassword("a");
        userAccount.setUserName("a");
        return userAccount;
    }

}