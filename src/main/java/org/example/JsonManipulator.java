package org.example;

import com.jayway.jsonpath.JsonPath;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class JsonManipulator {

    public static int countTotalCountries(String jsonContent) {
        return JsonPath.parse(jsonContent).read("$.length()");
    }

    private static String countryWithMostOfficiallyLanguagesInList(List<LinkedHashMap> countries) {
        LinkedHashMap countryWithMostOfficiallyLanguages = null;
        for (var currentCountry : countries) {
            if(countryWithMostOfficiallyLanguages == null ||
                    ((List) countryWithMostOfficiallyLanguages.get("languages")).size() < ((List) currentCountry.get("languages")).size())
                countryWithMostOfficiallyLanguages = currentCountry;
        }
        return (countryWithMostOfficiallyLanguages == null ? "" : countryWithMostOfficiallyLanguages.get("country").toString());
    }

    public static String countryThatSpeakGermanWithMostOfficiallyLanguages(String jsonContent) {
        List<LinkedHashMap> countriesThatSpeakGerman = JsonPath.parse(jsonContent).read("$[?(\"de\" in @.languages)]");
        return countryWithMostOfficiallyLanguagesInList(countriesThatSpeakGerman);
    }

    public static String countryWithMostOfficiallyLanguagesInJson(String jsonContent) {
        List<LinkedHashMap> countries = JsonPath.parse(jsonContent).read("$");
        return countryWithMostOfficiallyLanguagesInList(countries);
    }

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

    public static void main(String[] args) {
        try{
            String content = Files.readString(Paths.get("json_file.json"));

//            List countries = JsonPath.parse(content).read("$.*.country");
//            List onlyLanguages = JsonPath.parse(content).read("$..languages");

            System.out.println(languageMostCommon(content));
//            System.out.println(countLanguages(content));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
