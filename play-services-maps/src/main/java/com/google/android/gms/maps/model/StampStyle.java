/*
 * SPDX-FileCopyrightText: 2022 microG Project Team
 * SPDX-License-Identifier: Apache-2.0
 */

package com.google.android.gms.maps.model;

import android.os.IBinder;

import org.microg.safeparcel.AutoSafeParcelable;

public class StampStyle extends AutoSafeParcelable {
    public static final Creator<StampStyle> CREATOR = new AutoCreator<>(StampStyle.class);
    @Field(2)
    private IBinder stamp;
    private BitmapDescriptor stampDescriptor;
}
