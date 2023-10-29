import IOSSecuritySuite

@objc(AppSecurity)
class AppSecurity: NSObject {

  @objc
  func isDeviceRooted(_ resolver: RCTPromiseResolveBlock, rejecter: RCTPromiseRejectBlock) -> Void {
    do {
      let result = IOSSecuritySuite.amIJailbroken()
      resolver(result)
    } catch let error as NSError {
      rejecter("isDeviceRooted::Error", "Jailbreak detection failed", error)
    }
  }

  @objc
  func isDebugEnabled(_ resolver: RCTPromiseResolveBlock, rejecter: RCTPromiseRejectBlock) -> Void {
    do {
      let result = IOSSecuritySuite.amIDebugged()
      resolver(result)
    } catch let error as NSError {
      rejecter("isDebugEnabled::Error", "Debug detection failed", error)
    }
  }

  @objc
  func isIncorrectFingerprint(_ fingerprints: NSArray, resolver:RCTPromiseResolveBlock,rejecter:RCTPromiseRejectBlock) -> Void {
    // not supported on iOS
    resolver(false)
  }
}
