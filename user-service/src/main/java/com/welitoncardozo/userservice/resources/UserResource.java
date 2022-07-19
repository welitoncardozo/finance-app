package com.welitoncardozo.userservice.resources;

import com.welitoncardozo.userservice.models.User;
import com.welitoncardozo.userservice.services.UserService;
import com.welitoncardozo.userservice.utils.EnvironmentUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("user-service")
public class UserResource {
    private final UserService service;

    public UserResource(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody final User user) {
        service.save(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(EnvironmentUtil.getHostname());
    }

    @GetMapping("/{email}")
    public ResponseEntity<Map<String, Object>> search(@PathVariable final String email) {
        final Optional<User.Dto> user = service.findByEmail(email).map(User.Dto::from);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of(
                        "user", user.isPresent() ? user.get() : String.format("User by email %s not found.", email),
                        "os.name", EnvironmentUtil.getHostname()
                ));
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> searchAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of(
                        "users", service.findAll(),
                        "os.name", EnvironmentUtil.getHostname()
                ));
    }
}
