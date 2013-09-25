/**
 * Archetype - phresco-javawebservice-archetype
 *
 * Copyright (C) 1999-2013 Photon Infotech Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.photon.phresco.service;

import java.io.IOException;
import java.io.InputStream;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.commons.io.IOUtils;

/**
 * Cofiguration Service hosted at the URI path "/sample"
 */
@Path("/sample")
public class SampleService {

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public String getConfig() {
		String jsonString = "";
		try {
			InputStream is = this.getClass().getClassLoader()
					.getResourceAsStream("sample.json");
			jsonString = IOUtils.toString(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonString;
	}
}
