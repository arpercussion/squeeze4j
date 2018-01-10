package com.obscured.squeeze4j.converters;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringToListOfString extends JsonDeserializer<List<String>> {
	@Override
	public List<String> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException {
		List<String> result = null;
		String t = jsonParser.getText();
		if (StringUtils.isNotEmpty(t)) {
			if (StringUtils.contains(t, ",")) {
				result = Stream.of(t.split(","))
				               .map(String::trim)
				               .collect(Collectors.toList());
			} else {
				result = Collections.singletonList(t);
			}
		}
		return result;
	}
}
