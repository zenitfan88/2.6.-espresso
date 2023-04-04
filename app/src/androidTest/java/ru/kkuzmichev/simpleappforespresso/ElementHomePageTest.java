package ru.kkuzmichev.simpleappforespresso;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;

@RunWith(AllureAndroidJUnit4.class)
public class ElementHomePageTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testHomePageText() {
        ViewInteraction mainText = onView(withId(R.id.text_home));
        mainText.check(matches(isDisplayed()));
        mainText.check(matches(withText("This is home fragment")));
    }

    @Test
    public void testSlideshowText() {
        ViewInteraction appCompatImageButton = onView(withContentDescription("Open navigation drawer"));
        appCompatImageButton.check(matches(isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction slideshowButton = onView(withId(R.id.nav_slideshow));
        slideshowButton.check(matches(isDisplayed()));
        slideshowButton.perform(click());

        ViewInteraction mainText = onView(withId(R.id.text_slideshow));
        mainText.check(matches(isDisplayed()));
        mainText.check(matches(withText("This is slideshow fragment")));
    }
}
