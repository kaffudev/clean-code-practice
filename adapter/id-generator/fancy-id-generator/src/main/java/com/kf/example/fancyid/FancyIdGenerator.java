package com.kf.example.fancyid;

import com.kf.example.usecase.ports.IdGenerator;

import java.util.UUID;

public class FancyIdGenerator implements IdGenerator {
    @Override
    public String generate() {
        return "#fancy#" + UUID.randomUUID().toString();

    }
}
