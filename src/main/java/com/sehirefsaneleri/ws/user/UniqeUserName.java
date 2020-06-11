package com.sehirefsaneleri.ws.user;

/*
 * Jakarta Bean Validation API
 *
 * License: Apache License, Version 2.0
 * See the license.txt file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */



import static java.lang.annotation.ElementType.FIELD;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * The annotated element must not be {@code null}.
 * Accepts any type.
 *
 * @author Emmanuel Bernard
 */
@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = { UniqeUsernameValidator.class})
public @interface UniqeUserName {
	
	String message() default "sehirefsaneleri.constraints.UniqeUsername.message";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };


}
