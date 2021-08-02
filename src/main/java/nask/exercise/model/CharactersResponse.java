package nask.exercise.model;

import lombok.Value;

import java.util.List;
@Value
public class CharactersResponse {

    String count;
    String next;
    String previous;
    List<Character> results;
}
