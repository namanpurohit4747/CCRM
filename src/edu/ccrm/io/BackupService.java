package edu.ccrm.io;

import java.nio.file.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BackupService {
    public Path backupData(Path sourceDir, Path backupRoot) throws IOException {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        Path backupDir = backupRoot.resolve("backup_" + timestamp);
        Files.createDirectories(backupDir);
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(sourceDir)) {
            for (Path entry : stream) {
                Path dest = backupDir.resolve(entry.getFileName());
                Files.copy(entry, dest, StandardCopyOption.REPLACE_EXISTING);
            }
        }
        return backupDir;
    }

    public long computeBackupSize(Path backupDir) throws IOException {
        final long[] size = {0};
        Files.walk(backupDir).forEach(p -> {
            if (Files.isRegularFile(p)) {
                try {
                    size[0] += Files.size(p);
                } catch (IOException e) {
                    // handle error
                }
            }
        });
        return size[0];
    }
}
