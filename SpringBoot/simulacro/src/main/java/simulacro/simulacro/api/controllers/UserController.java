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
import simulacro.simulacro.api.dto.request.UserRQ;
import simulacro.simulacro.api.dto.response.basicResponse.UserRSBasic;
import simulacro.simulacro.infraestructure.abstract_services.IUserService;
import simulacro.simulacro.utils.enums.SortType;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {

  @Autowired
  private final IUserService userService;

  @GetMapping(path = "/get")
  public ResponseEntity<Page<UserRSBasic>> getAll(
      @RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "5") int size,
      @RequestHeader(required = false) SortType sortType) {

    if (Objects.isNull(sortType)) {
      sortType = SortType.NONE;
    }

    return ResponseEntity.ok(this.userService.getAll(page - 1, size, sortType));
  }

  @PostMapping
  public ResponseEntity<UserRSBasic> create(
      @Validated @RequestBody UserRQ request) {
    return ResponseEntity.ok(this.userService.create(request));
  }
  @PutMapping(path = "/{id}")
    public ResponseEntity<UserRSBasic> update(
            @Validated @RequestBody UserRQ request,
        @PathVariable Long id) {
      return ResponseEntity.ok(this.userService.update(request, id));
    }
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
      this.userService.delete(id);

      return ResponseEntity.noContent().build();
    }
    
    @GetMapping(path = "/{id}")
    public ResponseEntity<UserRSBasic> get(@PathVariable Long id) {
      return ResponseEntity.ok(this.userService.get(id));
    }

}
