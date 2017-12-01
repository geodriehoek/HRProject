package domain;

public class Project extends BaseEntity{
    private Integer projectId;
    private static int idCount = 0;
    private String name;
    private String description;

    public Project(){
        super();
        this.projectId = idCount++;
    }
    public Project(String name){
        this();
        this.setName(name);
    }
    public Project(String name, String description){
        this();
        this.setName(name);
        this.setDescription(description);
    }

    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public String getName(){
        return this.name;
    }
    public String getDescription(){
        return this.description;
    }
    public int getProjectId(){return this.projectId;}

}
