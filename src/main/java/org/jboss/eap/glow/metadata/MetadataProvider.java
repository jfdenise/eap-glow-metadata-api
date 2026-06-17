/*
 * Copyright The WildFly Authors
 * SPDX-License-Identifier: Apache-2.0
 */
package org.jboss.eap.glow.metadata;

import java.io.InputStream;
import java.net.URI;


/**
 *
 * @author jdenise
 */
public interface MetadataProvider {
    String getVersion();
    default String getVariant() {
        return null;
    }
    default InputStream getProvisioningFile(String space, String profile, ClassLoader loader) {
        return getProvisioningFile(space, profile, loader, null);
    }
    default URI getLayerConfiguration(URI uri, String layer, String space, String context, ClassLoader loader) {
        return getLayerConfiguration(uri, layer, space, context, loader, null);
    }
    InputStream getProvisioningFile(String space, String profile, ClassLoader loader, String variant);
    URI getLayerConfiguration(URI uri, String layer, String space, String context, ClassLoader loader, String variant);
}
