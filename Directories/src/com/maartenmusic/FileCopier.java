package com.maartenmusic;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileCopier extends SimpleFileVisitor<Path> {
    private Path sourceRoot;
    private Path targetRoot;

    public FileCopier(Path sourceRoot, Path targetRoot) {
        this.sourceRoot = sourceRoot;
        this.targetRoot = targetRoot;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Error accessing file: " + file.toAbsolutePath() + " " + exc.getMessage());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Path relativizedPath = sourceRoot.relativize(dir);
        System.out.println(relativizedPath);
        Path copyDir = targetRoot.resolve(relativizedPath);
        System.out.println(copyDir);

        try {
            Files.copy(dir, copyDir);
        } catch (IOException e) {
            e.printStackTrace();
            return FileVisitResult.SKIP_SUBTREE;
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path relativizedPath = sourceRoot.relativize(file);
        System.out.println(relativizedPath);
        Path copyDir = targetRoot.resolve(relativizedPath);
        System.out.println(copyDir);

        try {
            Files.copy(file, copyDir);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return FileVisitResult.CONTINUE;    }
}
