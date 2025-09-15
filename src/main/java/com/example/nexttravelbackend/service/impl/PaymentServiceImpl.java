package com.example.nexttravelbackend.service.impl;

import com.example.nexttravelbackend.dto.PaymentDTO;
import com.example.nexttravelbackend.entity.Payment;
import com.example.nexttravelbackend.repo.PaymentRepository;
import com.example.nexttravelbackend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public boolean savePayment(PaymentDTO dto) {
        try {
            Payment payment = new Payment();
            payment.setUserEmail(dto.getUserEmail());
            payment.setCardHolderName(dto.getCardHolderName());
            payment.setCardNumber(dto.getCardNumber());
            payment.setExpiryDate(dto.getExpiryDate());
            payment.setCvv(dto.getCvv());
            payment.setAmount(dto.getAmount());
            payment.setPaymentDate(LocalDateTime.now());

            paymentRepository.save(payment);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Map<String, Object>> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        System.out.println(payments);
        return payments.stream().map(payment -> {
            Map<String, Object> paymentDetails = new HashMap<>();
            paymentDetails.put("id", payment.getId());
            paymentDetails.put("userEmail", payment.getUserEmail());
            paymentDetails.put("amount", payment.getAmount());
            paymentDetails.put("paymentDate", payment.getPaymentDate());
            return paymentDetails;
        }).collect(Collectors.toList());
    }



}
