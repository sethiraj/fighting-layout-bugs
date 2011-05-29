/*
 * Copyright 2009-2011 Michael Tamm
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.googlecode.fightinglayoutbugs;

import org.junit.Test;

import java.util.Collection;

import static com.googlecode.fightinglayoutbugs.HamcrestHelper.*;

public class DetectNeedsHorizontalScrollingTest extends TestUsingSelenium {

    @Test
    public void test() {
        final DetectNeedsHorizontalScrolling detector = new DetectNeedsHorizontalScrolling();
        WebPage doesNotNeedHorizontalScrollingPage = getWebPageFor("/page_which_does_not_need_horizontal_scrolling.html");
        assertThat(detector.findLayoutBugsIn(doesNotNeedHorizontalScrollingPage), isEmpty());
        WebPage needsHorizontalScrollingPage = getWebPageFor("/page_which_needs_horizontal_scrolling.html");
        final Collection<LayoutBug> layoutBugs = detector.findLayoutBugsIn(needsHorizontalScrollingPage);
        for (LayoutBug bug : layoutBugs) {
            System.out.println(bug);
        }
        assertThat(layoutBugs.size(), is(1));
    }

}
