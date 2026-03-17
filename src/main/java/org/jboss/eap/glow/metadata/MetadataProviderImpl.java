/*
 * Copyright The WildFly Authors
 * SPDX-License-Identifier: Apache-2.0
 */
package org.jboss.eap.glow.metadata;

import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 *
 * @author jdenise
 */
public class MetadataProviderImpl implements MetadataProvider {

    private final String version;
    private final String resourcesRoot;

    protected MetadataProviderImpl(String version, String resourcesRoot) {
        this.version = version;
        this.resourcesRoot = resourcesRoot;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public InputStream getProvisioningFile(String space, String context, ClassLoader loader) {
        String path = resourcesRoot + (space == null ? ""  :"/" + space) + "/" + version + "/provisioning-" + context + ".xml";
        return loader.getResourceAsStream(path);
    }

    @Override
    public URI getLayerConfiguration(URI uri, String layer, String space, String context, ClassLoader loader) {
        String uriPath = uri.getPath().replace("/", "_");
        String path = resourcesRoot + "/layers-configuration/" + version + (space == null ? "/default"  : "/" + space) + "/nominal/" + context + "/" + layer + "/" + uriPath;
        URL u = loader.getResource(path);
        if (u == null) {
            return null;
        }
        try {
            return loader.getResource(path).toURI();
        } catch (URISyntaxException ex) {
            throw new RuntimeException(ex);
        }
    }
}
