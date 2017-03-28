package com.marceme.tddfasterpracting;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.marceme.tddfasterpracting.mainui.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import rx.Observable;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * @author Marcelino Yax-marce7j@gmail.com-Android Developer
 *         Created on 2/7/2017.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void shouldHaveInstruction() throws Exception{
        String expectedInstruction = mActivityRule.getActivity().getString(R.string.instruction_text);
        onView(withId(R.id.text_instruction)).check(matches(isDisplayed()));
        onView(withId(R.id.text_instruction)).check(matches(withText(expectedInstruction)));
    }

    @Test
    public void shouldHaveImageButton() throws Exception{
        String expectedImageBtnText = mActivityRule.getActivity().getString(R.string.action_image);
        onView(withId(R.id.button_image)).check(matches(isDisplayed()));
        onView(withId(R.id.button_image)).check(matches(withText(expectedImageBtnText)));
    }

    @Test
    public void shouldHaveNutritionButton() throws Exception{
        String expectedNutritionixBtnText = mActivityRule.getActivity().getString(R.string.action_nutritionix);
        onView(withId(R.id.button_nutritionix)).check(matches(isDisplayed()));
        onView(withId(R.id.button_nutritionix)).check(matches(withText(expectedNutritionixBtnText)));
    }

    @Test
    public void shouldHaveFeedbackButton() throws Exception{
        String expectedFeedbackBtnText = mActivityRule.getActivity().getString(R.string.action_feedback);
        onView(withId(R.id.button_feedback)).check(matches(isDisplayed()));
        onView(withId(R.id.button_feedback)).check(matches(withText(expectedFeedbackBtnText)));
    }
}