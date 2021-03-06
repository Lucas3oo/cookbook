package cdi;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

/**
 * Annotation to mark and name an implementation of the Store interface.
 * 
 * @author lucas.persson
 *
 */
@Qualifier
@Retention(RUNTIME)
@Target({ TYPE })
public @interface StoreName {
  String value();
}
