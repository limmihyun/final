package com.tree.gdhealth.customer.payment;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {

	int addPayment(Map<String, Object> paramap);
}
