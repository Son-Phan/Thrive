package com.group20.thrive.ui.diary;


import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static androidx.test.InstrumentationRegistry.getInstrumentation;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import com.group20.thrive.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class SurveyMoodActivityTest {

    @Rule
    public ActivityTestRule<SurveyMoodActivity> mActivityTestRule = new ActivityTestRule<>(SurveyMoodActivity.class);

    @Test
    public void surveyMoodActivityTest() {
        ViewInteraction radioButton = onView(
                allOf(withId(R.id.radioButton), withContentDescription("happy"),
                        withParent(allOf(withId(R.id.radioGroup),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        radioButton.check(matches(isDisplayed()));

        ViewInteraction radioButton2 = onView(
                allOf(withId(R.id.radioButton2), withContentDescription("good"),
                        withParent(allOf(withId(R.id.radioGroup),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        radioButton2.check(matches(isDisplayed()));

        ViewInteraction radioButton3 = onView(
                allOf(withId(R.id.radioButton3), withContentDescription("medium"),
                        withParent(allOf(withId(R.id.radioGroup),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        radioButton3.check(matches(isDisplayed()));

        ViewInteraction radioButton4 = onView(
                allOf(withId(R.id.radioButton4), withContentDescription("bad"),
                        withParent(allOf(withId(R.id.radioGroup),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        radioButton4.check(matches(isDisplayed()));

        ViewInteraction radioButton5 = onView(
                allOf(withId(R.id.radioButton5), withContentDescription("awful"),
                        withParent(allOf(withId(R.id.radioGroup),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        radioButton5.check(matches(isDisplayed()));

        ViewInteraction radioButton6 = onView(
                allOf(withId(R.id.radioButton5), withContentDescription("awful"),
                        withParent(allOf(withId(R.id.radioGroup),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        radioButton6.check(matches(isDisplayed()));

        ViewInteraction materialRadioButton = onView(
                allOf(withId(R.id.radioButton), withContentDescription("happy"),
                        childAtPosition(
                                allOf(withId(R.id.radioGroup),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                0),
                        isDisplayed()));
        materialRadioButton.perform(click());

        ViewInteraction materialCheckBox = onView(
                allOf(withId(R.id.checkbox_tv),
                        childAtPosition(
                                allOf(withId(R.id.activity2),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                0),
                        isDisplayed()));
        materialCheckBox.perform(click());

        ViewInteraction materialCheckBox2 = onView(
                allOf(withId(R.id.checkbox_medium_sleep),
                        childAtPosition(
                                allOf(withId(R.id.activity3),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                2)),
                                1),
                        isDisplayed()));
        materialCheckBox2.perform(click());

        ViewInteraction materialCheckBox3 = onView(
                allOf(withId(R.id.checkbox_homemade),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        3),
                                3),
                        isDisplayed()));
        materialCheckBox3.perform(click());

        ViewInteraction materialCheckBox4 = onView(
                allOf(withId(R.id.checkbox_fat_foot),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        3),
                                1),
                        isDisplayed()));
        materialCheckBox4.perform(click());

        ViewInteraction checkBox = onView(
                allOf(withId(R.id.checkbox_tv),
                        withParent(allOf(withId(R.id.activity2),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        checkBox.check(matches(isDisplayed()));

        ViewInteraction checkBox2 = onView(
                allOf(withId(R.id.checkbox_reading),
                        withParent(allOf(withId(R.id.activity2),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        checkBox2.check(matches(isDisplayed()));

        ViewInteraction checkBox3 = onView(
                allOf(withId(R.id.checkbox_gaming),
                        withParent(allOf(withId(R.id.activity2),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        checkBox3.check(matches(isDisplayed()));

        ViewInteraction checkBox4 = onView(
                allOf(withId(R.id.checkbox_sport),
                        withParent(allOf(withId(R.id.activity2),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        checkBox4.check(matches(isDisplayed()));

        ViewInteraction checkBox5 = onView(
                allOf(withId(R.id.checkbox_relax),
                        withParent(allOf(withId(R.id.activity2),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        checkBox5.check(matches(isDisplayed()));

        ViewInteraction checkBox6 = onView(
                allOf(withId(R.id.checkbox_good_sleep),
                        withParent(allOf(withId(R.id.activity3),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        checkBox6.check(matches(isDisplayed()));

        ViewInteraction checkBox7 = onView(
                allOf(withId(R.id.checkbox_medium_sleep),
                        withParent(allOf(withId(R.id.activity3),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        checkBox7.check(matches(isDisplayed()));

        ViewInteraction checkBox8 = onView(
                allOf(withId(R.id.checkbox_bad_sleep),
                        withParent(allOf(withId(R.id.activity3),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        checkBox8.check(matches(isDisplayed()));

        ViewInteraction checkBox9 = onView(
                allOf(withId(R.id.checkbox_eat_healthy),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class))),
                        isDisplayed()));
        checkBox9.check(matches(isDisplayed()));

        ViewInteraction checkBox10 = onView(
                allOf(withId(R.id.checkbox_fat_foot),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class))),
                        isDisplayed()));
        checkBox10.check(matches(isDisplayed()));

        ViewInteraction checkBox11 = onView(
                allOf(withId(R.id.checkbox_homemade),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class))),
                        isDisplayed()));
        checkBox11.check(matches(isDisplayed()));

        ViewInteraction checkBox12 = onView(
                allOf(withId(R.id.checkbox_restaurant),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class))),
                        isDisplayed()));
        checkBox12.check(matches(isDisplayed()));

        ViewInteraction checkBox13 = onView(
                allOf(withId(R.id.checkbox_delivery),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class))),
                        isDisplayed()));
        checkBox13.check(matches(isDisplayed()));

        ViewInteraction checkBox14 = onView(
                allOf(withId(R.id.checkbox_no_meat),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class))),
                        isDisplayed()));
        checkBox14.check(matches(isDisplayed()));

        ViewInteraction checkBox15 = onView(
                allOf(withId(R.id.checkbox_no_sweets),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class))),
                        isDisplayed()));
        checkBox15.check(matches(isDisplayed()));

        ViewInteraction checkBox16 = onView(
                allOf(withId(R.id.checkbox_no_sweets),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class))),
                        isDisplayed()));
        checkBox16.check(matches(isDisplayed()));

        ViewInteraction checkBox17 = onView(
                allOf(withId(R.id.checkbox_no_soda),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class))),
                        isDisplayed()));
        checkBox17.check(matches(isDisplayed()));

        ViewInteraction imageButton = onView(
                allOf(withId(R.id.save_button),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        imageButton.check(matches(isDisplayed()));

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
