package domain;

public abstract class Remuneration extends BaseEntity {         // abstract??
    private int id;
    private static int remunId = 0;
    private double cost;

    public Remuneration(double cost){
        super();
        this.id = remunId++;
        this.cost = cost;
    }

    public double getCost(){
        return cost;
    }
    public void setCost(double cost){
        this.cost = cost;
    }
}
