import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DAO {

    private Repository repository;
    private Formatter formatter;

    public DAO() {
        repository = new Repository();
        formatter = new Formatter();
    }

    public void load() {
        String path = System.getenv("LOCALAPPDATA");
        path += "\\Warframe\\EE.log";
        System.out.println("\nAccessing log at " + path);

        try {
            File file = new File(path);
            BufferedReader in = new BufferedReader(new FileReader(file));
            boolean named = false;
            boolean dated = false;

            String line;
            while ((line = in.readLine()) != null) {
                if (!dated) {
                    if (line.contains("Current time:")) {
                        repository.addTime(formatter.startTimeFormatter(line));
                        dated = true;
                    }
                }

                if (!named) {
                    if (line.contains("Logged in")) {
                        repository.addName(formatter.nameFormatter(line));
                        named = true;
                    }
                }
                if (line.contains("was killed") || line.contains("was downed")) {
                    repository.addData(formatter.dataFormatter(line));
                }
            }

        } catch (IOException ioe) {
            System.out.println("Unable to read from file: " + ioe.getMessage());
        }
    }

    public void printRepository() {
        repository.print();
    }
}
