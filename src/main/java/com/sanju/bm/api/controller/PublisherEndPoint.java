package com.sanju.bm.api.controller;

import com.sanju.bm.api.model.AuthorResource;
import com.sanju.bm.api.model.PublisherResource;
import com.sanju.bm.core.enums.Status;
import com.sanju.bm.core.service.PublisherService;
import com.sanju.bm.errorhandler.ResourceNotFoundException;
import com.sanju.bm.util.RequestAndParamBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("publisher")
public class PublisherEndPoint {

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private RequestAndParamBuilder requestAndParamBuilder;

    @GetMapping
    public List<PublisherResource> getPublisher() throws ResourceNotFoundException {

        return publisherService.getAll().stream()
                .filter(x -> x.getStatus().equals(Status.ACTIVE))
                .map(x -> requestAndParamBuilder.publisherParamToResource(x))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "{id}")
    public PublisherResource getOne(@PathVariable long id) throws ResourceNotFoundException {
        return requestAndParamBuilder.publisherParamToResource(publisherService.getOne(id));
    }

    @PostMapping
    public void add(@RequestBody PublisherResource publisherResource){
        publisherService.addPublisher(requestAndParamBuilder.publisherResourceToParam(publisherResource));
    }

    @PutMapping
    public void update(@RequestBody PublisherResource publisherResource){
        publisherService.updatePublisher(requestAndParamBuilder.publisherResourceToParam(publisherResource));
    }

    @DeleteMapping("{id}")
    public void delete(long id) throws ResourceNotFoundException {
        publisherService.delete(id);
    }

}
