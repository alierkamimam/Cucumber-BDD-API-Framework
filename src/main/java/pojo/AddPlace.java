package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
public class AddPlace {

    @JsonProperty("accuracy")
    private int accuracy;
    @JsonProperty("name")
    private String name;
    @JsonProperty("phone_number")
    private String phone_number;
    @JsonProperty("address")
    private String address;
    @JsonProperty("website")
    private String website;
    @JsonProperty("language")
    private String language;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("types")
    private List<String> types;

    }


   /*

     public int getAccuracy() {
        return accuracy;
    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone_number() {
        return phone_number;
    }
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public List<String> getTypes() {
        return types;
    }
    public void setTypes(List<String> types) {
        this.types = types;
    }
*/

