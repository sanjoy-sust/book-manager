package com.sanju.bm.core.service;

import com.sanju.bm.core.params.PublisherParam;
import com.sanju.bm.errorhandler.ResourceNotFoundException;

import java.util.List;

public interface PublisherService {
    void addPublisher(PublisherParam param);

    List<PublisherParam> getAll() throws ResourceNotFoundException;

    void updatePublisher(PublisherParam requestToParam);

    PublisherParam getOne(long id) throws ResourceNotFoundException;

    void delete(long id) throws ResourceNotFoundException;
}
