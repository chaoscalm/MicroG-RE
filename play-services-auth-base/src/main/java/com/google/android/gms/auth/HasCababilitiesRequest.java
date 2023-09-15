/*
 * SPDX-FileCopyrightText: 2022 microG Project Team
 * SPDX-License-Identifier: Apache-2.0
 */

package com.google.android.gms.auth;

import android.accounts.Account;

import org.microg.safeparcel.AutoSafeParcelable;

public class HasCababilitiesRequest extends AutoSafeParcelable {
    public static final Creator<HasCababilitiesRequest> CREATOR = new AutoCreator<>(HasCababilitiesRequest.class);
    @Field(1)
    public Account account;
    @Field(2)
    public String[] capabilities;
}
