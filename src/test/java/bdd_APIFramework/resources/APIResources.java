package bdd_APIFramework.resources;
//enum is special class in java which has collection of constant and methods
public enum APIResources {

    AddPlaceAPI("/maps/api/place/add/json"),
    getPlaceApI("/maps/api/place/get/json"),
    deletePlaceAPI("/maps/api/place/delete/json");
    private String resource;

    APIResources(String resource) {
        this.resource=resource;
    }


    public String getResources(){
        return resource;
    }
}
