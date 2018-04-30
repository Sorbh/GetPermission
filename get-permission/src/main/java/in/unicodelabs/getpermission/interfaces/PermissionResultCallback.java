package in.unicodelabs.getpermission.interfaces;

import java.util.ArrayList;

import in.unicodelabs.getpermission.PermissionRequest;

/**
 * Created by saurabh on 14/3/18.
 */

public interface PermissionResultCallback {
    void onPermissionGranted(ArrayList<PermissionRequest> grantedPermission);

    void onPermissionDenied(ArrayList<PermissionRequest> deniedPermission,PermissionDeniedDelegate permissionDeniedDelegate);

    void onPermissionRationalShouldShow(ArrayList<PermissionRequest> rationalPermission,PermissionRationalDelegate permissionRationalDelegate);
}
