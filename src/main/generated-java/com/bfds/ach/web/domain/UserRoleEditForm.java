/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-jsf2-spring-conversation:src/main/java/domain/EditForm.e.vm.java
 */
package com.bfds.ach.web.domain;

import javax.inject.Inject;
import javax.inject.Named;

import com.bfds.ach.domain.UserRole;
import com.bfds.ach.repository.UserRoleRepository;
import com.bfds.ach.web.domain.UserRoleController;
import com.bfds.ach.web.domain.support.GenericEditForm;
import com.bfds.ach.web.faces.ConversationContextScoped;

/**
 * View Helper/Controller to edit {@link UserRole}.
 */
@Named
@ConversationContextScoped
public class UserRoleEditForm extends GenericEditForm<UserRole, Long> {
    @Inject
    protected UserRoleController userRoleController;

    @Inject
    public UserRoleEditForm(UserRoleRepository userRoleRepository) {
        super(userRoleRepository);
    }

    /**
     * The entity to edit/view.
     */
    public UserRole getUserRole() {
        return getEntity();
    }

    public String print() {
        return userRoleController.print(getUserRole());
    }
}