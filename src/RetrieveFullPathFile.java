import java.io.File;
import java.io.FileFilter;

public class RetrieveFullPathFile {

	static private final String fileName = "app";
	static private final String rootDirectory = "C:\testnode";
	static private String FullPath = null;
	
	static void retrieveFullPathFile() {
		scanDirectories(rootDirectory);
	}
	
	
	static void scanDirectories(String path) {
		String current = null;
		File[] directories = getDirectories(path);
		if (directories == null) return;
		for (File d : directories) {
			current = d.getName();
		}
		scanDirectories(current);
		scanFiles(path);	
	}
	
	static void scanFiles(String path) {
		File[] files = getFiles(path);
		if (files == null) return;
		for (File file : files) {
			if(file.getName().matches(fileName)) {
				FullPath = path + file;
			}
		}
	}
	static File[] getDirectories(String path) {
		FileFilter bDirectory = new FileFilter() {
		    @Override
		    public boolean accept(File file) {
		        return file.isDirectory();
		    }
		};
		File f = new File(path);
		return f.listFiles(bDirectory);
	}
	
	static File[] getFiles(String path) {
		File f = new File(path);
		return f.listFiles();
	}
	public static void main(String args[]) {
		retrieveFullPathFile();
		System.out.println("path complet : " + FullPath);
	}
}
