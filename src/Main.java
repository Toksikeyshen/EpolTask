import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class Main {
    public static void main (String[] args) throws IOException, SQLException {
        ArrayList<String> input;
        ArrayList<String> count;
        ArrayList<String> output = new ArrayList<>();
        Parsing parsing = new Parsing();
        input = parsing.readFile("D:\\EpolTest\\src\\file");
        int unique = parsing.numOfUnique(input);
        int single = parsing.numOfSingle(input);
        count = parsing.maxCount(input);

        output.add(String.valueOf(input.size()));
        output.add(String.valueOf(unique));
        output.add(String.valueOf(single));
        output.add(count.get(0));
        output.add(count.get(1));
        System.out.println(output);

        Handler handler = new Handler();
       // handler.createDb();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        handler.inertResult( String.valueOf(dateFormat.format(cal.getTime())),input, output);
    }
}
