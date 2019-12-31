package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;


@TeleOp(name="TeleOp", group="Linear Opmode")
public class TeleopMode extends LinearOpMode {
    public Robot R = new Robot();
    public HardwareMap HwMap;

    @Override
    public void runOpMode() {
        R.init(hardwareMap);
        waitForStart();
        while (opModeIsActive()) {

            // Mech Drive
            R.left_front_motor.setPower(-gamepad1.left_stick_y + gamepad1.right_stick_x + gamepad1.left_stick_x);
            R.left_back_motor.setPower(-gamepad1.left_stick_y + gamepad1.right_stick_x - gamepad1.left_stick_x);
            R.right_front_motor.setPower(-gamepad1.left_stick_y - gamepad1.right_stick_x - gamepad1.left_stick_x);
            R.right_back_motor.setPower(-gamepad1.left_stick_y - gamepad1.right_stick_x + gamepad1.left_stick_x);

            // D-Pad Strafe
            if(gamepad1.dpad_left || gamepad1.dpad_right) {
                R.left_front_motor.setPower(-(gamepad1.dpad_left ? 1.0 : 0.0) + (gamepad1.dpad_right ? 1.0 : 0.0));
                R.left_back_motor.setPower((gamepad1.dpad_left ? 1.0 : 0.0) - (gamepad1.dpad_right ? 1.0 : 0.0));
                R.right_front_motor.setPower((gamepad1.dpad_left ? 1.0 : 0.0) - (gamepad1.dpad_right ? 1.0 : 0.0));
                R.right_back_motor.setPower(-(gamepad1.dpad_left ? 1.0 : 0.0) + (gamepad1.dpad_right ? 1.0 : 0.0));
            }

            // Claws
            if(gamepad2.y){
                R.claw.setPosition(1);
                R.claw2.setPosition(0);
            }
            if(gamepad2.a) {
                R.claw.setPosition(0);
                R.claw2.setPosition(1);
            }
        }
    }
}