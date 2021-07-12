package android.os;
/** @hide */
interface IJniService {
    int ledCtrl(int number, int status, boolean isFlicker);

    int recoveryCtrl(int option);
}