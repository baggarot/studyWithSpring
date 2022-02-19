package lesson28;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class RecordingArchivesRunner {

    public static void main(String[] args) {
        System.out.println("Введите путь до файла для выполнения процедуры архивации");
        Scanner in = new Scanner(System.in);
        String filePath = in.next();
        ConfigurableApplicationContext appContext = SpringApplication.run(RecordingArchivesRunner.class);
        RecordingArchives recordingArchives = appContext.getBean(RecordingArchives.class);
        recordingArchives.archiver(filePath);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
