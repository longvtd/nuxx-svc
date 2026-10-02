package org.springdoc.core.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface ParameterObject {
	String value() default "";

	String name() default "";

	String description() default "";

	String summary() default "";

	String method() default "";
}