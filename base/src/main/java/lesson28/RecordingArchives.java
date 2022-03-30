package lesson28;

import lombok.SneakyThrows;

public interface RecordingArchives {

    @SneakyThrows
    void archiver(String filePath);

    @SneakyThrows
    void unarchiver(String archivePath);
}
