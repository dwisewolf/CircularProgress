package com.welmondetest.camerabit;

import com.google.gson.annotations.SerializedName;

public class Img_Pojo {



    @SerializedName("Base64Barcode")
    private String Base64Barcode;

    @SerializedName("FirstName")
    private String FirstName;

    @SerializedName("Is21")
    private String Image;

    @SerializedName("IssuerIdentificationNumber")
    private String IssuerIdentificationNumber;

    @SerializedName("LastName")
    private String LastName;



    @SerializedName("response")
    private String Response;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getIssuerIdentificationNumber() {
        return IssuerIdentificationNumber;
    }

    public void setIssuerIdentificationNumber(String issuerIdentificationNumber) {
        IssuerIdentificationNumber = issuerIdentificationNumber;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }



    public String getResponse() {
        return Response;
    }

    public String getBase64Barcode() {
        return Base64Barcode;
    }

    public void setBase64Barcode(String base64Barcode) {
        Base64Barcode = base64Barcode;
    }


}
