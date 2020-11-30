package utils.info;

public @interface NewAlgo {
    String details() default "";
    String learningSource() default "";
}
