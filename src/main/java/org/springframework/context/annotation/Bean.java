package org.springframework.context.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Bean {
	String value() default "";

	String name() default "";

	String description() default "";

	String summary() default "";

	String method() default "";
}