package com.example.demo.service;

import com.example.demo.converter.StringToOnwerConverter;
import com.example.demo.dto.PageDto;
import com.example.demo.model.Page;
import com.example.demo.repository.PageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Slf4j
@Service
public class PageServiceImpl implements PageService {
    @Autowired
    PageRepository pageRepository;

    @Autowired
    StringToOnwerConverter stringToOnwerConverter;

    @Override
    public long addPage(PageDto pageDto) {
        log.info(pageDto.toString());
//        User user = stringToOnwerConverter.convert(pageDto.getOwner());
        Page page = pageRepository.save(Page.builder()
                .title(pageDto.getTitle())
                .text(pageDto.getText())
                .owner(pageDto.getOwner())
                .date(new Date(new java.util.Date().getTime()))
                .build());
        return page.getId();
    }

    @Override
    public List<Page> getPages(int num, int offset) {
        Pageable sortedByPriceDesc = PageRequest.of(offset, num, Sort.by("id").descending());
        return pageRepository.findAll(sortedByPriceDesc).toList();
    }


}
