package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.VoltageSensor;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;

@Config
public final class MecanumDrive {
    public final DcMotorEx frontLeft, frontRight, backLeft, backRight;
    public final VoltageSensor voltageSensor;

    public MecanumDrive(HardwareMap hardwareMap, Pose2d pose) {
        // --- MATCHING EXPANSION HUB PORTS ---
        frontLeft = hardwareMap.get(DcMotorEx.class, "frontLeft");   // Port 0
        frontRight = hardwareMap.get(DcMotorEx.class, "frontRight"); // Port 1
        backLeft = hardwareMap.get(DcMotorEx.class, "backLeft");     // Port 2
        backRight = hardwareMap.get(DcMotorEx.class, "backRight");   // Port 3
        
        // Reverse left side motors so positive power moves forward
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        voltageSensor = hardwareMap.voltageSensor.iterator().next();
    }

    // Returns our local builder to clear IDE errors
    public TrajectoryActionBuilder actionBuilder(Pose2d beginPose) {
        return new TrajectoryActionBuilder(beginPose);
    }
}
