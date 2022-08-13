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

package org.apache.streampipes.export.resolver;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.streampipes.export.utils.SerializationUtils;
import org.apache.streampipes.model.export.ExportItem;
import org.apache.streampipes.model.pipeline.Pipeline;

public class PipelineResolver extends AbstractResolver<Pipeline> {

  @Override
  public Pipeline findDocument(String resourceId) {
    var doc = getNoSqlStore().getPipelineStorageAPI().getPipeline(resourceId);
    doc.setRev(null);
    doc.setRestartOnSystemReboot(false);
    doc.setRunning(false);
    return doc;
  }

  @Override
  public Pipeline readDocument(String serializedDoc) throws JsonProcessingException {
    return SerializationUtils.getSpObjectMapper().readValue(serializedDoc, Pipeline.class);
  }

  @Override
  public ExportItem convert(Pipeline document) {
    return new ExportItem(document.getPipelineId(), document.getName(), true);
  }

  @Override
  public void writeDocument(String document) throws JsonProcessingException {
    getNoSqlStore().getPipelineStorageAPI().storePipeline(deserializeDocument(document));
  }

  @Override
  protected Pipeline deserializeDocument(String document) throws JsonProcessingException {
    return this.spMapper.readValue(document, Pipeline.class);
  }
}