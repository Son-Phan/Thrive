package com.group20.thrive;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4ClassRunner.class)
public class ProfileActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityTestRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void textViewExist(){
        ViewInteraction textView = onView(
                allOf(withText("Profile"),
                        withParent(allOf(withId(R.id.action_bar),
                                withParent(withId(R.id.action_bar_container)))),
                        isDisplayed()));
        textView.check(matches(withText("Profile")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.textView), withText("userName"),
                        withParent(withParent(withId(R.id.nav_host_fragment_activity_main))),
                        isDisplayed()));
        textView2.check(matches(withText("userName")));

        ViewInteraction textView3 = onView(
                allOf(withText("EXERCISE"),
                        withParent(allOf(withContentDescription("Exercise"),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))),
                        isDisplayed()));
        textView3.check(matches(withText("EXERCISE")));

        ViewInteraction textView4 = onView(
                allOf(withText("EXERCISE"),
                        withParent(allOf(withContentDescription("Exercise"),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))),
                        isDisplayed()));
        textView4.check(matches(withText("EXERCISE")));

        ViewInteraction textView5 = onView(
                allOf(withText("MEDITATE"),
                        withParent(allOf(withContentDescription("Meditate"),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))),
                        isDisplayed()));
        textView5.check(matches(withText("MEDITATE")));

        ViewInteraction textView6 = onView(
                allOf(withText("DIARY"),
                        withParent(allOf(withContentDescription("Diary"),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))),
                        isDisplayed()));
        textView6.check(matches(withText("DIARY")));

        ViewInteraction textView7 = onView(
                allOf(withText("SLEEP"),
                        withParent(allOf(withContentDescription("Sleep"),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))),
                        isDisplayed()));
        textView7.check(matches(withText("SLEEP")));

        ViewInteraction textView8 = onView(
                allOf(withId(R.id.exerciseStreak), withText("Streak"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class))),
                        isDisplayed()));
        textView8.check(matches(withText("Streak")));

        ViewInteraction textView9 = onView(
                allOf(withId(R.id.average), withText("Average"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class))),
                        isDisplayed()));
        textView9.check(matches(withText("Average")));
    }

    @Test
    public void imageButtonExist(){
        ViewInteraction imageButton = onView(
                allOf(withId(R.id.imageButton),
                        withParent(withParent(withId(R.id.nav_host_fragment_activity_main))),
                        isDisplayed()));
        imageButton.check(matches(isDisplayed()));

    }
    @Test
    public void recycleViewExist(){
        ViewInteraction recyclerView = onView(
                allOf(withParent(allOf(withId(R.id.viewPager),
                        withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        recyclerView.check(matches(isDisplayed()));
    }

    @Test
    public void viewGroupExist(){

        ViewInteraction viewGroup = onView(
                allOf(withId(R.id.exerciseBarChart),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class))),
                        isDisplayed()));
        viewGroup.check(matches(isDisplayed()));

        ViewInteraction viewGroup2 = onView(
                allOf(withId(R.id.exerciseBarChart),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class))),
                        isDisplayed()));
        viewGroup2.check(matches(isDisplayed()));

    }
    @Test
    public void profileActivityTest() {



        ViewInteraction tabView = onView(
                allOf(withContentDescription("Meditate"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabLayout),
                                        0),
                                1),
                        isDisplayed()));
        tabView.perform(click());

        ViewInteraction tabView2 = onView(
                allOf(withContentDescription("Sleep"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabLayout),
                                        0),
                                2),
                        isDisplayed()));
        tabView2.perform(click());

        ViewInteraction tabView3 = onView(
                allOf(withContentDescription("Diary"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabLayout),
                                        0),
                                3),
                        isDisplayed()));
        tabView3.perform(click());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
