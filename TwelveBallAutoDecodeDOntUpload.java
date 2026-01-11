package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
// Important: Ensure the trajectorysequence package is in your TeamCode folder
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

/*
 * DECODE 12-Ball Auto - Robot Ready Version
 */
@Autonomous(name = "12-Ball Auto Decode", group = "Autonomous")
public class TwelveBallAutoDecode extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        // 1. Initialize Drive
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        // --- MAP DATA (Inches) ---
        Vector2d triangleMiddle = new Vector2d(-24, 24);
        double row1X = -12;
        double row2X = 12;
        double row3X = 36;

        Vector2d s4 = new Vector2d(row1X, 48);
        Vector2d s5 = new Vector2d(row2X, 48);
        Vector2d s6 = new Vector2d(row3X, 48);

        Pose2d startPose = new Pose2d(-52, 53, Math.toRadians(315));
        drive.setPoseEstimate(startPose);

        // 2. Build the Sequence
        TrajectorySequence mySequence = drive.trajectorySequenceBuilder(startPose)
                // --- PRELOAD ---
                .lineTo(triangleMiddle)
                .turn(Math.toRadians(90))
                .addDisplacementMarker(() -> {
                    // TODO: ADD SCORE HARDWARE CALL HERE
                })
                .waitSeconds(0.7)

                // --- CYCLE 1 ---
                .turn(Math.toRadians(-45))
                .lineTo(new Vector2d(row1X, 24))
                .turn(Math.toRadians(90))
                .lineTo(s4)
                .addDisplacementMarker(() -> {
                    // TODO: ADD INTAKE HARDWARE CALL HERE
                })
                .waitSeconds(0.2)
                .turn(Math.toRadians(-67.4))
                .lineTo(new Vector2d(0, 53)) // LEVER HIT
                .turn(Math.toRadians(207.8))
                .lineTo(triangleMiddle)
                .turn(Math.toRadians(-185.4))
                .addDisplacementMarker(() -> {
                    // TODO: ADD SCORE HARDWARE CALL HERE
                })
                .waitSeconds(0.65)

                // --- CYCLE 2 ---
                .turn(Math.toRadians(-45))
                .lineTo(new Vector2d(row2X, 24))
                .turn(Math.toRadians(90))
                .lineTo(s5)
                .addDisplacementMarker(() -> {
                    // TODO: INTAKE
                })
                .waitSeconds(0.2)
                .turn(Math.toRadians(180))
                .lineTo(new Vector2d(row2X, 24))
                .turn(Math.toRadians(-90))
                .lineTo(triangleMiddle)
                .turn(Math.toRadians(-135))
                .addDisplacementMarker(() -> {
                    // TODO: SCORE
                })
                .waitSeconds(0.65)

                // --- CYCLE 3 ---
                .turn(Math.toRadians(-45))
                .lineTo(new Vector2d(row3X, 24))
                .turn(Math.toRadians(90))
                .lineTo(s6)
                .addDisplacementMarker(() -> {
                    // TODO: INTAKE
                })
                .waitSeconds(0.2)
                .turn(Math.toRadians(180))
                .lineTo(new Vector2d(row3X, 24))
                .turn(Math.toRadians(-90))
                .lineTo(triangleMiddle)
                .turn(Math.toRadians(-135))
                .addDisplacementMarker(() -> {
                    // TODO: SCORE
                })
                .waitSeconds(0.65)

                // --- FINISH ---
                .turn(Math.toRadians(-45))
                .lineTo(new Vector2d(0, 20))
                .build();

        waitForStart();
        if (isStopRequested()) return;

        // 3. Execute
        drive.followTrajectorySequence(mySequence);
    }
}
