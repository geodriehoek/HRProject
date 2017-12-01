package enums;

public enum Country {
    BELGIUM(1), NETHERLANDS(2), GERMANY(3);
    private final int index;

    Country(int index) {
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }

//    helper schrijven die iterate over enum.values() om constante te vinden. om via index op te roepen eerder dan String
}




//    BELGIUM(1, "Belgian"), NETHERLANDS(2, "Dutch"), GERMANY(3, "German");
//    private final int index;
//    private final String nationality;           //wel goe voor bvb. departments??
//
//    Country(int index, String nationality){
//        this.index = index;
//        this.nationality = nationality;
//    }
//    public String getNationality(){
//        return this.nationality;
//    }

