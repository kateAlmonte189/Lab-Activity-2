// Subclass for files
public class File extends FileNode {
    public File(String name) {
        super(name, false); // A file is not a directory
    }
}