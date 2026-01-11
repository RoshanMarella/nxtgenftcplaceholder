import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        // --- DECODE MAP DATA (Inches) ---
        Vector2d triangleMiddle = new Vector2d(-24, 24); 
        
        double row1X = -12;
        double row2X = 12;
        double row3X = 36;

        // Top Samples (Red side)
        Vector2d s4 = new Vector2d(row1X, 48);
        Vector2d s5 = new Vector2d(row2X, 48);
        Vector2d s6 = new Vector2d(row3X, 48);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                .setDimensions(14, 14)
                .setConstraints(120, 120, Math.toRadians(720), Math.toRadians(720), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-52, 53, Math.toRadians(315)))
                                // 1. Preload Score
                                .lineTo(triangleMiddle)
                                .turn(Math.toRadians(90)) // Face scoring goal (45 deg)
                                .waitSeconds(0.7) // Score Preload

                                // --- CYCLE 1 ---
                                .turn(Math.toRadians(-45)) // Face destination (0 deg)
                                .lineTo(new Vector2d(row1X, 24))
                                .turn(Math.toRadians(90)) // Face destination (90 deg)
                                .lineTo(s4)
                                .waitSeconds(0.2) // Intake Sample 1
                                
                                // Lever Hit (Facing where it's going)
                                .turn(Math.toRadians(-67.4)) // Face lever at (0, 53) (~22.6 deg)
                                .lineTo(new Vector2d(0, 53))
                                .turn(Math.toRadians(207.8)) // Face triangleMiddle (230.4 deg)
                                .lineTo(triangleMiddle)
                                .turn(Math.toRadians(-185.4)) // Face scoring goal (45 deg)
                                .waitSeconds(0.65) // Score Sample 1

                                // --- CYCLE 2 ---
                                .turn(Math.toRadians(-45)) // Face destination (0 deg)
                                .lineTo(new Vector2d(row2X, 24))
                                .turn(Math.toRadians(90)) // Face destination (90 deg)
                                .lineTo(s5)
                                .waitSeconds(0.2) // Intake Sample 2
                                .turn(Math.toRadians(180)) // Face destination (-90 deg)
                                .lineTo(new Vector2d(row2X, 24))
                                .turn(Math.toRadians(-90)) // Face destination (180 deg)
                                .lineTo(triangleMiddle)
                                .turn(Math.toRadians(-135)) // Face scoring goal (45 deg)
                                .waitSeconds(0.65) // Score Sample 2

                                // --- CYCLE 3 ---
                                .turn(Math.toRadians(-45)) // Face destination (0 deg)
                                .lineTo(new Vector2d(row3X, 24))
                                .turn(Math.toRadians(90)) // Face destination (90 deg)
                                .lineTo(s6)
                                .waitSeconds(0.2) // Intake Sample 3
                                .turn(Math.toRadians(180)) // Face destination (-90 deg)
                                .lineTo(new Vector2d(row3X, 24))
                                .turn(Math.toRadians(-90)) // Face destination (180 deg)
                                .lineTo(triangleMiddle)
                                .turn(Math.toRadians(-135)) // Face scoring goal (45 deg)
                                .waitSeconds(0.65) // Score Sample 3

                                // --- FINISH ---
                                .turn(Math.toRadians(-45)) // Face destination (0 deg)
                                .lineTo(new Vector2d(0, 20))
                                .build()
                );

        try {
            File imgFile = new File("field-2024.png");
            if (imgFile.exists()) {
                BufferedImage img = ImageIO.read(imgFile);
                if (img != null) meepMeep.setBackground(img);
            } else {
                meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK);
            }
        } catch (IOException e) {
            meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK);
        }

        meepMeep.setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}
