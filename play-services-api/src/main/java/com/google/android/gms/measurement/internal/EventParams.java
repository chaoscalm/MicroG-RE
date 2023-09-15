/*
 * SPDX-FileCopyrightText: 2020, microG Project Team
 * SPDX-License-Identifier: Apache-2.0
 */

package com.google.android.gms.measurement.internal;

import android.os.Bundle;

import org.microg.safeparcel.AutoSafeParcelable;

public class EventParams extends AutoSafeParcelable {
    public static final Creator<EventParams> CREATOR = new AutoCreator<>(EventParams.class);
    @Field(2)
    public Bundle data;
}
