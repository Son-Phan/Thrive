package com.group20.thrive;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.navigation.Navigation;
import androidx.navigation.testing.TestNavHostController;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.group20.thrive.ui.today.TodayFragment;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest {

    @Rule
    public  ActivityScenarioRule<MainActivity> mActivityTestRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    @LargeTest
    public void mainActivityTest() {
//        ViewInteraction button = onView(
//                allOf(withId(R.id.btn_sign_in_app), withText("Sign in"),
//                        childAtPosition(
//                                allOf(withId(R.id.sign_in),
//                                        childAtPosition(
//                                                withId(android.R.id.content),
//                                                0)),
//                                1),
//                        isDisplayed()));
//        button.perform(click());
//
//        ViewInteraction appCompatEditText = onView(
//                allOf(withId(R.id.input_email),
//                        childAtPosition(
//                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
//                                2),
//                        isDisplayed()));
//        appCompatEditText.perform(replaceText("testing@gmail.com"), closeSoftKeyboard());
//
//        ViewInteraction appCompatEditText2 = onView(
//                allOf(withId(R.id.input_password),
//                        childAtPosition(
//                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
//                                3),
//                        isDisplayed()));
//        appCompatEditText2.perform(replaceText("123456"), closeSoftKeyboard());
//
//        ViewInteraction button2 = onView(
//                allOf(withId(R.id.btn_sign_in_confirm), withText("Confirm"),
//                        childAtPosition(
//                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
//                                4),
//                        isDisplayed()));
//        button2.perform(click());

        ViewInteraction bottomNavigationItemView1 = onView(
                allOf(withId(R.id.navigation_diary), withContentDescription("Diary"),
                        withParent(withParent(withId(R.id.nav_view)))));
        bottomNavigationItemView1.perform(click());

        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.navigation_today), withContentDescription("Today"),
                        withParent(withParent(withId(R.id.nav_view)))));
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
