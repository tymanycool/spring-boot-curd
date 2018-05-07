package com.tianyao.springbootcurd.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Component("localeResolver")
public class MyLocale implements LocaleResolver{
    Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String lang = request.getParameter("lang");
        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(lang)){
            String[] split = lang.split("_");
            locale = new Locale(split[0],split[1]);
        }
        logger.debug("国际化。。。。");
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, @Nullable HttpServletResponse httpServletResponse, @Nullable Locale locale) {

    }
}
