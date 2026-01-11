package org.firstinspires.ftc.teamcode.trajectorysequence;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;

public class TrajectorySequenceBuilder {
    public TrajectorySequenceBuilder(Pose2d startPose) { }

    public TrajectorySequenceBuilder lineTo(Vector2d vector) {
        return this;
    }

    public TrajectorySequenceBuilder turn(double angle) {
        return this;
    }

    public TrajectorySequenceBuilder waitSeconds(double seconds) {
        return this;
    }

    public TrajectorySequenceBuilder addDisplacementMarker(Runnable callback) {
        return this;
    }

    public TrajectorySequence build() {
        return new TrajectorySequence();
    }
}
