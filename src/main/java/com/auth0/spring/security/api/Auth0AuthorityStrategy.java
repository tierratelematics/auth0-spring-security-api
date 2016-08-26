package com.auth0.spring.security.api;

import java.util.Collection;
import java.util.Map;

/**
 * The strategy used to extract "Role" info from the token.
 */
public interface Auth0AuthorityStrategy {

  Collection<String> getAuthorities(Map<String, Object> map);
}
