package nask.exercise.service;

import nask.exercise.connector.InputProvider;
import nask.exercise.connector.SwapiConntector;
import nask.exercise.model.Character;
import nask.exercise.model.CharactersResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CharactersServiceTest {

    @Mock
    InputProvider inputProvider;

    @Test
    void givenCorrectListOfCharacters_whenGetCalled_thenReturnCorrectResult() throws IOException {
        //given
        SwapiConntector swapiConntector = new SwapiConntector(inputProvider);
        CharactersService charactersService = new CharactersService(swapiConntector);
        when(inputProvider.getInputFromSwapi(any())).thenReturn(correctListOfCharacters);
        //when
        CharactersResponse charactersResponse = charactersService.getAllCharacters(any());
        //then
        assertNotNull(charactersResponse);
        assertNotNull(charactersResponse.getResults());
        assertEquals(10, charactersResponse.getResults().size());
    }

    @Test
    void givenCorrectCharacterDetails_whenGetCalled_thenReturnCorrectResult() throws IOException {
        //given
        SwapiConntector swapiConntector = new SwapiConntector(inputProvider);
        CharactersService charactersService = new CharactersService(swapiConntector);
        when(inputProvider.getInputFromSwapi(any())).thenReturn(correctCharacterDetails);
        //when
        Character character = charactersService.getCharacterDetails(any());
        //then
        assertNotNull(character);
        assertEquals("Luke Skywalker", character.getName());
    }

    String correctCharacterDetails = "{\n" +
            "   \"name\":\"Luke Skywalker\",\n" +
            "   \"height\":\"172\",\n" +
            "   \"mass\":\"77\",\n" +
            "   \"hair_color\":\"blond\",\n" +
            "   \"skin_color\":\"fair\",\n" +
            "   \"eye_color\":\"blue\",\n" +
            "   \"birth_year\":\"19BBY\",\n" +
            "   \"gender\":\"male\",\n" +
            "   \"homeworld\":\"https://swapi.dev/api/planets/1/\",\n" +
            "   \"films\":[\n" +
            "      \"https://swapi.dev/api/films/1/\",\n" +
            "      \"https://swapi.dev/api/films/2/\",\n" +
            "      \"https://swapi.dev/api/films/3/\",\n" +
            "      \"https://swapi.dev/api/films/6/\"\n" +
            "   ],\n" +
            "   \"species\":[\n" +
            "      \n" +
            "   ],\n" +
            "   \"vehicles\":[\n" +
            "      \"https://swapi.dev/api/vehicles/14/\",\n" +
            "      \"https://swapi.dev/api/vehicles/30/\"\n" +
            "   ],\n" +
            "   \"starships\":[\n" +
            "      \"https://swapi.dev/api/starships/12/\",\n" +
            "      \"https://swapi.dev/api/starships/22/\"\n" +
            "   ],\n" +
            "   \"created\":\"2014-12-09T13:50:51.644000Z\",\n" +
            "   \"edited\":\"2014-12-20T21:17:56.891000Z\",\n" +
            "   \"url\":\"https://swapi.dev/api/people/1/\"\n" +
            "}";

    String correctListOfCharacters = "{\n" +
            "   \"count\":82,\n" +
            "   \"next\":\"https://swapi.dev/api/people/?page=3&format=json\",\n" +
            "   \"previous\":\"https://swapi.dev/api/people/?page=1&format=json\",\n" +
            "   \"results\":[\n" +
            "      {\n" +
            "         \"name\":\"Anakin Skywalker\",\n" +
            "         \"height\":\"188\",\n" +
            "         \"mass\":\"84\",\n" +
            "         \"hair_color\":\"blond\",\n" +
            "         \"skin_color\":\"fair\",\n" +
            "         \"eye_color\":\"blue\",\n" +
            "         \"birth_year\":\"41.9BBY\",\n" +
            "         \"gender\":\"male\",\n" +
            "         \"homeworld\":\"https://swapi.dev/api/planets/1/\",\n" +
            "         \"films\":[\n" +
            "            \"https://swapi.dev/api/films/4/\",\n" +
            "            \"https://swapi.dev/api/films/5/\",\n" +
            "            \"https://swapi.dev/api/films/6/\"\n" +
            "         ],\n" +
            "         \"species\":[\n" +
            "            \n" +
            "         ],\n" +
            "         \"vehicles\":[\n" +
            "            \"https://swapi.dev/api/vehicles/44/\",\n" +
            "            \"https://swapi.dev/api/vehicles/46/\"\n" +
            "         ],\n" +
            "         \"starships\":[\n" +
            "            \"https://swapi.dev/api/starships/39/\",\n" +
            "            \"https://swapi.dev/api/starships/59/\",\n" +
            "            \"https://swapi.dev/api/starships/65/\"\n" +
            "         ],\n" +
            "         \"created\":\"2014-12-10T16:20:44.310000Z\",\n" +
            "         \"edited\":\"2014-12-20T21:17:50.327000Z\",\n" +
            "         \"url\":\"https://swapi.dev/api/people/11/\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"name\":\"Wilhuff Tarkin\",\n" +
            "         \"height\":\"180\",\n" +
            "         \"mass\":\"unknown\",\n" +
            "         \"hair_color\":\"auburn, grey\",\n" +
            "         \"skin_color\":\"fair\",\n" +
            "         \"eye_color\":\"blue\",\n" +
            "         \"birth_year\":\"64BBY\",\n" +
            "         \"gender\":\"male\",\n" +
            "         \"homeworld\":\"https://swapi.dev/api/planets/21/\",\n" +
            "         \"films\":[\n" +
            "            \"https://swapi.dev/api/films/1/\",\n" +
            "            \"https://swapi.dev/api/films/6/\"\n" +
            "         ],\n" +
            "         \"species\":[\n" +
            "            \n" +
            "         ],\n" +
            "         \"vehicles\":[\n" +
            "            \n" +
            "         ],\n" +
            "         \"starships\":[\n" +
            "            \n" +
            "         ],\n" +
            "         \"created\":\"2014-12-10T16:26:56.138000Z\",\n" +
            "         \"edited\":\"2014-12-20T21:17:50.330000Z\",\n" +
            "         \"url\":\"https://swapi.dev/api/people/12/\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"name\":\"Chewbacca\",\n" +
            "         \"height\":\"228\",\n" +
            "         \"mass\":\"112\",\n" +
            "         \"hair_color\":\"brown\",\n" +
            "         \"skin_color\":\"unknown\",\n" +
            "         \"eye_color\":\"blue\",\n" +
            "         \"birth_year\":\"200BBY\",\n" +
            "         \"gender\":\"male\",\n" +
            "         \"homeworld\":\"https://swapi.dev/api/planets/14/\",\n" +
            "         \"films\":[\n" +
            "            \"https://swapi.dev/api/films/1/\",\n" +
            "            \"https://swapi.dev/api/films/2/\",\n" +
            "            \"https://swapi.dev/api/films/3/\",\n" +
            "            \"https://swapi.dev/api/films/6/\"\n" +
            "         ],\n" +
            "         \"species\":[\n" +
            "            \"https://swapi.dev/api/species/3/\"\n" +
            "         ],\n" +
            "         \"vehicles\":[\n" +
            "            \"https://swapi.dev/api/vehicles/19/\"\n" +
            "         ],\n" +
            "         \"starships\":[\n" +
            "            \"https://swapi.dev/api/starships/10/\",\n" +
            "            \"https://swapi.dev/api/starships/22/\"\n" +
            "         ],\n" +
            "         \"created\":\"2014-12-10T16:42:45.066000Z\",\n" +
            "         \"edited\":\"2014-12-20T21:17:50.332000Z\",\n" +
            "         \"url\":\"https://swapi.dev/api/people/13/\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"name\":\"Han Solo\",\n" +
            "         \"height\":\"180\",\n" +
            "         \"mass\":\"80\",\n" +
            "         \"hair_color\":\"brown\",\n" +
            "         \"skin_color\":\"fair\",\n" +
            "         \"eye_color\":\"brown\",\n" +
            "         \"birth_year\":\"29BBY\",\n" +
            "         \"gender\":\"male\",\n" +
            "         \"homeworld\":\"https://swapi.dev/api/planets/22/\",\n" +
            "         \"films\":[\n" +
            "            \"https://swapi.dev/api/films/1/\",\n" +
            "            \"https://swapi.dev/api/films/2/\",\n" +
            "            \"https://swapi.dev/api/films/3/\"\n" +
            "         ],\n" +
            "         \"species\":[\n" +
            "            \n" +
            "         ],\n" +
            "         \"vehicles\":[\n" +
            "            \n" +
            "         ],\n" +
            "         \"starships\":[\n" +
            "            \"https://swapi.dev/api/starships/10/\",\n" +
            "            \"https://swapi.dev/api/starships/22/\"\n" +
            "         ],\n" +
            "         \"created\":\"2014-12-10T16:49:14.582000Z\",\n" +
            "         \"edited\":\"2014-12-20T21:17:50.334000Z\",\n" +
            "         \"url\":\"https://swapi.dev/api/people/14/\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"name\":\"Greedo\",\n" +
            "         \"height\":\"173\",\n" +
            "         \"mass\":\"74\",\n" +
            "         \"hair_color\":\"n/a\",\n" +
            "         \"skin_color\":\"green\",\n" +
            "         \"eye_color\":\"black\",\n" +
            "         \"birth_year\":\"44BBY\",\n" +
            "         \"gender\":\"male\",\n" +
            "         \"homeworld\":\"https://swapi.dev/api/planets/23/\",\n" +
            "         \"films\":[\n" +
            "            \"https://swapi.dev/api/films/1/\"\n" +
            "         ],\n" +
            "         \"species\":[\n" +
            "            \"https://swapi.dev/api/species/4/\"\n" +
            "         ],\n" +
            "         \"vehicles\":[\n" +
            "            \n" +
            "         ],\n" +
            "         \"starships\":[\n" +
            "            \n" +
            "         ],\n" +
            "         \"created\":\"2014-12-10T17:03:30.334000Z\",\n" +
            "         \"edited\":\"2014-12-20T21:17:50.336000Z\",\n" +
            "         \"url\":\"https://swapi.dev/api/people/15/\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"name\":\"Jabba Desilijic Tiure\",\n" +
            "         \"height\":\"175\",\n" +
            "         \"mass\":\"1,358\",\n" +
            "         \"hair_color\":\"n/a\",\n" +
            "         \"skin_color\":\"green-tan, brown\",\n" +
            "         \"eye_color\":\"orange\",\n" +
            "         \"birth_year\":\"600BBY\",\n" +
            "         \"gender\":\"hermaphrodite\",\n" +
            "         \"homeworld\":\"https://swapi.dev/api/planets/24/\",\n" +
            "         \"films\":[\n" +
            "            \"https://swapi.dev/api/films/1/\",\n" +
            "            \"https://swapi.dev/api/films/3/\",\n" +
            "            \"https://swapi.dev/api/films/4/\"\n" +
            "         ],\n" +
            "         \"species\":[\n" +
            "            \"https://swapi.dev/api/species/5/\"\n" +
            "         ],\n" +
            "         \"vehicles\":[\n" +
            "            \n" +
            "         ],\n" +
            "         \"starships\":[\n" +
            "            \n" +
            "         ],\n" +
            "         \"created\":\"2014-12-10T17:11:31.638000Z\",\n" +
            "         \"edited\":\"2014-12-20T21:17:50.338000Z\",\n" +
            "         \"url\":\"https://swapi.dev/api/people/16/\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"name\":\"Wedge Antilles\",\n" +
            "         \"height\":\"170\",\n" +
            "         \"mass\":\"77\",\n" +
            "         \"hair_color\":\"brown\",\n" +
            "         \"skin_color\":\"fair\",\n" +
            "         \"eye_color\":\"hazel\",\n" +
            "         \"birth_year\":\"21BBY\",\n" +
            "         \"gender\":\"male\",\n" +
            "         \"homeworld\":\"https://swapi.dev/api/planets/22/\",\n" +
            "         \"films\":[\n" +
            "            \"https://swapi.dev/api/films/1/\",\n" +
            "            \"https://swapi.dev/api/films/2/\",\n" +
            "            \"https://swapi.dev/api/films/3/\"\n" +
            "         ],\n" +
            "         \"species\":[\n" +
            "            \n" +
            "         ],\n" +
            "         \"vehicles\":[\n" +
            "            \"https://swapi.dev/api/vehicles/14/\"\n" +
            "         ],\n" +
            "         \"starships\":[\n" +
            "            \"https://swapi.dev/api/starships/12/\"\n" +
            "         ],\n" +
            "         \"created\":\"2014-12-12T11:08:06.469000Z\",\n" +
            "         \"edited\":\"2014-12-20T21:17:50.341000Z\",\n" +
            "         \"url\":\"https://swapi.dev/api/people/18/\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"name\":\"Jek Tono Porkins\",\n" +
            "         \"height\":\"180\",\n" +
            "         \"mass\":\"110\",\n" +
            "         \"hair_color\":\"brown\",\n" +
            "         \"skin_color\":\"fair\",\n" +
            "         \"eye_color\":\"blue\",\n" +
            "         \"birth_year\":\"unknown\",\n" +
            "         \"gender\":\"male\",\n" +
            "         \"homeworld\":\"https://swapi.dev/api/planets/26/\",\n" +
            "         \"films\":[\n" +
            "            \"https://swapi.dev/api/films/1/\"\n" +
            "         ],\n" +
            "         \"species\":[\n" +
            "            \n" +
            "         ],\n" +
            "         \"vehicles\":[\n" +
            "            \n" +
            "         ],\n" +
            "         \"starships\":[\n" +
            "            \"https://swapi.dev/api/starships/12/\"\n" +
            "         ],\n" +
            "         \"created\":\"2014-12-12T11:16:56.569000Z\",\n" +
            "         \"edited\":\"2014-12-20T21:17:50.343000Z\",\n" +
            "         \"url\":\"https://swapi.dev/api/people/19/\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"name\":\"Yoda\",\n" +
            "         \"height\":\"66\",\n" +
            "         \"mass\":\"17\",\n" +
            "         \"hair_color\":\"white\",\n" +
            "         \"skin_color\":\"green\",\n" +
            "         \"eye_color\":\"brown\",\n" +
            "         \"birth_year\":\"896BBY\",\n" +
            "         \"gender\":\"male\",\n" +
            "         \"homeworld\":\"https://swapi.dev/api/planets/28/\",\n" +
            "         \"films\":[\n" +
            "            \"https://swapi.dev/api/films/2/\",\n" +
            "            \"https://swapi.dev/api/films/3/\",\n" +
            "            \"https://swapi.dev/api/films/4/\",\n" +
            "            \"https://swapi.dev/api/films/5/\",\n" +
            "            \"https://swapi.dev/api/films/6/\"\n" +
            "         ],\n" +
            "         \"species\":[\n" +
            "            \"https://swapi.dev/api/species/6/\"\n" +
            "         ],\n" +
            "         \"vehicles\":[\n" +
            "            \n" +
            "         ],\n" +
            "         \"starships\":[\n" +
            "            \n" +
            "         ],\n" +
            "         \"created\":\"2014-12-15T12:26:01.042000Z\",\n" +
            "         \"edited\":\"2014-12-20T21:17:50.345000Z\",\n" +
            "         \"url\":\"https://swapi.dev/api/people/20/\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"name\":\"Palpatine\",\n" +
            "         \"height\":\"170\",\n" +
            "         \"mass\":\"75\",\n" +
            "         \"hair_color\":\"grey\",\n" +
            "         \"skin_color\":\"pale\",\n" +
            "         \"eye_color\":\"yellow\",\n" +
            "         \"birth_year\":\"82BBY\",\n" +
            "         \"gender\":\"male\",\n" +
            "         \"homeworld\":\"https://swapi.dev/api/planets/8/\",\n" +
            "         \"films\":[\n" +
            "            \"https://swapi.dev/api/films/2/\",\n" +
            "            \"https://swapi.dev/api/films/3/\",\n" +
            "            \"https://swapi.dev/api/films/4/\",\n" +
            "            \"https://swapi.dev/api/films/5/\",\n" +
            "            \"https://swapi.dev/api/films/6/\"\n" +
            "         ],\n" +
            "         \"species\":[\n" +
            "            \n" +
            "         ],\n" +
            "         \"vehicles\":[\n" +
            "            \n" +
            "         ],\n" +
            "         \"starships\":[\n" +
            "            \n" +
            "         ],\n" +
            "         \"created\":\"2014-12-15T12:48:05.971000Z\",\n" +
            "         \"edited\":\"2014-12-20T21:17:50.347000Z\",\n" +
            "         \"url\":\"https://swapi.dev/api/people/21/\"\n" +
            "      }\n" +
            "   ]\n" +
            "}";
}