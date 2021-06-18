// ILedService.aidl
package android.os;

// Declare any non-default types here with import statements

interface ILedService {

     int ledCtrl(int number, int status, boolean isFlicker);
}