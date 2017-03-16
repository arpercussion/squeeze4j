package com.obscured.squeeze4j.converters;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class IntegerToDash extends JsonSerializer {
	@Override
	public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException {

		Object r = "-";
		Integer i = (Integer) o;
		if (i > 0) {
			r = i;
		}
		jsonGenerator.writeObject(r);
	}
}
