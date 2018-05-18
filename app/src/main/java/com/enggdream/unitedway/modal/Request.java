package com.enggdream.unitedway.modal;

import android.os.Parcel;
import android.os.Parcelable;

public class Request implements Parcelable{

    private int requestNumber;

    private String reqType;

    private String reqStatus;

    private String createdOn;

    private String assignedTo;

    protected Request(Parcel in) {
        requestNumber = in.readInt();
        reqType = in.readString();
        reqStatus = in.readString();
        createdOn = in.readString();
        assignedTo = in.readString();
    }

    public static final Creator<Request> CREATOR = new Creator<Request>() {
        @Override
        public Request createFromParcel(Parcel in) {
            return new Request(in);
        }

        @Override
        public Request[] newArray(int size) {
            return new Request[size];
        }
    };

    public int getRequestNumber() {
        return requestNumber;
    }

    public Request() {
    }

    public Request(int requestNumber, String reqType, String reqStatus, String createdOn, String assignedTo) {
        this.requestNumber = requestNumber;
        this.reqType = reqType;
        this.reqStatus = reqStatus;
        this.createdOn = createdOn;
        this.assignedTo = assignedTo;
    }

    public void setRequestNumber(int requestNumber) {
        this.requestNumber = requestNumber;
    }

    public String getReqType() {
        return reqType;
    }

    public void setReqType(String reqType) {
        this.reqType = reqType;
    }

    public String getReqStatus() {
        return reqStatus;
    }

    public void setReqStatus(String reqStatus) {
        this.reqStatus = reqStatus;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(requestNumber);
        dest.writeString(reqType);
        dest.writeString(reqStatus);
        dest.writeString(createdOn);
        dest.writeString(assignedTo);
    }
}
