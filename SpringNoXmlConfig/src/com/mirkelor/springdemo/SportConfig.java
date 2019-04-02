package com.mirkelor.springdemo;

import org.springframework.context.annotation.*;

@Configuration
@PropertySources({
        @PropertySource("sport.properties"),
        @PropertySource("coach.properties")
})
//@ComponentScan("com.mirkelor.springdemo")
class SportConfig {

    // define bean for fortune service
    @Bean
    public FortuneService fortuneService(){
        return new RandomFortuneService();
    }

    // define bean for tennis coach and inject dependency
    @Bean
    @Scope("prototype")
    public Coach tennisCoach(){
        return new TennisCoach(fortuneService());
    }

}
