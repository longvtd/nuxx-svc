package org.springframework.transaction.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Transactional {
	String value() default "";

	String name() default "";

	String description() default "";

	String summary() default "";

	String method() default "";
}