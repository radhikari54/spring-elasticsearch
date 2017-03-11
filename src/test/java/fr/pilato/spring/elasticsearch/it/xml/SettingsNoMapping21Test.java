/*
 * Licensed to David Pilato (the "Author") under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. Author licenses this
 * file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package fr.pilato.spring.elasticsearch.it.xml;

import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.client.Client;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class SettingsNoMapping21Test extends AbstractXmlContextModel {
    private String[] xmlBeans = {"/models/settings-no-mapping-21/settings-no-mapping-21-context.xml"};

    @Override
    String[] xmlBeans() {
        return xmlBeans;
    }

    @Override
    public String indexName() {
        return "twitter";
    }

    @Test
	public void test_settings_without_mapping() {
		Client client = checkClient();

		// We should have an existing index here
        IndicesExistsResponse ier = client.admin().indices().prepareExists("twitter").execute().actionGet();
        assertThat(ier.isExists(), is(true));
    }
}