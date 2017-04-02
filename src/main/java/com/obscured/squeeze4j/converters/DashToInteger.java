package com.obscured.squeeze4j.converters;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class DashToInteger extends JsonDeserializer<Integer> {
	@Override
	public Integer deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException {

		Integer i = 0;
		String t = jsonParser.getText();
		if (!t.equals("-")) {
			i = Integer.parseInt(t);
		}
		return i;
	}
}
