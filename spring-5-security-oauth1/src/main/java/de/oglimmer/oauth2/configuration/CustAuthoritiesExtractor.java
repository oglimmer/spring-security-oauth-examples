package de.oglimmer.oauth2.configuration;

import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustAuthoritiesExtractor implements AuthoritiesExtractor {

    @Override
    public List<GrantedAuthority> extractAuthorities(Map<String, Object> map) {
        return AuthorityUtils
                .commaSeparatedStringToAuthorityList(asAuthorities(map));
    }

    private String asAuthorities(Map<String, Object> map) {
        List<String> roles = (List<String>) map.get("roles");
        if (roles != null) {
            return roles.stream().collect(Collectors.joining(","));
        }
        return "";
    }
}
