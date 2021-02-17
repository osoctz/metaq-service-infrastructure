package cn.metaq.example.sso2.jackson;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.security.jackson2.SecurityJackson2Modules;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

public class OAuth2Jackson2Module extends SimpleModule {

    public OAuth2Jackson2Module() {
        super(OAuth2Jackson2Module.class.getName(), new Version(1, 0, 0, null, null, null));
    }

    @Override
    public void setupModule(SetupContext context) {

        SecurityJackson2Modules.enableDefaultTyping(context.getOwner());
        context.setMixInAnnotations(OAuth2Authentication.class, OAuth2AuthenticationMixin.class);
        super.setupModule(context);
    }
}
