/**
 * Copyright 2013 Lukas Nalezenec
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package parquet.proto;

import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import parquet.io.api.GroupConverter;
import parquet.io.api.RecordMaterializer;
import parquet.proto.converters.ProtoRecordConverter;
import parquet.schema.MessageType;

class ProtoRecordMaterializer<T extends MessageOrBuilder> extends RecordMaterializer<T> {

  private final ProtoRecordConverter<T> root;

  public ProtoRecordMaterializer(MessageType requestedSchema, Class<? extends Message> protobufClass) {
    this.root = new ProtoRecordConverter<T>(protobufClass, requestedSchema);
  }

  @Override
  public T getCurrentRecord() {
    return root.getCurrentRecord();
  }

  @Override
  public GroupConverter getRootConverter() {
    return root;
  }
}
