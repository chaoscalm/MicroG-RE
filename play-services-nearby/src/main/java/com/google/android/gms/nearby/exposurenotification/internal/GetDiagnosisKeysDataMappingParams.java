/*
 * SPDX-FileCopyrightText: 2020, microG Project Team
 * SPDX-License-Identifier: Apache-2.0
 */

package com.google.android.gms.nearby.exposurenotification.internal;

import org.microg.safeparcel.AutoSafeParcelable;

public class GetDiagnosisKeysDataMappingParams extends AutoSafeParcelable {
    public static final Creator<GetDiagnosisKeysDataMappingParams> CREATOR = new AutoCreator<>(GetDiagnosisKeysDataMappingParams.class);
    @Field(1)
    public IDiagnosisKeysDataMappingCallback callback;

    private GetDiagnosisKeysDataMappingParams() {
    }

    public GetDiagnosisKeysDataMappingParams(IDiagnosisKeysDataMappingCallback callback) {
        this.callback = callback;
    }
}
