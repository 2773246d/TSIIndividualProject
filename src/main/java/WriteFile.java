import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.List;

public class WriteFile {
    public void writeToFile(String file, List<String> fileData){
        try {
            FileWriter writer = new FileWriter(file);
            for(String line: fileData) {
                writer.write(line + "\n");
            }
            writer.close();
            System.out.println("Successfully saved player stats.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
