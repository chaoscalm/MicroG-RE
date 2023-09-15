/*
 * SPDX-FileCopyrightText: 2020, microG Project Team
 * SPDX-License-Identifier: Apache-2.0
 */

package com.google.firebase.auth.api.internal;

import org.microg.safeparcel.AutoSafeParcelable;

import java.util.ArrayList;
import java.util.List;

public class ProviderUserInfoList extends AutoSafeParcelable {
    public static final Creator<ProviderUserInfoList> CREATOR = new AutoCreator<>(ProviderUserInfoList.class);
    @Field(2)
    public List<ProviderUserInfo> providerUserInfos = new ArrayList<>();
}
