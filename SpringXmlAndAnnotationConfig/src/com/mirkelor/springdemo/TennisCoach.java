package com.mirkelor.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component
@Scope("prototype")
public class TennisCoach implements Coach{

//  This section inject object from class
//  ===========================================
    @Autowired
    @Qualifier("fileReadFortuneService")
    private FortuneService fortuneService;
//  ===========================================

//  This section read variables from property files
//  ===============================================
    @Value("${p.email}")
    private String email;
    @Value("${p.team}")
    private String team;
    @Value("${p.name}")
    private String name;
//  ==============================================

    public TennisCoach() {
        System.out.println(">> TennisCoach: inside default constructor");
    }

    /*@Autowired
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println(">> TennisCoach: inside setFortuneService() method");
        this.fortuneService = fortuneService;
    }*/

    /*@Autowired
    public TennisCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }*/

    @Override
    public String getDailyWorkout() {
        return "Practice your backend volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

//  Setter methods
//  ===========================================
    public String getEmail() {
        return email;
    }
    public String getTeam() {
        return team;
    }
    public String getName() {
        return name;
    }
//  ===========================================

//  This section runs code for after initalizing bean and before destroying bean
//  ==========================================================================================================
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println(">> TennisCoach: inside method doMyStartupStuff()");
    }
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println(">> TennisCoach: inside method doMyCleanupStuff()");
    }
//  ==========================================================================================================

}
