package com.dangjang.service;

import com.dangjang.dto.PaymentMapperDTO;
import com.dangjang.mapper.PaymentMapper;
import com.dangjang.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    public PaymentMapperDTO getOrderPayment(String orderNum) {
        return paymentMapper.getOrderPayment(orderNum);
    }

    public PaymentMapperDTO getPaymentDetail(Map<String, String> map) {
        return paymentMapper.getPaymentDetail(map);
    }

    public void cancelOrder(Map<String, String> map) {
        paymentMapper.cancelOrder(map);
    }

    public void refundOrder(Map<String, String> map) {
        paymentMapper.refundOrder(map);
    }

}
