package util;

import com.google.gson.Gson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Util {
    public static String getFloatStringFromString(String numberString) {
        return String.format("%.2f", Double.parseDouble(numberString));
    }

    public void printObjectToJson(Object object) {
        Gson gson = new Gson();
        System.out.println(gson.toJson(object).toString());
    }

    public static boolean validateJavaDate(String strDate, String dateFormat)
    {
        /* Check if date is 'null' */
        if(strDate.trim().equals("")) {
            return true;
        }else{
            /*
             * Set preferred date format,
             * For example MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.*/
            SimpleDateFormat sdfrmt = new SimpleDateFormat(dateFormat);
            sdfrmt.setLenient(false);
            /* Create Date object
             * parse the string into date
             */
            try
            {
                Date javaDate = sdfrmt.parse(strDate);
            }
            /* Date format is invalid */
            catch (ParseException e)
            {
                return false;
            }
            /* Return true if date format is valid */
            return true;
        }
    }

    public static LocalDate convertStringToDate(String dateStr, String dateFormat){
        if (dateStr.trim().equals("")){
            return null;
        }else{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
            /* Create Date object
             * parse the string into date
             */
            LocalDate date = LocalDate.parse(dateStr, formatter);
            return  date;
        }
    }

    public static long monthsBetweenDates(LocalDate startDate, LocalDate endDate){
        Period periodDiff = Period.between(
                startDate,
                endDate);
        long months = periodDiff.getMonths();
        long days = periodDiff.getDays();

        if(days>0){
            months = months + 1;
        }
        return months;
    }


}
