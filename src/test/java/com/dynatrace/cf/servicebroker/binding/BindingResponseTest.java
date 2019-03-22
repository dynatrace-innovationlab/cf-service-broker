/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dynatrace.cf.servicebroker.binding;

import com.dynatrace.cf.servicebroker.Credentials;
import com.dynatrace.cf.servicebroker.AbstractSerializationTest;

import java.io.IOException;
import java.net.URI;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public final class BindingResponseTest extends AbstractSerializationTest<BindingResponse> {

    @Override
    protected void assertContents(Map m) throws IOException {
        assertEquals(roundTrip(getCredentials()), m.get("credentials"));
        assertEquals("http://test.syslog.drain.url", m.get("syslog_drain_url"));
    }

    @Override
    protected BindingResponse getInstance() {
        return new BindingResponse(getCredentials(), URI.create("http://test.syslog.drain.url"));
    }

    private Credentials getCredentials() {
        return new Credentials("test-tenant", "test-apikey", "test-apiurl", false);
    }

}
