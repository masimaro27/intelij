package com.authorization.oauth.service;

import com.authorization.oauth.domain.AccessToken;
import com.authorization.oauth.domain.Client;
import com.authorization.oauth.repository.AccessTokenRepository;
import com.authorization.oauth.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Slf4j
@Service("ssoService")
public class SsoServiceImpl implements SsoService {

    @Autowired
    private AccessTokenRepository accessTokenRepository;

    @Autowired
    private ClientRepository clientRepository;


    @Override
    public AccessToken getAccessToken(String token, String clientId) {

        return null;
    }

    @Override
    @Transactional
    public String logoutAllClients(String clientId, String userName) {
        return null;
    }

    private String extractTokenId(String value) {
        if (value == null) {
            return null;
        }

        byte[] bytes = null;
        try{
            MessageDigest digest = MessageDigest.getInstance("MD5");
            bytes = digest.digest(value.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return String.format("%032x", new BigInteger(1, bytes));
    }

    private void requestLogoutToAllClients(String userName) {
        //
        List<AccessToken> tokens = accessTokenRepository.findByUserName(userName);

        for (AccessToken token : tokens) {
            requestLogoutToClient(token);
        }
    }

    private void requestLogoutToClient(AccessToken token) {
        //
        Client client = clientRepository.findOne(token.getClientId());

        String logoutUri = client.getLogoutUri();
        String authorizationHeader = null;

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("tokenId", token.getTokenId());
        paramMap.put("userName", token.getUserName());

        HttpPost post = buildHttpPost(logoutUri, paramMap, authorizationHeader);
        executePostAndParseResult(post, Object.class);
    }


}
