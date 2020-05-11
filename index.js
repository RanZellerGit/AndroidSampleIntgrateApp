import React from 'react';
import {AppRegistry, StyleSheet, Text, View, NativeModules} from 'react-native';
import BatchedBridge from "react-native/Libraries/BatchedBridge/BatchedBridge";

class HelloWorld extends React.Component {
    render() {
        return (
          <View style={styles.container}>
            <Text style={styles.textStyle}>
              This is react-native View 
            </Text>
          </View>
        );
      }
    }
    
    const styles = StyleSheet.create({
      container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#FFFFFF'
      },
      textStyle: {
        fontSize: 20,
        textAlign: 'center',
        margin: 10
      }
    });



const {CallbackFromJS} = NativeModules;

const exposedToJava =  {    
    callFromNative(message,numbre) {
      console.log(`${message} ${numbre}`);
      CallbackFromJS.callbackAns(`the call back made for javasctipt`)
    }
};

BatchedBridge.registerCallableModule("JavaScriptVisibleToJava", exposedToJava);

AppRegistry.registerComponent('MyAndroidReactNativeApp', () => HelloWorld);