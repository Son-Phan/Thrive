package com.group20.thrive.ui.diary;


import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
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
@RunWith(AndroidJUnit4ClassRunner.class)
public class SurveyMoodActivityTest {

    @Rule
    public ActivityScenarioRule<SurveyMoodActivity> mActivityTestRule = new ActivityScenarioRule<>(SurveyMoodActivity.class);

    @Test
    public void checkboxExist(){
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
                allOf(withId(R.id.checkbox_sleep_early),
                        withParent(allOf(withId(R.id.activity3),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        checkBox9.check(matches(isDisplayed()));

        ViewInteraction checkBox10 = onView(
                allOf(withId(R.id.checkbox_eat_healthy),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class))),
                        isDisplayed()));
        checkBox10.check(matches(isDisplayed()));

        ViewInteraction checkBox11 = onView(
                allOf(withId(R.id.checkbox_fat_foot),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class))),
                        isDisplayed()));
        checkBox11.check(matches(isDisplayed()));

        ViewInteraction checkBox12 = onView(
                allOf(withId(R.id.checkbox_homemade),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class))),
                        isDisplayed()));
        checkBox12.check(matches(isDisplayed()));

        ViewInteraction checkBox13 = onView(
                allOf(withId(R.id.checkbox_restaurant),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class))),
                        isDisplayed()));
        checkBox13.check(matches(isDisplayed()));

        ViewInteraction checkBox14 = onView(
                allOf(withId(R.id.checkbox_delivery),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class))),
                        isDisplayed()));
        checkBox14.check(matches(isDisplayed()));

        ViewInteraction checkBox15 = onView(
                allOf(withId(R.id.checkbox_no_meat),
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
    }

    @Test
    public void radioGroupAndButtonExist(){
        ViewInteraction radioGroup = onView(
                allOf(withId(R.id.radioGroup),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        radioGroup.check(matches(isDisplayed()));

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
    }

    @Test
    public void textViewExist(){
        ViewInteraction textView = onView(
                allOf(withId(R.id.textView3), withText("How are you?"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView.check(matches(withText("How are you?")));


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

        ViewInteraction textView2 = onView(
                allOf(withText("Thrive"),
                        withParent(allOf(withId(R.id.action_bar),
                                withParent(withId(R.id.action_bar_container)))),
                        isDisplayed()));
        textView2.check(matches(withText("Thrive")));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.textView7), withText("What have you been up to?"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView3.check(matches(withText("What have you been up to?")));


        ViewInteraction textView4 = onView(
                allOf(withId(R.id.textView9), withText("Hobbies"),
                        withParent(allOf(withId(R.id.activity2),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        textView4.check(matches(withText("Hobbies")));
        ViewInteraction textView5 = onView(
                allOf(withText("Food"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class))),
                        isDisplayed()));
        textView5.check(matches(withText("Food")));

        ViewInteraction textView6 = onView(
                allOf(withText("Sleep"),
                        withParent(allOf(withId(R.id.activity3),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        textView6.check(matches(withText("Sleep")));

        ViewInteraction textView7 = onView(
                allOf(withText("Sleep"),
                        withParent(allOf(withId(R.id.activity3),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        textView7.check(matches(withText("Sleep")));
    }
    @Test
    public void surveyMoodActivityTest() {

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




        ViewInteraction imageButton = onView(
                allOf(withId(R.id.save_button),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        imageButton.check(matches(isDisplayed()));




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
                allOf(withId(R.id.checkbox_no_meat),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        3),
                                2),
                        isDisplayed()));
        materialCheckBox4.perform(click());

        ViewInteraction materialCheckBox5 = onView(
                allOf(withId(R.id.checkbox_fat_foot),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        3),
                                1),
                        isDisplayed()));
        materialCheckBox5.perform(click());

        ViewInteraction materialCheckBox6 = onView(
                allOf(withId(R.id.checkbox_eat_healthy),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        3),
                                0),
                        isDisplayed()));
        materialCheckBox6.perform(click());

        ViewInteraction materialCheckBox7 = onView(
                allOf(withId(R.id.checkbox_restaurant),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        3),
                                5),
                        isDisplayed()));
        materialCheckBox7.perform(click());

        ViewInteraction materialCheckBox8 = onView(
                allOf(withId(R.id.checkbox_no_sweets),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        3),
                                4),
                        isDisplayed()));
        materialCheckBox8.perform(click());

        ViewInteraction materialCheckBox9 = onView(
                allOf(withId(R.id.checkbox_no_soda),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        3),
                                6),
                        isDisplayed()));
        materialCheckBox9.perform(click());

        ViewInteraction materialCheckBox10 = onView(
                allOf(withId(R.id.checkbox_delivery),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        3),
                                7),
                        isDisplayed()));
        materialCheckBox10.perform(click());

        ViewInteraction materialCheckBox11 = onView(
                allOf(withId(R.id.checkbox_sleep_early),
                        childAtPosition(
                                allOf(withId(R.id.activity3),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                2)),
                                3),
                        isDisplayed()));
        materialCheckBox11.perform(click());

        ViewInteraction materialCheckBox12 = onView(
                allOf(withId(R.id.checkbox_bad_sleep),
                        childAtPosition(
                                allOf(withId(R.id.activity3),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                2)),
                                2),
                        isDisplayed()));
        materialCheckBox12.perform(click());

        ViewInteraction materialCheckBox13 = onView(
                allOf(withId(R.id.checkbox_good_sleep),
                        childAtPosition(
                                allOf(withId(R.id.activity3),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                2)),
                                0),
                        isDisplayed()));
        materialCheckBox13.perform(click());

        ViewInteraction materialCheckBox14 = onView(
                allOf(withId(R.id.checkbox_reading),
                        childAtPosition(
                                allOf(withId(R.id.activity2),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                1),
                        isDisplayed()));
        materialCheckBox14.perform(click());

        ViewInteraction materialCheckBox15 = onView(
                allOf(withId(R.id.checkbox_gaming),
                        childAtPosition(
                                allOf(withId(R.id.activity2),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                2),
                        isDisplayed()));
        materialCheckBox15.perform(click());

        ViewInteraction materialCheckBox16 = onView(
                allOf(withId(R.id.checkbox_sport),
                        childAtPosition(
                                allOf(withId(R.id.activity2),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                3),
                        isDisplayed()));
        materialCheckBox16.perform(click());

        ViewInteraction materialCheckBox17 = onView(
                allOf(withId(R.id.checkbox_relax),
                        childAtPosition(
                                allOf(withId(R.id.activity2),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                4),
                        isDisplayed()));
        materialCheckBox17.perform(click());
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
