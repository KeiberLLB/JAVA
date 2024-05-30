package simulacro.simulacro.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import simulacro.simulacro.api.dto.request.CoursesRQ;
import simulacro.simulacro.api.dto.response.basicResponse.CoursesRS;
import simulacro.simulacro.infraestructure.abstract_services.ICoursesService;

@RestController
@RequestMapping(path = "/courses")
@AllArgsConstructor
public class CourseController {
  @Autowired
  private final ICoursesService coursesService;

  @PostMapping
  public ResponseEntity<CoursesRS> create(
      @Validated @RequestBody CoursesRQ request) {
    return ResponseEntity.ok(this.coursesService.create(request));
  }
}
