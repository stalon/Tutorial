package com.adp.z2x.idea.plugin.gamma.utils;

import com.intellij.openapi.util.text.StringUtil;

import java.io.File;
import java.util.Properties;

/**
 * Created by stephane on 18/10/2016.
 */
public class GammaUtils {

    @Nullable
    public static String GammaVersion(String gammaHome) {
        return getGammaVersion(new File(mavenHome));
    }

    @Nullable
    public static String getGammaVersion(@Nullable File gammaHome) {
        if(gammaHome == null) return null;
        String[] libs = new File(gammaHome, "lib").list();

        if (libs != null) {
            for (String lib : libs) {
                if (lib.startsWith("maven-core-") && lib.endsWith(".jar")) {
                    String version = lib.substring("maven-core-".length(), lib.length() - ".jar".length());
                    if (StringUtil.contains(version, ".x")) {
                        Properties props = JarUtil.loadProperties(new File(gammaHome, "lib/" + lib),
                                "META-INF/maven/org.apache.maven/maven-core/pom.properties");
                        return props != null ? props.getProperty("version") : null;
                    }
                    else {
                        return version;
                    }
                }
                if (lib.startsWith("maven-") && lib.endsWith("-uber.jar")) {
                    return lib.substring("maven-".length(), lib.length() - "-uber.jar".length());
                }
            }
        }
        return null;
    }
}
