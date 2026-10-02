package org.springframework.context.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Configuration {
	String value() default "";

	String name() default "";

	String description() default "";

	String summary() default "";

	String method() default "";
}