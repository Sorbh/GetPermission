package in.unicodelabs.getpermission.interfaces;

import in.unicodelabs.getpermission.PermissionRequest;

public interface PermissionRationalDelegate {
    void requestPermission(PermissionRequest permissionRequest, int requestCode);
}
