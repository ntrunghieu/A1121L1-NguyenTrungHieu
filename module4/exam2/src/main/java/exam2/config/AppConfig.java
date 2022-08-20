package exam2.config;

import exam2.formatter.DateFormatter;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer, ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    @Override
    public void addFormatters(FormatterRegistry registry) {
//        registry.addFormatter(new DanhMucFormatter(applicationContext.getBean(DanhMucService.class)));
//
//
        registry.addFormatter(new DateFormatter());
//        registry.addConverter(new DateConverter());

    }
}

