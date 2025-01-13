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

import { Component, Input, OnInit } from '@angular/core';
import { stringify } from 'yaml';
import { MatTabChangeEvent } from '@angular/material/tabs';

@Component({
    selector: 'sp-configuration-code-panel',
    templateUrl: './configuration-code-panel.component.html',
    styleUrls: ['./configuration-code-panel.component.scss'],
})
export class ConfigurationCodePanelComponent implements OnInit {
    @Input()
    configuration: any;

    @Input()
    maxHeight = '300px';

    configurationYaml: string;
    configurationJson: string;

    currentConfiguration: string;

    ngOnInit() {
        this.configurationYaml = stringify(this.configuration);
        this.configurationJson = JSON.stringify(this.configuration);
        this.currentConfiguration = this.configurationYaml;
    }

    onTabChanged(event: MatTabChangeEvent) {
        if (event.index === 0) {
            this.currentConfiguration = this.configurationYaml;
        } else {
            this.currentConfiguration = this.configurationJson;
        }
    }
}