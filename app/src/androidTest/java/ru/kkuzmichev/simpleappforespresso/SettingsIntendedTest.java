package ru.kkuzmichev.simpleappforespresso;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;

import android.content.Intent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.intent.rule.IntentsTestRule;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;

@RunWith(AllureAndroidJUnit4.class)
public class SettingsIntendedTest {

    @Rule
    public IntentsTestRule intentsTestRule = new IntentsTestRule(MainActivity.class);

    @Test
    public void settingsIntendedTest() {
        ViewInteraction buttonToolbar = onView(
                Matchers.allOf(withParent(withParent(withId(R.id.toolbar)))));
        buttonToolbar.check(matches(isDisplayed()));
        buttonToolbar.perform(click());

        ViewInteraction buttonSettings = onView(withId(R.id.title));
        buttonSettings.check(matches(isDisplayed()));
        buttonSettings.perform(click());

        intended(hasData("https://google.com"));
        intended(hasAction(Intent.ACTION_VIEW));
    }
}
