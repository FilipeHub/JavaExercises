package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JsonManipulatorTest {
    private String jsonContent1 = "[\n" +
            "  {\n" +
            "    \"country\": \"US\",\n" +
            "    \"languages\": [ \"en\" ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"country\": \"BE\",\n" +
            "    \"languages\": [ \"nl\", \"fr\", \"de\" ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"country\": \"NL\",\n" +
            "    \"languages\": [ \"nl\", \"fy\", \"en\", \"xy\" ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"country\": \"DE\",\n" +
            "    \"languages\": [ \"de\" ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"country\": \"ES\",\n" +
            "    \"languages\": [ \"es\" ]\n" +
            "  }\n" +
            "]";

    private String jsonContent2 = "[\n" +
            "  {\n" +
            "    \"country\": \"US\",\n" +
            "    \"languages\": [ \"en\" ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"country\": \"NL\",\n" +
            "    \"languages\": [ \"nl\", \"en\" ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"country\": \"ES\",\n" +
            "    \"languages\": [ \"es\" ]\n" +
            "  }\n" +
            "]";
    private String jsonContentEmpty = "[]";

    //Number of countries
    @Test
    void itShouldReturn5TheTotalCountries() {
        int countTotalCountries = JsonManipulator.countTotalCountries(jsonContent1);
        assertThat(countTotalCountries).isEqualTo(5);
    }

    @Test
    void itShouldReturnZeroTheTotalCountries() {
        int countTotalCountries = JsonManipulator.countTotalCountries(jsonContentEmpty);
        assertThat(countTotalCountries).isEqualTo(0);
    }

    //The Country That Speak German With Most Officially Languages
    @Test
    void itShouldReturnBEOfTheCountryThatSpeakGermanWithMostOfficiallyLanguages() {
        String result = JsonManipulator.countryThatSpeakGermanWithMostOfficiallyLanguages(jsonContent1);
        assertThat(result).isEqualTo("BE");
    }

    @Test
    void itShouldReturnEmptyOfTheCountryThatSpeakGermanWithMostOfficiallyLanguages() {
        String result = JsonManipulator.countryThatSpeakGermanWithMostOfficiallyLanguages(jsonContent2);
        assertThat(result).isEqualTo("");
    }

    @Test
    void itShouldReturnEmptyOfTheCountryThatSpeakGermanWithMostOfficiallyLanguages2() {
        String result = JsonManipulator.countryThatSpeakGermanWithMostOfficiallyLanguages(jsonContentEmpty);
        assertThat(result).isEqualTo("");
    }


    //The Country That With Most Officially Languages

    @Test
    void itShouldReturnNLTheCountryWithMostOfficiallyLanguages() {
        String result = JsonManipulator.countryWithMostOfficiallyLanguagesInJson(jsonContent1);
        assertThat(result).isEqualTo("NL");
    }

    @Test
    void itShouldReturnEmptyTheCountryWithMostOfficiallyLanguages() {
        String result = JsonManipulator.countryWithMostOfficiallyLanguagesInJson(jsonContentEmpty);
        assertThat(result).isEqualTo("");
    }

    //Count All Officially Languages

    @Test
    void itShouldReturn7TheCountOfficiallyLanguages() {
        int result = JsonManipulator.countLanguages(jsonContent1);
        assertThat(result).isEqualTo(7);
    }

    @Test
    void itShouldReturn5TheCountOfficiallyLanguages() {
        int result = JsonManipulator.countLanguages(jsonContent2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void itShouldReturn0TheCountOfficiallyLanguages() {
        int result = JsonManipulator.countLanguages(jsonContentEmpty);
        assertThat(result).isEqualTo(0);
    }

    // Language Most Common
    @Test
    void itShouldReturnPTToLanguageMostCommon() {
        String result = JsonManipulator.languageMostCommon(jsonContent1);
        assertThat(result).isEqualTo("nl");
    }

    @Test
    void itShouldReturnENToLanguageMostCommon() {
        String result = JsonManipulator.languageMostCommon(jsonContent2);
        assertThat(result).isEqualTo("en");
    }

    @Test
    void itShouldReturnEmptyToLanguageMostCommon() {
        String result = JsonManipulator.languageMostCommon(jsonContentEmpty);
        assertThat(result).isEqualTo("");
    }

}
