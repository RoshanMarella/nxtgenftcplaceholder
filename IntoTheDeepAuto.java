package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/*
 * This is a Road Runner OpMode generated from your MeepMeep simulation.
 * You will need to replace the "waitSeconds" with your actual intake/scoring hardware calls.
 */
@Autonomous(name = "IntoTheDeepAuto", group = "Autonomous")
public class IntoTheDeepAuto extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        // Initialize your Road Runner drive (SampleMecanumDrive or similar)
        // SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        // --- DECODE MAP DATA (Inches) ---
        Vector2d triangleMiddle = new Vector2d(-24, 24); 
        double row1X = -12;
        double row2X = 12;
        double row3X = 38;

        Vector2d s4 = new Vector2d(row1X, 48);
        Vector2d s5 = new Vector2d(row2X, 48);
        Vector2d s6 = new Vector2d(row3X, 48);

        Pose2d startPose = new Pose2d(-60, 60, Math.toRadians(315));
        // drive.setPoseEstimate(startPose);

        waitForStart();

        if (isStopRequested()) return;

        /* 
         * IMPORTANT: In a real OpMode, you usually pre-build these trajectories 
         * during initialization to save time. This is a simplified version.
         */

        // 1. Score Preload
        // drive.followTrajectory(drive.trajectoryBuilder(startPose).lineTo(triangleMiddle).build());
        // drive.turn(Math.toRadians(90));
        sleep(600); // Wait for score

        // Cycle 1
        // drive.turn(Math.toRadians(-45));
        // drive.followTrajectory(drive.trajectoryBuilder(drive.getPoseEstimate()).lineTo(new Vector2d(row1X, 24)).build());
        // drive.turn(Math.toRadians(90));
        // drive.followTrajectory(drive.trajectoryBuilder(drive.getPoseEstimate()).lineTo(s4).build());
        sleep(200); // Pickup
        // drive.turn(Math.toRadians(180));
        // drive.followTrajectory(drive.trajectoryBuilder(drive.getPoseEstimate()).lineTo(new Vector2d(row1X, 24)).build());
        // drive.turn(Math.toRadians(-90));
        // drive.followTrajectory(drive.trajectoryBuilder(drive.getPoseEstimate()).lineTo(triangleMiddle).build());
        // drive.turn(Math.toRadians(-135));
        sleep(600); // Score

        // ... Repeat for Cycle 2 and 3 ...
    }
}
