/*
 * SPDX-FileCopyrightText: 2022 microG Project Team
 * SPDX-License-Identifier: Apache-2.0
 */

package com.google.android.gms.location.internal;

import com.google.android.gms.location.IDeviceOrientationListener;

import org.microg.gms.common.Hide;
import org.microg.safeparcel.AutoSafeParcelable;

@Hide
public class DeviceOrientationRequestUpdateData extends AutoSafeParcelable {
    public static final int REQUEST_UPDATES = 1;
    public static final int REMOVE_UPDATES = 2;
    public static final Creator<DeviceOrientationRequestUpdateData> CREATOR = new AutoCreator<DeviceOrientationRequestUpdateData>(DeviceOrientationRequestUpdateData.class);
    @Field(1)
    public int opCode;
    @Field(2)
    public DeviceOrientationRequestInternal request;
    @Field(3)
    public IDeviceOrientationListener listener;
    @Field(4)
    public IFusedLocationProviderCallback fusedLocationProviderCallback;

    @Override
    public String toString() {
        return "DeviceOrientationRequestUpdateData{" +
                "opCode=" + opCode +
                ", request=" + request +
                ", listener=" + (listener != null ? listener.asBinder() : null) +
                ", fusedLocationProviderCallback=" + (fusedLocationProviderCallback != null ? fusedLocationProviderCallback.asBinder() : null) +
                '}';
    }
}
