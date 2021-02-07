package com.IBS.tasks.services;

import com.IBS.tasks.entities.Organization;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;


public class OrganizationRepository {
    private static final String FILE_NAME = "json/Organizations.json";

    private List<Organization> organizationList;


    public OrganizationRepository() {
        File file = getOrganizationFile();

        try {
            ObjectMapper mapper = new ObjectMapper();
            Organization[] organizations = mapper.readValue(file, Organization[].class);
            organizationList = Arrays.asList(organizations);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении json файла: " + e.getMessage());
        }
    }

    private File getOrganizationFile() {
        URL resource = getClass().getClassLoader().getResource(FILE_NAME);

        if (resource == null) {
            throw new IllegalArgumentException("Файл с именем " + FILE_NAME + " не найден");
        } else {
            try {
                return new File(resource.toURI());
            } catch (URISyntaxException e) {
                throw new IllegalArgumentException("Некорректный путь к файлу " + FILE_NAME);
            }
        }
    }

    public List<Organization> getOrganizationList() {
        return organizationList;
    }
}
