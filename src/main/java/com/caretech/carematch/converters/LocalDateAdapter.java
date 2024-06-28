package com.caretech.carematch.converters;

import java.io.IOException;
import java.time.LocalDate;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class LocalDateAdapter extends TypeAdapter<LocalDate>{

	@Override
	public void write(JsonWriter out, LocalDate value) throws IOException {
		if (value == null) {
            out.nullValue();
            return;
        }
        out.value(value.toString());
	}

	@Override
	public LocalDate read(JsonReader in) throws IOException {
		String dateString = in.nextString();
        return LocalDate.parse(dateString);
	}

	
	
}
