package rz.rasel.androidpassingobjectsbetweenactivitiesone;

import java.io.Serializable;

/**
 * Created by nextdot on 2/9/16.
 */
public class RzSendObjectToActivity implements Serializable {
    //|------------------------------------|
    private String name;
    private long serialUID;

    //|------------------------------------|
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    public String getName() {
        return name;
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    public void setName(String argName) {
        this.name = argName;
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    public long getSerialUID() {
        return serialUID;
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    public void setSerialUID(long argSerialUID) {
        this.serialUID = argSerialUID;
    }
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
}