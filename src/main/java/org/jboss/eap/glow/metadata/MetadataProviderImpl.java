/*
 * Copyright The WildFly Authors
 * SPDX-License-Identifier: Apache-2.0
 */
package org.jboss.eap.glow.metadata;

import java.io.InputStream;
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
    public InputStream getProvisioningFile(String context, ClassLoader loader) {
        String path = resourcesRoot + "/" + version + "/provisioning-" + context + ".xml";
        System.out.println("PATH IS " + path);
        return loader.getResourceAsStream(path);
    }
}
