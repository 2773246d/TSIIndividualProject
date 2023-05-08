import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WriteFileTest {

    WriteFile writeFileTest = new WriteFile();
    @Test

    public void writeToFileTest(){
        LoadFile loadFileTest = new LoadFile();
        List<String> fileData = new ArrayList<>();
        fileData.add("Derek,1");
        fileData.add("Darren,2");
        writeFileTest.writeToFile("Scores.txt", fileData);
        fileData = loadFileTest.getFileData("Scores.txt");
        assertEquals("Derek,1", fileData.get(0));
    }

}
