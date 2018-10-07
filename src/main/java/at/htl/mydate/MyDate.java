package at.htl.mydate;

/**
 * Informationen zu Enums: http://tutorials.jenkov.com/java/enums.html
 *               zu split: https://stackoverflow.com/a/3481842/9818338
 *   zur Ermittlung des Wochentages: https://de.wikipedia.org/wiki/Wochentagsberechnung#Programmierung
 */
public class MyDate {

    private int day;
    private int month;
    private int year;
    private String weekday;
    private int dayyounger = 31;
    private int monthyounger = 12;
    private int yearyounger = Integer.MAX_VALUE;


    /**
     * Formatierung des Datums
     *
     * @return String, zB Samstag, 29. September 2018
     */

    public MyDate(String dateString){
        extracteDate(dateString);

    }

    private void extracteDate(String dateString) {
        String [] date = dateString.split("\\.");
        this.day = Integer.valueOf(date[0]);
        this.month = Integer.valueOf(date[1]);
        this.year = Integer.valueOf(date[2]);
    }

    private String weekday() {
        int weekday1 = ((day + (int)(2.6 * ((month + 9) % 12 + 1) - 0.2)
                + year % 100 + (int)(year % 100 / 4) + (int)(year / 400)
                - 2 * (int)(year / 100) - 1) % 7 + 7) % 7 + 1;

        switch (weekday1){
            case 0:
                weekday = String.valueOf(Weekday.MONDAY);
                break;
            case 1:
                weekday = String.valueOf(Weekday.TUESDAY);
                break;
            case 2:
                weekday = String.valueOf(Weekday.WEDNESDAY);
                break;
            case 3:
                weekday = String.valueOf(Weekday.THURSDAY);
                break;
            case 4:
                weekday = String.valueOf(Weekday.FRIDAY);
                break;
            case 5:
                weekday = String.valueOf(Weekday.SATURDAY);
                break;
            case 6:
                weekday = String.valueOf(Weekday.SUNDAY);
        }
        return weekday;
    }



    public String formatDate() {

        String date = "";

        weekday = weekday();

        date = weekday + "," + day + "." + month + "." + year;


        return date;

    }

    /**
     *  Überprüfen, ob ein übergebenes Datum (other) jünger oder älter ist
     *
     * @return true, wenn this-Datum jünger als other-Datum ist
     *         false, wenn this-Datum jünger oder gleich other-Datum ist
     */
    public boolean isYoungerThan() {

        Boolean younger = false;

        if (year < yearyounger){
             younger = true;
        }else if (year == yearyounger && month <= monthyounger){
                if (month < monthyounger){
                    younger = true;
                }else if (day < dayyounger){
                    younger = true;
                }
        }

        if(younger){
            dayyounger = day;
            monthyounger = month;
            yearyounger = year;
        }

        return younger;

    }



    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getWeekday() {
        return weekday;
    }

}


