package ru.practicum.ewm.compilation.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.compilation.CompilationService;
import ru.practicum.ewm.compilation.dto.CompilationDto;
import ru.practicum.ewm.compilation.dto.NewCompilationDto;

import javax.validation.Valid;

@Slf4j
@Validated
@RestController
@RequestMapping(path = "/admin/compilations")
@RequiredArgsConstructor
public class CompilationsAdminController {

    private final CompilationService compilationService;

    @PostMapping
    CompilationDto createCompilation(@Valid @RequestBody NewCompilationDto dto) {
        CompilationDto comp = compilationService.createCompilation(dto);
        log.info("Created compilation, {}", dto);
        return comp;
    }

    @DeleteMapping(value = "/{compId}")
    void deleteCompilation(@Valid @PathVariable Long compId) {
        compilationService.deleteCompilation(compId);
        log.info("Deleted compilation {}", compId);
    }

    @DeleteMapping(value = "/{compId}/events/{eventId}")
    void deleteEventFromCompilation(@Valid @PathVariable Long compId,
                                    @Valid @PathVariable Long eventId) {
        compilationService.deleteEventFromCompilation(compId, eventId);
        log.info("Deleted event {} from compilation {}", eventId, compId);
    }

    @PatchMapping(value = "/{compId}/events/{eventId}")
    void addEventToCompilation(@Valid @PathVariable Long compId,
                               @Valid @PathVariable Long eventId) {
        compilationService.addEventToCompilation(compId, eventId);
        log.info("Added event {} to compilation {}", eventId, compId);
    }

    @DeleteMapping(value = "/{compId}/pin")
    void unpinCompilation(@Valid @PathVariable Long compId) {
        compilationService.unpinCompilation(compId);
        log.info("Unpinned compilation {}", compId);
    }

    @PatchMapping(value = "/{compId}/pin")
    void pinCompilation(@Valid @PathVariable Long compId) {
        compilationService.pinCompilation(compId);
        log.info("Pinned compilation {}", compId);
    }
}
