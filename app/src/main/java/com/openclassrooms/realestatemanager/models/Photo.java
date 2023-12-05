package com.openclassrooms.realestatemanager.models;

public class Photo {
    private int id;
    private final String url;
    private final String description;
    private int propertyId;

    public Photo(String url, String description) {
            this.url = url;
            this.description = description;
        }

        public void setId ( int id){
            this.id = id;
        }

        public int getId () {
            return id;

        }
        public String getUrl () {
            return url;
        }
        public String getDescription () {
            return description;
        }
    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }
    }
