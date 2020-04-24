package com.company;

import java.lang.Math;

public class CreditCalculator {
    private int creditSum;
    private int creditTime;
    private double fixedPercent;
    private int payment;

    public CreditCalculator(int creditSum, int creditTime, double fixedPercent, int payment) {
        this.creditSum = creditSum;
        this.creditTime = creditTime;
        this.fixedPercent = fixedPercent / 100;
        this.payment = payment;
    }

    public double monthPayment(int n) {       //Рассчёт месячного платежа
        double monthPayment = 0;
        if (payment == 0) {     //0 - дифференцированный платёж, 1 - аннуитетный
            monthPayment = (creditSum + fixedPercent * creditSum * (creditTime - n + 1)) / creditTime;
        } else {
            monthPayment = creditSum * (fixedPercent + fixedPercent / (Math.pow((1 + fixedPercent), creditTime) - 1));
        }
        return Math.round(monthPayment * 100.0) / 100.0;
    }

    public double allPayments() {       //Рассчёт всей суммы платежей
        double allPayments = 0;
        if (payment == 0) {
            allPayments = fixedPercent * creditSum * (creditTime + 1) / 2 + creditSum;
        } else {
            for (int i = 0; i < creditTime; i++) {
                allPayments += monthPayment(0);
            }
        }
        return Math.round(allPayments * 100.0) / 100.0;
    }
}
