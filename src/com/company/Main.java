package com.company;

import java.util.Scanner;

public class Main {

    public static void test() {
        CreditCalculator credit0 = new CreditCalculator(100000, 48, 10, 0);       //Кредит с дифференцированными платежами
        CreditCalculator credit1 = new CreditCalculator(100000, 48, 10, 1);       //Кредит с аннуитетными платежами
        double monthPayment0 = credit0.monthPayment(5);
        double monthPayment1 = credit1.monthPayment(0);
        double allPayments0 = credit0.allPayments();
        double allPayments1 = credit1.allPayments();
        System.out.println("Дифференцированный платёж в n месяце: " + monthPayment0);
        System.out.println("Сумма дифференцированных платежей: " + allPayments0);
        System.out.println();
        System.out.println("Ежемесячный аннуитетный платёж: " + monthPayment1);
        System.out.println("Сумма аннуитетных платежей: " + allPayments1);
        System.out.println();
    }

    public static void main(String[] args) {
        test();
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите сумму кредита: ");
        int creditSum = scan.nextInt();
        System.out.println("Введите срок кредитования в месяцах: ");
        int creditTime = scan.nextInt();
        System.out.println("Введите месячную процентную ставку: ");
        double fixedPercent = scan.nextDouble();
        System.out.println("Введите вид платежа (0 - дифференцированный, 1 - аннуитетный): ");
        int payment = scan.nextInt();
        int n = 0;
        if(payment == 0) {
            System.out.println("Введите месяц для расчёта дифференцированного платежа: ");
            n = scan.nextInt();
        }
        CreditCalculator credit = new CreditCalculator(creditSum, creditTime, fixedPercent, payment);
        double monthPayment = credit.monthPayment(n);
        double allPayments = credit.allPayments();
        System.out.println("Месячный платёж: " + monthPayment);
        System.out.println("Сумма всех платежей: " + allPayments);
    }
}
