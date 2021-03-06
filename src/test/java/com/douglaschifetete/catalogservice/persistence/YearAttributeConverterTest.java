package com.douglaschifetete.catalogservice.persistence;

import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.assertj.core.api.Assertions.assertThat;

class YearAttributeConverterTest {

    @Test
    void whenYearThanConvertToInteger() {
        YearAttributeConverter converter = new YearAttributeConverter();
        Year expectedYear = Year.of(1973);
        int actualYear = converter.convertToDatabaseColumn(expectedYear);
        assertThat(actualYear).isEqualTo(expectedYear.getValue());
    }

    @Test
    void whenIntegerThanConvertToYear() {
        YearAttributeConverter converter = new YearAttributeConverter();
        int expectedYear = 1973;
        Year actualYear = converter.convertToEntityAttribute(expectedYear);
        assertThat(actualYear.getValue()).isEqualTo(expectedYear);
    }
}
