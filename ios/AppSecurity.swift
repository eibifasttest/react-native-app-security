import IOSSecuritySuite

@objc(AppSecurity)
class AppSecurity: NSObject {

  @objc(multiply:withB:withResolver:withRejecter:)
  func multiply(a: Float, b: Float, resolve:RCTPromiseResolveBlock,reject:RCTPromiseRejectBlock) -> Void {
    IOSSecuritySuite.amIRunInEmulator() ? resolve(1) : resolve(0)
  }
}
