import java.util.regex.Pattern;

public class regexFloatTimeLicencePlate {
    public static void main(String[] args) {

        String year = "\\d\\d\\d\\d-";
        String time = "T(([01]\\d)|(2[0-3])):[0-5]\\d:[0-5]\\d:\\d\\d\\d";
        String longmonth ="(((0[13578])|(10)|(12))-((0[1-9]|[12]\\d)|(3[01])))";
        String shortmonth ="(((0[469])|(11))-((0[1-9]|[12]\\d)|(30)))";
        String february = "(02-((0[1-9]|1\\d)|2\\d))";
        String zeitpunkt = year + "(" + longmonth + "|"+ shortmonth +"|"+ february +")" + time;

        String ganzeZahl = "([+-]?0|([-+]?[1-9]\\d*))";
        String dezimal = "((\\.(\\d+))?";
        String exponent = "([Ee](0|(-?[1-9]\\d*)))?)?";
        String gleitkomma = ganzeZahl + dezimal + exponent;

        String city = "[A-ZÄÜÖ][A-ZÄÜÖ]?[A-ZÄÜÖ]?";
        String letters = "[A-ZÄÜÖ][A-ZÄÜÖ]?";
        String digits = "[1-9]\\d?\\d?\\d?";
        String kennzeichen = city + " " + letters + " " + digits + "( [HE])?";
    }
}
