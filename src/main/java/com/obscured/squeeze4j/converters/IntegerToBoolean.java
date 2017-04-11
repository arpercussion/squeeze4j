package com.obscured.squeeze4j.converters;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class IntegerToBoolean extends JsonDeserializer<Boolean> {
	@Override
	public Boolean deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException {
		return jsonParser.getIntValue() > 0 ? Boolean.TRUE : Boolean.FALSE;
	}
}
