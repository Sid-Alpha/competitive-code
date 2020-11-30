package utils.info;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface Enhance {
    String details() default "";
    Stat[] reduce() default Stat.NONE;
    Stat[] complexity() default Stat.NONE;
    String[] otherSolutions() default "";
    boolean updated() default false;
}
