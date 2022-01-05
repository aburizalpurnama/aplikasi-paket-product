package com.example.paketproduct.algorithm.association;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.paketproduct.algorithm.fpgrowth.AlgoFPGrowth;

public class ParcelableAssocResult implements Parcelable {

    private AlgoFPGrowth fpGrowth;

    private AssocRules rules;

    public ParcelableAssocResult() {
    }

    public ParcelableAssocResult(AlgoFPGrowth fpGrowth, AssocRules rules) {
        this.fpGrowth = fpGrowth;
        this.rules = rules;
    }

    public AlgoFPGrowth getFpGrowth() {
        return fpGrowth;
    }

    public AssocRules getRules() {
        return rules;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.fpGrowth, flags);
        dest.writeParcelable(this.rules, flags);
    }

    public void readFromParcel(Parcel source) {
        this.fpGrowth = source.readParcelable(AlgoFPGrowth.class.getClassLoader());
        this.rules = source.readParcelable(AssocRules.class.getClassLoader());
    }

    protected ParcelableAssocResult(Parcel in) {
        this.fpGrowth = in.readParcelable(AlgoFPGrowth.class.getClassLoader());
        this.rules = in.readParcelable(AssocRules.class.getClassLoader());
    }

    public static final Parcelable.Creator<ParcelableAssocResult> CREATOR = new Parcelable.Creator<ParcelableAssocResult>() {
        @Override
        public ParcelableAssocResult createFromParcel(Parcel source) {
            return new ParcelableAssocResult(source);
        }

        @Override
        public ParcelableAssocResult[] newArray(int size) {
            return new ParcelableAssocResult[size];
        }
    };
}