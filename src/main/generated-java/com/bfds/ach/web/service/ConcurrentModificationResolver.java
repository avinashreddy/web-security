/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-jsf2-spring-conversation:src/main/java/services/ConcurrentModificationResolver.p.vm.java
 */
package com.bfds.ach.web.service;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.bfds.ach.web.conversation.ConversationManager;

/**
 * Simple service used from the concurrentModificationResolution.xhtml view.
 */
@Named
@Singleton
public class ConcurrentModificationResolver {

    @Inject
    private ConversationManager conversationManager;

    public String refresh() {
        return conversationManager.getCurrentConversation().getCurrentContext().getCallBack().ok(null);
    }

    public String discard() {
        conversationManager.endCurrentConversation();
        return "/home.faces?faces-redirect=true";
    }
}