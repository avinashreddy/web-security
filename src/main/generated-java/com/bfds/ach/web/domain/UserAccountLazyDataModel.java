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

import com.bfds.ach.domain.UserAccount;
import com.bfds.ach.repository.UserAccountRepository;
import com.bfds.ach.web.domain.UserAccountExcelExporter;
import com.bfds.ach.web.domain.support.GenericLazyDataModel;
import com.bfds.ach.web.faces.ConversationContextScoped;

/**
 * Provide PrimeFaces {@link LazyDataModel} for {@link UserAccount}
 */
@Named
@ConversationContextScoped
public class UserAccountLazyDataModel extends GenericLazyDataModel<UserAccount, Long, UserAccountSearchForm> {
    private static final long serialVersionUID = 1L;

    @Inject
    public UserAccountLazyDataModel(UserAccountRepository userAccountRepository, UserAccountController userAccountController,
            UserAccountSearchForm userAccountSearchForm, UserAccountExcelExporter userAccountExcelExporter) {
        super(userAccountRepository, userAccountController, userAccountSearchForm, userAccountExcelExporter);
    }
}