package hello.core.scan.filter;

import java.lang.annotation.*;

// Annotation 만드는 것
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {
}
