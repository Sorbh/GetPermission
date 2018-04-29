package in.unicodelabs.getpermission;

import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.io.Serializable;

public class PermissionRequest implements Serializable {
    private final String name;
    private boolean isPermanentlyDenied = false;
    private AskPermissionInterface askPermissionInterface;

    public PermissionRequest(@NonNull String name) {
        this.name = name;
    }

    public String getPermission() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean isPermanentlyDenied() {
        return isPermanentlyDenied;
    }

    public void setPermanentlyDenied(boolean permanentlyDenied) {
        isPermanentlyDenied = permanentlyDenied;
    }

    public AskPermissionInterface getAskPermissionInterface() {
        return askPermissionInterface;
    }

    public void setAskPermissionInterface(AskPermissionInterface askPermissionInterface) {
        this.askPermissionInterface = askPermissionInterface;
    }

    public interface AskPermissionInterface {

        void requestPermission(PermissionRequest permissionRequest, int requestCode);

        void showSetting();

    }
}
