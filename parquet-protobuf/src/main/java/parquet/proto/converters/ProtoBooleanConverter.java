/**
 * Copyright 2013 Lukas Nalezenec.
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

package parquet.proto.converters;

import parquet.io.api.PrimitiveConverter;

final class ProtoBooleanConverter extends PrimitiveConverter {

  final ParentValueContainer parent;

  public ProtoBooleanConverter(ParentValueContainer parent) {
    this.parent = parent;
  }

  @Override
  final public void addBoolean(boolean value) {
    parent.add(value ? Boolean.TRUE : Boolean.FALSE);
  }

}
