# react-native-app-security

Verify app integrity and device security!
This package wraps [RootBeer](https://github.com/scottyab/rootbeer) and [IOSSecuritySuite](https://github.com/securing/IOSSecuritySuite) for use in React Native.

## Feature



## Installation

```sh
npm install @sleiv/react-native-app-security

or

yarn add @sleiv/react-native-app-security
```

## Usage

```ts
import { AppSecurity } from '@sleiv/react-native-app-security';

// root check
const isRooted = await AppSecurity.isDeviceRooted();

// debug check
const isDebugEnabled = await AppSecurity.isDebugEnabled();

// fingerprint check (android only)
const fingerprints = ['...']
const isIncorrectFingerprint = await AppSecurity.isIncorrectFingerprint(fingerprints)
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

### Dependencies

- [RootBeer](https://github.com/scottyab/rootbeer): Licensed under [Apache 2.0 License](https://github.com/scottyab/rootbeer/blob/master/LICENSE).
- [IOSSecuritySuite](https://github.com/securing/IOSSecuritySuite): Licensed under [BSD 2-Clause License](https://github.com/securing/IOSSecuritySuite/blob/master/README.md#license).

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
