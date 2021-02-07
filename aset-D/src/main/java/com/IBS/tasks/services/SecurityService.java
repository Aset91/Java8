package com.IBS.tasks.services;


import com.IBS.tasks.entities.Currency;
import com.IBS.tasks.entities.Organization;
import com.IBS.tasks.entities.Security;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class SecurityService {
    private static final List<String> SUPPORTED_CURRENCY = Arrays.asList("EU", "USD", "RU");
    private OrganizationRepository organizationRepository;

    public SecurityService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    private List<Security> getAllOverdueSecurities() {
        List<Security> overdueSecurityList = new ArrayList<>();

        organizationRepository.getOrganizationList().forEach(org -> {
            overdueSecurityList.addAll(
                    org.getSecurities().stream()
                            .filter(security -> security.getValidTillAsDate().isBefore(LocalDate.now()))
                            .collect(Collectors.toList()));
        });
        return overdueSecurityList;
    }

    private List<Security> getAllSecuritiesByCurrency(Currency currency) {
        List<Security> securityList = new ArrayList<>();

        organizationRepository.getOrganizationList().forEach(org -> {
            securityList.addAll(
                    org.getSecurities().stream()
                            .filter(security -> security.getCode().startsWith(currency.getTitle()))
                            .collect(Collectors.toList()));
        });
        return securityList;
    }

    public void printAllOverdueSecurities() {
        List<Security> overdueSecurityList = getAllOverdueSecurities();

        System.out.println("Ценные бумаги, просроченные на текущий день:");
        overdueSecurityList.forEach(security -> {
            System.out.println(security.toString());
        });

        System.out.println("Общее количество: " + overdueSecurityList.size());
        System.out.println();
    }

    public void printAllSecuritiesByCurrency() {
        Currency userCurrency = null;

        Scanner in = new Scanner(System.in);
        while (userCurrency == null) {
            System.out.println("Введите валюту в одном из форматов EU, USD, RU");
            String value = in.nextLine();

            try {
                userCurrency = Currency.valueOf(value);
            } catch (IllegalArgumentException e) {
                System.out.println("Введено некорректное значение. Попробуйте еще раз");
            }
        }

        List<Security> securityList = getAllSecuritiesByCurrency(userCurrency);
        if (!securityList.isEmpty()) {
            securityList.forEach(security -> {
                System.out.println(security.toString());
            });
        } else {
            System.out.println("Данные не найдены");
        }
    }
}
