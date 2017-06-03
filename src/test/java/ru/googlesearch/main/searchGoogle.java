package ru.googlesearch.main;

import com.codeborne.selenide.*;
import org.junit.Test;
import ru.googlesearch.utils.Page;

public class searchGoogle {

    @Test
    public void Search() {
        Page google = new Page();

        google.open().searchText("selenium");
        google.results().shouldHaveSize(10);
        google.results().get(0).shouldHave(Condition.text("www.seleniumhq.org"));

        google.searchImage();
        google.resultsImages().shouldHaveSize(3);
        google.resultsImages().get(1).shouldHave(Condition.text("www.seleniumhq.org"));

        google.searchAll();
        google.results().shouldHaveSize(10);
        google.results().get(0).shouldHave(Condition.text("www.seleniumhq.org"));

    }
}

