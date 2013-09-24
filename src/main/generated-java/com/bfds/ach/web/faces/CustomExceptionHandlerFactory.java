/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-jsf2-spring-conversation:src/main/java/faces/CustomExceptionHandlerFactory.p.vm.java
 */
package com.bfds.ach.web.faces;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

public class CustomExceptionHandlerFactory extends ExceptionHandlerFactory {

    private ExceptionHandlerFactory wrapped;

    /**
     * Construct a new full conversation aware exception handler factory around the given wrapped factory.
     * @param wrapped The wrapped factory.
     */
    public CustomExceptionHandlerFactory(ExceptionHandlerFactory wrapped) {
        this.wrapped = wrapped;
    }

    /**
     * Returns a new instance of {@link CustomExceptionHandler} which wraps the original exception handler.
     */
    @Override
    public ExceptionHandler getExceptionHandler() {
        return new CustomExceptionHandler(wrapped.getExceptionHandler());
    }

    /**
     * Returns the wrapped factory.
     */
    @Override
    public ExceptionHandlerFactory getWrapped() {
        return wrapped;
    }
}