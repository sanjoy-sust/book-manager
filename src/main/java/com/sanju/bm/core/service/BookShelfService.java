package com.sanju.bm.core.service;

import com.sanju.bm.core.params.BookShelfParam;
import com.sanju.bm.core.params.TagParam;
import com.sanju.bm.errorhandler.ResourceNotFoundException;

import java.util.List;

public interface BookShelfService {
    void add(BookShelfParam param);
    void update(BookShelfParam param);
    BookShelfParam getOne(long id) throws ResourceNotFoundException;
    List<BookShelfParam> getAll() throws ResourceNotFoundException;
    void delete(long id) throws ResourceNotFoundException;
}
