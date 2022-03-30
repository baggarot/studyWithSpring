package lesson29;

import lesson28.RecordingArchives;
import lesson28.impl.RecordingArchivesImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
@RequiredArgsConstructor
public class InteractionWithArchives {

    private final LocalizationService localizationService;
    private String file;

    @ShellMethod(value = "message")
    public String message() {
        return localizationService.localize("message");
    }

    @ShellMethod(value = "archiver")
    public void archiver(@ShellOption({"-f, --file"}) String filePath) {
        this.file = filePath;
        RecordingArchives recordingArchives = new RecordingArchivesImpl();
        recordingArchives.archiver(filePath);
    }

    @ShellMethod(value = "unarchiver")
    public void unarchiver(@ShellOption({"-f, --file"}) String archivePath) {
        this.file = archivePath;
        RecordingArchives recordingArchives = new RecordingArchivesImpl();
        recordingArchives.unarchiver(archivePath);
    }
}
