package com.enggdream.unitedway.modal;

import android.os.Parcel;
import android.os.Parcelable;

public class Provider implements Parcelable {

    private String requestNumber;

    private String requestType;

    private String customerName;

    private String customerMoNumber;

    private String customerAddress;

    private String description;

    private String comment;

    public Provider() {
    }

    public Provider(String customerName, String customerMoNumber, String customerAddress, String description, String comment,String requestNumber,String requestType) {
        this.customerName = customerName;
        this.customerMoNumber = customerMoNumber;
        this.customerAddress = customerAddress;
        this.description = description;
        this.comment = comment;
        this.requestNumber = requestNumber;
        this.requestType = requestType;
    }

    protected Provider(Parcel in) {
        customerName = in.readString();
        customerMoNumber = in.readString();
        customerAddress = in.readString();
        description = in.readString();
        comment = in.readString();
        requestNumber = in.readString();
        requestType = in.readString();
    }

    public static final Creator<Provider> CREATOR = new Creator<Provider>() {
        @Override
        public Provider createFromParcel(Parcel in) {
            return new Provider(in);
        }

        @Override
        public Provider[] newArray(int size) {
            return new Provider[size];
        }
    };

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerMoNumber() {
        return customerMoNumber;
    }

    public void setCustomerMoNumber(String customerMoNumber) {
        this.customerMoNumber = customerMoNumber;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(String requestNumber) {
        this.requestNumber = requestNumber;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(customerName);
        dest.writeString(customerMoNumber);
        dest.writeString(customerAddress);
        dest.writeString(description);
        dest.writeString(comment);
        dest.writeString(requestNumber);
        dest.writeString(requestType);
    }
}
