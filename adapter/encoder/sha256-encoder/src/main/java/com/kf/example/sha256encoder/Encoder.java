package com.kf.example.sha256encoder;

import com.kf.example.usecase.ports.PasswordEncoder;
import org.apache.commons.codec.digest.DigestUtils;


public class Encoder implements PasswordEncoder {
    @Override
    public String encode(String s) {
        return DigestUtils.sha3_256Hex(s);
    }
}
