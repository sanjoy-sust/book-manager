package com.sanju.bm.core.service;

import com.sanju.bm.core.params.BookParam;
import com.sanju.bm.core.params.BookShelfParam;
import com.sanju.bm.errorhandler.ResourceNotFoundException;

import java.util.List;

public interface BookService {

    void add(BookParam param);
    void update(BookParam param);
    BookParam getOne(long id) throws ResourceNotFoundException;
    List<BookParam> getAll() throws ResourceNotFoundException;
    void delete(long id) throws ResourceNotFoundException;
}
