"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.AppSecurity = void 0;
var _reactNative = require("react-native");
const LINKING_ERROR = `The package '@sleiv/react-native-app-security' doesn't seem to be linked. Make sure: \n\n` + _reactNative.Platform.select({
  ios: "- You have run 'pod install'\n",
  default: ''
}) + '- You rebuilt the app after installing the package\n' + '- You are not using Expo Go\n';
function createModuleProxy(moduleName) {
  if (_reactNative.NativeModules[moduleName]) {
    return _reactNative.NativeModules[moduleName];
  } else {
    return new Proxy({}, {
      get() {
        throw new Error(LINKING_ERROR);
      }
    });
  }
}
const AppSecurity = exports.AppSecurity = createModuleProxy('AppSecurity');
//# sourceMappingURL=index.js.map