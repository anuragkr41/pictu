package com.pictu.iam.core.utilities;

import lombok.Getter;

@Getter
public class OTPGenerator {
	private static String Otp = generateOTP();

	private static String generateOTP() {
		int x = 0;

		for (int i = 0; i < 50; i++) {
			x = (int) (Math.random() * 1000000);
			String OTP = String.valueOf(x);

			if (OTP.length() == 6) {
				System.out.println(OTP);
			}

			else {
				int zerosToAppend = 6 - OTP.length();
				if (zerosToAppend == 1) {
					OTP = OTP.concat("0");
				} else if (zerosToAppend == 2) {
					OTP = OTP.concat("00");
				} else if (zerosToAppend == 3) {
					OTP = OTP.concat("000");
				} else if (zerosToAppend == 4) {
					OTP = OTP.concat("0000");
				} else if (zerosToAppend == 5) {
					OTP = OTP.concat("00000");
				}

				System.out.println(OTP);
			}

		}
		return "Whatever";

	}

	public static void main(String[] args) {
		System.out.println(Otp);

	}

}
