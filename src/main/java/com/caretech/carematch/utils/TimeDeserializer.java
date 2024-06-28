package com.caretech.carematch.utils;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class TimeDeserializer extends StdDeserializer<Time> {

	public TimeDeserializer() {
		this(null);
	}
	
	public TimeDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public Time deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		JsonNode node = p.getCodec().readTree(p);
		String timeStr = node.asText();
		LocalTime localTime = LocalTime.parse(timeStr, DateTimeFormatter.ISO_LOCAL_TIME);
		return Time.valueOf(localTime);
	}
	

}
