/*
 * SPDX-FileCopyrightText: 2022 microG Project Team
 * SPDX-License-Identifier: Apache-2.0
 */

package com.google.android.gms.location.reporting;

import org.microg.safeparcel.AutoSafeParcelable;

public class UlrPrivateModeRequest extends AutoSafeParcelable {
    public static final Creator<UlrPrivateModeRequest> CREATOR = new AutoCreator<UlrPrivateModeRequest>(UlrPrivateModeRequest.class);
    @Field(1)
    public String tag;
    @Field(2)
    public boolean privateMode;
}
