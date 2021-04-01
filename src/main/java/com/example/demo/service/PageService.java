package com.example.demo.service;

import com.example.demo.dto.PageDto;
import com.example.demo.model.Page;

import java.util.List;


public interface PageService {
    long addPage(PageDto pageDto);
    List<Page> getPages(int num, int offset);
}
