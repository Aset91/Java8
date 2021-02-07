package com.IBS.tasks.services;

import com.IBS.tasks.entities.Organization;
import com.IBS.tasks.utils.DateTimeUtils;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class OrganizationService {
    private OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    private List<Organization> getAllOrganizationsCreatedAfterDate(LocalDate date) {
        List<Organization> organizations = organizationRepository.getOrganizationList().stream()
                .filter(organization -> organization.getFoundationDateAsDate().isAfter(date))
                .collect(Collectors.toList());

        return organizations;
    }

    public void printOrganizationsWithFoundationDate() {
        organizationRepository.getOrganizationList().forEach(org -> {
            System.out.println(String.join("", "\"", org.getName(), "\" - \"", org.getFoundationDate(), "\""));
        });
        System.out.println();
    }

    public void printAllOrganizationsAfterUserDate() {
        LocalDate userDate = null;

        Scanner in = new Scanner(System.in);
        while (userDate == null) {
            System.out.println("Введите дату в одном из форматов: «ДД.ММ.ГГГГ», «ДД.ММ.ГГ», «ДД/ММ/ГГГГ», «ДД/ММ/ГГ»");
            String value = in.nextLine();

            userDate = DateTimeUtils.parseDateByMultipleFormats(value);
            if (userDate == null) {
                System.out.println("Введено некорректное значение. Попробуйте еще раз");
            }
        }

        List<Organization> organizations = getAllOrganizationsCreatedAfterDate(userDate);

        if (!organizations.isEmpty()) {
            organizations.forEach(org -> {
                System.out.println(String.join("", "\"", org.getName(), "\" - \"", org.getFoundationDate(), "\""));
            });
        } else {
            System.out.println("Данные не найдены");
        }
        System.out.println();
    }
}
