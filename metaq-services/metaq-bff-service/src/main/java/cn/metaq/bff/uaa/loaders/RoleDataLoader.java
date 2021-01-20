package cn.metaq.bff.uaa.loaders;

import cn.metaq.fegin.authz.interceptor.FeignClientsRequestInterceptor;
import cn.metaq.uaa.client.UaaServiceClient;
import cn.metaq.uaa.dto.RoleDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dataloader.BatchLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Component
public class RoleDataLoader implements BatchLoader<String, RoleDTO> {

    private static final Logger log = LogManager.getLogger(RoleDataLoader.class);

    @Autowired
    private UaaServiceClient uaaServiceClient;

    @Override
    public CompletionStage<List<RoleDTO>> load(List<String> usernames) {

        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
        log.info("token:{}",details.getTokenType()+" "+details.getTokenValue());
        return CompletableFuture.supplyAsync(() -> uaaServiceClient.list(details.getTokenType()+" "+details.getTokenValue(),usernames));
    }
}
