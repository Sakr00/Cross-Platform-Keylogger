package com.example.fluttertojava;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class MainActivity extends FlutterActivity {
    private static final String CHANNEL = "com.example.mychannel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FlutterEngine flutterEngine = new FlutterEngine(this);
        flutterEngine.getDartExecutor().executeDartEntrypoint(
                DartExecutor.DartEntrypoint.createDefault()
        );
        FlutterMain.startInitialization(this);
        flutterEngine.getNavigationChannel().setInitialRoute("/");
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), CHANNEL);
        methodChannel.setMethodCallHandler(
                new MethodChannel.MethodCallHandler() {
                    @Override
                    public void onMethodCall(@NonNull MethodCall call, @NonNull MethodChannel.Result result) {
                        if (call.method.equals("sendStringToJava")) {
                            String message = call.argument("message");
                            Log.d("FlutterToJava", "Received message from Flutter: " + message);
                            // Process the received string as needed
                            result.success(null); // Return a success result
                        } else {
                            result.notImplemented(); // Method not implemented
                        }
                    }
                }
        );
        flutterEngine.getNavigationChannel().setInitialRoute("/");
        setContentView(R.layout.activity_main);
    }
}
