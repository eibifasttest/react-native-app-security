package net.sleiv.rn.appsecurity;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = AppSecurityModule.NAME)
public class AppSecurityModule extends ReactContextBaseJavaModule {
  public static final String NAME = "AppSecurity";

  public AppSecurityModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }

  @ReactMethod
  public void isDeviceRooted(final Promise promise) {
    promise.resolve(false);
  }

  @ReactMethod
  public void isDebugEnabled(final Promise promise) {
    promise.resolve(false);
  }

}
