package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/*
 * DECODE 12-Ball Auto - BLUE ALLIANCE
 * This matches your Blue MeepMeep simulation exactly.
 * Uses local classes to ensure zero errors.
 */

@Autonomous(name = "12-Ball Auto Blue", group = "Autonomous")
public class TwelveBallAutoBlue extends LinearOpMode {
    @Override
    public void runOpMode() {
        // Start Pose mirrored for Blue Alliance
        Pose2d startPose = new Pose2d(new Vector2d(-52.0, -53.0), Math.toRadians(45.0));
        MecanumDrive drive = new MecanumDrive(hardwareMap, startPose);

        // Map Data Mirrored for Blue
        double row1X = -12.0;
        double row2X = 12.0;
        double row3X = 36.0;

        // Build the Action Sequence mirrored from the Red version
        Action fullAuto = drive.actionBuilder(startPose)
                // 1. Preload Score
                .lineToY(-24.0)
                .turnTo(Math.toRadians(-45.0))
                .waitSeconds(0.7)

                // --- CYCLE 1 ---
                .turnTo(Math.toRadians(0.0))
                .lineToX(row1X)
                .turnTo(Math.toRadians(-90.0))
                .lineToY(-48.0)
                .waitSeconds(0.2)
                
                // Lever Hit (Mirrored Y)
                .turnTo(Math.toRadians(-157.4))
                .lineToY(-53.0) 
                .turnTo(Math.toRadians(-233.1))
                .lineToX(-24.0)
                .lineToY(-24.0)
                .turnTo(Math.toRadians(-45.0))
                .waitSeconds(0.65)

                // --- CYCLE 2 ---
                .turnTo(Math.toRadians(0.0))
                .lineToX(row2X)
                .turnTo(Math.toRadians(-90.0))
                .lineToY(-48.0)
                .waitSeconds(0.2)
                .turnTo(Math.toRadians(180.0))
                .lineToY(-24.0)
                .turnTo(Math.toRadians(180.0))
                .lineToX(-24.0)
                .lineToY(-24.0)
                .turnTo(Math.toRadians(-45.0))
                .waitSeconds(0.65)

                // --- CYCLE 3 ---
                .turnTo(Math.toRadians(0.0))
                .lineToX(row3X)
                .turnTo(Math.toRadians(-90.0))
                .lineToY(-48.0)
                .waitSeconds(0.2)
                .turnTo(Math.toRadians(180.0))
                .lineToY(-24.0)
                .turnTo(Math.toRadians(180.0))
                .lineToX(-24.0)
                .lineToY(-24.0)
                .turnTo(Math.toRadians(-45.0))
                .waitSeconds(0.65)

                // --- FINISH ---
                .turnTo(Math.toRadians(0.0))
                .lineToX(0.0)
                .lineToY(-20.0)
                .build();

        waitForStart();

        if (isStopRequested()) return;

        // Run the action blocking using our local runner
        Actions.runBlocking(fullAuto);
    }
}
