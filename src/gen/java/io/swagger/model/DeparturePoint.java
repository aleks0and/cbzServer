/*
 * CBZ API
 * This is a simple API
 *
 * OpenAPI spec version: 123-oas3
 * Contact: you@your-company.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import javax.validation.constraints.*;

/**
 * DeparturePoint
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2018-12-08T14:37:58.127Z[GMT]")public class DeparturePoint   {
  @JsonProperty("id_place")
  private String idPlace = null;

  @JsonProperty("departureTime")
  private Date departureTime = null;

  public DeparturePoint idPlace(String idPlace) {
    this.idPlace = idPlace;
    return this;
  }

  /**
   * Get idPlace
   * @return idPlace
   **/
  @JsonProperty("id_place")
  @Schema(required = true, description = "")
  @NotNull
  public String getIdPlace() {
    return idPlace;
  }

  public void setIdPlace(String idPlace) {
    this.idPlace = idPlace;
  }

  public DeparturePoint departureTime(Date departureTime) {
    this.departureTime = departureTime;
    return this;
  }

  /**
   * Get departureTime
   * @return departureTime
   **/
  @JsonProperty("departureTime")
  @Schema(required = true, description = "")
  @NotNull
  public Date getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(Date departureTime) {
    this.departureTime = departureTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeparturePoint departurePoint = (DeparturePoint) o;
    return Objects.equals(this.idPlace, departurePoint.idPlace) &&
        Objects.equals(this.departureTime, departurePoint.departureTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idPlace, departureTime);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeparturePoint {\n");
    
    sb.append("    idPlace: ").append(toIndentedString(idPlace)).append("\n");
    sb.append("    departureTime: ").append(toIndentedString(departureTime)).append("\n");
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
