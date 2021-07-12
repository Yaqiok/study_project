package android.app;

import android.os.IJniService;
import android.os.RemoteException;

/**
 * @hide
 */
public class JniServiceManager {

    private IJniService mIJniService;

    public JniServiceManager(IJniService service) {
        mIJniService = service;
    }

    public int ledCtrl(int number, int status, boolean isFlicker) {
        try {
            return mIJniService.ledCtrl(number, status, isFlicker);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int recoveryCtrl(int option){
        try{
            return mIJniService.recoveryCtrl(option);
        }catch(RemoteException e){
            e.printStackTrace();
            return -1;
        }
    }

    public class LedLightColor {
        public final static int ALL_COLOR = 0;
        public final static int RED = 1;
        public final static int GREEN = 2;
        public final static int BLUE = 3;
        public final static int YELLOW = 4;
    }

    public class LedLightStatus {
        public final static int ON = 1;
        public final static int OFF = 0;
    }

    public class RecoveryOption {
        public final static int QUERY_PRIVATE = 0;
        public final static int QUERY = 1;
        public final static int BACKUP = 2;
        public final static int DELETE = 3;
        public final static int RESTORE = 4;
    }
}