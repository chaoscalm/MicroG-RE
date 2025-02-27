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

package com.google.android.gms.location;

import android.location.Location;

import androidx.annotation.NonNull;

/**
 * Used for receiving notifications from the {@link FusedLocationProviderApi} when the location has
 * changed. The methods are called if the LocationListener has been registered with the location
 * client.
 */
public interface LocationListener {

    /**
     * Called when the location has changed.
     *
     * @param location The updated location.
     */
    public void onLocationChanged(@NonNull Location location);
}
