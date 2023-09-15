/*
 * SPDX-FileCopyrightText: 2022 microG Project Team
 * SPDX-License-Identifier: Apache-2.0
 */

package com.google.android.gms.location.reporting;

import org.microg.safeparcel.AutoSafeParcelable;

public class SendDataRequest extends AutoSafeParcelable {
    public static final Creator<SendDataRequest> CREATOR = new AutoCreator<SendDataRequest>(SendDataRequest.class);
    @Field(1)
    public String dataType;
    @Field(2)
    public byte[] data;
}
