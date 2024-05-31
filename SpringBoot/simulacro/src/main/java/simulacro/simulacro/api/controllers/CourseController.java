package simulacro.simulacro.api.controllers;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import simulacro.simulacro.api.dto.request.CoursesRQ;
import simulacro.simulacro.api.dto.response.CourseRS;
import simulacro.simulacro.api.dto.response.basicResponse.CoursesRSBasic;
import simulacro.simulacro.infraestructure.abstract_services.ICoursesService;
import simulacro.simulacro.utils.enums.SortType;

@RestController
@RequestMapping(path = "/courses")
@AllArgsConstructor
public class CourseController {

  @Autowired
  private final ICoursesService coursesService;

  @PostMapping
  public ResponseEntity<CoursesRSBasic> create(
      @Validated @RequestBody CoursesRQ request) {
    return ResponseEntity.ok(this.coursesService.create(request));
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<CoursesRSBasic> get(@PathVariable Long id) {
    return ResponseEntity.ok(this.coursesService.get(id));
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<CoursesRSBasic> update(
      @Validated @RequestBody CoursesRQ request,
      @PathVariable Long id) {
    return ResponseEntity.ok(this.coursesService.update(request, id));
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    this.coursesService.delete(id);

    return ResponseEntity.noContent().build();
  }

  @GetMapping(path = "/get")
  // no se puede aplicar el principio de herencia en Page
  public ResponseEntity<Page<CourseRS>> getAll(
      @RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "5") int size,
      @RequestHeader(required = false) SortType sortType) {
    if (Objects.isNull(sortType)) {
      sortType = SortType.NONE;
    }

    return ResponseEntity.ok(this.coursesService.getAll(page - 1, size, sortType));
  }
}
