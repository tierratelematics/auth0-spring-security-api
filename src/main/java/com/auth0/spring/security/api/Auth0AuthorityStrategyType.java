package com.auth0.spring.security.api;

/**
 * The built in authority strategy being used
 *
 * Three possible types of strategy pertaining to "Role" info are built in:
 * Groups, Roles, and Scope
 *
 * For API Resource Server using JWT Tokens - `scope` is the default
 * Configurable via auth0.properties file or by providing a custom Auth0AuthorityStrategy
 * bean
 *
 */
public enum Auth0AuthorityStrategyType {

    GROUPS("groups", new ListAttributeStrategy("groups")),
    ROLES("roles", new ListAttributeStrategy("roles")),
    SCOPE("scope", new StringAttributeStrategy("scopes"));

    private final String name;
    private final Auth0AuthorityStrategy strategy;

    private Auth0AuthorityStrategyType(final String name, final Auth0AuthorityStrategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public Auth0AuthorityStrategy getStrategy() {
      return this.strategy;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static boolean contains(String value) {
        for (final Auth0AuthorityStrategyType authorityStrategy : values()) {
            if (authorityStrategy.name().equals(value)) {
                return true;
            }
        }
        return false;
    }

}
