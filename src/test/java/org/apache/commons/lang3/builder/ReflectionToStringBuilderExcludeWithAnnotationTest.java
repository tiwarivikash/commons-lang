/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.commons.lang3.builder;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Test class for ToStringExclude annotation
 * @version $Id$
 */
public class ReflectionToStringBuilderExcludeWithAnnotationTest {

    class TestFixture {
        @ToStringExclude
        private final String secretField = SECRET_VALUE;

        @SuppressWarnings("unused")
        private final String showField = NOT_SECRET_VALUE;
    }

    private static final String NOT_SECRET_FIELD = "showField";

    private static final String NOT_SECRET_VALUE = "Hello World!";

    private static final String SECRET_FIELD = "secretField";

    private static final String SECRET_VALUE = "secret value";

    @Test
    public void test_toStringExclude() {
        final String toString = ReflectionToStringBuilder.toString(new TestFixture());

        assertThat(toString, not(containsString(SECRET_FIELD)));
        assertThat(toString, not(containsString(SECRET_VALUE)));
        assertThat(toString, containsString(NOT_SECRET_FIELD));
        assertThat(toString, containsString(NOT_SECRET_VALUE));
    }

}
