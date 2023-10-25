package net.sleiv.rn.appsecurity

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.os.Build
import android.util.Base64
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.scottyab.rootbeer.RootBeer
import java.security.MessageDigest

class AppSecurityModule(reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {

  override fun getName(): String {
    return NAME
  }

  private fun hexToBase64(hex: String): String {
    return hex.chunked(2).map { it.toInt(16).toByte() }
      .toByteArray()
      .let { String(Base64.encode(it, Base64.NO_WRAP)) }
  }

  @Suppress("DEPRECATION")
  @SuppressLint("PackageManagerGetSignatures")
  private fun getCertificateFingerprints(context: Context): String {
    try {
      val packageInfo = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
        context.packageManager.getPackageInfo(
          context.packageName,
          PackageManager.GET_SIGNING_CERTIFICATES
        )
      } else {
        context.packageManager.getPackageInfo(context.packageName, PackageManager.GET_SIGNATURES)
      }

      val signatures = packageInfo?.let {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
          it.signingInfo.apkContentsSigners
        } else {
          it.signatures
        }
      }

      val messageDigest = MessageDigest.getInstance("SHA")
      signatures?.forEach { signature ->
        messageDigest.update(signature.toByteArray())
      }

      return String(Base64.encode(messageDigest.digest(), Base64.NO_WRAP))
    } catch (e: Exception) {
      e.printStackTrace()
      return ""
    }
  }


  @ReactMethod
  fun isDeviceRooted(promise: Promise) {
    try {
      promise.resolve(
        RootBeer(reactApplicationContext).isRooted
      )
    } catch (e: Exception) {
      e.printStackTrace()
      promise.reject(e)
    }
  }

  @ReactMethod
  fun isDebugEnabled(promise: Promise) {
    try {
      val isDebuggable =
        reactApplicationContext?.applicationInfo?.flags?.and(ApplicationInfo.FLAG_DEBUGGABLE) != 0
      val isDebuggerConnected = android.os.Debug.isDebuggerConnected()
      promise.resolve(isDebuggable or isDebuggerConnected)
    } catch (e: Exception) {
      e.printStackTrace()
      promise.reject(e)
    }
  }

  @ReactMethod
  fun isIncorrectFingerprint(fingerprints: Array<String>, promise: Promise) {
    try {
      reactApplicationContext?.let {
        for (fingerprint in fingerprints) {
          if (hexToBase64(fingerprint) == getCertificateFingerprints(it)) {
            promise.resolve(true)
            return
          }
        }
      }
    } catch (e: Exception) {
      e.printStackTrace()
      promise.reject(e)
    }
    promise.resolve(false)
  }

  companion object {
    const val NAME = "AppSecurity"
  }
}
