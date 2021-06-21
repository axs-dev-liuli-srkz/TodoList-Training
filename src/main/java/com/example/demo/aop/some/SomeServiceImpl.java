package com.example.demo.aop.some;

import org.springframework.stereotype.Service;

@Service
public class SomeServiceImpl implements SomeService {
    @Override
    public int getUserCount() {
        // ダミー実装
        return 100;
    }

    @Override
    public void insert(Some some) {
        // ダミー実装
    }

    @Override
    public String getUserName(int id) {
        // ダミー実装
        return "User " + id;
    }
}
