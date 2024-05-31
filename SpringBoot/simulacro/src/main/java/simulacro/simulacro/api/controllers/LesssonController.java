package simulacro.simulacro.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import simulacro.simulacro.api.dto.request.LessonsRQ;
import simulacro.simulacro.api.dto.response.basicResponse.LessonsRSBasic;
import simulacro.simulacro.infraestructure.abstract_services.ILessonsService;

@RestController
@RequestMapping(path = "/lessons")
@AllArgsConstructor
public class LesssonController {
  @Autowired
  private final ILessonsService lessonsService;

  @PostMapping
  public ResponseEntity<LessonsRSBasic> create(
      @Validated @RequestBody LessonsRQ request) {
    return ResponseEntity.ok(this.lessonsService.create(request));
  }
      
  @GetMapping(path = "/{id}")
  public ResponseEntity<LessonsRSBasic> get(@PathVariable Long id) {
    return ResponseEntity.ok(this.lessonsService.get(id));
  }
}
