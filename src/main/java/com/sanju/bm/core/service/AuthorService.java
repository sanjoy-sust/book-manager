package com.sanju.bm.core.service;

import com.sanju.bm.core.params.AuthorParam;
import com.sanju.bm.errorhandler.ResourceNotFoundException;

import java.util.List;

public interface AuthorService {
    void addAuthor(AuthorParam param);

    List<AuthorParam> getAll() throws ResourceNotFoundException;

    void updateAuthor(AuthorParam requestToParam);

    AuthorParam getOne(long id) throws ResourceNotFoundException;

    void delete(long id) throws ResourceNotFoundException;
}
