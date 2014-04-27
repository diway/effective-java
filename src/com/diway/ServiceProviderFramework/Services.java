package com.diway.ServiceProviderFramework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Service registration and access class
public class Services {
    private Services() {
    }

    private static final String DEFAULT_PROVIDER_NAME = "default";
    private static final Map<String, Provider> providers = new ConcurrentHashMap<String, Provider>();

    // Provider registration API
    public static void registerDefaultProvider(Provider p) {
        registerProvider(DEFAULT_PROVIDER_NAME, p);
    }

    public static void registerProvider(String name, Provider p) {
        providers.put(name, p);
    }

    // Service access API
    public static Service newInstance() {
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    public static Service newInstance(String name) {
        Provider p = providers.get(name);
        if (p == null) {
            throw new IllegalArgumentException("No provider registered with name: " + name);
        }
        return p.newService();
    }
}
