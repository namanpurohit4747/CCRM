package edu.ccrm.util;

import java.nio.file.*;
import java.io.IOException;

public class RecursionUtils {
    public static void listFilesByDepth(Path dir, int depth) throws IOException {
        listFilesByDepthHelper(dir, depth, 0);
    }

    private static void listFilesByDepthHelper(Path dir, int maxDepth, int currentDepth) throws IOException {
        if (currentDepth > maxDepth) return;
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path entry : stream) {
                System.out.println(" ".repeat(currentDepth * 2) + entry.getFileName());
                if (Files.isDirectory(entry)) {
                    listFilesByDepthHelper(entry, maxDepth, currentDepth + 1);
                }
            }
        }
    }
}
