/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-jsf2-spring-conversation:src/main/java/domain/LazyDataModel.e.vm.java
 */
package com.bfds.ach.web.domain;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.LazyDataModel;

import com.bfds.ach.domain.UserRole;
import com.bfds.ach.repository.UserRoleRepository;
import com.bfds.ach.web.domain.UserRoleExcelExporter;
import com.bfds.ach.web.domain.support.GenericLazyDataModel;
import com.bfds.ach.web.faces.ConversationContextScoped;

/**
 * Provide PrimeFaces {@link LazyDataModel} for {@link UserRole}
 */
@Named
@ConversationContextScoped
public class UserRoleLazyDataModel extends GenericLazyDataModel<UserRole, Long, UserRoleSearchForm> {
    private static final long serialVersionUID = 1L;

    @Inject
    public UserRoleLazyDataModel(UserRoleRepository userRoleRepository, UserRoleController userRoleController, UserRoleSearchForm userRoleSearchForm,
            UserRoleExcelExporter userRoleExcelExporter) {
        super(userRoleRepository, userRoleController, userRoleSearchForm, userRoleExcelExporter);
    }
}