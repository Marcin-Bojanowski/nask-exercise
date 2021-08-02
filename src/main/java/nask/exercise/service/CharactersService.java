package nask.exercise.service;

import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import nask.exercise.connector.SwapiConntector;
import nask.exercise.model.Character;
import nask.exercise.model.CharactersResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class CharactersService {

    private final SwapiConntector swapiConntector;

    public CharactersResponse getAllCharacters(Integer page) throws IOException {
        return swapiConntector.getListOfCharacters(page);

    }

    public Character getCharacterDetails(Integer id) throws IOException {
        return swapiConntector.getCharacterDetails(id);
    }
}
