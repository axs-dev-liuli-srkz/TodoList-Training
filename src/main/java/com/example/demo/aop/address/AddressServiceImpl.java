package com.example.demo.aop.address;

import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    @MyAnnotation("AAA")
    @Override
    public String getAddress(String zipNo) {
        return "address " + zipNo; // ダミー実装
    }
}
