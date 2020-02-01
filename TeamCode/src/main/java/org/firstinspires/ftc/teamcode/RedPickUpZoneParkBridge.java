package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "RedPickUpZoneParkBridge", group = "Autonomous")
public class RedPickUpZoneParkBridge extends LinearOpMode{
    public Robot R = new Robot();

    public void runOpMode(){
        R.init(hardwareMap);
        waitForStart();

        R.strafe("Right", 1200, .3);
        R.waitFor();

        R.skystoneClaw.setPosition(.4);
        sleep(500);

    }
}
