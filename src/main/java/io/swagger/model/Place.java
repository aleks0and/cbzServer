package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Location;
import io.swagger.model.PlaceScore;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Place
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-08T19:00:38.207Z[GMT]")

public class Place   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("location")
  private Location location = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("placeScore")
  @Valid
  private List<PlaceScore> placeScore = null;

  public Place id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Place location(Location location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public Place description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Place placeScore(List<PlaceScore> placeScore) {
    this.placeScore = placeScore;
    return this;
  }

  public Place addPlaceScoreItem(PlaceScore placeScoreItem) {
    if (this.placeScore == null) {
      this.placeScore = new ArrayList<PlaceScore>();
    }
    this.placeScore.add(placeScoreItem);
    return this;
  }

  /**
   * Get placeScore
   * @return placeScore
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<PlaceScore> getPlaceScore() {
    return placeScore;
  }

  public void setPlaceScore(List<PlaceScore> placeScore) {
    this.placeScore = placeScore;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Place place = (Place) o;
    return Objects.equals(this.id, place.id) &&
        Objects.equals(this.location, place.location) &&
        Objects.equals(this.description, place.description) &&
        Objects.equals(this.placeScore, place.placeScore);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, location, description, placeScore);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Place {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    placeScore: ").append(toIndentedString(placeScore)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

