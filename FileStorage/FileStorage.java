package FileStorage;
import java.io.FileWriter;
import java.io.IOException;

public class FileStorage {
    public static synchronized void logTrade(String trade) {

        try {

            FileWriter writer = new FileWriter("trades.txt", true);

            writer.write(trade + "\n");

            writer.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}
