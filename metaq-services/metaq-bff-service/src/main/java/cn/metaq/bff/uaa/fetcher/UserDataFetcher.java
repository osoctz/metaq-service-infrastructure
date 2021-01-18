package cn.metaq.bff.uaa.fetcher;

import cn.metaq.uaa.client.UaaServiceClient;
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
            return uaaServiceClient.loadUserByUsername(username);
        };
    }
}
