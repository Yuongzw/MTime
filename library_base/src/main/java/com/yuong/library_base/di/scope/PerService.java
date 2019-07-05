package com.yuong.library_base.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created yuong
 */
@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PerService {
}
