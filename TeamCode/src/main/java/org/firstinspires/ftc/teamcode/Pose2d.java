package org.firstinspires.ftc.teamcode;

public class Pose2d {
    public final Vector2d position;
    public final double heading;

    public Pose2d(Vector2d position, double heading) {
        this.position = position;
        this.heading = heading;
    }

    public Pose2d(double x, double y, double heading) {
        this.position = new Vector2d(x, y);
        this.heading = heading;
    }
}
