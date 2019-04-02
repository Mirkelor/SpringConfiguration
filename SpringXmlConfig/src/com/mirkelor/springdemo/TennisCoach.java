package com.mirkelor.springdemo;

public class TennisCoach implements Coach{
//  Fields
//  =========================================================================
    private FortuneService fortuneService;
    private String email;
    private String team;
    private String name;
//  =========================================================================

//  This section defines xml with constructor argument and property name with ref
//  ======================================================================================================
    public TennisCoach(FortuneService fortuneService) { this.fortuneService = fortuneService; }

    public void setFortuneService(FortuneService fortuneService) { this.fortuneService = fortuneService; }
//  ======================================================================================================


//  This section is necessary to set fields based on property files
//  =========================================================================
    public void setEmail(String email) { this.email = email; }
    public void setTeam(String team) { this.team = team; }
    public void setName(String name) { this.name = name; }
//  =========================================================================

//  This section is retrieve data in main class
//  =========================================================================
    public String getEmail() { return email; }
    public String getTeam() { return team; }
    public String getName() { return name; }
//  =========================================================================
    @Override
    public String getDailyWorkout() { return "Practice fast bowling for 15 minutes"; }
    @Override
    public String getDailyFortune() { return fortuneService.getFortune(); }

//  This section is for set method after bean initializing and before bean destroying
//  =======================================================================================================
    public void doMyStartupStuff(){ System.out.println(">> TennisCoach: inside method doMyStartupStuff"); }
    public void doMyCleanupStuff(){ System.out.println(">> TennisCoach: inside method doMyCleanupStuff"); }
//  =======================================================================================================

}
