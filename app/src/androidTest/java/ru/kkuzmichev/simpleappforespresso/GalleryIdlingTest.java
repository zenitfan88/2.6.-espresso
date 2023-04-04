package ru.kkuzmichev.simpleappforespresso;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.ViewInteraction;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;

@RunWith(AllureAndroidJUnit4.class)
public class GalleryIdlingTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Before
    public void registerIdlingResources() {
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource);
    }

    @After
    public void unregisterIdlingResources() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource);
    }



    @Test
    public void galleryIdlingTest() {
        ViewInteraction appCompatImageButton = onView(
                withContentDescription("Open navigation drawer"));
        appCompatImageButton.check(matches(isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction galleryButton = onView(withId(R.id.nav_gallery));
        galleryButton.check(matches(isDisplayed()));
        galleryButton.perform(click());

        ViewInteraction recyclerView = onView(withId(R.id.recycle_view));
        recyclerView.check(matches(CustomViewMatcher.recyclerViewSizeMatcher(10)));
    }
}
