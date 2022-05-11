package com.dangjang.service;

import com.dangjang.repository.ShareRefrigeratorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ShareRefrigeratorService {
    private final ShareRefrigeratorRepository shareRefrigeratorRepository;
}
