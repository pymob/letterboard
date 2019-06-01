package de.max.letterboard.controller;

import de.max.letterboard.exception.InvalidMottoException;
import de.max.letterboard.exception.NoMottoProvidedException;
import de.max.letterboard.model.QueryMottoResult;
import de.max.letterboard.service.QueryMottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.Optional;

@RestController
@RequestMapping(path = "motto")
public class QueryMottoController {
    private final QueryMottoService mottoService;

    @Autowired
    public QueryMottoController(QueryMottoService mottoService) {
        this.mottoService = mottoService;
    }

    @GetMapping
    public ResponseEntity<QueryMottoResult> queryMotto(@NotEmpty @RequestParam(name = "motto") String motto) throws NoMottoProvidedException {
        //TODO
        if (motto == null || motto.isEmpty()) {
            throw new NoMottoProvidedException();
        }
        System.out.printf("Received new motto: '%s'%n", motto);
        Optional<QueryMottoResult> mottoResult = mottoService.handleMotto(motto);
        return ResponseEntity.ok(mottoResult.orElseThrow(InvalidMottoException::new));

    }
}
