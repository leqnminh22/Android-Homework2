package com.mle.homework2;

import android.os.Parcel;
import android.os.Parcelable;

public class Calculator implements Parcelable {

    private Double result = 0.0;
    private String firstArg = "";
    private String secondArg = "";
    private Boolean addFlag = false; // Флаг сложения
    private Boolean subFlag = false; // Флаг вычитания
    private Boolean mulFlag = false; // Флаг умножения
    private Boolean divFlag = false; // Флаг деления

    public Calculator() {
    }

    protected Calculator(Parcel in) {
        if (in.readByte() == 0) {
            result = null;
        } else {
            result = in.readDouble();
        }
        firstArg = in.readString();
        secondArg = in.readString();
        byte tmpAddFlag = in.readByte();
        addFlag = tmpAddFlag == 0 ? null : tmpAddFlag == 1;
        byte tmpSubFlag = in.readByte();
        subFlag = tmpSubFlag == 0 ? null : tmpSubFlag == 1;
        byte tmpMulFlag = in.readByte();
        mulFlag = tmpMulFlag == 0 ? null : tmpMulFlag == 1;
        byte tmpDivFlag = in.readByte();
        divFlag = tmpDivFlag == 0 ? null : tmpDivFlag == 1;
    }

    public static final Creator<Calculator> CREATOR = new Creator<Calculator>() {
        @Override
        public Calculator createFromParcel(Parcel in) {
            return new Calculator(in);
        }

        @Override
        public Calculator[] newArray(int size) {
            return new Calculator[size];
        }
    };

    /**
     * Ввод номера
     *
     * @param firstArg - номер
     */
    public void setFirstArg(String firstArg) {
        this.firstArg = this.firstArg + firstArg;
    }

    /**
     * Выход результата нажатий
     *
     * @return - результат ввода
     */
    public String getResult() {
        result = Double.parseDouble(firstArg);
        return result.toString();
    }

    public void setAddFlag(Boolean addFlag) {
        this.addFlag = addFlag;
        if (this.addFlag) {
            secondArg = firstArg;
            firstArg = "";
        }
    }

    public void setSubFlag(Boolean subFlag) {
        this.subFlag = subFlag;
        if (this.subFlag) {
            secondArg = firstArg;
            firstArg = "";
        }
    }

    public void setMulFlag(Boolean mulFlag) {
        this.mulFlag = mulFlag;
        if (this.mulFlag) {
            secondArg = firstArg;
            firstArg = "";
        }
    }

    public void setDivFlag(Boolean divFlag) {
        this.divFlag = divFlag;
        if (this.divFlag) {
            secondArg = firstArg;
            firstArg = "";
        }
    }

    public void reset() {
        firstArg = "";
        secondArg = "";
        addFlag = false;
        subFlag = false;
        mulFlag = false;
        divFlag = false;

    }

    public void calculations() {
        if (addFlag) add();
        if (subFlag) sub();
        if (mulFlag) mul();
        if (divFlag) div();

    }

    public String getCalculations() {
        return result.toString();
    }

    public void add() {
        result = Double.parseDouble(secondArg) + Double.parseDouble(firstArg);
        addFlag = false;
        firstArg = "";
        secondArg = "";
    }

    public void sub() {
        result = Double.parseDouble(secondArg) - Double.parseDouble(firstArg);
        subFlag = false;
        firstArg = "";
        secondArg = "";
    }


    public void mul() {
        result = Double.parseDouble(secondArg) * Double.parseDouble(firstArg);
        mulFlag = false;
        firstArg = "";
        secondArg = "";
    }

    public void div() {
        result = Double.parseDouble(secondArg) / Double.parseDouble(firstArg);
        divFlag = false;
        firstArg = "";
        secondArg = "";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (result == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(result);
        }
        parcel.writeString(firstArg);
        parcel.writeString(secondArg);
        parcel.writeByte((byte) (addFlag == null ? 0 : addFlag ? 1 : 2));
        parcel.writeByte((byte) (subFlag == null ? 0 : subFlag ? 1 : 2));
        parcel.writeByte((byte) (mulFlag == null ? 0 : mulFlag ? 1 : 2));
        parcel.writeByte((byte) (divFlag == null ? 0 : divFlag ? 1 : 2));
    }
}
