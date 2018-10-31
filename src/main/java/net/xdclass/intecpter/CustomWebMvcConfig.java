package net.xdclass.intecpter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by chengjiapeng on 2018/9/12.
 *
 * Spring2.x 开始
 */
@Configuration
public class CustomWebMvcConfig implements WebMvcConfigurer{
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //先进
        registry.addInterceptor(new LoginInteceptor()).addPathPatterns("/api2/*/**").excludePathPatterns("/api2/xxx/**");
        //后进
        registry.addInterceptor(new TwoInteceptor()).addPathPatterns("/api2/*/**").excludePathPatterns("/api2/xxx/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
