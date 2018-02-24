/*
Copyright 2018 FZI Forschungszentrum Informatik

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package org.streampipes.messaging.jms;

import org.streampipes.messaging.EventConsumer;
import org.streampipes.messaging.EventProducer;
import org.streampipes.messaging.SpProtocolDefinition;
import org.streampipes.model.grounding.JmsTransportProtocol;

public class SpJmsProtocol implements SpProtocolDefinition<JmsTransportProtocol> {

  private EventConsumer<JmsTransportProtocol> jmsConsumer;
  private EventProducer<JmsTransportProtocol> jmsProducer;

  public SpJmsProtocol() {
    this.jmsConsumer = new ActiveMQConsumer();
    this.jmsProducer = new ActiveMQPublisher();
  }

  @Override
  public EventConsumer<JmsTransportProtocol> getConsumer() {
    return jmsConsumer;
  }

  @Override
  public EventProducer<JmsTransportProtocol> getProducer() {
    return jmsProducer;
  }
}
