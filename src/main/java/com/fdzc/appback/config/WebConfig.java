package com.fdzc.appback.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${file.upload-path.apk:D:/手游管理平台/apk/}") // 带默认值的配置
    private String uploadApkPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Windows路径需要额外处理斜杠
        String formattedPath = uploadApkPath.replace("\\", "/");
        if (!formattedPath.endsWith("/")) {
            formattedPath += "/";
        }

        registry.addResourceHandler("/apk/**")
                .addResourceLocations("file:" + formattedPath);
    }
}
