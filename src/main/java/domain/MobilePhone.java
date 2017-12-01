package domain;


import static utilities.Parser.*;

public class MobilePhone extends Remuneration {
    public static final int MAXINSTANCE = 2;
    private MobilePhoneType type;
    private Long msisdn;            //10 cijfers, startend met 0


    public MobilePhone(MobilePhoneType type, double cost, Long msisdn){         //super() moet eerst komen, doch moet msisdn gecheckt worden
        super(cost);
        if(checkmsisdn(msisdn)) {
            this.type = type;
            this.msisdn = msisdn;
        }else{/*throw illegalargumentexception*/}
    }

    public void setType(MobilePhoneType type) {
        this.type = type;
    }
    public void setMsisdn(Long msisdn) {
        this.msisdn = msisdn;
    }

    public MobilePhoneType getType() {
        return type;
    }
    public Long getMsisdn() {
        return msisdn;
    }

    public boolean checkmsisdn(Long msisdn){
        String pattern = "0\\d9";                           //just??
        String msisdnString = msisdn.toString();
        String firstNumber = msisdnString.substring(0, 1);
        return (stringToInt(firstNumber)==0 && msisdnString.matches(pattern));
    }

    public enum MobilePhoneType{
        PRIVATE, PROFESSIONAL
    }
}
