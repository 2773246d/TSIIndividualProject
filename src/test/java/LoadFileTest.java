import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class LoadFileTest {


    @Test
    public void getFileDataTestMock(){
        LoadFile loadFileTestMock = spy(LoadFile.class);
        List<String> data = new ArrayList<>();
        data.add("Me,6");
        data.add("Derek,5");
        when(loadFileTestMock.getFileData("Score.txt")).thenReturn(data);
        assertEquals("Derek,5", loadFileTestMock.getFileData("Score.txt").get(1));
    }


}
