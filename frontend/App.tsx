import React from 'react';
import HomeTabs from './src/navigation/HomeTabs';
import Toast from 'react-native-toast-message';

export default function App() {
  return (
    <>
      <HomeTabs />
      <Toast />
    </>
  );
}
