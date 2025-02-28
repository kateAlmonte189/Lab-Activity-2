import java.util.ArrayList;
import java.util.List;

// Base class representing a file system node
public class FileNode {
    String name;
    boolean isDirectory;
    List<FileNode> children;

    // Constructor to initialize a file or folder
    public FileNode(String name, boolean isDirectory) {
        this.name = name;
        this.isDirectory = isDirectory;
        this.children = new ArrayList<>();
    }

    // Method to add a child node (file or folder)
    public void addChild(FileNode child) {
        if (this.isDirectory) {
            this.children.add(child);
        }
    }
}