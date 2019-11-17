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
        while(opModeIsActive()){


//                R.left_front_motor.setPower(gamepad1.left_stick_y);
//                R.right_front_motor.setPower(gamepad1.left_stick_y);
//                R.left_back_motor.setPower(gamepad1.left_stick_y);
//                R.right_back_motor.setPower(gamepad1.left_stick_y);
//
//                R.left_front_motor.setPower(gamepad1.left_stick_x);
//                R.left_back_motor.setPower(gamepad1.left_stick_x);
//                R.right_front_motor.setPower(-gamepad1.left_stick_x);
//                R.right_back_motor.setPower(-gamepad1.left_stick_x);
//
//                R.left_front_motor.setPower(-gamepad1.right_stick_x);
//                R.left_back_motor.setPower(gamepad1.right_stick_x);
//                R.right_front_motor.setPower(gamepad1.right_stick_x);
//                R.right_back_motor.setPower(-gamepad1.right_stick_x);

            double r = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y);
            double robotAngle = Math.atan2(-gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4;
            double rightX = gamepad1.right_stick_x;

            final double v1 = r * Math.cos(robotAngle) + rightX;
            final double v2 = r * Math.sin(robotAngle) - rightX;
            final double v3 = r * Math.sin(robotAngle) + rightX;
            final double v4 = r * Math.cos(robotAngle) - rightX;

            if(gamepad1.dpad_left){ // If Left D-Pad Arrow is pressed.
                R.left_front_motor.setPower(-0.7);
                R.right_front_motor.setPower(0.7);
                R.left_back_motor.setPower(0.7);
                R.right_back_motor.setPower(-0.7);
            }else if(gamepad1.dpad_right){ // If Right D-Pad Arrow is pressed.
                R.left_front_motor.setPower(0.7);
                R.right_front_motor.setPower(-0.7);
                R.left_back_motor.setPower(-0.7);
                R.right_back_motor.setPower(0.7);
            }else{ // If Left or Right D-Pad Arrows are NOT pressed.
                R.left_front_motor.setPower(v1);
                R.right_front_motor.setPower(v2);
                R.left_back_motor.setPower(v3);
                R.right_back_motor.setPower(v4);
            }

//            // check to see if we need to move the servo.
//            if(gamepad1.y) {
//                // move to 0 degrees.
//                servoTest.setPosition(0);
//            } else if (gamepad1.x || gamepad1.b) {
//                // move to 90 degrees.
//                servoTest.setPosition(0.5);
//            } else if (gamepad1.a) {
//                // move to 180 degrees.
//                servoTest.setPosition(1);
//            }

        }

    }
}