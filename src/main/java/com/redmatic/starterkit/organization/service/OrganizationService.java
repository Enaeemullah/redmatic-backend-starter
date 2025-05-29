package com.redmatic.starterkit.organization.service;

import com.redmatic.starterkit.organization.dto.OrganizationSignupRequest;

public interface OrganizationService {
    void signupWithAdmin(OrganizationSignupRequest request);
}
