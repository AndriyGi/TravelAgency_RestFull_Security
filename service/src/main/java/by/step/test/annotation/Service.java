package by.step.test.annotation;

public @interface Service {

    String name();
    boolean lasyload() default false;
}
