package utilities;

public abstract class Parser {
    public final static int stringToInt(String string){
        return Integer.parseInt(string);
    }

    public final static String intToString(Integer integer){
        return String.valueOf(integer);
    }

    public final static String longToString(Long l){ return String.valueOf(l);}

    public final static Long stringToLong(String string){ return Long.parseLong(string);}
}
