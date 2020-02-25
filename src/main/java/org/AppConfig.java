package org;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by Ocean lin on 2020/2/24.
 *
 * @author Ocean lin
 */

@Configuration
@ComponentScan("org.dao")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {
}
