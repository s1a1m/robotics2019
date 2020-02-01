package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.vuforia.CameraDevice;

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

@Autonomous(name = "RedSkystone", group = "Autonomous")
public class RedPickUpZone extends LinearOpMode{
    public Robot R = new Robot();

    public void runOpMode() {
        R.init(hardwareMap);

        final VuforiaLocalizer.CameraDirection CAMERA_CHOICE = BACK;

        final String VUFORIA_KEY = "AW/D0F3/////AAABmT6CO76ZukEWtNAvh1kty819QDEF9SG9ZxbfUcbjoxBCe0UcoTGK19TZdmHtWDwxhrL4idOt1tdJE+h9YGDtZ7U/njHEqSZ7jflzurT4j/WXTCjeTCSf0oMqcgduLTDNz+XEXMbPSlnHbO9ZnEZBun7HHr6N06kpYu6QZmG6WRvibuKCe5IeZJ21RoIeCsdp3ho/f/+QQLlnqaa1dw6i4xMFM0e2IaxujhQiWnd4by23CkMPvzKhy6YP3wPBq+awpzEPLDZcD8l1i0SqmX7HNpmw4kXBrWzEimAzp1aqONVau4kIwCGwJFusMdErw9IL7KQ5VqMKN4Xl67s0pwotoXsA+5SlWQAIodipYKZnPzwO";

        // Class Members
        VuforiaLocalizer vuforia = null;
        boolean targetVisible = false;

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);

        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraDirection = CAMERA_CHOICE;

        //  Instantiate the Vuforia engine
        vuforia = ClassFactory.getInstance().createVuforia(parameters);

        // Turns flashlight on
        CameraDevice CD = CameraDevice.getInstance();
        CD.setFlashTorchMode(true);

        // Load the data sets for the trackable objects. These particular data
        // sets are stored in the 'assets' part of our application.
        VuforiaTrackables targetsSkyStone = vuforia.loadTrackablesFromAsset("Skystone");

        VuforiaTrackable stoneTarget = targetsSkyStone.get(0);
        stoneTarget.setName("Stone Target");

//        // For convenience, gather together all the trackable objects in one easily-iterable collection */
//        List<VuforiaTrackable> allTrackables = new ArrayList<>();
//        allTrackables.addAll(targetsSkyStone);

        int block = 0;

        waitForStart();

        R.skystoneClaw.setPosition(1);
        sleep(500);

        R.driveStraight(1800, .7);
        R.waitFor();

        R.turn("CCW", 1450, .7);
        R.waitFor();

        R.driveStraight(1110, .7);
        R.waitFor();

        targetsSkyStone.activate();
        while (!isStopRequested()) {

            //Looks for sky stone; prints if found
            targetVisible = false;
            sleep(1350);
//            for (VuforiaTrackable trackable : allTrackables) {
//                if (((VuforiaTrackableDefaultListener) trackable.getListener()).isVisible()) {
//                    telemetry.addData("Visible Target", trackable.getName());
//                    targetVisible = true;
//                }
//            }

            if (((VuforiaTrackableDefaultListener) stoneTarget.getListener()).isVisible()) {
                telemetry.addData("Visible Target", stoneTarget.getName());
                telemetry.addData("Distance", ((VuforiaTrackableDefaultListener) stoneTarget.getListener()).getPosePhone().getTranslation().get(2));
                targetVisible = true;
            }

            telemetry.update();
            // Provide feedback as to where the robot is located (if we know).
            if (targetVisible) {
                targetsSkyStone.deactivate();
                //Grabs Block
                R.skystoneClaw.setPosition(1);
                sleep(500);

//                R.driveStraight(-500, .3);
//                R.waitFor();

                R.turn("CW", 1450, .7);
                R.waitFor();

                R.driveStraight(1300, .7);
                R.waitFor();

                R.skystoneClaw.setPosition(.45);
                sleep(1000);

                R.driveStraight(-1200, .7);
                R.waitFor();

                R.turn("CCW", 1450, .7);
                R.waitFor();

                R.driveStraight(4500 + block, .8);
                R.waitFor();

                R.skystoneClaw.setPosition(1);
                sleep(1000);

                R.driveStraight(-(6630 + block), 1);
                R.waitFor();

                R.turn("CW", 1410, .7);
                R.waitFor();

                R.driveStraight(1300, .7);
                R.waitFor();

                R.skystoneClaw.setPosition(.45);
                sleep(1000);

                R.driveStraight(-1200, .7);
                R.waitFor();

                R.turn("CCW", 1450, .7);
                R.waitFor();

                R.driveStraight((6630 + block), 1);
                R.waitFor();

                R.skystoneClaw.setPosition(1);
                sleep(1000);

                R.driveStraight(-2000, .7);
                R.waitFor();

                R.turn(" CW", 1410, .7);
                R.waitFor();

                R.driveStraight(500, .5);
                R.waitFor();

                sleep(20000);
//
//                R.driveStraight(-2000, .7);
//                R.waitFor();
//
//                R.turn("CW", 1410, .7);
//                R.waitFor();
//
//                R.driveStraight(500, .5);
//                R.waitFor();
//
//                sleep(20000);
            } else {
                //Goes Backward and finds next block
                block = block + 710;
                R.driveStraight(-710, .5);
                R.waitFor();
            }
        }
    }
}
