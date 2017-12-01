package domain;

import java.util.HashMap;

public class Director extends Worker {
    private static final int MINREMUN = 4;
    private HashMap<Integer, Integer> revenueGoals;
    public static final double REMUNMODIFIER = 1.1;

    public void setRevenueGoal(int year, int goal){
        this.revenueGoals.put(year, goal);
    }       //check voor het jaartal?

    public HashMap<Integer, Integer> getRevenueGoals(){
        return this.revenueGoals;
    }

    public int getRevenueGoal(int year){
        return revenueGoals.get(year);
    }

    public Director(String firstName, String lastName, String ssn, Salary salary){
        super(firstName, lastName, ssn, salary);
    }


}