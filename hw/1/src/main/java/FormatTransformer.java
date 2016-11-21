import com.google.gson.GsonBuilder;
import com.sun.deploy.util.StringUtils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Martin Melka (martin.melka@gmail.com)
 * 18.10.2016 22:14
 */
public class FormatTransformer {
    // regexp to capture trip, location and person's name (as a single string, non-separated)
    final static Pattern pattern = Pattern.compile("trip[^\"]*\"(\\d+)\"\\s*\\n*\\s*location[^\"]*\"([^\"]*)\"\\s*\\n\\s*person[^\"]*\"([^\"]*)\"", Pattern.CASE_INSENSITIVE);

    public static void main(String[] args) {
        for (String text : Texts.texts) {
            System.out.println("*********************************************\nINPUT:");
            System.out.println(text + "\n\n    ##########################\n\n");

            String transformed = transformText(text);

            System.out.println(transformed + "*********************************************");
        }
    }

    private static String transformText(String text) {
        Matcher m = pattern.matcher(text);
        if (m.find()) {
            String id = m.group(1);
            String location = m.group(2);
            String name = m.group(3);

            // Split obtained name and create firstname, lastname and middlename if there are 1, 2 or 3+ space-separated
            // tokens, respectively.
            String[] nameTokens = name.split(" ");
            String firstName = null;
            String midName = null;
            String lastName = null;
            if (nameTokens.length >= 1) firstName = nameTokens[0];
            if (nameTokens.length >= 2) lastName = nameTokens[nameTokens.length - 1];
            if (nameTokens.length >= 3)
                midName = StringUtils.join(Arrays.asList(
                        Arrays.copyOfRange(nameTokens, 1, nameTokens.length - 1)), " ");

            return new GsonBuilder().setPrettyPrinting().create().toJson(new Trip(id, location, new Person(firstName, midName, lastName)));
        } else {
            System.out.println("Pattern did not match. Could not parse input. Sorry.");
            return "";
        }
    }
}

class Trip {
    private String id;
    private String location;
    private Person person;

    public Trip(String id,
                String location,
                Person person) {
        this.id = id;
        this.location = location;
        this.person = person;
    }
}

class Person{
    private String name;
    private String middlename;
    private String surname;

    public Person(String name, String middlename, String surname) {
        this.name = name;
        this.middlename = (middlename == null || middlename.isEmpty() ? null : middlename);
        this.surname = surname;
    }
}

class Texts {
    final static String[] texts = {
            "test Trip \"23\"",
            "Dear Sir or Madam,\n" +
                    "\n" +
                    "please find the details about my booking below:\n" +
                    "\n" +
                    "===\n" +
                    "Trip id: \"1\"\n" +
                    "Location: \"Bohemian Switzerland\"\n" +
                    "Person: \"Jan Novak\"\n" +
                    "===\n" +
                    "\n" +
                    "Regards,\n" +
                    "Jan Novak",
            "trip ID: \"169\"\n" +
                    "Location: \"Hogwarts\"\n" +
                    "Person: \"Nikdo\"",
            "I have a dream, folks.\n" +
                    "\n" +
                    "Trip id: \"42\"\n" +
                    "Location: \"Dreamland\"\n" +
                    "Person: \"Martin Luther King\"\n" +
                    "===",
            "Dear Sir or Madam,\n" +
                    "\n" +
                    "===\n" +
                    "Trip id: \"666\"\n" +
                    "Location: \"Highway to Hell\"\n" +
                    "Person: \"Devil Himself the Almighty\"\n" +
                    "===\n" +
                    "\n" +
                    "Thanks,\n" +
                    "Satan"
    };
}


