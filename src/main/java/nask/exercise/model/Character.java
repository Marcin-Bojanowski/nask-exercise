package nask.exercise.model;

import com.google.gson.annotations.SerializedName;
import lombok.Value;

@Value
public class Character {

    @SerializedName("name")
    String name;
    @SerializedName("height")
    String height;
    @SerializedName("mass")
    String mass;
    @SerializedName("hair_color")
    String hairColor;
    @SerializedName("skin_color")
    String skinColor;
    @SerializedName("eye_color")
    String eyeColor;
    @SerializedName("birth_year")
    String birthYear;
    @SerializedName("gender")
    String gender;
    @SerializedName("homeworld")
    String homeWorld;
    @SerializedName("films")
    String[] films;
    @SerializedName("species")
    String[] species;
    @SerializedName("vehicles")
    String[] vehicles;
    @SerializedName("starships")
    String[] starships;
    @SerializedName("created")
    String created;
    @SerializedName("edited")
    String edited;
    @SerializedName("url")
    String url;
}
