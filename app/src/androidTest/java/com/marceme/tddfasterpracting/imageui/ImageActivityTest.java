package com.marceme.tddfasterpracting.imageui;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.marceme.tddfasterpracting.R;
import com.marceme.tddfasterpracting.TestComponentRule;
import com.marceme.tddfasterpracting.model.Image;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.mockito.Mockito.doReturn;

/**
 * @author Marcelino Yax-marce7j@gmail.com-Android Developer
 *         Created on 2/23/2017.
 */

@RunWith(AndroidJUnit4.class)
public class ImageActivityTest {

    public final TestComponentRule component =
            new TestComponentRule(InstrumentationRegistry.getTargetContext());
    @Rule
    public ActivityTestRule<ImageActivity> mImageActivityRule = new ActivityTestRule<>(
            ImageActivity.class, false, false);

    @Rule
    public TestRule chain = RuleChain.outerRule(component).around(mImageActivityRule);

    @Test
    public void shouldDisplayImagesInRecyclerView() throws Exception{

        List<Image> emptyImageList = new ArrayList<>();
        doReturn(Observable.just(emptyImageList))
                .when(component.getMockDataManager())
                .getImages();

        onView(withText(mImageActivityRule.getActivity().getString(R.string.error_no_image)))
                .check(matches(isDisplayed()));
    }


}