package ge.tbc.testautomation.steps.Tbc;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import ge.tbc.testautomation.pages.TBC.BlogPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.*;

public class BlogSteps {
    BlogPage blogPage = new BlogPage();

    public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy", Locale.ENGLISH);

    public List<LocalDate> getBlogDates(int count) {
        int take = Math.min(5, blogPage.blogCards.size());
        List<LocalDate> dates = new ArrayList<>();

        for (int i = 0; i < take; i++) {

            blogPage.freshCards.shouldHave(CollectionCondition.sizeGreaterThan(0));
            blogPage.freshCards.get(i).scrollTo().click();

            blogPage.dateText.getText().trim();

            LocalDate parsed = LocalDate.parse(blogPage.dateText.getText().trim(), formatter);
            dates.add(parsed);

            back();
        }

        return dates;

    }


}
