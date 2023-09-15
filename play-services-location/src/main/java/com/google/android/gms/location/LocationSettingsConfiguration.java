/*
 * SPDX-FileCopyrightText: 2021, microG Project Team
 * SPDX-License-Identifier: Apache-2.0
 */

package com.google.android.gms.location;

import org.microg.gms.common.Hide;
import org.microg.safeparcel.AutoSafeParcelable;

@Hide
public class LocationSettingsConfiguration extends AutoSafeParcelable {
    public static final Creator<LocationSettingsConfiguration> CREATOR = new AutoCreator<>(LocationSettingsConfiguration.class);
    @Field(1)
    public String justificationText;
    @Field(2)
    public String experimentId;
    @Field(5)
    public String titleText;
}
