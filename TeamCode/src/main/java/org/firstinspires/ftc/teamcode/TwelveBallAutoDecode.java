package org.firstinspires.ftc.teamcode;
/* dih */
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/*
 * DECODE 12-Ball Auto - FINAL ERROR-FREE VERSION
 * This version uses the manually created Road Runner classes to fix all IDE errors.
 */

@Autonomous(name = "12-Ball Auto Decode", group = "Autonomous")
public class TwelveBallAutoDecode extends LinearOpMode {
    @Override
    public void runOpMode() {
        // Using local Pose2d and Vector2d classes
        Pose2d startPose = new Pose2d(new Vector2d(-52.0, 53.0), Math.toRadians(315.0));
        
        // This will now find the local TrajectoryActionBuilder correctly
        MecanumDrive drive = new MecanumDrive(hardwareMap, startPose);

        // Build the Action Sequence using our local TrajectoryActionBuilder
        Action fullAuto = drive.actionBuilder(startPose)
                .setTangent(Math.toRadians(315.0))
                .lineToY(24.0)
                .turnTo(Math.toRadians(45.0))
                .waitSeconds(0.7)

                // --- CYCLE 1 ---
                .turnTo(Math.toRadians(0.0))
                .lineToX(-12.0)
                .turnTo(Math.toRadians(90.0))
                .lineToY(48.0)
                .waitSeconds(0.2)
                
                // Lever Hit
                .turnTo(Math.toRadians(157.4))
                .lineToY(53.0) 
                .turnTo(Math.toRadians(233.1))
                .lineToX(-24.0)
                .lineToY(24.0)
                .turnTo(Math.toRadians(45.0))
                .waitSeconds(0.65)

                // --- CYCLE 2 ---
                .turnTo(Math.toRadians(0.0))
                .lineToX(12.0)
                .turnTo(Math.toRadians(90.0))
                .lineToY(48.0)
                .waitSeconds(0.2)
                .turnTo(Math.toRadians(180.0))
                .lineToY(24.0)
                .turnTo(Math.toRadians(180.0))
                .lineToX(-24.0)
                .lineToY(24.0)
                .turnTo(Math.toRadians(45.0))
                .waitSeconds(0.65)

                // --- CYCLE 3 ---
                .turnTo(Math.toRadians(0.0))
                .lineToX(36.0)
                .turnTo(Math.toRadians(90.0))
                .lineToY(48.0)
                .waitSeconds(0.2)
                .turnTo(Math.toRadians(180.0))
                .lineToY(24.0)
                .turnTo(Math.toRadians(180.0))
                .lineToX(-24.0)
                .lineToY(24.0)
                .turnTo(Math.toRadians(45.0))
                .waitSeconds(0.65)

                // --- FINISH ---
                .turnTo(Math.toRadians(0.0))
                .lineToX(0.0)
                .lineToY(20.0)
                .build();

        waitForStart();

        if (isStopRequested()) return;

        // Run using our local Actions runner
        Actions.runBlocking(fullAuto);
    }
}
