package org.firstinspires.ftc.teamcode;

public class Actions {
    public static void runBlocking(Action action) {
        com.acmerobotics.dashboard.telemetry.TelemetryPacket packet = new com.acmerobotics.dashboard.telemetry.TelemetryPacket();
        while (action.run(packet)) {
            // Run until the action returns false
        }
    }
}
