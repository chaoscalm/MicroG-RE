/*
 * SPDX-FileCopyrightText: 2020, microG Project Team
 * SPDX-License-Identifier: Apache-2.0
 */

package com.google.android.gms.phenotype;

import org.microg.safeparcel.AutoSafeParcelable;

public class Configuration extends AutoSafeParcelable {
    public static final Creator<Configuration> CREATOR = new AutoCreator<>(Configuration.class);
    @Field(2)
    public int flagType;
    @Field(3)
    public Flag[] flags;
    @Field(4)
    public String[] names;
}
