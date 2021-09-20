package mx.inova_core.infrastructure.controller.auth;


import lombok.AllArgsConstructor;
import mx.inova_core.app.dto.UserDTO;
import mx.inova_core.app.service.UserAppService;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@AllArgsConstructor
public class InfoAdicional implements TokenEnhancer {
    private final UserAppService userAppService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        UserDTO usuario = userAppService.getByUserName(authentication.getName());
        Map<String, Object> info = new HashMap<>();
        info.put("names", usuario.getName() + " " + usuario.getLastName());
        info.put("identificationNumber", usuario.getCode());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        return accessToken;
    }
}
