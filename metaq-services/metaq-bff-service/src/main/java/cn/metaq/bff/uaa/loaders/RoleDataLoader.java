package cn.metaq.bff.uaa.loaders;

import cn.metaq.bff.types.Role;
import cn.metaq.uaa.client.UaaServiceClient;
import com.netflix.graphql.dgs.DgsDataLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dataloader.BatchLoader;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

@DgsDataLoader(name = "roles")
public class RoleDataLoader implements BatchLoader<String, Role> {

    private static final Logger log = LogManager.getLogger(RoleDataLoader.class);

    private final UaaServiceClient uaaServiceClient;

    public RoleDataLoader(UaaServiceClient uaaServiceClient) {
        this.uaaServiceClient = uaaServiceClient;
    }

    @Override
    public CompletionStage<List<Role>> load(List<String> usernames) {

        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();

        log.info("token:{}", details.getTokenType() + " " + details.getTokenValue());

        return CompletableFuture.supplyAsync(() -> uaaServiceClient.list(details.getTokenType() + " " + details.getTokenValue(), usernames).stream()
                .map(s -> Role.newBuilder()
                        .id(String.valueOf(s.getId()))
                        .nameCn(s.getNameCn())
                        .nameEn(s.getNameEn())
                        .build()).collect(Collectors.toList()));
    }
}
