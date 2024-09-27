package com.offline.codeassistant;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {
	private static Scanner scanner = new Scanner(System.in);

	// Function to create a file with a name provided by the user
	public static void createFile(String folderPath, String fileName) {
		try {

			File file = new File(folderPath + "/" + fileName);

			if (file.createNewFile()) {
				System.out.println("File created: " + file.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occured while Creating.");
			e.printStackTrace();
		}

	}

	// Function to write to file
	public static void writerFile(String filePath, String content) {
		try {
			FileWriter writer = new FileWriter(filePath);
			writer.write(content);
			writer.close();
			System.out.println("Successfully wrote to the file.");

		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("An error occured while Writing.");
			e.printStackTrace();
		}

	}

	// function to read from a file
	public static void readFile(String filePath) {
		try {
			File file = new File(filePath);
			System.out.println(filePath);
			Scanner reader = new Scanner(file);
			while (reader.hasNextLine()) {
				String data = reader.nextLine();
				System.out.println(data);

			}
			reader.close();
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("An error occured while reading.");
			e.printStackTrace();
		}

	}

	// Function to append content to a file
	public static void appendToFile(String filePath, String content) {
		try {
			FileWriter writer = new FileWriter(filePath, true);
			writer.write(content);
			writer.close();
			System.out.println("Successfully appended to the file.");

		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("An error occured while appending.");
			e.printStackTrace();
		}

	}

	// Function to delete a file
	public static void deleteFile(String folderPath) {
		File file = new File(folderPath);
		if (file.delete()) {
			System.out.println("Deleted the file: " + file.getName());
		} else {
			System.out.println("Failed to deleted the file.");
		}

	}

	// Function to list all files in the folder
	public static void listFileInFolder(String filePath) {
		File folder = new File(filePath);
		File[] listOfFiles = folder.listFiles();

		if (listOfFiles != null && listOfFiles.length > 0) {
			System.out.println("Files in folder: ");
			for (File file : listOfFiles) {
				if (file.isFile()) {
					System.out.println(file.getName());
				}
			}
		} else {
			System.out.println("The folder is empty or does not exist. ");
		}
	}

	// function to choose a file from the folder
	public static String chooseFile(String folderPath) {
		try (Scanner scanner = new Scanner(System.in)) {
			listFileInFolder(folderPath);
			System.out.println("Enter the name of the file you want to work with (including the extension): ");
			return folderPath + "/" + scanner.nextLine();
		}
	}

	public static void main(String[] args) {
		
		String folderPath = "src/Storage"; // Path of the folder for saving the user files

		// Ensure the folder exists
		File folder = new File(folderPath);
		if (!folder.exists()) {
			folder.mkdir(); // create the folder if it doesn't exist
		}

//		while (true) {
			Scanner scanner = new Scanner(System.in);
			displayMenu();
			try {
				int choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {
				case 1: // Create a new file
					System.out.println("Enter the name of the new file (with extension): ");
					String newFileName = scanner.nextLine();
					createFile(folderPath, newFileName);
					break;

				case 2: // Write to an existing file
					String fileToWrite = chooseFile(folderPath);
					System.out.println("Enter the content to write to the file: ");
					String content = scanner.nextLine();
					writerFile(fileToWrite, content);
					break;

				case 3:
					String fileToRead = chooseFile(folderPath);
					System.out.println("File content:");
					readFile(fileToRead);
					break;
				case 4:
					String fileToAppend = chooseFile(folderPath);
					System.out.println("Enter the content to append to the file: ");
					String appendContent = scanner.nextLine();
					appendToFile(fileToAppend, appendContent);
					break;
				case 5:
					String fileToDelete = chooseFile(folderPath);
					deleteFile(fileToDelete);
					break;
				case 6:
					listFileInFolder(folderPath);
					break;
				case 7:
					System.out.println("Existing the program.bye bye (*_*)");
					scanner.close();
					System.exit(0);
					break;

				default:
					System.out.println("Invalid choice. Please choose again. ");
					;
				}

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Invalid input");
				scanner.nextLine();
			}

//		}

	}

	public static void displayMenu() {
		System.out.println("\nFile Handling Menu:");
		System.out.println("1. Create a new file");
		System.out.println("2. Write to an existing file");
		System.out.println("3. Read an existing file");
		System.out.println("4. Append to an existing file");
		System.out.println("5. Deleting an existing file");
		System.out.println("6. List all files in the folder");
		System.out.println("7. Exit");
		System.out.println("Choose an option: ");

	}
	
	public static void fileHandling() {
		public static void main(String[] args) {
			
			String folderPath = "src/Storage"; // Path of the folder for saving the user files

			// Ensure the folder exists
			File folder = new File(folderPath);
			if (!folder.exists()) {
				folder.mkdir(); // create the folder if it doesn't exist
			}

//			while (true) {
				Scanner scanner = new Scanner(System.in);
				displayMenu();
				try {
					int choice = scanner.nextInt();
					scanner.nextLine();

					switch (choice) {
					case 1: // Create a new file
						System.out.println("Enter the name of the new file (with extension): ");
						String newFileName = scanner.nextLine();
						createFile(folderPath, newFileName);
						break;

					case 2: // Write to an existing file
						String fileToWrite = chooseFile(folderPath);
						System.out.println("Enter the content to write to the file: ");
						String content = scanner.nextLine();
						writerFile(fileToWrite, content);
						break;

					case 3:
						String fileToRead = chooseFile(folderPath);
						System.out.println("File content:");
						readFile(fileToRead);
						break;
					case 4:
						String fileToAppend = chooseFile(folderPath);
						System.out.println("Enter the content to append to the file: ");
						String appendContent = scanner.nextLine();
						appendToFile(fileToAppend, appendContent);
						break;
					case 5:
						String fileToDelete = chooseFile(folderPath);
						deleteFile(fileToDelete);
						break;
					case 6:
						listFileInFolder(folderPath);
						break;
					case 7:
						System.out.println("Existing the program.bye bye (*_*)");
						scanner.close();
						System.exit(0);
						break;

					default:
						System.out.println("Invalid choice. Please choose again. ");
						;
					}

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Invalid input");
					scanner.nextLine();
				}

//			}

		}

	}
}
