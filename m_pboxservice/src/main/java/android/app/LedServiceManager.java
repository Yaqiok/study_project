package android.app;

import android.os.ILedService;
import android.os.RemoteException;

/**
 * @hide
 */
public class LedServiceManager {

    private ILedService mILedService;

    public LedServiceManager(ILedService service) {
        mILedService = service;
    }

    public int ledCtrl(int number, int status, boolean isFlicker) {
        try {
            return mILedService.ledCtrl(number, status, isFlicker);
        } catch (RemoteException e) {
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
}