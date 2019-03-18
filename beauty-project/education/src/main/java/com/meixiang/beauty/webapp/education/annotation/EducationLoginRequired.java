package com.meixiang.beauty.webapp.education.annotation;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * Created by zbm84 on 2017/5/24.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Mapping
@Documented
public @interface EducationLoginRequired {
}
