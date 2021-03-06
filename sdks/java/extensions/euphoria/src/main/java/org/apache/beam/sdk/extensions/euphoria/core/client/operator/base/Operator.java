/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.beam.sdk.extensions.euphoria.core.client.operator.base;

import java.io.Serializable;
import java.util.Optional;
import javax.annotation.Nullable;
import org.apache.beam.sdk.extensions.euphoria.core.annotation.audience.Audience;
import org.apache.beam.sdk.extensions.euphoria.core.client.type.TypeAware;
import org.apache.beam.sdk.values.TypeDescriptor;

/** An operator base class. All operators extends this class. */
@Audience(Audience.Type.INTERNAL)
public abstract class Operator<OutputT> implements Serializable, TypeAware.Output<OutputT> {

  /** Name of the operator. */
  @Nullable private final String name;

  /** The type of output elements. */
  @Nullable private final TypeDescriptor<OutputT> outputType;

  protected Operator(@Nullable String name, @Nullable TypeDescriptor<OutputT> outputType) {
    this.name = name;
    this.outputType = outputType;
  }

  /**
   * Returns user provided name of the operator.
   *
   * @return maybe name
   */
  public Optional<String> getName() {
    return Optional.ofNullable(name);
  }

  @Override
  public Optional<TypeDescriptor<OutputT>> getOutputType() {
    return Optional.ofNullable(outputType);
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + " operator{" + "name='" + name + '\'' + '}';
  }
}
