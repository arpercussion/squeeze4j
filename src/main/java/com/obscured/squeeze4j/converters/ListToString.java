package com.obscured.squeeze4j.converters;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ListToString extends JsonSerializer<List<Integer>> {

	@Override
	public void serialize(List<Integer> o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException {

		String result = null;
		if (o == null || o.isEmpty()) {
			// noop
		} else if (o.size() < 2) {
			result = Integer.toString(o.get(0));
		} else {
			result = o.stream()
			          .map(v -> Integer.toString(v))
			          .collect(Collectors.joining(","));
		}

		jsonGenerator.writeObject(result);
	}
}
