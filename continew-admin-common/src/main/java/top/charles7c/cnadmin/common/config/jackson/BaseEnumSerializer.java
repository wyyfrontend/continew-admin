/*
 * Copyright (c) 2022-present Charles7c Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package top.charles7c.cnadmin.common.config.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

import top.charles7c.cnadmin.common.base.BaseEnum;

/**
 * 通用枚举接口 BaseEnum 序列化器
 *
 * @author Charles7c
 * @since 2023/1/8 13:56
 */
@JacksonStdImpl
public class BaseEnumSerializer extends JsonSerializer<BaseEnum> {

    /** 静态实例 */
    public static final BaseEnumSerializer SERIALIZER_INSTANCE = new BaseEnumSerializer();

    @Override
    public void serialize(BaseEnum value, JsonGenerator generator, SerializerProvider serializers) throws IOException {
        generator.writeObject(value.getValue());
    }
}
