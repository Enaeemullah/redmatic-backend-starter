package com.redmatic.autotab.organization.service;

import com.redmatic.autotab.organization.dto.OrganizationSignupRequest;

public interface OrganizationService {
    void signupWithAdmin(OrganizationSignupRequest request);
}
