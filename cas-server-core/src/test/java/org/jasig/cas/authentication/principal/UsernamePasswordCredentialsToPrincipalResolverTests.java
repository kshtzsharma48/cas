/*
 * Licensed to Jasig under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Jasig licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain a
 * copy of the License at the following location:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jasig.cas.authentication.principal;

import static org.junit.Assert.*;

import org.jasig.cas.TestUtils;
import org.junit.Test;

/**
 * @author Scott Battaglia
 * @since 3.0
 */
public final class UsernamePasswordCredentialsToPrincipalResolverTests {

    private CredentialsToPrincipalResolver resolver = new UsernamePasswordCredentialsToPrincipalResolver();

    @Test
    public void testValidSupportsCredentials() {
        assertTrue(this.resolver.supports(TestUtils.getCredentialsWithSameUsernameAndPassword()));
    }

    @Test
    public void testNullSupportsCredentials() {
        assertFalse(this.resolver.supports(null));
    }

    @Test
    public void testInvalidSupportsCredentials() {
        assertFalse(this.resolver.supports(TestUtils.getHttpBasedServiceCredentials()));
    }

    @Test
    public void testValidCredentials() {
        Principal p = this.resolver.resolvePrincipal(TestUtils.getCredentialsWithSameUsernameAndPassword());

        assertEquals(p.getId(), TestUtils.getCredentialsWithSameUsernameAndPassword().getUsername());
    }
}
