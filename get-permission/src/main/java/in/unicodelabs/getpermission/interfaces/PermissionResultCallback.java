package in.unicodelabs.getpermission.interfaces;

import java.util.ArrayList;
import java.util.Arrays;

import in.unicodelabs.getpermission.PermissionRequest;
import in.unicodelabs.getpermission.PermissionResponse;

/**
 * Created by saurabh on 14/3/18.
 */

public interface PermissionResultCallback {
    void onPermissionGranted(ArrayList<PermissionRequest> grantedPermission);

    void onPermissionDenied(ArrayList<PermissionRequest> deniedPermission,PermissionRequest.AskPermissionInterface askPermissionInterface);

    void onPermissionRationalShouldShow(ArrayList<PermissionRequest> rationalPermission,PermissionRequest.AskPermissionInterface askPermissionInterface);
}
