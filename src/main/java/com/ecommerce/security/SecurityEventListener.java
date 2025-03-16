package com.ecommerce.security;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

@Component
public class SecurityEventListener {

    @EventListener
    public void onSuccess(AuthenticationSuccessEvent success) {
        System.out.println("LOGIN SUCCESS: " + success.getAuthentication().getName());
    }

    @EventListener
    public void onFailure(AuthenticationFailureBadCredentialsEvent failure) {
        System.out.println("FAILED LOGIN: " + failure.getAuthentication().getName());
    }
}
