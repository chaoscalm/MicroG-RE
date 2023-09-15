/*
 * SPDX-FileCopyrightText: 2021, microG Project Team
 * SPDX-License-Identifier: Apache-2.0
 */

package com.google.firebase.dynamiclinks.internal;

import com.google.firebase.dynamiclinks.ShortDynamicLink;

import org.microg.safeparcel.AutoSafeParcelable;
import org.microg.safeparcel.SafeParceled;

public class WarningImpl extends AutoSafeParcelable implements ShortDynamicLink.Warning {
    public static final Creator<WarningImpl> CREATOR = new AutoCreator<WarningImpl>(WarningImpl.class);
    @Field(2)
    private final String message;
    @Field(1)
    @Deprecated
    private int code = 1;

    private WarningImpl() {
        this.message = null;
    }

    public WarningImpl(String message) {
        this.message = message;
    }

    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
