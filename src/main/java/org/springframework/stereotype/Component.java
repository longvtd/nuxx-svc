package org.springframework.stereotype;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Component {
	String value() default "";

	String name() default "";

	String description() default "";

	String summary() default "";

	String method() default "";
}