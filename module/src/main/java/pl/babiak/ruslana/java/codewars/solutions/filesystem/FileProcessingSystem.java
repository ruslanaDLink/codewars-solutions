package pl.babiak.ruslana.java.codewars.solutions.filesystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileProcessingSystem {
    private static String directory = "C:\\Users\\hp\\file-processing-system-app";


    public static void main(String[] args) throws IOException {
        System.out.println("""
                Welcome to File Processing System
                    1. Create a new file
                    2. Write data to a file
                    3. Analyze a file
                    4. Search files
                    5. Move/Rename files
                    6. Create .zip archive
                    7. Retrieve all files in the directory
                    8. Exit

                Enter your choice:""");

        Scanner scanner = new Scanner(System.in);

        File[] listFiles = new File(directory).listFiles();

        boolean running = true;

        while (running) {
            String choice = scanner.next();
            switch (choice) {
                case "1" -> {
                    System.out.println("Type filename");
                    String filename = scanner.next();
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH-mm");
                    String path = directory + "\\" + filename + "-" + dateTimeFormatter.format(LocalDateTime.now()) + ".txt";
                    File userFile = new File(path);

                    try {
                        boolean created = userFile.createNewFile();
                        System.out.println(userFile);
                        if (created) {
                            System.out.println("Created file successfully!");
                        } else {
                            System.err.println("Failed to create file.");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                case "2" -> {
                    System.out.println("Select file in the directory");
                    if (listFiles != null) {
                        printAllFiles(directory);
                        String selectedFileStr = scanner.next();

                        File selectedFile = new File(selectedFileStr);
                        Path filePath = selectedFile.toPath();
                        if (Files.exists(filePath)) {
                            System.out.println("Write your content below\n");
                            String content = scanner.next();

                            Files.writeString(filePath, content, StandardOpenOption.APPEND);
                            List<String> allLines = Files.readAllLines(filePath);
                            if (allLines.contains(content)) {
                                System.out.println("Written to file successfully!");
                            } else {
                                System.err.println("Error occurred during trying write contents");
                            }
                        }
                    }
                }
                case "3" -> {
                    System.out.println("Select file in the directory");
                    printAllFiles(directory);

                    String fileSelectedStr = scanner.next();
                    File fileSelected = new File(fileSelectedStr);
                    Path path = fileSelected.toPath();

                    System.out.println("File analyzing...");
                    if (Files.exists(path)) {
                        List<String> allLines = Files.readAllLines(path);
                        int wordsCount = 0;
                        int charactersCount = 0;
                        for (String allLine : allLines) {
                            wordsCount += allLine.split("\\s").length;
                            charactersCount += allLine.length();
                        }
                        System.out.println("Total words: " + wordsCount);
                        System.out.println("Total chars: " + charactersCount);
                    } else {
                        System.err.println("File not found.");
                    }
                }

                case "4" -> {
                    System.out.println("Write filename or extension");
                    String fileToSearch = scanner.next();
                    File[] files = new File(directory).listFiles();
                    if (files != null) {
                        for (File file : files) {
                            if (file.getName().equals(fileToSearch) || file.getName().endsWith(fileToSearch)) {
                                System.out.println("File found.");
                                System.out.println("Analyzing...");

                                BasicFileAttributes attributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                                System.out.println(file.getName() + ":");
                                double size = (double) attributes.size() / 1000;
                                System.out.println("Size: " + size + " kb");
                                System.out.println("Creation time: " + attributes.creationTime());
                                System.out.println("Last modified time: " + attributes.lastModifiedTime());

                                Path filePath = file.toPath();
                                String[] permissions = new String[3];
                                if (Files.isReadable(filePath)) {
                                    permissions[0] = "Readable";
                                }
                                if (Files.isWritable(filePath)) {
                                    permissions[1] = "Writable";
                                }
                                if (Files.isExecutable(filePath)) {
                                    permissions[2] = "Executable";
                                }
                                System.out.println("Permissions: " + Arrays.toString(permissions));
                            } else {
                                System.err.println("No such file in the directory " + file);
                            }
                        }
                    } else {
                        System.err.println("No files in the specified directory.");
                    }
                }

                case "5" -> {
                    System.out.println("copy file or rename?");
                    String copyOrRename = scanner.next();
                    if (copyOrRename.equalsIgnoreCase("copy")) {
                        System.out.println("Write source path");
                        String sourcePath = scanner.next();
                        Path pathSource = Path.of(sourcePath);


                        System.out.println("Write target path");
                        String targetPath = scanner.next();
                        Path pathTarget = Path.of(targetPath);

                        if (Files.exists(pathSource)) {
                            Path copiedPath = Files.copy(pathSource, pathTarget, StandardCopyOption.REPLACE_EXISTING);
                            System.out.println("Copied to the " + copiedPath + " destination.");
                        } else {
                            System.err.println("File not found " + pathSource);
                        }
                    } else if (copyOrRename.equalsIgnoreCase("rename")) {
                        System.out.println("Specify file to rename");
                        String oldFile = scanner.next();
                        System.out.println("Type new file");
                        String newFile = scanner.next();
                        boolean renamed = new File(oldFile).renameTo(new File(newFile));
                        if (renamed) {
                            System.out.println("Renamed successfully!");
                        } else {
                            System.err.println("Failed to rename file.");
                        }
                    }
                }

                case "6" -> {
                    System.out.println("Specify file to zip");
                    String sourceFile = scanner.next();
                    System.out.println("Specify zip file name");
                    String zipFileName = scanner.next();
                    zip(sourceFile, zipFileName);
                }

                case "7" -> {
                    System.out.println("Directory:");
                    String directory = scanner.next();
                    if (Files.exists(Path.of(directory))) {
                        printAllFiles(directory);
                    } else {
                        System.err.println("Directory not found");
                    }
                }
                case "8" -> {
                    scanner.close();
                    running = false;
                }
            }
        }
    }

    private static void printAllFiles(String directory) {
        if (directory == null || directory.isBlank()) {
            throw new NullPointerException("Directory should not be empty");
        }
        File[] files = new File(directory).listFiles();
        if (files != null) {
            Arrays.stream(files).forEach(file -> System.out.println("-- " + file + " --"));
        } else {
            System.out.println("No single file in the specified directory.");
        }
    }

    private static void zip(String file, String zipFileName) {
        if (!Files.exists(Path.of(file))) {
            System.err.println("Specified file does not exist. Try again");
            return;
        }
        byte[] buffer = new byte[1024];

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFileName));
             FileInputStream fileInputStream = new FileInputStream(file)) {
            ZipEntry entry = new ZipEntry(new File(file).getName());
            zipOutputStream.putNextEntry(entry);
            int i;
            while ((i = fileInputStream.read(buffer)) > -1) {
                zipOutputStream.write(buffer, 0, i);
            }
            zipOutputStream.close();
            System.out.println(file + " zipped to " + zipFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}