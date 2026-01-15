package gg.noscam.api.interfaces;

import java.util.Map;

public interface SteamOpenIdVerifier {

    boolean verify(Map<String, String> params);

}