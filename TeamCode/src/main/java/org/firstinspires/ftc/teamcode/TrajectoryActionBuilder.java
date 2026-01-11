package org.firstinspires.ftc.teamcode;

public class TrajectoryActionBuilder {
    public TrajectoryActionBuilder(Pose2d startPose) {}

    public TrajectoryActionBuilder setTangent(double tangent) {
        return this;
    }

    public TrajectoryActionBuilder lineToX(double x) {
        return this;
    }

    public TrajectoryActionBuilder lineToY(double y) {
        return this;
    }

    public TrajectoryActionBuilder turnTo(double heading) {
        return this;
    }

    public TrajectoryActionBuilder waitSeconds(double seconds) {
        return this;
    }

    public Action build() {
        return (packet) -> false;
    }
}
