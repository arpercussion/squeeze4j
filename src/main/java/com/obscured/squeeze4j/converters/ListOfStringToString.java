package com.obscured.squeeze4j.converters;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ListOfStringToString extends JsonSerializer<List<String>> {

	@Override
	public void serialize(List<String> o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException {

		String result = null;
		if (o == null || o.isEmpty()) {
			// noop
		} else if (o.size() < 2) {
			result = o.get(0);
		} else {
			result = o.stream()
			          .collect(Collectors.joining(","));
		}

		jsonGenerator.writeObject(result);
	}
}
