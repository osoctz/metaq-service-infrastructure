package cn.metaq.bff.uaa.fetchers;

import cn.metaq.uaa.client.UaaServiceClient;
import cn.metaq.uaa.dto.UserDTO;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDataFetcher {

    @Autowired
    private UaaServiceClient uaaServiceClient;

    public DataFetcher loadUserByUsername(){

        return dataFetchingEnvironment->{
            String username = dataFetchingEnvironment.getArgument("username");

            UserDTO user=uaaServiceClient.loadUserByUsername(username);

            cn.metaq.bff.dto.UserDTO userDTO=new cn.metaq.bff.dto.UserDTO();

            userDTO.setId(user.getId());
            userDTO.setName(user.getName());
            userDTO.setUsername(user.getUsername());
            userDTO.setEmail(user.getEmail());

            return userDTO;
        };
    }
}
