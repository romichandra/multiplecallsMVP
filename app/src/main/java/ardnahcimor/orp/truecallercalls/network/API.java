package ardnahcimor.orp.truecallercalls.network;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by romichandra on 27-08-2017.
 */
@Target(METHOD)
@Retention(RUNTIME)
public @interface API {
    String desricption() default "testApiVersion";
}
