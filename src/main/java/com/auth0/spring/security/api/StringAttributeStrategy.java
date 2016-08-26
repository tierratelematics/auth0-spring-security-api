package com.auth0.spring.security.api;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class StringAttributeStrategy implements Auth0AuthorityStrategy {

  private final String attribute;

  public StringAttributeStrategy(String attribute) {
    if (attribute == null || attribute.isEmpty()) {
      throw new IllegalArgumentException("Attribute must be a valid string");
    }
    this.attribute = attribute;
  }

  @Override
  public Collection<String> getAuthorities(Map<String, Object> map) {
      final String authoritiesStr = (String) map.get(attribute);
      if (authoritiesStr != null) {
          return Arrays.asList(authoritiesStr.split("\\s+"));
      }
      return null;
  }

}
