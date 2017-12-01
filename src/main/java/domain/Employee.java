package domain;

public class Employee extends Worker {
    private Manager manager;
    private static final int MINREMUN = 2;
    public static final double REMUNMODIFIER = 1;

    public void setManager(Manager manager){
        this.manager = manager;
    }

    public Manager getManager(){
        return this.manager;
    }


    public Employee(String firstName, String lastName, String ssn, Salary salary){
        super(firstName, lastName, ssn, salary);
    }
    public Employee withManager(Manager manager) {
        this.manager = manager;
        return this;
    }

}
