package cn.metaq.example.sso2.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class OAuth2AuthenticationDeserializer extends JsonDeserializer<OAuth2Authentication> {

    @Override
    public OAuth2Authentication deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {

        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        JsonNode jsonNode = mapper.readTree(jp);

        JsonNode requestNode = readJsonNode(jsonNode, "storedRequest");
        JsonNode userAuthenticationNode = readJsonNode(jsonNode, "userAuthentication");

        Authentication authentication = parseAuthentication(mapper, userAuthenticationNode);
        OAuth2Request request = parseOAuth2Request(mapper, requestNode);
        return new OAuth2Authentication(request, authentication);
    }

    private Authentication parseAuthentication(ObjectMapper mapper, JsonNode json) {
        if (mapper == null || json == null) {
            return null;
        }

        json = readJsonNode(json, "details");
        User principal = parseOAuth2User(mapper, json.get("principal"));
        Object credentials = readValue(mapper, json.get("credentials"), Object.class);
        Set<SimpleGrantedAuthority> grantedAuthorities = parseSimpleGrantedAuthorities(mapper, json.get("authorities"));

        return new UsernamePasswordAuthenticationToken(principal, credentials, grantedAuthorities);
    }

    private User parseOAuth2User(ObjectMapper mapper, JsonNode json) {
        if (mapper == null || json == null) {
            return null;
        }

        String username = readString(mapper, json.get("username"));
        String password = readString(mapper, json.get("password"));
        password = password == null ? "" : password;
        Boolean accountNonExpired = readValue(mapper, json.get("accountNonExpired"), Boolean.class);
        Boolean accountNonLocked = readValue(mapper, json.get("accountNonLocked"), Boolean.class);
        Boolean credentialsNonExpired = readValue(mapper, json.get("credentialsNonExpired"), Boolean.class);
        Boolean enabled = readValue(mapper, json.get("enabled"), Boolean.class);

        Set<SimpleGrantedAuthority> grantedAuthorities = parseSimpleGrantedAuthorities(mapper, json.get("authorities"));

        return new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuthorities);
    }

    private OAuth2Request parseOAuth2Request(ObjectMapper mapper, JsonNode json) {
        if (mapper == null || json == null) {
            return null;
        }
        Map<String, String> requestParameters = new HashMap<>();//readValue(mapper, json.get("requestParameters"), HashMap.class);
        String clientId = readString(mapper, json.get("clientId"));
        String grantType = readString(mapper, json.get("grantType"));//null
        String redirectUri = readString(mapper, json.get("redirectUri"));//null
        Boolean approved = readValue(mapper, json.get("approved"), Boolean.class);

        Set<String> responseTypes = new HashSet<>();//readValue(mapper, json.get("responseTypes"), Set.class);
        Set<String> scope = new HashSet<>();//readValue(mapper, json.get("scope"), new TypeReference<Set<String>>(){});
        Set<String> resourceIds = new HashSet<>();//readValue(mapper, json.get("resourceIds"), new TypeReference<Set<String>>(){});
        Map<String, Serializable> extensions = readValue(mapper, json.get("extensions"),
                new TypeReference<Map<String, Serializable>>() {
                });

        //Set<SimpleGrantedAuthority> grantedAuthorities = parseSimpleGrantedAuthorities(mapper, json.get("authorities"));

        OAuth2Request request = new OAuth2Request(requestParameters, clientId,
                null, approved, scope, resourceIds, redirectUri, responseTypes, extensions);
        TokenRequest tokenRequest = new TokenRequest(requestParameters, clientId, scope, grantType);
        request.refresh(tokenRequest);
        return request;
    }

    private Set<SimpleGrantedAuthority> parseSimpleGrantedAuthorities(ObjectMapper mapper, JsonNode json) {
        List<LinkedHashMap<String, String>> authorities = readValue(mapper, json, List.class);
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>(0);
        if (authorities != null && !authorities.isEmpty()) {
            authorities.forEach(s -> {
                if (s != null && !s.isEmpty()) {
                    grantedAuthorities.add(new SimpleGrantedAuthority(s.get("authority")));
                }
            });
        }
        return grantedAuthorities;
    }

    private static String readString(ObjectMapper mapper, JsonNode jsonNode) {
        String value = readValue(mapper, jsonNode, String.class);
        return StringUtils.isEmpty(value) ? "" : value;
    }

    private static <T> T readValue(ObjectMapper mapper, JsonNode jsonNode, Class<T> clazz) {
        if (mapper == null || jsonNode == null || clazz == null) {
            return null;
        }
        try {
            return mapper.readValue(jsonNode.traverse(), clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static <T> T readValue(ObjectMapper mapper, JsonNode jsonNode, TypeReference<T> type) {
        if (mapper == null || jsonNode == null || type == null) {
            return null;
        }
        try {
            return mapper.readValue(jsonNode.traverse(), type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private JsonNode readJsonNode(JsonNode jsonNode, String field) {
        return jsonNode.has(field) ? jsonNode.get(field) : MissingNode.getInstance();
    }
}
