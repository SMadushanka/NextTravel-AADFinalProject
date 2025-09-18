package com.example.nexttravelbackend.service;

import com.example.nexttravelbackend.dto.PaymentDTO;

import java.util.List;
import java.util.Map;

public interface PaymentService {
    boolean savePayment(PaymentDTO paymentDTO);


    List<Map<String, Object>> getAllPayments();

}
''