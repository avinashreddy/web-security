/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-jsf2-spring-conversation:src/main/java/filter/LocaleResolverRequestFilter.p.vm.java
 */
package com.bfds.ach.web.filter;

import static org.apache.commons.lang.StringUtils.isNotBlank;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.LocaleUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.LocaleResolver;

/**
 * Set the current {@link Locale} in the {@link LocaleContextHolder}
 */
public class LocaleResolverRequestFilter extends OncePerRequestFilter {
    private static final Logger log = LoggerFactory.getLogger(LocaleResolverRequestFilter.class);

    public static final String LOCALE_PARAMETER = "locale";

    private LocaleResolver localeResolver;

    @Override
    protected void initFilterBean() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        localeResolver = context.getBean(LocaleResolver.class);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        forceLocaleFromParameter(request, response);
        try {
            LocaleContextHolder.setLocale(localeResolver.resolveLocale(request));
            filterChain.doFilter(request, response);
        } finally {
            LocaleContextHolder.resetLocaleContext();
        }
    }

    private void forceLocaleFromParameter(HttpServletRequest request, HttpServletResponse response) {
        String localeParameter = null;
        try {
            localeParameter = request.getParameter(LOCALE_PARAMETER);
            if (isNotBlank(localeParameter)) {
                Locale locale = LocaleUtils.toLocale(localeParameter);
                log.info("forcing locale to {}", locale.getLanguage());
                localeResolver.setLocale(request, response, locale);
            }
        } catch (IllegalArgumentException e) {
            log.error("Locale " + localeParameter + " is not valid");
        }
    }
}
