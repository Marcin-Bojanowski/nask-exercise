package nask.exercise.controller;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import nask.exercise.model.Character;
import nask.exercise.service.CharactersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CharactersController {

    private final CharactersService charactersService;

    @GetMapping("/characters")
    @Timed(value = "get_all_characters")
    public ResponseEntity getAllCharacters(@RequestParam Integer page) throws IOException {
        List<Character> characters = charactersService.getAllCharacters(page).getResults();
        if (characters != null) {
            return ResponseEntity.ok(characters);
        } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("characters/{id}")
    @Timed(value = "get_character_details")
    public ResponseEntity getCharacterDetails(@PathVariable Integer id) throws IOException {
        Character character = charactersService.getCharacterDetails(id);
        if (character != null) {
            return ResponseEntity.ok(character);
        } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
