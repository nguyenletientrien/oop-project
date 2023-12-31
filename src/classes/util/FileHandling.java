package classes.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {

	private String path;

	public boolean displayContent() {
		try {
			final File file = new File(this.path);
			try (Scanner scanner = new Scanner(file)) {
				while (scanner.hasNextLine()) {
					String data = scanner.nextLine();
					System.out.println(data);
				}
			}
		} catch (FileNotFoundException e) {
			return false;
		}
		return true;
	}

	public boolean displayContent(String fileName) {
		try {
			final File file = new File(this.path + fileName);
			try (Scanner scanner = new Scanner(file)) {
				while (scanner.hasNextLine()) {
					String data = scanner.nextLine();
					System.out.println(data);
				}
			}
		} catch (FileNotFoundException e) {
			return false;
		}
		return true;
	}

	protected boolean createDir() {
		File dir = new File(this.path);
		if (!dir.exists())
			return dir.mkdirs();
		return true;
	}

	public static boolean createFile(String fileName, String newNameForOldFile) {
		try {
			File file = new File(fileName);
			if (file.exists())
				file.renameTo(new File(newNameForOldFile));
			file.createNewFile();
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	public static boolean createFile(String fileName) {
		try {
			File file = new File(fileName);
			file.createNewFile();
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	public boolean listFileInDir() {
		final File folder = new File(this.path);
		if (folder.list() == null)
			return false;
		for (final String fileEntry : folder.list()) {
			System.out.println(fileEntry);
		}
		return true;
	}

	protected boolean removeFile(String examFileName) {
		return new File(this.path + examFileName).delete();
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public FileHandling(String path) {
		this.path = path;
	}

	public FileHandling() {
		this.path = null;
	}

}
