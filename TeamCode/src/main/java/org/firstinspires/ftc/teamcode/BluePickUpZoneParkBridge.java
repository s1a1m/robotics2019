package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "BluePickUpZoneParkBridge", group = "Autonomous")
public class BluePickUpZoneParkBridge extends LinearOpMode{
    public Robot R = new Robot();

    public void runOpMode(){
        R.init(hardwareMap);
        waitForStart();

        R.strafe("Left", 1200, .3);
        R.waitFor();

        R.skystoneClaw.setPosition(.4);
        sleep(500);

    }
}
