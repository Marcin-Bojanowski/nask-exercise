package nask.exercise.connector;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nask.exercise.model.Character;
import nask.exercise.model.CharactersResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

@Service
@Slf4j
@RequiredArgsConstructor
public class SwapiConntector {

    private final InputProvider inputProvider;
    private final String SWAPI_URL = "https://swapi.dev/api/";

    public CharactersResponse getListOfCharacters(Integer page) throws IOException {
        URL url = new URL(SWAPI_URL + "people/?page=" + page + "&format=json");
        String input = inputProvider.getInputFromSwapi(url);
        Gson gson = new Gson();
        log.info(input);
        return gson.fromJson(input, CharactersResponse.class);
    }

    public Character getCharacterDetails(Integer id) throws IOException {
        URL url = new URL(SWAPI_URL + "people/" + id + "?format=json");
        String input = inputProvider.getInputFromSwapi(url);
        Gson gson = new Gson();
        return gson.fromJson(input, Character.class);
    }


}