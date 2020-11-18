package com.bjsxt.test.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value= {ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SxtMethod {
	String columnName();
	String type();
	int length();

}
