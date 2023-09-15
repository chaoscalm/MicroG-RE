/*
 * SPDX-FileCopyrightText: 2017 microG Project Team
 * SPDX-License-Identifier: Apache-2.0
 */

package com.google.android.gms.safetynet;

import org.microg.safeparcel.AutoSafeParcelable;

public class RecaptchaResultData extends AutoSafeParcelable {
    public static final Creator<RecaptchaResultData> CREATOR = new AutoCreator<RecaptchaResultData>(RecaptchaResultData.class);
    @Field(2)
    public String token;
}
