package domain;

import enums.*;

import static utilities.DateUtility.*;
import static utilities.Checks.*;

import java.util.*;
import java.time.*;
import static enums.AddressComponent.*;
import static domain.Remuneration.*;


public abstract class Worker extends BaseEntity {          //implements comparator<Worker??>?? of elders? of aparte WorkerSort-class die comparator<Worker> implementeert??
    private static int MINREMUN;                                    //just?  protected??
    private static double REMUNMODIFIER;
    private String firstName;
    private String lastName;
    private String middleName;
    private Gender gender;
    private HashSet<TransportType> transportTypes;
    private Date dateOfBirth;
    private Date hireDate;
//    private HashMap<AddressComponent, String> address;              //object optioneel
//    private Country country;
    private Address address;
    private String nationality;
    private HashSet<DriversLicense> driversLicenses;           // mix van beide?
    private String ssn;
    private Department department;          //properties: id, naam, omschrijving
    private LinkedList<Project> projects;
    private HashSet<Remuneration> remunerations;

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public void setTransportType(TransportType type) {
        this.transportTypes.add(type);
    }
    public void setDateOfBirth(int d, int m, int y) {
        if (checkDateOfBirth(d, m, y)) {
//            LocalDate dateOfBirth = LocalDate.of(y, m, d);
            this.dateOfBirth = convertLocalDateToDate(LocalDate.of(y, m, d));
        }
    }            //higher level isValid-check?
    public void setHireDate(int d, int m, int y) {
        LocalDate dateOfBirth = this.getLocalDateOfBirth();
        if (checkHireDate(d, m, y, dateOfBirth)) {
            this.hireDate = convertLocalDateToDate(LocalDate.of(y, m, d));
        }
    }            //higher level isValid-check?
    public void setSSN(String ssn) {                    //(..., boolean withBirthDatePresent)???
        if (checkSsn(ssn, this.getLocalDateOfBirth(), this.getGender())) {
            this.ssn = ssn;
        }
    }
    public void addDriversLicense(DriversLicense license){this.driversLicenses.add(license);}
    public void setDepartment(Department department) {
        this.department = department;
    }
    public void setAddress(Address address){
        this.address = address;
    }
    public void setAddress(String street, int number, int ZIP, String city, Country country){
        this.address = new Address(street, number, ZIP, city, country);
    }
    public void setAddress(String street, int number, int ZIP, String city, Country country, boolean withNationality){
        this.address = new Address(street, number, ZIP, city, country);
        if (withNationality) this.setNationality();
    }
    private void setNationality() {
        if (this.address.getCountry() != null){
            switch (this.address.getCountry()) {
                case BELGIUM:
                    this.nationality = "Belgian";
                    break;
                case NETHERLANDS:
                    this.nationality = "Dutch";
                    break;
                case GERMANY:
                    this.nationality = "German";
                    break;
            }
        }
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void addRemun(Remuneration remun){
        if(checkRemun(remun)) {
            remunerations.add(remun);
        }//else log
    }                                       //is dit de mutator() van in de opgave??
    private boolean checkRemun(Remuneration remun) {
        if (!(remun instanceof MobilePhone)) {
            return (remunerations.stream().map(i -> i.getClass()).filter(e -> e.equals(remun.getClass())).count() == 0);
        } else {
            return (remunerations.stream().map(i -> i.getClass()).filter(e -> e.equals(remun.getClass())).count() < 2);
        }
    }

    public void newProject() {
        projects.add(new Project());
    }
    public void newProject(String name) {
        projects.add(new Project(name));
    }
    public void newProject(String name, String description) {
        projects.add(new Project(name, description));
    }
    public void updateProject(String name, String description) {
        for (Project entry : projects) {
            if (entry.getName() == name) {
                entry.setDescription(description);
            }
        }
    }           //beide met streams?
    public void updateName(String name, String newName) {
        for (Project entry : projects) {
            if (entry.getName() == name) {
                entry.setName(newName);
            }
        }
    }


    public String getFullName() {
        return (this.firstName + " " + this.lastName + " (" + this.middleName + ")");
    }
    //    public String getFullName(String[]...){}
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String getMiddleName() {
        return this.middleName;
    }
    public Gender getGender() {
        return this.gender;
    }
    public String getDateOfBirth() {
        return this.dateOfBirth.toString();
    }
    public Date getDateDateOfBirth() {
        return this.dateOfBirth;
    }
    public LocalDate getLocalDateOfBirth() {
        return converDateToLocalDate(getDateDateOfBirth());
    }
    public String getHireDate() {
        return this.hireDate.toString();
    }
    public Date getHireDateDate() {
        return this.hireDate;
    }
    public LocalDate getHireLocalDate() {
        return converDateToLocalDate(getHireDateDate());
    }
    public String getSsn(){ return this.ssn;}
    public Address getAddress(){ return this.address;}
    public String getCity(){ return this.address.getCity();}
    public String getStreet(){ return this.address.getStreet();}
    public int getStreetNumber(){ return this.address.getNumber();}
    public int getZip(){ return this.address.getZIP();}
    public Country getCountry(){ return this.address.getCountry();}
    public String getNationality() {
        return this.nationality;
    }
    public Set<TransportType> getTransportTypes() {
        return this.transportTypes;
    }
    public Department getDepartment() {
        return department;
    }
    public LinkedList<Project> getProjects() {
        return projects;
    }
    public Project getProject(String name) {
        return projects.stream().filter(p -> p.getName().equals(name)).findFirst().get();
//        for (Project p : projects) {
//            if (name.equals(p.getName())) {
//                return p;
//            } else {
//            } //return "invalid";
//        }
//        Optional<Project> foundProject = projects.stream().filter(p -> p.getName().equals(name)).findFirst();
//        return foundProject.get();
    }                               //throws NoSuchElementException
    public Project getProject(Integer id) {
        return projects.stream().filter(p -> p.getId()==id).findFirst().get();
//        for (Project p : projects) {
//            if (id.equals(p.getId())) {
//                return p;
//            } else {
//            } //return "invalid";
//        }
    }                               //throws NoSuchElementException
    public Set<DriversLicense> getDriverslicenses(){return this.driversLicenses;}
    public boolean hasDriversLicense(DriversLicense type){return this.driversLicenses.contains(type);}
    public HashSet<Remuneration> getRemunerations(){return this.remunerations;}             //???
//    public int getMINREMUN(){ return this.MINREMUN;}                                                              //just?

    public int calcSeniority() {
        LocalDate now = LocalDate.now();
        return Period.between(getHireLocalDate(), now).getDays();
    }
    public double calculateTotalIncentiveCost(){
        double sumtotal = 0;
        for(Remuneration r: remunerations){
            sumtotal += r.getCost();
        }
        return sumtotal *= this.REMUNMODIFIER;
    }               //abstract in opgave?

    public Worker(String firstName, String lastName, String ssn, Salary salary){
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        setSSN(ssn);
        addRemun(salary);
    }
    public Worker withMiddleName(String middleName){
        this.middleName = middleName;
        return this;
    }
    public Worker withGender(Gender gender){
        this.gender = gender;
        return this;
    }
    public Worker withTransportType(TransportType type){
        this.transportTypes.add(type);
        return this;
    }
    public Worker withTransportTypes(TransportType[] types){
        this.transportTypes.addAll(Arrays.asList(types));
        return this;
    }
    public Worker withAddress(String street, int number, int ZIP, String city, Country country, boolean withNationality){
        this.setAddress(street, number, ZIP, city, country, withNationality);
        return this;
    }
    public Worker withAddress(String street, int number, int ZIP, String city, Country country){
        this.setAddress(street, number, ZIP, city, country);
        return this;
    }
    public Worker withAddress(Address address){
        this.setAddress(address);
        return this;
    }
    public Worker withSSN(String ssn){
        this.setSSN(ssn);
        return this;
    }
    public Worker withNationality(String nationality){
        this.nationality = nationality;
        return this;
    }
    public Worker withNationality(){
        this.setNationality();
        return this;
    }
    public Worker withDateOfBirth(int d, int m, int y){
        this.setDateOfBirth(d, m, y);
        return this;
    }
    public Worker withHireDate(int d, int m, int y){
        this.setHireDate(d, m, y);
        return this;
    }
    public Worker withDepartment(Department department){
        this.department = department;
        return this;
    }
    public Worker withRemun(Remuneration remun){
        this.addRemun(remun);
        return this;
    }
    public Worker withRemun(HashSet<Remuneration> remuns){
            remunerations.addAll(remuns);
            return this;
    }

    public boolean isValid() {
        if (getLocalDateOfBirth() == null ||
                getHireLocalDate() == null ||
                getFirstName() == null ||
                getLastName() == null ||
                getSsn() == null ||
                getAddress() == null ) {
            return false;
        }
        if (!checkDateOfBirth(this.getLocalDateOfBirth().getDayOfMonth(),
                                this.getLocalDateOfBirth().getMonthValue(),
                                this.getLocalDateOfBirth().getYear())) {
            return false;
        }
        if (!checkHireDate(this.getHireLocalDate().getDayOfMonth(),
                            this.getHireLocalDate().getMonthValue(),
                            this.getHireLocalDate().getYear(),
                            this.getLocalDateOfBirth())) {
            return false;
        }
        return true;
    }                               //waar gebruiken? liefst voor het maken van object?


}

