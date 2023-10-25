import * as React from 'react';

import { StyleSheet, View } from 'react-native';
import { AppSecurity } from '@sleiv/react-native-app-security';

export default function App() {
  React.useEffect(() => {
    AppSecurity.isDebugEnabled().then(console.log);
    AppSecurity.isDeviceRooted().then(console.log);
    AppSecurity.isIncorrectFingerprint(['']).then(console.log);
  }, []);

  return <View style={styles.container} />;
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
