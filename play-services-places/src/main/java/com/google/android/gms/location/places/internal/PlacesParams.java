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

package com.google.android.gms.location.places.internal;

import org.microg.safeparcel.AutoSafeParcelable;
import org.microg.safeparcel.SafeParceled;

public class PlacesParams extends AutoSafeParcelable {

    public static final Creator<PlacesParams> CREATOR = new AutoCreator<PlacesParams>(PlacesParams.class);
    @SafeParceled(1)
    public final String clientPackageName;
    @SafeParceled(2)
    public final String locale;
    @SafeParceled(3)
    public final String accountName;
    @SafeParceled(4)
    public final String gCoreClientName;
    @SafeParceled(1000)
    private int versionCode = 1;

    private PlacesParams() {
        clientPackageName = locale = accountName = gCoreClientName = null;
    }
}
