package de.oglimmer.oauth2.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;

import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository(@Value("${keycloak.client.api.secret}") String keycloakClientApiSecret) {
        ClientRegistration cr = ClientRegistration
                .withRegistrationId("keycloak")
                .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .clientId("api")
                .clientSecret(keycloakClientApiSecret)
                .redirectUriTemplate("{baseUrl}/login/oauth2/code/{registrationId}")
                .authorizationUri("http://localhost:7070/auth/realms/Test/protocol/openid-connect/auth")
                .tokenUri("http://localhost:7070/auth/realms/Test/protocol/openid-connect/token")
                .userInfoUri("http://localhost:7070/auth/realms/Test/protocol/openid-connect/userinfo")
                .userNameAttributeName("preferred_username")
                .jwkSetUri("http://localhost:7070/auth/realms/Test/protocol/openid-connect/certs")
                .clientName("keycloak")
                .build();
        return new InMemoryClientRegistrationRepository(cr);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .oauth2Login();
                //.userInfoEndpoint();
                //.userAuthoritiesMapper(userAuthoritiesMapper());
    }

    private GrantedAuthoritiesMapper userAuthoritiesMapper() {
        return (authorities) -> {
            Set<GrantedAuthority> mappedAuthorities = new HashSet<>();
            // any code here.....
            return authorities;
        };
    }

}