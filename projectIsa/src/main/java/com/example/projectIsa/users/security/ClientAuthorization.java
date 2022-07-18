package com.example.projectIsa.users.security;

import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('CLIENT')")
public @interface ClientAuthorization {

}
