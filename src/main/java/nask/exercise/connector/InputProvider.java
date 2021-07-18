package nask.exercise.connector;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

@Component
public class InputProvider {

    public String getInputFromSwapi(URL url) throws IOException {
        StringBuilder jsonText = new StringBuilder();
        InputStream inputStream;
        inputStream = url.openStream();
        if (inputStream != null) {
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNext()) {
                jsonText.append(scanner.nextLine());
            }

        }
        return jsonText.toString();
    }
}
