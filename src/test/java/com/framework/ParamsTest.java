package com.framework;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class ParamsTest {
    @ParameterizedTest
    @MethodSource("stringProvider")
    void testWithExplicitLocalMethodSource(String argument) {
        assertNotNull(argument);

    }

    static Stream<String> stringProvider() {
        return Stream.of("apple", "banana");
    }

    @ParameterizedTest
//    @ValueSource(strings = {"search demo1","search demo2"})
    @MethodSource()
    void search(TestCase testCase){
        System.out.println(testCase);
        testCase.run();
    }

    static Stream<TestCase> search() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        TestCase testCase = mapper.readValue(
                ParamsTest.class.getResourceAsStream("/framework/search.yaml"),
       TestCase.class);
        return Stream.of(testCase);
    }





















}
