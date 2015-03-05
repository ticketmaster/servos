/*
 * Copyright (C) 2015 Two Toasters
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.twotoasters.servos.util;

import android.widget.TextView;

/**
 * Helper class that returns a trimmed String representation of a TextView's contents.
 * Usage: String trimmed = Trimmer.on(TextView).trim();
 */
public final class Trimmer {

    public static Trimmer on(TextView v) {
        return new Trimmer(v);
    }

    TextView v;

    private Trimmer(TextView v) {
        this.v = v;
    }

    public String trim() {
        CharSequence cs = (v != null) ? v.getText() : null;
        return (cs != null) ? cs.toString().trim() : null;
    }

}
