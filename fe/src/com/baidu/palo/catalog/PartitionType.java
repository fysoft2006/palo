// Copyright (c) 2017, Baidu.com, Inc. All Rights Reserved

// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package com.baidu.palo.catalog;

import com.baidu.palo.thrift.TPartitionType;

/**
 * Created by zhaochun on 14-8-26.
 */
public enum PartitionType {
    UNPARTITIONED("UNPARTITIONED"),
    RANGE("RANGE");

    public String typeString;

    private PartitionType(String typeString) {
        this.typeString = typeString;
    }

    public static PartitionType fromThrift(TPartitionType tType) {
        switch (tType) {
            case UNPARTITIONED:
                return UNPARTITIONED;
            case RANGE_PARTITIONED:
                return RANGE;
            default:
                return UNPARTITIONED;
        }
    }

    public TPartitionType toThrift() {
        switch (this) {
            case UNPARTITIONED:
                return TPartitionType.UNPARTITIONED;
            case RANGE:
                return TPartitionType.RANGE_PARTITIONED;
            default:
                return TPartitionType.UNPARTITIONED;
        }
    }

}
