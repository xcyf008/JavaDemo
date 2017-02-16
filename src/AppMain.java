import java.util.StringJoiner;

/**
 * Created by timothy on 16/7/17.
 */
public class AppMain {

    public static void main(String[] args) {

        try {
            throwException();
        } catch (Exception ex) {
            String msg = exceptionToString(ex);
            System.out.println(msg);
        }
    }

    public static String strackTraceToString(StackTraceElement[] traces) {
        if (traces ==  null || traces.length == 0) return "";

        StringJoiner joiner = new StringJoiner("\r\n");
        for (StackTraceElement ele : traces) {
            joiner.add(ele.toString());
        }

        return joiner.toString();
    }

    public static String exceptionToString(Exception exception) {
        if (exception == null) return "";
        StringJoiner joiner = new StringJoiner("\r\n");
        joiner.add(exception.getMessage());
        for(StackTraceElement ele : exception.getStackTrace()) {
            joiner.add(ele.toString());
        }

        return joiner.toString();
    }

    public static void throwException() {
        throw new IllegalArgumentException("Test Test");
    }
}
