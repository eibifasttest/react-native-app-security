#import <React/RCTBridgeModule.h>

@interface RCT_EXTERN_MODULE(AppSecurity, NSObject)

+ (BOOL)requiresMainQueueSetup
{
  return NO;
}

RCT_EXTERN_METHOD(isDeviceRooted:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject)

RCT_EXTERN_METHOD(isDebugEnabled:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject)

RCT_EXTERN_METHOD(isIncorrectFingerprint:(NSArray<NSString *> *)fingerprints
                  resolver:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject)

@end
