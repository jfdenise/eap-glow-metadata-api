/*
 * Copyright The WildFly Authors
 * SPDX-License-Identifier: Apache-2.0
 */
package org.jboss.eap.glow.metadata;

import java.io.InputStream;


/**
 *
 * @author jdenise
 */
public interface MetadataProvider {
    public String getVersion();
    InputStream getProvisioningFile(String profile, ClassLoader loader);
}
