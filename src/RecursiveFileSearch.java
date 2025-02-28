import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RecursiveFileSearch {

    // Method to recursively search for files with a specific extension
    public static boolean searchFiles(FileNode node, String extension, FileWriter writer) throws IOException {
        boolean fileFound = false; // Flag to track if any file is found

        if (!node.isDirectory) {
            // If it's a file, check if it matches the extension
            if (node.name.endsWith(extension)) {
                String result = "File found: " + node.name + "\n";
                writer.write(result);
                System.out.print("✓ " + result); //comment
                fileFound = true;
            }
        } else {
            // If it's a folder, recursively search its children
            for (FileNode child : node.children) {
                if (searchFiles(child, extension, writer)) {
                    fileFound = true;
                }
            }
        }

        return fileFound;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n*******************************************");
        System.out.println("*          RECURSIVE FILE SEARCH          *");
        System.out.println("*******************************************\n");

        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        System.out.println("\nName: Kate Cassandra G. Almonte");
        System.out.println("Section: ITCC 11.1 - A");

        System.out.print("\nEnter file extension to search for (e.g., .txt): ");
        String extension = scanner.nextLine();

        // Creating a mock file system
        Folder root = new Folder(directoryPath);
        Folder subFolder = new Folder("subfolder");
        File file1 = new File("notes.txt");
        File file2 = new File("todo.txt");
        File file3 = new File("image.png");

        root.addChild(file1);
        root.addChild(subFolder);
        subFolder.addChild(file2);
        root.addChild(file3);

        // Perform the search and write results to a file
        try (FileWriter writer = new FileWriter("search_results.txt")) {
            System.out.println("\nSearching...");
            boolean fileFound = searchFiles(root, extension, writer);

            if (!fileFound) {
                System.out.println("No file found with extension: " + extension);
                writer.write("No file found with extension: " + extension + "\n");
            } else {
                System.out.println("\nSearch completed. Results saved to search_results.txt.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        System.out.println("\n*********************************************");
        System.out.println("*           THANK YOU FOR USING!           *");
        System.out.println("*********************************************");

        scanner.close();
    }
}