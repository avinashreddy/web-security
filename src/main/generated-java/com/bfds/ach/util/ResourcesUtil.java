/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/main/java/util/ResourcesUtil.p.vm.java
 */
package com.bfds.ach.util;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * ResourcesUtil allows you to retrieve localized resources for the locale present in the current thread of execution.
 * It can be used from both Spring beans (simple dependency injection) and from non spring beans. In the later case,
 * you obtain the reference thanks to the static method ResourcesUtil.getInstance()
 */
@Named
@Singleton
@Lazy(false)
public class ResourcesUtil {

    private static ResourcesUtil instance;
    private MessageSource messageSource;

    @Inject
    public ResourcesUtil(MessageSource ms) {
        messageSource = ms;
        instance = this;
    }

    /**
     * Call it from non spring aware code to obtain a reference to the ResourcesUtil singleton instance.
     */
    public static ResourcesUtil getInstance() {
        return instance;
    }

    /**
     * Return the {@link MessageSource} that backs this ResourcesUtil.
     */
    public MessageSource getMessageSource() {
        return messageSource;
    }

    /**
     * Return the property value for the contextual locale.
     * If no value is found, the given key is returned.
     */
    public String getProperty(String key, Object... args) {
        if (key == null) {
            return "";
        }

        return messageSource.getMessage(key, args, LocaleContextHolder.getLocale());
    }

    /**
     * Same as {@link #getProperty(String, Object...)} but use the count to choose the proper key.
     * Used when the message varies depending on the context. 
     * <p>
     * For example: 
     * <ul>
     * <li>there is no result</li>
     * <li>there is one result</li>
     * <li>there are n results</li>
     * </ul>
     * @param key the base key
     */
    public String getPluralableProperty(String key, int count) {
        if (key == null) {
            return "";
        }

        switch (count) {
        case 0:
            return getProperty(key + "_0");
        case 1:
            return getProperty(key + "_1");
        default:
            return getProperty(key + "_n", count);
        }
    }
}