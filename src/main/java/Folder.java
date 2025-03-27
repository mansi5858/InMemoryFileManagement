import java.util.HashMap;
import java.util.Map;

public class Folder {

    Map<String, String> files;
    Map<String, Folder> subFolders;
    public Folder()
    {
        files = new HashMap<>();
        subFolders = new HashMap<>();
    }

}
