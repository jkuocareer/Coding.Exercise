package com.company;

public interface SecurityFunction {

    /**
     * if you has a api key, most likely should be considered a external vendor, company employee shouldn't need an api key
     *
     * @return
     */
    boolean hasAPIKey();

    /**
     * @return
     */
    String getAPIKey();

    /**
     * @param key
     */
    void setAPIKey(String key);

    /**
     * this returns read permission level
     *
     * @return
     */
    int getAccountLevel();

    /**
     * @param permission
     */
    void setAccountLevel(int permission);

    /**
     * @return
     */
    int getReadPermissionLevel();

    /**
     * @param permission
     */

    void setReadPermissionLevel(int permission);

    /**
     * this returns write permission level
     *
     * @return
     */
    int getWritePermissionLeve();

    /**
     * @param permission
     */
    void setWritePermissionLevel(int permission);


}
