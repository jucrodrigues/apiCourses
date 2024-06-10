package br.com.juliana.apiCourses.modules.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequestDTO {

  @JsonProperty("name")
  private String name;

  @JsonProperty("category")
  private String category;
}
