package org.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Ocean lin on 2020/2/25.
 *
 * @author Ocean lin
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface MyService {

    public String value();
}
