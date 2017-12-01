package domain;

public abstract class BaseEntity {
    private Integer id;
    private static int uniqueID = 0;

    public BaseEntity(){
        this.id = uniqueID++;
    }

    public Integer getId(){
        return this.id;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof BaseEntity)) return false;
        BaseEntity other = (BaseEntity) o;
        return other.getId().equals(this.getId());
    }
}
