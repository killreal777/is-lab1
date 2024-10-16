package itmo.is.controller;

import itmo.is.dto.domain.SpaceMarineDto;
import itmo.is.dto.domain.request.CreateSpaceMarineRequest;
import itmo.is.service.SpaceMarineService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/space-marines")
@RequiredArgsConstructor
public class SpaceMarineRestController {
    private final SpaceMarineService spaceMarineService;

    @GetMapping
    public ResponseEntity<List<SpaceMarineDto>> findAll() {
        return ResponseEntity.ok(spaceMarineService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpaceMarineDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(spaceMarineService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SpaceMarineDto> save(@RequestBody CreateSpaceMarineRequest request) {
        log.info("Save space marine request: {}", request);
        return ResponseEntity.ok(spaceMarineService.save(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        spaceMarineService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
