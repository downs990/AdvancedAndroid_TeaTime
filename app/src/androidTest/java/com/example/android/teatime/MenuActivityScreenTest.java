/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.teatime;

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;

/**
 * This test demos a user clicking on a GridView item in MenuActivity which opens up the
 * corresponding OrderActivity.
 *
 * This test does not utilize Idling Resources yet. If idling is set in the MenuActivity,
 * then this test will fail. See the IdlingResourcesTest for an identical test that
 * takes into account Idling Resources.
 */


// TODO (1) Add annotation to specify AndroidJUnitRunner class as the default test runner
@RunWith(AndroidJUnit4ClassRunner.class)
public class MenuActivityScreenTest {

    public static final String TEA_NAME = "Black Tea";

    // TODO (2) Add the rule that provides functional testing of a single activity
    @Rule
    public ActivityTestRule<MenuActivity> mActivityTestRule
            =   new ActivityTestRule<>(MenuActivity.class);


    // TODO (3) Finish writing this test which will click on a gridView Tea item and verify that
    // the OrderActivity opens up with the correct tea name displayed.
    @Test
    public void clickGridViewItem_OpensOrderActivity() {


        // 1. Find the view
        onData( anything() ).inAdapterView(withId(R.id.tea_grid_view))
        // 2. Perform action on the view
            .atPosition(0).perform(click());
        // 3. Check if the view does what you expected


        onView(withId(R.id.tea_name_text_view)).check(matches(withText(TEA_NAME)));

    }

}