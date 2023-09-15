/*
 * Copyright (C) 2013-2017 microG Project Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.gms.search.global;

import org.microg.safeparcel.AutoSafeParcelable;
import org.microg.safeparcel.SafeParceled;

import java.util.Arrays;

public class SetExperimentIdsRequest extends AutoSafeParcelable {

    public static final Creator<SetExperimentIdsRequest> CREATOR = new AutoCreator<SetExperimentIdsRequest>(SetExperimentIdsRequest.class);
    @SafeParceled(1)
    public byte[] experimentIds;

    @SafeParceled(2)
    public boolean enable;
    @SafeParceled(1000)
    private int versionCode = 1;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SetExperimentIdsRequest{");
        sb.append("experimentIds=").append(Arrays.toString(experimentIds));
        sb.append(", enable=").append(enable);
        sb.append('}');
        return sb.toString();
    }
}
