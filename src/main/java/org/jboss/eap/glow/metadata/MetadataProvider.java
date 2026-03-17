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
    public String getVersion();
    InputStream getProvisioningFile(String space, String profile, ClassLoader loader);
    URI getLayerConfiguration(URI uri, String layer, String space, String context, ClassLoader loader);
}
