/*
 * Copyright 2018 Andrew Louth
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

package au.com.louth.kwiet.actions

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import au.com.louth.kwiet.actions.actionsdk.ActionsSdkApp
import au.com.louth.kwiet.actions.actionsdk.Serializer
import au.com.louth.kwiet.actions.actionsdk.ActionRequest
import au.com.louth.kwiet.actions.actionsdk.ActionResponse


object JacksonSerializer : Serializer {
    val mapper = jacksonObjectMapper()
    override fun <T> serialize(obj: T) = mapper.writeValueAsString(obj)
    override fun <T> deserialize(str: String, clazz: Class<T>) = mapper.readValue(str, clazz)
}

fun buildLambdaApp(request: ActionRequest, serializer: Serializer = JacksonSerializer): ActionsSdkApp {
    val requestWrapper = RequestWrapper(body = request)
    val responseWrapper = ResponseWrapper(body = ActionResponse())
    return ActionsSdkApp(requestWrapper, responseWrapper, serializer = serializer)
}