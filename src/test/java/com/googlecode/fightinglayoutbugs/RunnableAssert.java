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

/**
* Helper class for {@link TestHelper#waitFor}.
*
* @author Michael Tamm
*/
public abstract class RunnableAssert {

    private final String _description;

    public RunnableAssert(String description) {
        _description = description;
    }

    public abstract void run() throws Exception;

    @Override
    public String toString() {
        return _description;
    }
}
