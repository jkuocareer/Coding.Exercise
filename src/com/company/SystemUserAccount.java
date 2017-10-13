package com.company;

public class SystemUserAccount implements SecurityFunction {

    private int accountLevel = 0;
    private int accountWriteLevel = 0;
    private int accountReadLevel = 0;
    private String api_key = "";


    SystemUserAccount(int accountLevel, int writeLevel, int readLevel, String apiKey) {
        this.accountLevel = accountLevel;
        this.accountWriteLevel = writeLevel;
        this.accountReadLevel = readLevel;
        this.api_key = apiKey;

    }

    /**
     * if you has a api key, most likely should be considered a external vendor, company employee shouldn't need an api key
     *
     * @return
     */
    @Override
    public boolean hasAPIKey() {
        return (api_key.length() > 0);
    }

    /**
     * @return
     */
    @Override
    public String getAPIKey() {
        return api_key;
    }

    @Override
    public void setAPIKey(String key) {

        this.api_key = key;
    }

    /**
     * this returns read permission level
     *
     * @return
     */
    @Override
    public int getAccountLevel() {
        return this.accountLevel;
    }

    /**
     * @param permission
     */
    @Override
    public void setAccountLevel(int permission) {

        this.accountLevel = permission;
    }

    /**
     * @return
     */
    @Override
    public int getReadPermissionLevel() {
        return this.accountReadLevel;
    }

    /**
     * @param permission
     */
    @Override
    public void setReadPermissionLevel(int permission) {

        this.accountReadLevel = permission;
    }

    /**
     * this returns write permission level
     *
     * @return
     */
    @Override
    public int getWritePermissionLeve() {
        return this.accountWriteLevel;
    }

    /**
     * @param permission
     */
    @Override
    public void setWritePermissionLevel(int permission) {

        this.accountWriteLevel = permission;

    }
}
