package com.dangjang.service;

import com.dangjang.repository.BigCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BigCategoryService {
    private final BigCategoryRepository bigCategoryRepository;

}
