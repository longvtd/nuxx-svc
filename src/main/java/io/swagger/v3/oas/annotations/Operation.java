package io.swagger.v3.oas.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Operation {
	String value() default "";

	String name() default "";

	String description() default "";

	String summary() default "";

	String method() default "";
}