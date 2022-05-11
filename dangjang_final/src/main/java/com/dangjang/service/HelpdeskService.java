package com.dangjang.service;

import com.dangjang.repository.HelpDeskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class HelpdeskService {
    private final HelpDeskRepository helpDeskRepository;

}
