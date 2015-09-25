package cdi;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author lucas.persson
 *
 */
@Qualifier
@Retention(RUNTIME)
@Target({ TYPE })
public @interface StoreName {
  String value();
}
