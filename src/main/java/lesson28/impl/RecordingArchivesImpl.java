package lesson28.impl;

import lesson28.RecordingArchives;
import lombok.SneakyThrows;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

@Service
@ConditionalOnProperty(name = "app.recordingArchives.enabled", havingValue = "1", matchIfMissing = true)
public class RecordingArchivesImpl implements RecordingArchives {

    @SneakyThrows
    @Override
    public void archiver(String filePath) {
        ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("F:\\output.zip"));
        FileInputStream fis = new FileInputStream(filePath);
        byte[] buffer = new byte[fis.available()];
        zout.write(buffer);
        zout.closeEntry();
    }

    @SneakyThrows
    @Override
    public void unarchiver(String archivePath) {
        ZipInputStream zin = new ZipInputStream(new FileInputStream(archivePath));
        ZipEntry entry;
        String name;
        while ((entry = zin.getNextEntry()) != null) {
            name = entry.getName();
            FileOutputStream fout = new FileOutputStream("F:\\new " + name);
            for (int i = zin.read(); i != -1; i = zin.read()) fout.write(i);
            fout.flush();
            zin.closeEntry();
            fout.close();
        }
    }
}
