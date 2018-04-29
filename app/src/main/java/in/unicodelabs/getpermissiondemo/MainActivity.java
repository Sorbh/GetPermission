package in.unicodelabs.getpermissiondemo;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import in.unicodelabs.getpermission.GetPermission;
import in.unicodelabs.getpermission.PermissionRequest;
import in.unicodelabs.getpermission.PermissionRequestActivity;
import in.unicodelabs.getpermission.interfaces.PermissionResultCallback;

public class MainActivity extends AppCompatActivity {
    Context context;
    Button contactBtn;
    TextView contactTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        contactBtn = (Button) findViewById(R.id.contactBtn);
        contactTv = (TextView) findViewById(R.id.contactTv);

        contactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new GetPermission.Builder(context).setPermissions(Manifest.permission.READ_CONTACTS).enqueue(new PermissionResultCallback() {
                    @Override
                    public void onPermissionGranted(ArrayList<PermissionRequest> grantedPermission) {
                        for (PermissionRequest permissionRequest : grantedPermission) {
                            Log.d("Get Permission", "Granted - " + permissionRequest.getPermission());
                        }
                    }

                    @Override
                    public void onPermissionDenied(ArrayList<PermissionRequest> deniedPermission, final PermissionRequest.AskPermissionInterface askPermissionInterface) {
                        for (PermissionRequest permissionRequest : deniedPermission) {
                            Log.d("Get Permission", "Denied - " + permissionRequest.getPermission());
                            if(permissionRequest.isPermanentlyDenied()){
                                    askPermissionInterface.showSetting();
                            }
                        }
                    }

                    @Override
                    public void onPermissionRationalShouldShow(final ArrayList<PermissionRequest> rationalPermission, final PermissionRequest.AskPermissionInterface askPermissionInterface) {
                        for (final PermissionRequest permissionRequest : rationalPermission) {
                            Log.d("Get Permission", "Rational - " + permissionRequest.getPermission());

                            AlertDialog alertDialog = new AlertDialog.Builder(context)
                                    .setMessage("Message")
                                    .setCancelable(true)
                                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            dialogInterface.dismiss();
//                                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{permissionRequest.getPermission()}, 110);
//                                            permissionRequest.getAskPermissionInterface().requestPermission(permissionRequest,110);
                                            askPermissionInterface.requestPermission(permissionRequest, 110);
                                        }
                                    })
                                    .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            dialogInterface.cancel();
                                        }
                                    })
                                    .setOnCancelListener(new DialogInterface.OnCancelListener() {
                                        @Override
                                        public void onCancel(DialogInterface dialogInterface) {
                                            dialogInterface.dismiss();
                                        }
                                    })
                                    .show();
                        }
                    }
                });
            }
        });
    }
}
