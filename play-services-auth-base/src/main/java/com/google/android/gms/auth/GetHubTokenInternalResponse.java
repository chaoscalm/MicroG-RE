/*
 * SPDX-FileCopyrightText: 2022 microG Project Team
 * SPDX-License-Identifier: Apache-2.0
 */

package com.google.android.gms.auth;

import android.content.Intent;

import org.microg.safeparcel.AutoSafeParcelable;

public class GetHubTokenInternalResponse extends AutoSafeParcelable {
    public static final Creator<GetHubTokenInternalResponse> CREATOR = new AutoCreator<>(GetHubTokenInternalResponse.class);
    @Field(1)
    public TokenData tokenData;
    @Field(2)
    public String status;
    @Field(3)
    public Intent recoveryIntent;
}
