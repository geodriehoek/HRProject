package utilities;


import java.time.LocalDate;

import static utilities.Parser.*;
//import static enums.Gender.*;                   //zeker nog checken
import enums.Gender;

public abstract class Checks {                                                              //exceptions?
    private static final String ssnPattern = "\\d2\\.\\d2\\.\\d2-\\d3\\.\\d2";
//    private String ssn;
//    private int ssnBirthYSubstring;                                                         //kan men gebruikmaken van zowel variabelen als statische methoden



    public final static boolean checkSsn(String ssn, LocalDate dateOfBirth, Gender gender){             //ssn = yy.mm.dd-iii.jj
        return (ssn.matches(ssnPattern) && checkDOB(ssn,dateOfBirth) && checkGender(ssn,gender) && checkCheckDigits(ssn));

//        if(!ssn.matches(ssnPattern)){
//            return false;
//            //log "wrong pattern"
//        }

    }

    public final static boolean checkDOB(String ssn, LocalDate dob){
        int ssnBirthYSubstring = stringToInt(ssn.substring(0, 2));
        int ssnBirthMSubstring = stringToInt(ssn.substring(3, 5));
        int ssnBirthDSubstring = stringToInt(ssn.substring(6, 8));

        return (ssnBirthYSubstring == dob.getYear() &&
                ssnBirthMSubstring == dob.getMonthValue() &&
                ssnBirthDSubstring == dob.getDayOfMonth());
    }

    public final static boolean checkGender(String ssn, Gender gender){
        int ssnGenderSubstring = stringToInt(ssn.substring(9, 12));
        return ((Gender.FEMALE == gender && ssnGenderSubstring % 2 == 0)
                || (Gender.MALE == gender && ssnGenderSubstring % 2 != 0));

//        if (Gender.FEMALE == gender) {
//            return (ssnGenderSubstring % 2 == 0);
//        } else if(Gender.MALE == gender){
//            return (ssnGenderSubstring % 2 != 0);
//        }else{return false;}
    }                              //voorkeur/performantie tss beiden??   "||" zou geen 2x true mogen ontvangen

    public final static boolean checkCheckDigits(String ssn){
        int ssnCheckSubstringResult = stringToInt(ssn.substring(13, 15));
        String ssnSplice = ssn.replaceAll("\\.", "").replace("-", "");         //klopt da wel?
        int ssnCheckSubstringDividend = stringToInt(ssnSplice.substring(0, 9));

        int ssnBirthYSubstring = stringToInt(ssn.substring(0, 2));
        if(ssnBirthYSubstring >= 0 && ssnBirthYSubstring < 40){
            String ssnMillenial = "2" + ssn;
            ssnCheckSubstringDividend = stringToInt(ssnMillenial);
        }

        return (97 - (ssnCheckSubstringDividend%97) == ssnCheckSubstringResult);
    }
}