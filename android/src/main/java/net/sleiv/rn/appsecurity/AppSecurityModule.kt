package net.sleiv.rn.appsecurity

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Promise
import com.scottyab.rootbeer.RootBeer

class AppSecurityModule(reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {

  private val rootBeer = RootBeer(reactContext)

  override fun getName(): String {
    return NAME
  }

  // Example method
  // See https://reactnative.dev/docs/native-modules-android
  @ReactMethod
  fun multiply(a: Double, b: Double, promise: Promise) {
    val x = if(rootBeer.isRootedWithBusyBoxCheck()) 1 else 0
    promise.resolve(x)
  }

  companion object {
    const val NAME = "AppSecurity"
  }
}
