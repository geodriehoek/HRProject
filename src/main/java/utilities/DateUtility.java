package utilities;

//import javax.print.attribute.standard.Finishings;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public abstract class DateUtility {

    public final static LocalDate converDateToLocalDate(Date date) {
        return new java.sql.Date(date.getTime()).toLocalDate();
    }

    public final static long convertLocalDateToEpoch(LocalDate localDate) {
        ZoneId zoneId = ZoneId.systemDefault();
        return localDate.atStartOfDay(zoneId).toEpochSecond();
    }

    public final static Date convertLocalDateToDate(LocalDate localDate) {
        return java.sql.Date.valueOf(localDate);
    }

    public final static boolean checkDateOfBirth(int d, int m, int y){            //algemenere check??? lambda's??
        LocalDate now = LocalDate.now();
        LocalDate dateOfBirth = LocalDate.of(y, m, d);

        Period p = Period.between(dateOfBirth, now);
        return (p.getYears()>=18);
    }

    public final static boolean checkHireDate(int d, int m, int y, LocalDate dateOfBirth){
        LocalDate now = LocalDate.now();
        LocalDate hireDate = LocalDate.of(y, m, d);
        Period p = Period.between(now, hireDate);
        return (hireDate.isAfter(dateOfBirth) && p.getMonths()<=2);
    }
}