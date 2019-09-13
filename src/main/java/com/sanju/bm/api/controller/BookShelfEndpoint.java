package com.sanju.bm.api.controller;

import com.sanju.bm.api.model.AuthorResource;
import com.sanju.bm.api.model.BookShelfResource;
import com.sanju.bm.api.model.TagResource;
import com.sanju.bm.core.enums.Status;
import com.sanju.bm.core.service.BookShelfService;
import com.sanju.bm.errorhandler.ResourceNotFoundException;
import com.sanju.bm.util.RequestAndParamBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("book-shelf")
public class BookShelfEndpoint {
    @Autowired
    private BookShelfService bookShelfService;

    @Autowired
    private RequestAndParamBuilder requestAndParamBuilder;

    @GetMapping
    public List<BookShelfResource> get() throws ResourceNotFoundException {

        return bookShelfService.getAll().stream()
                .filter(x -> x.getStatus().equals(Status.ACTIVE))
                .map(x -> requestAndParamBuilder.bookShelfParamToResource(x))
                .collect(Collectors.toList());
    }


    @GetMapping(value = "{id}")
    public BookShelfResource getOne(@PathVariable long id) throws ResourceNotFoundException {
        return requestAndParamBuilder.bookShelfParamToResource(bookShelfService.getOne(id));
    }

    @PostMapping
    public void add(@RequestBody BookShelfResource resource){
        bookShelfService.add(requestAndParamBuilder.bookShelfResourceToParam(resource));
    }

    @PutMapping
    public void update(@RequestBody BookShelfResource resource){
        bookShelfService.update(requestAndParamBuilder.bookShelfResourceToParam(resource));
    }

    @DeleteMapping("{id}")
    public void delete(long id) throws ResourceNotFoundException {
        bookShelfService.delete(id);
    }
}
