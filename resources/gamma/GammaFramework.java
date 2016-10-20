package com.adp.z2x.idea.plugin.gamma;

import com.intellij.framework.FrameworkTypeEx;
import com.intellij.framework.addSupport.FrameworkSupportInModuleConfigurable;
import com.intellij.framework.addSupport.FrameworkSupportInModuleProvider;
import com.intellij.icons.AllIcons;
import com.intellij.ide.util.frameworkSupport.FrameworkSupportModel;
import com.intellij.openapi.module.JavaModuleType;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.roots.ModifiableModelsProvider;
import com.intellij.openapi.roots.ModifiableRootModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author Anna Bulenkova
 */
public class GammaFramework extends FrameworkTypeEx {
    public static final String FRAMEWORK_ID = "Gamma";

    protected GammaFramework() {
        super(FRAMEWORK_ID);
    }

    @NotNull
    @Override
    public FrameworkSupportInModuleProvider createProvider() {
        return new FrameworkSupportInModuleProvider() {
            @NotNull
            @Override
            public FrameworkTypeEx getFrameworkType() {
                return com.adp.z2x.idea.plugin.gamma.config.GammaFramework.this;
            }

            @NotNull
            @Override
            public FrameworkSupportInModuleConfigurable createConfigurable(@NotNull FrameworkSupportModel model) {
                return new FrameworkSupportInModuleConfigurable() {
                    @Nullable
                    @Override
                    public JComponent createComponent() {
                        return new JCheckBox("Extra Option");
                    }

                    @Override
                    public void addSupport(@NotNull Module module,
                                           @NotNull ModifiableRootModel model,
                                           @NotNull ModifiableModelsProvider provider) {
                        //do what you want here: setup a library, generate a specific file, etc
                    }
                };
            }

            @Override
            public boolean isEnabledForModuleType(@NotNull ModuleType type) {
                return moduleType instanceof JavaModuleType;;
            }
        };
    }

    @NotNull
    @Override
    public String getPresentableName() {
        return "Gamma Application";
    }

    @NotNull
    @Override
    public Icon getIcon() {
        return AllIcons.Providers.Bea;
    }
}