/*
 * Copyright (C) 2020 Graylog, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the Server Side Public License, version 1,
 * as published by MongoDB, Inc.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Server Side Public License for more details.
 *
 * You should have received a copy of the Server Side Public License
 * along with this program. If not, see
 * <http://www.mongodb.com/licensing/server-side-public-license>.
 */
package org.graylog.integrations.aws.resources.responses;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import org.graylog.autovalue.WithBeanGetter;

@JsonAutoDetect
@AutoValue
@WithBeanGetter
public abstract class KinesisNewStreamResponse {

    private static final String STREAM_NAME = "stream_name";
    private static final String STREAM_ARN = "stream_arn";
    private static final String RESULT = "result";

    @JsonProperty(STREAM_NAME)
    public abstract String streamName();

    @JsonProperty(STREAM_ARN)
    public abstract String streamArn();

    @JsonProperty(RESULT)
    public abstract String result();

    public static KinesisNewStreamResponse create(@JsonProperty(STREAM_NAME) String streamName,
                                                  @JsonProperty(STREAM_ARN) String streamArn,
                                                  @JsonProperty(RESULT) String result) {
        return new AutoValue_KinesisNewStreamResponse(streamName, streamArn, result);
    }
}