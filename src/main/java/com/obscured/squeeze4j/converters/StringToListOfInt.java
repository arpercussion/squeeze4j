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

public class StringToListOfInt extends JsonDeserializer<List<Integer>> {
	@Override
	public List<Integer> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException {
		List<Integer> result = null;
		String t = jsonParser.getText();
		if (StringUtils.isNotEmpty(t)) {
			if (StringUtils.contains(t, ",")) {
				result = Stream.of(t.split(","))
				               .map(String::trim)
				               .map(Integer::parseInt)
				               .collect(Collectors.toList());
			} else {
				result = Collections.singletonList(Integer.parseInt(t));
			}
		}
		return result;
	}
}
