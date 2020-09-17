package com.haixue.lib.network.base

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter
import java.io.IOException

/**
 * Copyright (c) 2020 北京嗨学网教育科技股份有限公司 All rights reserved.
 *
 * @author 袁斌
 * @date 2020-04-26
 * @description CustomerGsonTypeAdapterFactory
 *
 */
class CustomerGsonTypeAdapterFactory : TypeAdapterFactory {
    override fun <T> create(gson: Gson, type: TypeToken<T>): TypeAdapter<T> {
        val adapter = gson.getDelegateAdapter(this, type)
        return object : TypeAdapter<T>() {
            @Throws(IOException::class)
            override fun write(out: JsonWriter, value: T) {
                adapter.write(out, value)
            }

            @Throws(IOException::class)
            override fun read(inParam: JsonReader): T? {

                return try {
                    adapter.read(inParam)
                } catch (e: Throwable) {
                    consumeAll(inParam)
                    null
                }

            }
            @Throws(IOException::class)
            private fun consumeAll(inParam: JsonReader) {
                if (inParam.hasNext()) {
                    val peek = inParam.peek()
                    when {
                        peek === JsonToken.STRING       -> inParam.nextString()
                        peek === JsonToken.BEGIN_ARRAY  -> {
                            inParam.beginArray()
                            consumeAll(inParam)
                            inParam.endArray()
                        }
                        peek === JsonToken.BEGIN_OBJECT -> {
                            inParam.beginObject()
                            consumeAll(inParam)
                            inParam.endObject()
                        }
                        peek === JsonToken.END_ARRAY    -> inParam.endArray()
                        peek === JsonToken.END_OBJECT   -> inParam.endObject()
                        peek === JsonToken.NUMBER       -> inParam.nextString()
                        peek === JsonToken.BOOLEAN      -> inParam.nextBoolean()
                        peek === JsonToken.NAME         -> {
                            inParam.nextName()
                            consumeAll(inParam)
                        }
                        peek === JsonToken.NULL         -> inParam.nextNull()
                    }
                }
            }
        }
    }
}