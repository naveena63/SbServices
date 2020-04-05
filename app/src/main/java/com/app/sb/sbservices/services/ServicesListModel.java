package com.app.sb.sbservices.services;

import com.app.sb.sbservices.Menu.QuestionAndAnswerModel;

import java.util.ArrayList;

public class ServicesListModel {
    String serviceId;
    String serviceName;
    String serviceImage;
    String inclusion;
    String exclusion;
    String no_packages_available;
    private ArrayList<QuestionAndAnswerModel> allItemsInSection;

    public ArrayList<QuestionAndAnswerModel> getAllItemsInSection() {
        return allItemsInSection;
    }

    public void setAllItemsInSection(ArrayList<QuestionAndAnswerModel> allItemsInSection) {
        this.allItemsInSection = allItemsInSection;
    }

    public String getFaqs() {
        return faqs;
    }

    public void setFaqs(String faqs) {
        this.faqs = faqs;
    }

    String faqs;


    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getNo_packages_available() {
        return no_packages_available;
    }

    public void setNo_packages_available(String no_packages_available) {
        this.no_packages_available = no_packages_available;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceImage() {
        return serviceImage;
    }

    public void setServiceImage(String serviceImage) {
        this.serviceImage = serviceImage;
    }

    public String getInclusion()
    {
        return  inclusion;
    }
    public void setInclusion(String inclusion) {
        this.inclusion = inclusion;
    }
    public String getExclusion()
    {
        return  exclusion;
    }
    public void setExclusion(String exclusion) {
        this.exclusion = exclusion;
    }
}
