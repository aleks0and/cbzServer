package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Disability;
import io.swagger.model.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * User
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-08T19:00:38.207Z[GMT]")

public class User   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("surname")
  private String surname = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("disabilityType")
  @Valid
  private List<Disability> disabilityType = null;

  @JsonProperty("caretaker")
  @Valid
  private List<User> caretaker = null;

  public User id(String id) {
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

  public User name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public User surname(String surname) {
    this.surname = surname;
    return this;
  }

  /**
   * Get surname
   * @return surname
  **/
  @ApiModelProperty(value = "")


  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public User email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(value = "")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public User disabilityType(List<Disability> disabilityType) {
    this.disabilityType = disabilityType;
    return this;
  }

  public User addDisabilityTypeItem(Disability disabilityTypeItem) {
    if (this.disabilityType == null) {
      this.disabilityType = new ArrayList<Disability>();
    }
    this.disabilityType.add(disabilityTypeItem);
    return this;
  }

  /**
   * Get disabilityType
   * @return disabilityType
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Disability> getDisabilityType() {
    return disabilityType;
  }

  public void setDisabilityType(List<Disability> disabilityType) {
    this.disabilityType = disabilityType;
  }

  public User caretaker(List<User> caretaker) {
    this.caretaker = caretaker;
    return this;
  }

  public User addCaretakerItem(User caretakerItem) {
    if (this.caretaker == null) {
      this.caretaker = new ArrayList<User>();
    }
    this.caretaker.add(caretakerItem);
    return this;
  }

  /**
   * Get caretaker
   * @return caretaker
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<User> getCaretaker() {
    return caretaker;
  }

  public void setCaretaker(List<User> caretaker) {
    this.caretaker = caretaker;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.id, user.id) &&
        Objects.equals(this.name, user.name) &&
        Objects.equals(this.surname, user.surname) &&
        Objects.equals(this.email, user.email) &&
        Objects.equals(this.disabilityType, user.disabilityType) &&
        Objects.equals(this.caretaker, user.caretaker);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, surname, email, disabilityType, caretaker);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    disabilityType: ").append(toIndentedString(disabilityType)).append("\n");
    sb.append("    caretaker: ").append(toIndentedString(caretaker)).append("\n");
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

