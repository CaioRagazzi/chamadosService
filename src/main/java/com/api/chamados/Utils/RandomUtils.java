package com.api.chamados.Utils;

import java.util.Random;

public class RandomUtils {

	public static int random50PercentError() {
		Random random = new Random();
		return random.nextInt(2) + 1;
	}

	public static double randomTotalOrder() {
		Random random = new Random();
		return random.nextInt(100) + 1;
	}

	public static int randomTotalItems() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}

	public static String randomOrderStatus() {
		Random random = new Random();
		return (random.nextInt(1) + 1) == 1 ? "Aberto" : "Fechado";
	}

	public static String randomPaymentInfoStatus() {
		Random random = new Random();
		return (random.nextInt(1) + 1) == 1 ? "Aceito" : "Rejeitado";
	}

	public static int randomPaymentInfoId() {
		Random random = new Random();
		return random.nextInt(1000) + 1;
	}

	public static void randomSleep() {
		Random random = new Random();
		int sleepTimeInMiles = (random.nextInt(15000) + 1);
		try {
			Thread.sleep(sleepTimeInMiles);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
