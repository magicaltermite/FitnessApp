package com.example.fitnessapp.models.wgerAPI.exerciseInfo;

import java.util.List;

public class Result {
    public int id;
    public String name;
    public String uuid;
    public String description;
    public String creation_date;
    public Category category;
    public List<Muscle> muscles;
    public List<MusclesSecondary> muscles_secondary;
    public List<Equipment> equipment;
    public Language language;
    public License license;
    public String license_author;
    public List<Image> images;
    public List<Comment> comments;
    public List<Integer> variations;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Muscle> getMuscles() {
        return muscles;
    }

    public void setMuscles(List<Muscle> muscles) {
        this.muscles = muscles;
    }

    public List<MusclesSecondary> getMuscles_secondary() {
        return muscles_secondary;
    }

    public void setMuscles_secondary(List<MusclesSecondary> muscles_secondary) {
        this.muscles_secondary = muscles_secondary;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public String getLicense_author() {
        return license_author;
    }

    public void setLicense_author(String license_author) {
        this.license_author = license_author;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Integer> getVariations() {
        return variations;
    }

    public void setVariations(List<Integer> variations) {
        this.variations = variations;
    }
}
