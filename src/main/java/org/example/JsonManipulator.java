package org.example;

import com.jayway.jsonpath.JsonPath;

import java.util.*;

/**
 * Class to manipulate Json content with the following structure
 * [
 *  {
 *      country: "US",
 *      languages: [ "en" ]
 *  },
 *  {
 *      country: "BE",
 *      languages: [ "nl", "fr", "de" ]
 *  }
 * ...]
 *
 */
public class JsonManipulator {

    /**
     * Method to count all countries in a Json data
     *
     * @param jsonContent
     * @return
     */
    public static int countTotalCountries(String jsonContent) {
        return JsonPath.parse(jsonContent).read("$.length()");
    }

    /**
     * Method to help others methods, for example countryThatSpeakGermanWithMostOfficiallyLanguages(..) and
     * countryWithMostOfficiallyLanguagesInJson(..), to find the country with most official languages in a list
     *
     * @param countries List of countries
     * @return the acronym of the country with most official languages
     */
    private static String countryWithMostOfficiallyLanguagesInList(List<LinkedHashMap> countries) {
        LinkedHashMap countryWithMostOfficiallyLanguages = null;
        for (var currentCountry : countries) {
            if(countryWithMostOfficiallyLanguages == null ||
                    ((List) countryWithMostOfficiallyLanguages.get("languages")).size() < ((List) currentCountry.get("languages")).size())
                countryWithMostOfficiallyLanguages = currentCountry;
        }
        return (countryWithMostOfficiallyLanguages == null ? "" : countryWithMostOfficiallyLanguages.get("country").toString());
    }

    /**
     * Method to find the country that speaks German with most official languages
     *
     * @param jsonContent Json data
     * @return the acronym of the country that speaks German with most official languages
     */
    public static String countryThatSpeakGermanWithMostOfficiallyLanguages(String jsonContent) {
        List<LinkedHashMap> countriesThatSpeakGerman = JsonPath.parse(jsonContent).read("$[?(\"de\" in @.languages)]");
        return countryWithMostOfficiallyLanguagesInList(countriesThatSpeakGerman);
    }

    /**
     * Method to find the country with most official languages
     *
     * @param jsonContent Json data
     * @return the acronym of the country with most official languages
     */
    public static String countryWithMostOfficiallyLanguagesInJson(String jsonContent) {
        List<LinkedHashMap> countries = JsonPath.parse(jsonContent).read("$");
        return countryWithMostOfficiallyLanguagesInList(countries);
    }

    /**
     * Count the quantity of different languages in the Json data
     *
     * @param jsonContent Json data
     * @return number of total amount of different languages
     */
    public static int countLanguages(String jsonContent) {
        List<List> languages = JsonPath.parse(jsonContent).read("$..languages");
        List<String> differentLanguages = new LinkedList<String>();
        for (var arr : languages) {
            for(var language : arr){
                if(!differentLanguages.contains(language)) differentLanguages.add((String) language);
            }
        }
        return differentLanguages.size();
    }

    /**
     * Method to find the the country that is most common in the countries in a Json data
     *
     * @param jsonContent Json data
     * @return the acronym of the country that is most common in the countries
     */
    public static String languageMostCommon(String jsonContent) {
        List<List> languages = JsonPath.parse(jsonContent).read("$..languages");
        HashMap<String, Integer> languagesMap = new LinkedHashMap<String, Integer>();
        String countryMostCommon = "";
        Integer quantityLanguagesOfCountryMostCommon = 0;
        for (var arr : languages) {
            for(var language : arr){
                languagesMap.computeIfAbsent((String) language, key -> 1);
                languagesMap.computeIfPresent((String) language, (key, val) -> val + 1);

                if(languagesMap.get(language) > quantityLanguagesOfCountryMostCommon) {
                    countryMostCommon = (String) language;
                    quantityLanguagesOfCountryMostCommon = languagesMap.get(language);
                }
            }
        }

        return countryMostCommon;
    }

}
