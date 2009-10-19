/*
 * Copyright 2009 Michael Tamm
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

package de.michaeltamm.fightinglayoutbugs;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static de.michaeltamm.fightinglayoutbugs.HamcrestHelper.assertThat;
import static de.michaeltamm.fightinglayoutbugs.HamcrestHelper.is;


public class Utf8BomAwareByteArrayOutputStreamTest {

    @Test
    public void test() throws UnsupportedEncodingException {
        Utf8BomAwareByteArrayOutputStream out = new Utf8BomAwareByteArrayOutputStream();
        assertThat(out.hasUtf8Bom(), is(false));
        out.write((byte) 0xEF);
        out.write((byte) 0xBB);
        assertThat(out.hasUtf8Bom(), is(false));
        out.write((byte) 0xBF);
        assertThat(out.hasUtf8Bom(), is(true));
        out.write((byte) 0x61);
        assertThat(out.toString(), is(""));
        assertThat(out.toString("UTF-8"), is(""));
        assertThat(out.hasUtf8Bom(), is(true));
        assertThat(out.toString(), is("a"));
        assertThat(out.toString("UTF-8"), is("a"));
    }

}
