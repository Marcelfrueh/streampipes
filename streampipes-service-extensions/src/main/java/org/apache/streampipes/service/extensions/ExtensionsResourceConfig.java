/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.apache.streampipes.service.extensions;


import org.apache.streampipes.rest.extensions.WelcomePage;
import org.apache.streampipes.rest.extensions.connect.AdapterAssetResource;
import org.apache.streampipes.rest.extensions.connect.AdapterWorkerResource;
import org.apache.streampipes.rest.extensions.connect.GuessResource;
import org.apache.streampipes.rest.extensions.connect.HttpServerAdapterResource;
import org.apache.streampipes.rest.extensions.connect.RuntimeResolvableResource;
import org.apache.streampipes.rest.extensions.monitoring.MonitoringResource;
import org.apache.streampipes.rest.extensions.pe.DataProcessorPipelineElementResource;
import org.apache.streampipes.rest.extensions.pe.DataSinkPipelineElementResource;
import org.apache.streampipes.rest.extensions.pe.DataStreamPipelineElementResource;
import org.apache.streampipes.rest.extensions.pe.PipelineTemplateResource;
import org.apache.streampipes.rest.shared.serializer.JacksonSerializationProvider;
import org.apache.streampipes.service.base.rest.BaseResourceConfig;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExtensionsResourceConfig extends BaseResourceConfig {

  @Override
  public List<List<Class<?>>> getClassesToRegister() {
    return List.of(
        getAdapterResourceClasses(),
        getBaseResourceClasses(),
        getPipelineElementResourceClasses()
    );
  }

  private List<Class<?>> getAdapterResourceClasses() {
    return List.of(
        GuessResource.class,
        RuntimeResolvableResource.class,
        AdapterWorkerResource.class,
        MultiPartFeature.class,
        AdapterAssetResource.class,
        HttpServerAdapterResource.class);
  }

  private List<Class<?>> getBaseResourceClasses() {
    return List.of(
        JacksonSerializationProvider.class,
        MonitoringResource.class);
  }

  private List<Class<?>> getPipelineElementResourceClasses() {
    return List.of(
        DataSinkPipelineElementResource.class,
        DataProcessorPipelineElementResource.class,
        DataStreamPipelineElementResource.class,
        WelcomePage.class,
        PipelineTemplateResource.class);
  }
}
