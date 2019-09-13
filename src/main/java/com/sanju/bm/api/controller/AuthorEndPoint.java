package com.sanju.bm.api.controller;

import com.sanju.bm.api.model.AuthorResource;
import com.sanju.bm.api.validator.AuthorRequestValidator;
import com.sanju.bm.config.Translator;
import com.sanju.bm.core.enums.Status;
import com.sanju.bm.core.params.AuthorParam;
import com.sanju.bm.core.service.AuthorService;
import com.sanju.bm.errorhandler.ErrorCodes;
import com.sanju.bm.errorhandler.ResourceNotFoundException;
import com.sanju.bm.util.RequestAndParamBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/author")
public class AuthorEndPoint {

    @InitBinder("authorRequest")
    protected void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(new AuthorRequestValidator());
    }

    private static final Logger log = LoggerFactory.getLogger(AuthorEndPoint.class);

    @Autowired
    private AuthorService authorService;

    @Autowired
    private RequestAndParamBuilder requestAndParamBuilder;

    @Autowired
    private Translator translator;

    @GetMapping("/test")
    public String test() {
        return "Welcome to Book Manager";
    }

    @PostMapping
    public void add(@RequestBody @Valid AuthorResource request) {
        log.info("Author adding api called");
        authorService.addAuthor(requestAndParamBuilder.requestToParam(request));
        log.info("Author added.");
    }

    @PutMapping("{id}")
    public void update(@RequestBody @Valid AuthorResource request, @PathVariable long id) throws Exception {
        if (id <= 0) {
            log.error("No author found for this author id {}", id);
            throw new ResourceNotFoundException(ErrorCodes.Feature.AUTHOR_GET,
                    ErrorCodes.CODE.AUTHOR_NOT_FOUND, translator.toLocale(ErrorCodes.REASON_MAP.get(ErrorCodes.CODE.AUTHOR_NOT_FOUND)));
        }

        authorService.updateAuthor(requestAndParamBuilder.requestToParam(request));
    }

    @GetMapping
    public List<AuthorResource> getAllAuthor() throws ResourceNotFoundException {
        log.info("Getting all active authors");
        List<AuthorResource> authorResources =
                authorService.getAll().stream()
                        .map(authorParam -> requestAndParamBuilder.paramToRequest(authorParam))
                        .collect(Collectors.toList());

        return authorResources;
    }

    @GetMapping(value = "{id}")
    public AuthorResource getOne(@PathVariable long id) throws ResourceNotFoundException {
        return requestAndParamBuilder.paramToRequest(authorService.getOne(id));
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable long id) throws ResourceNotFoundException {
        log.info("Author deleting for id {}", id);
        authorService.delete(id);
    }
}
