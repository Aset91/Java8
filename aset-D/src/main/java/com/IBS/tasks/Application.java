package com.IBS.tasks;


import com.IBS.tasks.services.OrganizationRepository;
import com.IBS.tasks.services.OrganizationService;
import com.IBS.tasks.services.SecurityService;


public class Application {

    public static void main(String[] args) {
        OrganizationRepository organizationRepository = new OrganizationRepository();
        OrganizationService organizationService = new OrganizationService(organizationRepository);
        SecurityService securityService = new SecurityService(organizationRepository);

        //Вывести все имеющиеся компании в формате «Краткое название» – «Дата основания 17/01/98»
        organizationService.printOrganizationsWithFoundationDate();

        //Вывести все ценные бумаги (их код, дату истечения и полное название организации-владельца),
        // которые просрочены на текущий день, а также посчитать суммарное число всех таких бумаг
        securityService.printAllOverdueSecurities();

        //На запрос пользователя в виде даты «ДД.ММ.ГГГГ», «ДД.ММ.ГГ», «ДД/ММ/ГГГГ» и «ДД/ММ/ГГ»
        // вывести название и дату создания всех организаций, основанных после введенной даты
        organizationService.printAllOrganizationsAfterUserDate();

        //На запрос пользователя в виде кода валюты, например EU, USD, RUB и пр. выводить id и коды ценных бумаг,
        // использующих заданную валюту.
        securityService.printAllSecuritiesByCurrency();
    }
}
