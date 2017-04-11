package com.obscured.squeeze4j.converters;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class BooleanToInteger extends JsonSerializer<Boolean> {
	@Override
	public void serialize(Boolean o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException {
		jsonGenerator.writeObject(o ? 1 : 0);
	}
}
