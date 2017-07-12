import java.io.File;
import java.io.FileFilter;

public class scanDirectory {
	 static String fullPath = null;
	 static String root = ".";							// racine du workspace Eclipse
	 static String target = "version1.txt";
	
	static String getFullPath() {
		File file = new File(root);
		scanDirectoryRec(file);
		return fullPath;
	}
	static void scanDirectoryRec(File dir) {
		//File file = new File(dir);
		File[] directories = dir.listFiles( 			 // FileFilter to match dir pattern
				new FileFilter() {
				    @Override
				    public boolean accept(File file) {
				        return file.isDirectory();
				    }
				});
		
		if (directories == null || directories.length == 0) return;
		System.out.println("dir size " + directories.length);
		for (File curDir : directories) {
			System.out.println("current path " + curDir);
			scanDirectoryRec(curDir);
			scanFiles(curDir);
		}
	}
	static void scanFiles(File dir) {
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) return;
		
		String current = null;
		for (File file : files) {
			current = file.getName();
			System.out.println("current file " + current);
			if (current.matches(target)) {
				fullPath = file.getAbsolutePath();
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(getFullPath());
	}
}
