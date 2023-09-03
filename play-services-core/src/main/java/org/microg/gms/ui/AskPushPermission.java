package org.microg.gms.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Build;
import android.os.ResultReceiver;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.R;

import org.microg.gms.gcm.GcmDatabase;
import org.microg.gms.gcm.PushRegisterService;

import static org.microg.gms.gcm.GcmConstants.EXTRA_APP;
import static org.microg.gms.gcm.GcmConstants.EXTRA_KID;
import static org.microg.gms.gcm.GcmConstants.EXTRA_PENDING_INTENT;

public class AskPushPermission extends FragmentActivity {
    public static final String EXTRA_REQUESTED_PACKAGE = "package";
    public static final String EXTRA_RESULT_RECEIVER = "receiver";
    public static final String EXTRA_EXPLICIT = "explicit";

    private GcmDatabase database;

    private String packageName;
    private ResultReceiver resultReceiver;
    private boolean answered;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        database = new GcmDatabase(this);

        packageName = getIntent().getStringExtra(EXTRA_REQUESTED_PACKAGE);
        resultReceiver = getIntent().getParcelableExtra(EXTRA_RESULT_RECEIVER);
        if (packageName == null || resultReceiver == null) {
            answered = true;
            finish();
            return;
        }

        if (database.getApp(packageName) != null) {
            resultReceiver.send(Activity.RESULT_OK, Bundle.EMPTY);
            answered = true;
            finish();
            return;
        }

        // Create and show the AlertDialog
        try {
            PackageManager pm = getPackageManager();
            final ApplicationInfo info = pm.getApplicationInfo(packageName, 0);
            String label = pm.getApplicationLabel(info).toString();
            String raw = getString(R.string.gcm_allow_app_popup, label);
            SpannableString s = new SpannableString(raw);
            s.setSpan(new StyleSpan(Typeface.BOLD), raw.indexOf(label), raw.indexOf(label) + label.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setCancelable(false); // Disable canceling the dialog by tapping outside or pressing the back button
            alertDialogBuilder.setMessage(s);
            alertDialogBuilder.setPositiveButton(R.string.allow, (dialog, which) -> {
                if (answered) return;
                database.noteAppKnown(packageName, true);
                answered = true;
                Bundle bundle = new Bundle();
                bundle.putBoolean(EXTRA_EXPLICIT, true);
                resultReceiver.send(Activity.RESULT_OK, bundle);
                finish();
            });
            alertDialogBuilder.setNegativeButton(R.string.deny, (dialog, which) -> {
                if (answered) return;
                database.noteAppKnown(packageName, false);
                answered = true;
                Bundle bundle = new Bundle();
                bundle.putBoolean(EXTRA_EXPLICIT, true);
                resultReceiver.send(Activity.RESULT_CANCELED, bundle);
                finish();
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY);
            } else {
                alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
            }
            alertDialog.show();
        } catch (PackageManager.NameNotFoundException e) {
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!answered) {
            resultReceiver.send(Activity.RESULT_CANCELED, Bundle.EMPTY);
        }
        database.close();
    }
}
