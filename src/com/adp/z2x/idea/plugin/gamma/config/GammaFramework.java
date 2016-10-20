package com.adp.z2x.idea.plugin.gamma.config;

import com.adp.z2x.idea.plugin.gamma.icons.Icons;
import com.intellij.framework.FrameworkTypeEx;
import com.intellij.framework.addSupport.*;
import com.intellij.icons.AllIcons;
import com.intellij.ide.util.frameworkSupport.FrameworkSupportModel;
import com.intellij.openapi.module.*;
import com.intellij.openapi.roots.*;
import org.jetbrains.annotations.*;

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
                return GammaFramework.this;
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
            public boolean isEnabledForModuleType(@NotNull ModuleType moduleType) {
                return moduleType instanceof JavaModuleType;
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
        return Icons.GAMMA;
    }
}