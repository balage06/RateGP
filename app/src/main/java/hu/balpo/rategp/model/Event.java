package hu.balpo.rategp.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;




@ApiModel(description = "")
public class Event   {
  
  @SerializedName("id")
  private Long id = null;
  
  @SerializedName("name")
  private String name = null;
  
  @SerializedName("ratings")
  private List<Review> ratings = new ArrayList<Review>();
  

  
  /**
   **/
  @ApiModelProperty(value = "")
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public List<Review> getRatings() {
    return ratings;
  }
  public void setRatings(List<Review> ratings) {
    this.ratings = ratings;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Event event = (Event) o;
    return Objects.equals(id, event.id) &&
        Objects.equals(name, event.name) &&
        Objects.equals(ratings, event.ratings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, ratings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Event {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    ratings: ").append(toIndentedString(ratings)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}