package com.maartenmusic;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

//        DirectoryStream.Filter<Path> filter =
//                new DirectoryStream.Filter<Path>() {
//                    @Override
//                    public boolean accept(Path path) throws IOException {
//                        return Files.isRegularFile(path);
//                    }
//                };

        DirectoryStream.Filter<Path> filter = path -> Files.isRegularFile(path);


        Path directory = FileSystems.getDefault().getPath("FileTree" + FileSystems.getDefault().getSeparator() +"Dir2");
//        Path directory = FileSystems.getDefault().getPath("FileTree/Dir2");

        try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter)) {

            for (Path file : contents) {
                System.out.println(file.getFileName());
            }

        } catch (IOException | DirectoryIteratorException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        String seperator = File.separator;
        System.out.println(seperator);
        seperator = FileSystems.getDefault().getSeparator();
        System.out.println(seperator);

        try {
            Path tempFile = Files.createTempFile("myapp", ".appext");
            System.out.println("Tempory file path = " + tempFile.toAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }

        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        for (FileStore store : stores) {
            System.out.println(store);
            System.out.println(store.name());
        }


        System.out.println("Walking tree for Dir2");
        Path dir2Path = FileSystems.getDefault().getPath("FileTree","Dir2");
        try {
            Files.walkFileTree(dir2Path, new PrintNames());

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Copying files from Dir2 to Dir4");

        Path copyPath = FileSystems.getDefault().getPath("FileTree","Dir4", "Dir2Copy");
        try {
            Files.walkFileTree(dir2Path, new FileCopier(dir2Path, copyPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File("/Example/file.txt");
        Path convertedPath = file.toPath();

    }
}

