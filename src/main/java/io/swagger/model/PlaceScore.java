package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Disability;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PlaceScore
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-08T19:00:38.207Z[GMT]")

public class PlaceScore   {
  @JsonProperty("disability")
  private Disability disability = null;

  @JsonProperty("score")
  private String score = null;

  public PlaceScore disability(Disability disability) {
    this.disability = disability;
    return this;
  }

  /**
   * Get disability
   * @return disability
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Disability getDisability() {
    return disability;
  }

  public void setDisability(Disability disability) {
    this.disability = disability;
  }

  public PlaceScore score(String score) {
    this.score = score;
    return this;
  }

  /**
   * Get score
   * @return score
  **/
  @ApiModelProperty(value = "")


  public String getScore() {
    return score;
  }

  public void setScore(String score) {
    this.score = score;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlaceScore placeScore = (PlaceScore) o;
    return Objects.equals(this.disability, placeScore.disability) &&
        Objects.equals(this.score, placeScore.score);
  }

  @Override
  public int hashCode() {
    return Objects.hash(disability, score);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlaceScore {\n");
    
    sb.append("    disability: ").append(toIndentedString(disability)).append("\n");
    sb.append("    score: ").append(toIndentedString(score)).append("\n");
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

