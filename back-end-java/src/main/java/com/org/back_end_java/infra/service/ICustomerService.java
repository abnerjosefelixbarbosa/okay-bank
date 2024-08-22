package com.org.back_end_java.infra.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.org.back_end_java.adapter.ICustomerGateway;

public interface ICustomerService extends UserDetailsService, ICustomerGateway {
}