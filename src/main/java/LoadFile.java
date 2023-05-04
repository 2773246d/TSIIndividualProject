import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoadFile implements Load{


    public List<String> getFileData( String fileName){
        List<String> fileData = new ArrayList<String>();
        try {
            File propertyFile = new File(fileName);
            Scanner propertyReader = new Scanner(propertyFile);
            while (propertyReader.hasNextLine()) {
                String fileRow = propertyReader.nextLine();
                fileData.add(fileRow);
            }
            propertyReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return fileData;
    }

    @Override
    public List<String> getLastLines(String fileName, int numberOfLines) {
        return null;
    }
}
