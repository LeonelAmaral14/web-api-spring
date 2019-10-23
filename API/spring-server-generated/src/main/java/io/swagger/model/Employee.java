//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import org.springframework.validation.annotation.Validated;

@ApiModel(
        description = "Model containing employee info"
)
@Validated
public class Employee {
  @JsonProperty("id")
  private Integer id = null;
  @JsonProperty("employee name")
  private String employeeName = null;
  @JsonProperty("employee title")
  private String employeeTitle = null;

  public Employee() {
  }

  public Employee id(Integer id) {
    this.id = id;
    return this;
  }

  @ApiModelProperty(
          example = "4",
          value = ""
  )
  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Employee employeeName(String employeeName) {
    this.employeeName = employeeName;
    return this;
  }

  @ApiModelProperty(
          example = "Matheus Silva",
          value = ""
  )
  public String getEmployeeName() {
    return this.employeeName;
  }

  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  public Employee employeeTitle(String employeeTitle) {
    this.employeeTitle = employeeTitle;
    return this;
  }

  @ApiModelProperty(
          example = "Beckend Developer",
          value = ""
  )
  public String getEmployeeTitle() {
    return this.employeeTitle;
  }

  public void setEmployeeTitle(String employeeTitle) {
    this.employeeTitle = employeeTitle;
  }

  public boolean equals(Object o) {
    if (this == o) {
      return true;
    } else if (o != null && this.getClass() == o.getClass()) {
      Employee employee = (Employee)o;
      return Objects.equals(this.id, employee.id) && Objects.equals(this.employeeName, employee.employeeName) && Objects.equals(this.employeeTitle, employee.employeeTitle);
    } else {
      return false;
    }
  }

  public int hashCode() {
    return Objects.hash(new Object[]{this.id, this.employeeName, this.employeeTitle});
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Employee {\n");
    sb.append("    id: ").append(this.toIndentedString(this.id)).append("\n");
    sb.append("    employeeName: ").append(this.toIndentedString(this.employeeName)).append("\n");
    sb.append("    employeeTitle: ").append(this.toIndentedString(this.employeeTitle)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return o == null ? "null" : o.toString().replace("\n", "\n    ");
  }
}
