import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Page {


    public Page open() {
        Selenide.open("http://google.com/ncr");
        return this;
    }

    public SearchResults searchText(String text) {
        $(By.name("q")).val(text).pressEnter();
        return new SearchResults();
    }

    public ResultImage searchImage() {
        $(By.linkText("Images")).click();
        $(By.name("i48MSmX01sE18M:")).click();
        return new ResultImage();
    }


    public ElementsCollection results() {

        return $$(".srg .g");
    }

    public ElementsCollection resultsImages() {

        return $$(".irc_ho");
    }

    public SearchResults searchAll() {
        $(By.linkText("All")).click();
        return new SearchResults();
    }


    public static class SearchResults {
        private final ElementsCollection elements = $$(".srg .g");
    }

    public static class ResultImage {
        private final ElementsCollection elementsImage = $$(".rg_ic.rg_i");
    }
}