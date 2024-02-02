package com.fpt.apiservice.services;

import com.fpt.apiservice.requests.auth.VerifyRequest;
import org.springframework.stereotype.Service;

@Service
public class VerifyService {
    public boolean isVerify(VerifyRequest verifyRequest) {
        return false;
    }
}
