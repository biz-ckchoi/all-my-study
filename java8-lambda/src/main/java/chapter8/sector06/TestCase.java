package chapter8.sector06;


import java.lang.annotation.Repeatable;


@Repeatable(TestCases.class)
public @interface TestCase {

    String params();
    String expected();

}
