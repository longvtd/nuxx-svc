package io.swagger.v3.oas.annotations.tags;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Tag {
	String value() default "";

	String name() default "";

	String description() default "";

	String summary() default "";

	String method() default "";
}