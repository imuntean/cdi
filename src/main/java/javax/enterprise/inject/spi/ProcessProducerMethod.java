/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package javax.enterprise.inject.spi;

/**
 * <p>
 * The container fires an event of this type for each enabled producer method, 
 * before registering the {@link javax.enterprise.inject.spi.Bean} object.
 * </p>
 * <p>
 * If any observer method of a {@code ProcessProducerMethod} event throws an
 * exception, the exception is treated as a definition error by the container.
 * </p>
 * 
 * @author David Allen
 * @param <T> The return type of the producer method
 * @param <X> The class of the bean declaring the producer method
 */
//These parameters are the wrong way according to the spec, however Oracle/JCP compatibility rules require us to 
//keep the wrong ordering
public interface ProcessProducerMethod<T, X> extends ProcessBean<X>
{
   /**
    * Returns the {@link javax.enterprise.inject.spi.AnnotatedMethod}
    * representing the producer method.
    * 
    * @return the {@link javax.enterprise.inject.spi.AnnotatedMethod} for the
    *         producer method being registered
    */
   public AnnotatedMethod<T> getAnnotatedProducerMethod();

   /**
    * Returns the {@link javax.enterprise.inject.spi.AnnotatedParameter} for
    * any matching injection point of the same type as the producer method
    * return type found on a disposal method.
    * 
    * @return the disposal method's {@link javax.enterprise.inject.spi.AnnotatedParameter}
    */
   public AnnotatedParameter<T> getAnnotatedDisposedParameter();
}
