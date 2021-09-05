package cn.metaq.bff.uaa.fetchers;

import cn.metaq.bff.DgsConstants;
import cn.metaq.bff.dto.UserDTO;
import cn.metaq.bff.types.Role;
import cn.metaq.bff.types.User;
import cn.metaq.bff.uaa.loaders.RoleDataLoader;
import cn.metaq.uaa.client.UaaServiceClient;
import cn.metaq.uaa.dto.RoleDTO;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.InputArgument;
import graphql.schema.DataFetcher;
import org.dataloader.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@DgsComponent
public class RoleDataFetcher {

    private final UaaServiceClient uaaServiceClient;

    public RoleDataFetcher(UaaServiceClient uaaServiceClient) {
        this.uaaServiceClient = uaaServiceClient;
    }

    @DgsData(parentType = DgsConstants.USER.TYPE_NAME,field = DgsConstants.USER.Roles)
    public CompletableFuture<List<Role>> roles(DgsDataFetchingEnvironment dfe) {

        DataLoader<String,Role> roleDataLoader=dfe.getDataLoader(RoleDataLoader.class);

        User user = dfe.getSource();
        return roleDataLoader.loadMany(List.of(user.getUsername()));
    }

    @DgsData(parentType = DgsConstants.QUERY_TYPE, field = DgsConstants.QUERY.Role)
    public List<Role> role(@InputArgument("username") String username) {

        return uaaServiceClient.list(List.of(username)).stream().map(s -> {

            return Role.newBuilder().id(String.valueOf(s.getId()))
                    .nameCn(s.getNameCn())
                    .nameCn(s.getNameEn())
                    .build();
        }).collect(Collectors.toList());

    }
}
