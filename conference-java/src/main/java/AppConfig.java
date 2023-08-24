import com.pluralsight.util.CalendarFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;

@Configuration
@ComponentScan({"com.pluralsight"})
public class AppConfig {

    @Bean(name = "cal")
    public CalendarFactory calFactory() {
        CalendarFactory factory = new CalendarFactory();
        factory.addDays(2);
        return factory;
    }

    @Bean
    public Calendar cal() throws Exception {
        return calFactory().getObject();
    }


    /*@Bean(name="speakerService")
    @Scope(value = BeanDefinition.SCOPE_SINGLETON) //Same memory direction and object
    //@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)  // Different memory direction and objects
    public SpeakerService getSpeakerService() {
        SpeakerServiceImpl service = new SpeakerServiceImpl();
//        SpeakerServiceImpl service = new SpeakerServiceImpl(getSpeakerRepository());
        //service.setRepository(getSpeakerRepository());
        return service;
    }

    @Bean(name="speakerRepository")
    public SpeakerRepository getSpeakerRepository() {
        return new HibernateSpeakerRepositoryImpl();
    }*/

}
