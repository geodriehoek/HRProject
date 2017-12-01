package domain;

import enums.Country;

public class Address extends BaseEntity{
    private String street;
    private int number;
    private int ZIP;
    private String city;
    private Country country;
    private double longitude;
    private double latitude;

    public Address(String street, int number, int ZIP, String city, Country country){
        super();
        this.street = street;
        this.number = number;
        this.ZIP = ZIP;
        this.city = city;
        this.country = country;
    }

    public String getStreet() {
        return this.street;
    }
    public int getNumber(){
        return this.number;
    }
    public int getZIP(){
        return this.ZIP;
    }
    public String getCity(){
        return this.city;
    }
    public Country getCountry(){
        return this.country;
    }

    //set???

//    We valideren of adres correct is (we gebruiken de Google Maps API)

    @Override
    public String toString(){
        return ("[" + this.street + " " + this.number + ", " + this.ZIP + " " + this.city + ", " + this.country + "]");
    }

}
