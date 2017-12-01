package domain;

import enums.Country;

public class Department extends BaseEntity {
    private int id;
    private static int idCount;
    private String name;
    private String description;
    private Address address;
//    private LinkedList<Worker> workers;

    public Department(){
        this.id = idCount++;
    }
    public Department(String name){
        this.id = idCount++;
        this.setName(name);
    }
    public Department(String name, String description){
        this.id = idCount++;
        this.setName(name);
        this.setDescription(description);
    }

    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setAddress(Address address){
        this.address = address;
    }
    public void setAddress(String street, int number, int ZIP, String city, Country country){
        this.address = new Address(street, number, ZIP, city, country);
    }

    public String getName(){
        return this.name;
    }
    public String getDescription(){
        return this.description;
    }
    public Address getAddress(){ return this.address;}
    public String getCity(){ return this.address.getCity();}
    public String getStreet(){ return this.address.getStreet();}
    public int getStreetNumber(){ return this.address.getNumber();}
    public int getZip(){ return this.address.getZIP();}
    public Country getCountry(){ return this.address.getCountry();}

}
