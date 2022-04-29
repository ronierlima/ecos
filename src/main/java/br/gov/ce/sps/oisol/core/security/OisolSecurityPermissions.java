package br.gov.ce.sps.oisol.core.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class OisolSecurityPermissions {

    @Autowired
    OisolSecurity oisolSecurity;

}
