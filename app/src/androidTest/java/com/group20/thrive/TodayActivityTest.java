package com.group20.thrive;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
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

import java.time.ZoneId;
import java.time.ZonedDateTime;

@LargeTest
@RunWith(AndroidJUnit4ClassRunner.class)
// WARNING: Espresso Test Recorder was paused during recording.
// The generated test may be missing actions which might lead to unexpected behavior.
public class TodayActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityTestRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void textViewExist(){
        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.navigation_today), withContentDescription("Today"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0),
                                0),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());
        ViewInteraction textView = onView(
                allOf(withText("Today"),
                        withParent(allOf(withId(R.id.action_bar),
                                withParent(withId(R.id.action_bar_container)))),
                        isDisplayed()));
        textView.check(matches(withText("Today")));

        int currentTime = ZonedDateTime.now(ZoneId.systemDefault()).getHour();

        String text;

        if (currentTime > 6 && currentTime < 12) { text = "Good Morning!"; }
        else if (currentTime > 12 && currentTime < 18) { text = "Good Afternoon!"; }
        else { text = "Good Evening!"; }
        ViewInteraction textView2 = onView(
                allOf(withId(R.id.greetings), withText(text),
                        withParent(allOf(withId(R.id.fragment_plans_layout),
                                withParent(withId(R.id.nav_host_fragment_activity_main)))),
                        isDisplayed()));
        textView2.check(matches(withText(text)));
        ViewInteraction textView3 = onView(
                allOf(withId(R.id.morning), withText("Morning"),
                        withParent(allOf(withId(R.id.fragment_plans_layout),
                                withParent(withId(R.id.nav_host_fragment_activity_main)))),
                        isDisplayed()));
        textView3.check(matches(withText("Morning")));
        ViewInteraction textView4 = onView(
                allOf(withId(R.id.activity1Name), withText("meditation_01"),
                        withParent(allOf(withId(R.id.activity1),
                                withParent(withId(R.id.fragment_plans_layout)))),
                        isDisplayed()));
        textView4.check(matches(withText("meditation_01")));

        ViewInteraction textView6 = onView(
                allOf(withId(R.id.afternoon), withText("Afternoon"),
                        withParent(allOf(withId(R.id.fragment_plans_layout),
                                withParent(withId(R.id.nav_host_fragment_activity_main)))),
                        isDisplayed()));
        textView6.check(matches(withText("Afternoon")));
        ViewInteraction textView9 = onView(
                allOf(withId(R.id.evening), withText("Evening"),
                        withParent(allOf(withId(R.id.fragment_plans_layout),
                                withParent(withId(R.id.nav_host_fragment_activity_main)))),
                        isDisplayed()));
        textView9.check(matches(withText("Evening")));
    }

    @Test
    public void viewGroupExist(){
        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.navigation_today), withContentDescription("Today"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0),
                                0),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());
        ViewInteraction viewGroup = onView(
                allOf(withId(R.id.decor_content_parent),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class))),
                        isDisplayed()));
        viewGroup.check(matches(isDisplayed()));


        ViewInteraction viewGroup2 = onView(
                allOf(withId(R.id.action_bar),
                        withParent(allOf(withId(R.id.action_bar_container),
                                withParent(withId(R.id.decor_content_parent)))),
                        isDisplayed()));
        viewGroup2.check(matches(isDisplayed()));



        ViewInteraction viewGroup3 = onView(
                allOf(withId(R.id.container),
                        withParent(allOf(withId(android.R.id.content),
                                withParent(withId(R.id.decor_content_parent)))),
                        isDisplayed()));
        viewGroup3.check(matches(isDisplayed()));
    }

    @Test
    public void viewExist(){
        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.navigation_today), withContentDescription("Today"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0),
                                0),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());
        ViewInteraction view = onView(
                allOf(withId(R.id.divider1A),
                        withParent(allOf(withId(R.id.fragment_plans_layout),
                                withParent(withId(R.id.nav_host_fragment_activity_main)))),
                        isDisplayed()));
        view.check(matches(isDisplayed()));

        ViewInteraction view2 = onView(
                allOf(withId(R.id.divider1B),
                        withParent(allOf(withId(R.id.fragment_plans_layout),
                                withParent(withId(R.id.nav_host_fragment_activity_main)))),
                        isDisplayed()));
        view2.check(matches(isDisplayed()));

        ViewInteraction view3 = onView(
                allOf(withId(R.id.divider1C),
                        withParent(allOf(withId(R.id.fragment_plans_layout),
                                withParent(withId(R.id.nav_host_fragment_activity_main)))),
                        isDisplayed()));
        view3.check(matches(isDisplayed()));
        ViewInteraction view4 = onView(
                allOf(withId(R.id.divider2A),
                        withParent(allOf(withId(R.id.fragment_plans_layout),
                                withParent(withId(R.id.nav_host_fragment_activity_main)))),
                        isDisplayed()));
        view4.check(matches(isDisplayed()));

        ViewInteraction view5 = onView(
                allOf(withId(R.id.divider2B),
                        withParent(allOf(withId(R.id.fragment_plans_layout),
                                withParent(withId(R.id.nav_host_fragment_activity_main)))),
                        isDisplayed()));
        view5.check(matches(isDisplayed()));

        ViewInteraction view6 = onView(
                allOf(withId(R.id.divider2C),
                        withParent(allOf(withId(R.id.fragment_plans_layout),
                                withParent(withId(R.id.nav_host_fragment_activity_main)))),
                        isDisplayed()));
        view6.check(matches(isDisplayed()));

        ViewInteraction view7 = onView(
                allOf(withId(android.R.id.statusBarBackground),
                        withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class)),
                        isDisplayed()));
        view7.check(matches(isDisplayed()));

        ViewInteraction view8 = onView(
                allOf(withId(android.R.id.navigationBarBackground),
                        withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class)),
                        isDisplayed()));
        view8.check(matches(isDisplayed()));

        ViewInteraction view9 = onView(
                allOf(withId(android.R.id.navigationBarBackground),
                        withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class)),
                        isDisplayed()));
        view9.check(matches(isDisplayed()));


    }

    @Test
    public void imageButtonExist(){
        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.navigation_today), withContentDescription("Today"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0),
                                0),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());


        ViewInteraction imageButton = onView(
                allOf(withId(R.id.circle1),
                        withParent(allOf(withId(R.id.fragment_plans_layout),
                                withParent(withId(R.id.nav_host_fragment_activity_main)))),
                        isDisplayed()));
        imageButton.check(matches(isDisplayed()));

        ViewInteraction imageButton2 = onView(
                allOf(withId(R.id.circle2),
                        withParent(allOf(withId(R.id.fragment_plans_layout),
                                withParent(withId(R.id.nav_host_fragment_activity_main)))),
                        isDisplayed()));
        imageButton2.check(matches(isDisplayed()));
        ViewInteraction imageButton3 = onView(
                allOf(withId(R.id.circle3),
                        withParent(allOf(withId(R.id.fragment_plans_layout),
                                withParent(withId(R.id.nav_host_fragment_activity_main)))),
                        isDisplayed()));
        imageButton3.check(matches(isDisplayed()));

    }

    @Test
    public void imageViewExist(){
        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.navigation_today), withContentDescription("Today"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0),
                                0),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());

        ViewInteraction imageView = onView(
                allOf(withId(R.id.activity1Image),
                        withParent(allOf(withId(R.id.activity1),
                                withParent(withId(R.id.fragment_plans_layout)))),
                        isDisplayed()));
        imageView.check(matches(isDisplayed()));
        ViewInteraction imageView2 = onView(
                allOf(withId(R.id.activity2Image),
                        withParent(allOf(withId(R.id.activity2),
                                withParent(withId(R.id.fragment_plans_layout)))),
                        isDisplayed()));
        imageView2.check(matches(isDisplayed()));



        ViewInteraction imageView3 = onView(
                allOf(withId(R.id.activity3Image),
                        withParent(allOf(withId(R.id.activity3),
                                withParent(withId(R.id.fragment_plans_layout)))),
                        isDisplayed()));
        imageView3.check(matches(isDisplayed()));


    }
    @Test
    public void todayActivityTest() {
        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.navigation_today), withContentDescription("Today"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0),
                                0),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());
        ViewInteraction cardView = onView(
                allOf(withId(R.id.activity1),
                        childAtPosition(
                                allOf(withId(R.id.fragment_plans_layout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_activity_main),
                                                0)),
                                13),
                        isDisplayed()));
        cardView.perform(click());


        ViewInteraction appCompatImageView = onView(
                allOf(withId(R.id.playBtn),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatImageView.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton.perform(click());



        ViewInteraction materialButton = onView(
                allOf(withId(R.id.startBtn), withText("begin"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                9),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.finishBtn), withText("finish"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        materialButton2.perform(click());



        ViewInteraction appCompatImageButton2 = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton2.perform(click());



        ViewInteraction cardView2 = onView(
                allOf(withId(R.id.activity2),
                        childAtPosition(
                                allOf(withId(R.id.fragment_plans_layout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_activity_main),
                                                0)),
                                14),
                        isDisplayed()));
        cardView2.perform(click());

        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.startBtn), withText("begin"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                9),
                        isDisplayed()));
        materialButton3.perform(click());

        ViewInteraction materialButton4 = onView(
                allOf(withId(R.id.finishBtn), withText("finish"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        materialButton4.perform(click());


        ViewInteraction appCompatImageButton3 = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton3.perform(click());



        ViewInteraction cardView3 = onView(
                allOf(withId(R.id.activity3),
                        childAtPosition(
                                allOf(withId(R.id.fragment_plans_layout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_activity_main),
                                                0)),
                                15),
                        isDisplayed()));
        cardView3.perform(click());

        ViewInteraction materialButton5 = onView(
                allOf(withId(R.id.startBtn), withText("begin"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                9),
                        isDisplayed()));
        materialButton5.perform(click());

        ViewInteraction materialButton6 = onView(
                allOf(withId(R.id.finishBtn), withText("finish"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton6.perform(click());



        ViewInteraction appCompatImageButton4 = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton4.perform(click());

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
