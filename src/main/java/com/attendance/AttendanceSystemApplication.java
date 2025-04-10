package com.attendance;
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AttendanceSystemApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        // javax.swing.SwingUtilities.invokeLater(() -> {
        //     javax.swing.JOptionPane.showMessageDialog(null, "Open Hotspot");
        //     //openHotspot();
        // });
        SpringApplication.run(AttendanceSystemApplication.class, args);
    }
    /*
    private static void openHotspot() {
        String ssid = "AttendancePortal";
        String password = "123456789";
        try {
            // Step 1: Set hosted network
            String setCommand = String.format("netsh wlan set hostednetwork mode=allow ssid=%s key=%s", ssid, password);
            Process setProcess = Runtime.getRuntime().exec("cmd /c " + setCommand);
            printProcessOutput(setProcess);

            int setExit = setProcess.waitFor();
            if (setExit != 0) {
                System.err.println("Failed to configure hotspot.");
                return;
            }

            // Step 2: Start hosted network
            Process startProcess = Runtime.getRuntime().exec("cmd /c netsh wlan start hostednetwork");
            printProcessOutput(startProcess);

            int startExit = startProcess.waitFor();
            if (startExit == 0) {
                System.out.println("Hotspot started successfully!");
            } else {
                System.err.println("Failed to start hotspot.");
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static void printProcessOutput(Process process) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
    */
}