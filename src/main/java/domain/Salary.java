package domain;

public class Salary extends Remuneration {
    public static final int MAXINSTANCE = 1;

    public Salary(double cost){
        super(cost);
    }           //Salary=int => Salary(double) coversie-helper?
}
