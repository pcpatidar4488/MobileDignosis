/*
 * Copyright (C) 2016 Nishant Srivastava
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.mindzdignostics;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;

final class RuntimePermissionUtil {

    public static boolean checkPermissonGranted(final Context context, final String permission) {
        return (ActivityCompat.checkSelfPermission(context, permission)
                == PackageManager.PERMISSION_GRANTED);
    }

    public static void onRequestPermissionsResult(final int[] grantResults,
            final RPResultListener rpResultListener) {
        if (grantResults.length > 0) {
            for (final int grantResult : grantResults) {
                if (grantResult == PackageManager.PERMISSION_GRANTED) {
                    rpResultListener.onPermissionGranted();
                } else {
                    rpResultListener.onPermissionDenied();
                }
            }
        }
    }

    public static void requestPermission(Activity activity, String permission,
            int REQUEST_CODE) {
        // No explanation needed, we can request the permission.
        ActivityCompat.requestPermissions(activity, new String[]{permission}, REQUEST_CODE);
    }

    public static void requestPermission(Activity activity, String[] permissions,
            int REQUEST_CODE) {
        // No explanation needed, we can request the permission.
        ActivityCompat.requestPermissions(activity, permissions, REQUEST_CODE);
    }

    private RuntimePermissionUtil() {

    }
}
