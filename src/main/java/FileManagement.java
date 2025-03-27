import java.util.*;

public class FileManagement {

        Folder home;

        public FileManagement() {
            home = new Folder();
        }

        public List<String> ls(String path) {

            Folder currFolder = home;
            List<String> lst = new ArrayList<>();
            String[] struct = path.split("/");
            int length = struct.length;
            if(length == 0)
            {
                lst.addAll(currFolder.files.keySet());
                lst.addAll(currFolder.subFolders.keySet());
                Collections.sort(lst);
                return lst;
            }

            for(int i=1; i<length-1; i++)
            {
                currFolder = currFolder.subFolders.get(struct[i]);

            }
            String last = struct[length - 1];
            if(last == "")
                return lst;
            if(currFolder.subFolders.containsKey(last))
            {
                currFolder = currFolder.subFolders.get(last);
                lst.addAll(currFolder.files.keySet());
                lst.addAll(currFolder.subFolders.keySet());
                Collections.sort(lst);
            }
            else
            {
                lst.add(last);
            }

            return lst;

        }

        public void mkdir(String path) {

            Folder currFolder = home;
            String[] struct = path.split("/");

            for(int i=1; i<struct.length; i++)
            {
                if( !currFolder.subFolders.containsKey(struct[i]))
                    currFolder.subFolders.put(struct[i], new Folder());

                currFolder = currFolder.subFolders.get(struct[i]);
            }

        }

        public void addContentToFile(String filePath, String content) {
            Folder currFolder = home;
            String[] struct = filePath.split("/");

            for(int i=1; i<struct.length-1; i++)
            {
                currFolder = currFolder.subFolders.get(struct[i]);
            }
            String fileName = struct[struct.length -1];
            currFolder.files.put(fileName, currFolder.files.getOrDefault(fileName, "") + content);
        }

        public String readContentFromFile(String filePath) {

            Folder currFolder = home;
            String[] struct = filePath.split("/");

            for(int i=1; i<struct.length-1; i++)
            {
                currFolder = currFolder.subFolders.get(struct[i]);
            }

            return currFolder.files.get(struct[struct.length - 1]);

        }
    }


