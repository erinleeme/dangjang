package com.dangjang.service;

import com.dangjang.repository.SaleProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SaleProductService {
    private final SaleProductRepository saleProductRepository;

}
