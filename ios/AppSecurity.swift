import IOSSecuritySuite

@objc(AppSecurity)
class AppSecurity: NSObject {

  @objc(isDeviceRooted)
  func isDeviceRooted(resolve: RCTPromiseResolveBlock, reject: RCTPromiseRejectBlock) -> Void {
    do {
      let result = IOSSecuritySuite.amIJailbroken()
      resolve(result)
    } catch let error as NSError {
      reject("Jailbreak detection failed", error)
    }
  }

  @objc(isDebugEnabled)
  func isDebugEnabled(resolve: RCTPromiseResolveBlock, reject: RCTPromiseRejectBlock) -> Void {
    do {
      let result = IOSSecuritySuite.amIDebugged()
      resolve(result)
    } catch let error as NSError {
      reject("Debug detection failed", error)
    }
  }

  @objc(isIncorrectFingerprint:)
  func isIncorrectFingerprint(fingerprints: NSArray, resolve:RCTPromiseResolveBlock,reject:RCTPromiseRejectBlock) -> Void {
    // not supported on iOS
    resolve(false)
  }
}
