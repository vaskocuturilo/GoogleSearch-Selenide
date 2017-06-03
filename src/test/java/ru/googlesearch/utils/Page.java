package ru.googlesearch.utils;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static ru.googlesearch.utils.PropertyLoader.loadProperty;

public class Page {

    public static final String MainField = "q";
    public static final String LinkImages = "Images";
    public static final String ImagesName = "i48MSmX01sE18M:";
    public static final String SearchElementsText = ".srg .g";
    public static final String SearchElementsImages = ".irc_ho";
    public static final String SearchResultImagesElements = ".rg_ic.rg_i";
    public static final String PROP_FILE = "/testdata.properties";

    public Page open() {
        Selenide.open(loadProperty("GOOGLE"));
        return this;
    }

    public SearchResults searchText(String text) {
        $(By.name(MainField)).val(text).pressEnter();
        return new SearchResults();
    }

    public ResultImage searchImage() {
        $(By.linkText(LinkImages)).click();
        $(By.name(ImagesName)).click();
        return new ResultImage();
    }


    public ElementsCollection results() {

        return $$(SearchElementsText);
    }

    public ElementsCollection resultsImages() {

        return $$(SearchElementsImages);
    }

    public SearchResults searchAll() {
        $(By.linkText("All")).click();
        return new SearchResults();
    }


    public static class SearchResults {
        private final ElementsCollection elements = $$(SearchElementsText);
    }

    public static class ResultImage {
        private final ElementsCollection elementsImage = $$(SearchResultImagesElements);
    }
}