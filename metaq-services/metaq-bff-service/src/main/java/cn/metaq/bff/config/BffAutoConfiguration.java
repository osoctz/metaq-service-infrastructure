package cn.metaq.bff.config;

import cn.metaq.bff.uaa.fetchers.RoleDataFetcher;
import cn.metaq.bff.uaa.fetchers.UserDataFetcher;
import cn.metaq.bff.uaa.loaders.RoleDataLoader;
import cn.metaq.uaa.dto.RoleDTO;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import graphql.GraphQL;
import graphql.execution.instrumentation.dataloader.DataLoaderDispatcherInstrumentation;
import graphql.execution.instrumentation.dataloader.DataLoaderDispatcherInstrumentationOptions;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderOptions;
import org.dataloader.DataLoaderRegistry;
import org.dataloader.impl.DefaultCacheMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Configuration
public class BffAutoConfiguration {

    private GraphQL graphQL;

    @Autowired
    private UserDataFetcher userDataFetcher;
    @Autowired
    private RoleDataFetcher roleDataFetcher;
    @Autowired
    private RoleDataLoader roleDataLoader;

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }

    @Bean
    //@Scope(value = WebApplicationContext.SCOPE_APPLICATION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public DataLoaderRegistry dataLoaderRegistry() {

        DataLoaderOptions options = DataLoaderOptions.newOptions().setCacheMap(new DefaultCacheMap<String, Object>());

        DataLoader<String, RoleDTO> roleLoader = DataLoader.newDataLoader(roleDataLoader,options);
        DataLoaderRegistry registry = new DataLoaderRegistry();
        registry.register("roleLoader", roleLoader);
        return registry;
    }


    @PostConstruct
    public void init() throws IOException {

        URL url = Resources.getResource("schema.graphqls");
        String sdl = Resources.toString(url, Charsets.UTF_8);
        GraphQLSchema graphQLSchema = buildSchema(sdl);

        DataLoaderDispatcherInstrumentationOptions options = DataLoaderDispatcherInstrumentationOptions
                .newOptions().includeStatistics(true);

        DataLoaderDispatcherInstrumentation dispatcherInstrumentation
                = new DataLoaderDispatcherInstrumentation(options);


        this.graphQL = GraphQL.newGraphQL(graphQLSchema)
                .instrumentation(dispatcherInstrumentation)
                .build();
    }

    private GraphQLSchema buildSchema(String sdl) {
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {

        return RuntimeWiring.newRuntimeWiring()
                .type(newTypeWiring("Query")
                        .dataFetcher("user", userDataFetcher.loadUserByUsername())
                        .dataFetcher("role", roleDataFetcher.loadRoleByUsername()))
                .type(newTypeWiring("User")
                        .dataFetcher("roles", roleDataFetcher.loadRoles()))
                .build();

    }

}