/*
 * SPDX-FileCopyrightText: 2022 microG Project Team
 * SPDX-License-Identifier: Apache-2.0
 */

package com.google.android.gms.fido.fido2.api.common;

import org.microg.safeparcel.AutoSafeParcelable;

import java.util.List;

public class CableAuthenticationExtension extends AutoSafeParcelable {
    public static final Creator<CableAuthenticationExtension> CREATOR = new AutoCreator<>(CableAuthenticationExtension.class);
    @Field(1)
    private List<CableAuthenticationData> cableAuthentication;
}
