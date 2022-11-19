import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Validator {

    public static void validateSymbols(String statement)
    {
        Pattern pattern = Pattern.compile("[^0-9\\+\\-\\*\\/ ]");
        Matcher matcher = pattern.matcher(statement);
        boolean matchFound = matcher.find();

        if (matchFound)
        {
            throw new RuntimeException("Unexpected symbol.");
        }
    }

    public static void validatePattern(String statement)
    {
        if (!statement.matches("\\d{1,2}( ?[\\+\\-\\*\\/] ?\\d{1,2}){0,2}"))
        {
            throw new RuntimeException("Invalid statement format.");
        }
    }

    public static void validateNumbersSize(int[] numbers)
    {
        for (int number : numbers)
        {
            if ((number < 1) || (number > 10))
            {
                throw new RuntimeException("Number size is not correct.");
            }
        }
    }
}
