package casestudy.config;

import casestudy.entity.customer.CustomerType;
import casestudy.formatter.CustomerTypeFormatter;
import casestudy.formatter.DivisionFormatter;
import casestudy.formatter.EducationFormatter;
import casestudy.formatter.PositionFormatter;
import casestudy.service.customer.CustomerServiceType;
import casestudy.service.employee.DivisionService;
import casestudy.service.employee.EducationService;
import casestudy.service.employee.PositionService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
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
        registry.addFormatter(new DivisionFormatter(applicationContext.getBean(DivisionService.class)));
        registry.addFormatter(new EducationFormatter(applicationContext.getBean(EducationService.class)));
        registry.addFormatter(new PositionFormatter(applicationContext.getBean(PositionService.class)));
        registry.addFormatter(new CustomerTypeFormatter(applicationContext.getBean(CustomerServiceType.class)));
    }
}
