package cdi2;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;


/**
 * Any CID bean annotated with Startup and ApplicationScoped will start when the application is
 * deployed
 * 
 * @author lucas.persson
 * 
 */
@Qualifier
@Retention(RUNTIME)
@Target({ TYPE })
public @interface Startup {
}
