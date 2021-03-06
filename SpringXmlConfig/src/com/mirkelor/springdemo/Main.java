package com.mirkelor.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args){

        // load the spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve bean from spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

        Boolean result = (theCoach == alphaCoach);

        // call methods from bean
        System.out.println("\nYour daily workout: " + theCoach.getDailyWorkout());
        System.out.println("Your daily fortune: " + theCoach.getDailyFortune());

        System.out.println("\nEmail: " + ((TennisCoach) theCoach).getEmail());
        System.out.println("Team: " + ((TennisCoach) theCoach).getTeam());
        System.out.println("Name: " + ((TennisCoach) theCoach).getName());

        System.out.println("\nBoth beans are same: " + result);
        System.out.println("\nMemory name for theCoach: " + theCoach);
        System.out.println("\nMemory name for alphaCoach: " + alphaCoach + "\n");

        // close
        context.close();

    }
}
