package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

import java.util.ArrayList;
import java.util.List;

import static org.firstinspires.ftc.robotcore.external.navigation.AngleUnit.DEGREES;
import static org.firstinspires.ftc.robotcore.external.navigation.AxesOrder.XYZ;
import static org.firstinspires.ftc.robotcore.external.navigation.AxesOrder.YZX;
import static org.firstinspires.ftc.robotcore.external.navigation.AxesReference.EXTRINSIC;
import static org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection.BACK;

@Autonomous(name = "Red2", group = "Autonomous")
public class RedPickUpZone extends LinearOpMode{
    public Robot R = new Robot();

    public void runOpMode() {
        R.init(hardwareMap);

        final VuforiaLocalizer.CameraDirection CAMERA_CHOICE = BACK;

        final String VUFORIA_KEY = "AW/D0F3/////AAABmT6CO76ZukEWtNAvh1kty819QDEF9SG9ZxbfUcbjoxBCe0UcoTGK19TZdmHtWDwxhrL4idOt1tdJE+h9YGDtZ7U/njHEqSZ7jflzurT4j/WXTCjeTCSf0oMqcgduLTDNz+XEXMbPSlnHbO9ZnEZBun7HHr6N06kpYu6QZmG6WRvibuKCe5IeZJ21RoIeCsdp3ho/f/+QQLlnqaa1dw6i4xMFM0e2IaxujhQiWnd4by23CkMPvzKhy6YP3wPBq+awpzEPLDZcD8l1i0SqmX7HNpmw4kXBrWzEimAzp1aqONVau4kIwCGwJFusMdErw9IL7KQ5VqMKN4Xl67s0pwotoXsA+5SlWQAIodipYKZnPzwO";

        VuforiaLocalizer vuforia = null;
        boolean targetVisible = false;


        waitForStart();

        R.driveStraight(1000, .7);
        R.waitFor();

        R.turn("CW", 1000, .7);
        R.waitFor();

        

    }
}
