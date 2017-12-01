package domain;

import java.util.HashSet;

public class Manager extends Worker {
    private Director director;
    private static final int MINREMUN = 3;
    public static final double REMUNMODIFIER = 1.05;
    private HashSet<Employee> employees;
//    verantwoordelijk voor employee's?

    public void setDirector(Director director){
        this.director = director;
    }
    public void setEmployee(Employee emp){ this.employees.add(emp);}
//    public void setEmployees(Employee[]...)

    public Director getDirector(){
        return this.director;
    }
    public HashSet<Employee> getEmployees(){ return this.employees;}
    public Employee searchAndGetEmployee(String firstName, String lastName){
        return employees.stream()
                        .filter(i-> (i.getFirstName().equals(firstName) && (i.getLastName().equals(lastName))))
                        .findFirst()
                        .get();
    }
    public Employee searchAndGetEmployee(int id){
        return employees.stream()
                        .filter(i-> (i.getId().equals(id)))
                        .findFirst()
                        .get();
    }


    public Manager(String firstName, String lastName, String ssn, Salary salary){
        super(firstName, lastName, ssn, salary);
    }
    public Manager withDirector(Director director) {
        this.director = director;
        return this;
    }
}
