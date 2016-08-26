package com.auth0.spring.security.api;

import java.util.Collection;
import java.util.Map;

public class ListAttributeStrategy implements Auth0AuthorityStrategy {

  private final String attribute;

  public ListAttributeStrategy(String attribute) {
    if (attribute == null || attribute.isEmpty()) {
      throw new IllegalArgumentException("Attribute must be a valid string");
    }
    this.attribute = attribute;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Collection<String> getAuthorities(Map<String, Object> map) {
    return (Collection<String>) map.get(attribute);
  }

}
