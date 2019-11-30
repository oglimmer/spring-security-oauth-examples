
# OAUTH - SPRING - @EnableOAuth2Sso

This is minimal project setup to use

* Spring (with thymeleaf)
* OAuth2 (using Authorization Code Flow)
* Spring's API @EnableOAuth2Sso (deprecated)

# Requires

* Keycloak running on 7070
* Realm in Keycloak Test
* client: api (setup secret!)

# Functionality

* Protects /**, except for /login** which is redirected to keycloak
* Always uses Authorization Code Flow (even for API endpoints)
* API endpoints can be used within an authenticated browser (as it sends the JSESSION Cookie)


# Keycloak config
* Uses preferred_username as the username (which is used by Keycloak by default)
* Extracts Authorities from the user-info (configure keycloak: add role mapper, set "Add to userinfo" to true, set "Token Claim Name" to "roles")
