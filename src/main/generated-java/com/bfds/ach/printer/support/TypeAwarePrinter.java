/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/main/java/printer/support/TypeAwarePrinter.p.vm.java
 */
package com.bfds.ach.printer.support;

import static com.google.common.collect.Maps.newHashMap;
import static org.hibernate.proxy.HibernateProxyHelper.getClassWithoutInitializingProxy;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.i18n.LocaleContextHolder;

/**
 * Given the type of the object use the corresponding {@link GenericPrinter}, or use {@link #toString()} method.
 */
@Named("printer")
public class TypeAwarePrinter {
    private Map<Class<?>, GenericPrinter<?>> printers = newHashMap();

    @Inject
    void buildCache(List<GenericPrinter<?>> registredPrinters) {
        for (GenericPrinter<?> printer : registredPrinters) {
            printers.put(printer.getTarget(), printer);
        }
    }

    public String print(Object object) {
        return print(object, LocaleContextHolder.getLocale());
    }

    @SuppressWarnings("unchecked")
    public String print(Object object, Locale locale) {
        if (object == null) {
            return "";
        }

        // note: getClassWithoutInitializingProxy expects a non null object
        // _HACK_ as we depend on hibernate here.
        @SuppressWarnings("rawtypes")
        GenericPrinter printer = printers.get(getClassWithoutInitializingProxy(object));
        return printer == null ? object.toString() : printer.print(object, locale);
    }
}