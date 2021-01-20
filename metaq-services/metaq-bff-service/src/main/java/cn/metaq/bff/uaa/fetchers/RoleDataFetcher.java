package cn.metaq.bff.uaa.fetchers;

import cn.metaq.bff.dto.UserDTO;
import cn.metaq.uaa.client.UaaServiceClient;
import cn.metaq.uaa.dto.RoleDTO;
import graphql.schema.DataFetcher;
import org.dataloader.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleDataFetcher {

    @Autowired
    private UaaServiceClient uaaServiceClient;

    public DataFetcher loadRoles(){
        return environment ->{
            UserDTO user=environment.getSource();
            DataLoader<String, RoleDTO> dataLoader = environment.getDataLoader("roleLoader");
            return dataLoader.loadMany(List.of(user.getUsername()));
        };
    }

    public DataFetcher loadRoleByUsername(){

        return env->{
            String username=env.getArgument("username");

            return uaaServiceClient.list(List.of(username));
        };
    }
}
