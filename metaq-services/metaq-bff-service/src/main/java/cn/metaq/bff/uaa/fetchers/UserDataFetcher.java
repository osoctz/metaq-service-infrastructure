package cn.metaq.bff.uaa.fetchers;

import cn.metaq.bff.DgsConstants;
import cn.metaq.bff.types.User;
import cn.metaq.uaa.client.UaaServiceClient;
import cn.metaq.uaa.dto.UserDTO;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@DgsComponent
public class UserDataFetcher {

    private final UaaServiceClient uaaServiceClient;

    public UserDataFetcher(UaaServiceClient uaaServiceClient) {
        this.uaaServiceClient = uaaServiceClient;
    }

    @DgsData(parentType = DgsConstants.QUERY_TYPE,field = DgsConstants.QUERY.User)
    public User user(@InputArgument("username") String username){

        UserDTO userDTO= uaaServiceClient.loadUserByUsername(username);

        return User.newBuilder()
                .id(String.valueOf(userDTO.getId()))
                .name(userDTO.getName())
                .username(userDTO.getUsername())
                .build();
    }
}
