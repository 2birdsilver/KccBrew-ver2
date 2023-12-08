package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `libs` extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final CglibLibraryAccessors laccForCglibLibraryAccessors = new CglibLibraryAccessors(owner);
    private final ComLibraryAccessors laccForComLibraryAccessors = new ComLibraryAccessors(owner);
    private final CommonsLibraryAccessors laccForCommonsLibraryAccessors = new CommonsLibraryAccessors(owner);
    private final JavaxLibraryAccessors laccForJavaxLibraryAccessors = new JavaxLibraryAccessors(owner);
    private final JunitLibraryAccessors laccForJunitLibraryAccessors = new JunitLibraryAccessors(owner);
    private final Log4jLibraryAccessors laccForLog4jLibraryAccessors = new Log4jLibraryAccessors(owner);
    private final OrgLibraryAccessors laccForOrgLibraryAccessors = new OrgLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Returns the group of libraries at cglib
     */
    public CglibLibraryAccessors getCglib() {
        return laccForCglibLibraryAccessors;
    }

    /**
     * Returns the group of libraries at com
     */
    public ComLibraryAccessors getCom() {
        return laccForComLibraryAccessors;
    }

    /**
     * Returns the group of libraries at commons
     */
    public CommonsLibraryAccessors getCommons() {
        return laccForCommonsLibraryAccessors;
    }

    /**
     * Returns the group of libraries at javax
     */
    public JavaxLibraryAccessors getJavax() {
        return laccForJavaxLibraryAccessors;
    }

    /**
     * Returns the group of libraries at junit
     */
    public JunitLibraryAccessors getJunit() {
        return laccForJunitLibraryAccessors;
    }

    /**
     * Returns the group of libraries at log4j
     */
    public Log4jLibraryAccessors getLog4j() {
        return laccForLog4jLibraryAccessors;
    }

    /**
     * Returns the group of libraries at org
     */
    public OrgLibraryAccessors getOrg() {
        return laccForOrgLibraryAccessors;
    }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class CglibLibraryAccessors extends SubDependencyFactory {

        public CglibLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for cglib (cglib:cglib)
         * with versionRef 'cglib.cglib'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCglib() {
                return create("cglib.cglib");
        }

    }

    public static class ComLibraryAccessors extends SubDependencyFactory {
        private final ComAmazonawsLibraryAccessors laccForComAmazonawsLibraryAccessors = new ComAmazonawsLibraryAccessors(owner);
        private final ComFasterxmlLibraryAccessors laccForComFasterxmlLibraryAccessors = new ComFasterxmlLibraryAccessors(owner);
        private final ComGoogleLibraryAccessors laccForComGoogleLibraryAccessors = new ComGoogleLibraryAccessors(owner);
        private final ComGooglecodeLibraryAccessors laccForComGooglecodeLibraryAccessors = new ComGooglecodeLibraryAccessors(owner);
        private final ComOracleLibraryAccessors laccForComOracleLibraryAccessors = new ComOracleLibraryAccessors(owner);

        public ComLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.amazonaws
         */
        public ComAmazonawsLibraryAccessors getAmazonaws() {
            return laccForComAmazonawsLibraryAccessors;
        }

        /**
         * Returns the group of libraries at com.fasterxml
         */
        public ComFasterxmlLibraryAccessors getFasterxml() {
            return laccForComFasterxmlLibraryAccessors;
        }

        /**
         * Returns the group of libraries at com.google
         */
        public ComGoogleLibraryAccessors getGoogle() {
            return laccForComGoogleLibraryAccessors;
        }

        /**
         * Returns the group of libraries at com.googlecode
         */
        public ComGooglecodeLibraryAccessors getGooglecode() {
            return laccForComGooglecodeLibraryAccessors;
        }

        /**
         * Returns the group of libraries at com.oracle
         */
        public ComOracleLibraryAccessors getOracle() {
            return laccForComOracleLibraryAccessors;
        }

    }

    public static class ComAmazonawsLibraryAccessors extends SubDependencyFactory {
        private final ComAmazonawsAwsLibraryAccessors laccForComAmazonawsAwsLibraryAccessors = new ComAmazonawsAwsLibraryAccessors(owner);

        public ComAmazonawsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.amazonaws.aws
         */
        public ComAmazonawsAwsLibraryAccessors getAws() {
            return laccForComAmazonawsAwsLibraryAccessors;
        }

    }

    public static class ComAmazonawsAwsLibraryAccessors extends SubDependencyFactory {
        private final ComAmazonawsAwsJavaLibraryAccessors laccForComAmazonawsAwsJavaLibraryAccessors = new ComAmazonawsAwsJavaLibraryAccessors(owner);

        public ComAmazonawsAwsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.amazonaws.aws.java
         */
        public ComAmazonawsAwsJavaLibraryAccessors getJava() {
            return laccForComAmazonawsAwsJavaLibraryAccessors;
        }

    }

    public static class ComAmazonawsAwsJavaLibraryAccessors extends SubDependencyFactory {

        public ComAmazonawsAwsJavaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for sdk (com.amazonaws:aws-java-sdk)
         * with versionRef 'com.amazonaws.aws.java.sdk'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSdk() {
                return create("com.amazonaws.aws.java.sdk");
        }

    }

    public static class ComFasterxmlLibraryAccessors extends SubDependencyFactory {
        private final ComFasterxmlJacksonLibraryAccessors laccForComFasterxmlJacksonLibraryAccessors = new ComFasterxmlJacksonLibraryAccessors(owner);

        public ComFasterxmlLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.fasterxml.jackson
         */
        public ComFasterxmlJacksonLibraryAccessors getJackson() {
            return laccForComFasterxmlJacksonLibraryAccessors;
        }

    }

    public static class ComFasterxmlJacksonLibraryAccessors extends SubDependencyFactory {
        private final ComFasterxmlJacksonCoreLibraryAccessors laccForComFasterxmlJacksonCoreLibraryAccessors = new ComFasterxmlJacksonCoreLibraryAccessors(owner);

        public ComFasterxmlJacksonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.fasterxml.jackson.core
         */
        public ComFasterxmlJacksonCoreLibraryAccessors getCore() {
            return laccForComFasterxmlJacksonCoreLibraryAccessors;
        }

    }

    public static class ComFasterxmlJacksonCoreLibraryAccessors extends SubDependencyFactory {
        private final ComFasterxmlJacksonCoreJacksonLibraryAccessors laccForComFasterxmlJacksonCoreJacksonLibraryAccessors = new ComFasterxmlJacksonCoreJacksonLibraryAccessors(owner);

        public ComFasterxmlJacksonCoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.fasterxml.jackson.core.jackson
         */
        public ComFasterxmlJacksonCoreJacksonLibraryAccessors getJackson() {
            return laccForComFasterxmlJacksonCoreJacksonLibraryAccessors;
        }

    }

    public static class ComFasterxmlJacksonCoreJacksonLibraryAccessors extends SubDependencyFactory {

        public ComFasterxmlJacksonCoreJacksonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for databind (com.fasterxml.jackson.core:jackson-databind)
         * with versionRef 'com.fasterxml.jackson.core.jackson.databind'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getDatabind() {
                return create("com.fasterxml.jackson.core.jackson.databind");
        }

    }

    public static class ComGoogleLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleCodeLibraryAccessors$1 laccForComGoogleCodeLibraryAccessors$1 = new ComGoogleCodeLibraryAccessors$1(owner);
        private final ComGoogleGuavaLibraryAccessors laccForComGoogleGuavaLibraryAccessors = new ComGoogleGuavaLibraryAccessors(owner);

        public ComGoogleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.google.code
         */
        public ComGoogleCodeLibraryAccessors$1 getCode() {
            return laccForComGoogleCodeLibraryAccessors$1;
        }

        /**
         * Returns the group of libraries at com.google.guava
         */
        public ComGoogleGuavaLibraryAccessors getGuava() {
            return laccForComGoogleGuavaLibraryAccessors;
        }

    }

    public static class ComGoogleCodeLibraryAccessors$1 extends SubDependencyFactory {
        private final ComGoogleCodeGsonLibraryAccessors laccForComGoogleCodeGsonLibraryAccessors = new ComGoogleCodeGsonLibraryAccessors(owner);

        public ComGoogleCodeLibraryAccessors$1(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.google.code.gson
         */
        public ComGoogleCodeGsonLibraryAccessors getGson() {
            return laccForComGoogleCodeGsonLibraryAccessors;
        }

    }

    public static class ComGoogleCodeGsonLibraryAccessors extends SubDependencyFactory {

        public ComGoogleCodeGsonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for gson (com.google.code.gson:gson)
         * with versionRef 'com.google.code.gson.gson'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getGson() {
                return create("com.google.code.gson.gson");
        }

    }

    public static class ComGoogleGuavaLibraryAccessors extends SubDependencyFactory {

        public ComGoogleGuavaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for guava (com.google.guava:guava)
         * with versionRef 'com.google.guava.guava'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getGuava() {
                return create("com.google.guava.guava");
        }

    }

    public static class ComGooglecodeLibraryAccessors extends SubDependencyFactory {
        private final ComGooglecodeJsonLibraryAccessors laccForComGooglecodeJsonLibraryAccessors = new ComGooglecodeJsonLibraryAccessors(owner);

        public ComGooglecodeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.googlecode.json
         */
        public ComGooglecodeJsonLibraryAccessors getJson() {
            return laccForComGooglecodeJsonLibraryAccessors;
        }

    }

    public static class ComGooglecodeJsonLibraryAccessors extends SubDependencyFactory {
        private final ComGooglecodeJsonSimpleLibraryAccessors laccForComGooglecodeJsonSimpleLibraryAccessors = new ComGooglecodeJsonSimpleLibraryAccessors(owner);

        public ComGooglecodeJsonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.googlecode.json.simple
         */
        public ComGooglecodeJsonSimpleLibraryAccessors getSimple() {
            return laccForComGooglecodeJsonSimpleLibraryAccessors;
        }

    }

    public static class ComGooglecodeJsonSimpleLibraryAccessors extends SubDependencyFactory {
        private final ComGooglecodeJsonSimpleJsonLibraryAccessors laccForComGooglecodeJsonSimpleJsonLibraryAccessors = new ComGooglecodeJsonSimpleJsonLibraryAccessors(owner);

        public ComGooglecodeJsonSimpleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.googlecode.json.simple.json
         */
        public ComGooglecodeJsonSimpleJsonLibraryAccessors getJson() {
            return laccForComGooglecodeJsonSimpleJsonLibraryAccessors;
        }

    }

    public static class ComGooglecodeJsonSimpleJsonLibraryAccessors extends SubDependencyFactory {

        public ComGooglecodeJsonSimpleJsonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for simple (com.googlecode.json-simple:json-simple)
         * with versionRef 'com.googlecode.json.simple.json.simple'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSimple() {
                return create("com.googlecode.json.simple.json.simple");
        }

    }

    public static class ComOracleLibraryAccessors extends SubDependencyFactory {
        private final ComOracleDatabaseLibraryAccessors laccForComOracleDatabaseLibraryAccessors = new ComOracleDatabaseLibraryAccessors(owner);

        public ComOracleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.oracle.database
         */
        public ComOracleDatabaseLibraryAccessors getDatabase() {
            return laccForComOracleDatabaseLibraryAccessors;
        }

    }

    public static class ComOracleDatabaseLibraryAccessors extends SubDependencyFactory {
        private final ComOracleDatabaseJdbcLibraryAccessors laccForComOracleDatabaseJdbcLibraryAccessors = new ComOracleDatabaseJdbcLibraryAccessors(owner);

        public ComOracleDatabaseLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.oracle.database.jdbc
         */
        public ComOracleDatabaseJdbcLibraryAccessors getJdbc() {
            return laccForComOracleDatabaseJdbcLibraryAccessors;
        }

    }

    public static class ComOracleDatabaseJdbcLibraryAccessors extends SubDependencyFactory {

        public ComOracleDatabaseJdbcLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ojdbc8 (com.oracle.database.jdbc:ojdbc8)
         * with versionRef 'com.oracle.database.jdbc.ojdbc8'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getOjdbc8() {
                return create("com.oracle.database.jdbc.ojdbc8");
        }

    }

    public static class CommonsLibraryAccessors extends SubDependencyFactory {
        private final CommonsFileuploadLibraryAccessors laccForCommonsFileuploadLibraryAccessors = new CommonsFileuploadLibraryAccessors(owner);
        private final CommonsIoLibraryAccessors laccForCommonsIoLibraryAccessors = new CommonsIoLibraryAccessors(owner);

        public CommonsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at commons.fileupload
         */
        public CommonsFileuploadLibraryAccessors getFileupload() {
            return laccForCommonsFileuploadLibraryAccessors;
        }

        /**
         * Returns the group of libraries at commons.io
         */
        public CommonsIoLibraryAccessors getIo() {
            return laccForCommonsIoLibraryAccessors;
        }

    }

    public static class CommonsFileuploadLibraryAccessors extends SubDependencyFactory {
        private final CommonsFileuploadCommonsLibraryAccessors laccForCommonsFileuploadCommonsLibraryAccessors = new CommonsFileuploadCommonsLibraryAccessors(owner);

        public CommonsFileuploadLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at commons.fileupload.commons
         */
        public CommonsFileuploadCommonsLibraryAccessors getCommons() {
            return laccForCommonsFileuploadCommonsLibraryAccessors;
        }

    }

    public static class CommonsFileuploadCommonsLibraryAccessors extends SubDependencyFactory {

        public CommonsFileuploadCommonsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for fileupload (commons-fileupload:commons-fileupload)
         * with versionRef 'commons.fileupload.commons.fileupload'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getFileupload() {
                return create("commons.fileupload.commons.fileupload");
        }

    }

    public static class CommonsIoLibraryAccessors extends SubDependencyFactory {
        private final CommonsIoCommonsLibraryAccessors laccForCommonsIoCommonsLibraryAccessors = new CommonsIoCommonsLibraryAccessors(owner);

        public CommonsIoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at commons.io.commons
         */
        public CommonsIoCommonsLibraryAccessors getCommons() {
            return laccForCommonsIoCommonsLibraryAccessors;
        }

    }

    public static class CommonsIoCommonsLibraryAccessors extends SubDependencyFactory {

        public CommonsIoCommonsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for io (commons-io:commons-io)
         * with versionRef 'commons.io.commons.io'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getIo() {
                return create("commons.io.commons.io");
        }

    }

    public static class JavaxLibraryAccessors extends SubDependencyFactory {
        private final JavaxInjectLibraryAccessors laccForJavaxInjectLibraryAccessors = new JavaxInjectLibraryAccessors(owner);
        private final JavaxServletLibraryAccessors laccForJavaxServletLibraryAccessors = new JavaxServletLibraryAccessors(owner);
        private final JavaxValidationLibraryAccessors laccForJavaxValidationLibraryAccessors = new JavaxValidationLibraryAccessors(owner);
        private final JavaxWebsocketLibraryAccessors laccForJavaxWebsocketLibraryAccessors = new JavaxWebsocketLibraryAccessors(owner);

        public JavaxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at javax.inject
         */
        public JavaxInjectLibraryAccessors getInject() {
            return laccForJavaxInjectLibraryAccessors;
        }

        /**
         * Returns the group of libraries at javax.servlet
         */
        public JavaxServletLibraryAccessors getServlet() {
            return laccForJavaxServletLibraryAccessors;
        }

        /**
         * Returns the group of libraries at javax.validation
         */
        public JavaxValidationLibraryAccessors getValidation() {
            return laccForJavaxValidationLibraryAccessors;
        }

        /**
         * Returns the group of libraries at javax.websocket
         */
        public JavaxWebsocketLibraryAccessors getWebsocket() {
            return laccForJavaxWebsocketLibraryAccessors;
        }

    }

    public static class JavaxInjectLibraryAccessors extends SubDependencyFactory {
        private final JavaxInjectJavaxLibraryAccessors laccForJavaxInjectJavaxLibraryAccessors = new JavaxInjectJavaxLibraryAccessors(owner);

        public JavaxInjectLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at javax.inject.javax
         */
        public JavaxInjectJavaxLibraryAccessors getJavax() {
            return laccForJavaxInjectJavaxLibraryAccessors;
        }

    }

    public static class JavaxInjectJavaxLibraryAccessors extends SubDependencyFactory {

        public JavaxInjectJavaxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for inject (javax.inject:javax.inject)
         * with versionRef 'javax.inject.javax.inject'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getInject() {
                return create("javax.inject.javax.inject");
        }

    }

    public static class JavaxServletLibraryAccessors extends SubDependencyFactory {
        private final JavaxServletJavaxLibraryAccessors laccForJavaxServletJavaxLibraryAccessors = new JavaxServletJavaxLibraryAccessors(owner);
        private final JavaxServletJspLibraryAccessors laccForJavaxServletJspLibraryAccessors = new JavaxServletJspLibraryAccessors(owner);

        public JavaxServletLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for jstl (javax.servlet:jstl)
         * with versionRef 'javax.servlet.jstl'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJstl() {
                return create("javax.servlet.jstl");
        }

        /**
         * Returns the group of libraries at javax.servlet.javax
         */
        public JavaxServletJavaxLibraryAccessors getJavax() {
            return laccForJavaxServletJavaxLibraryAccessors;
        }

        /**
         * Returns the group of libraries at javax.servlet.jsp
         */
        public JavaxServletJspLibraryAccessors getJsp() {
            return laccForJavaxServletJspLibraryAccessors;
        }

    }

    public static class JavaxServletJavaxLibraryAccessors extends SubDependencyFactory {
        private final JavaxServletJavaxServletLibraryAccessors laccForJavaxServletJavaxServletLibraryAccessors = new JavaxServletJavaxServletLibraryAccessors(owner);

        public JavaxServletJavaxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at javax.servlet.javax.servlet
         */
        public JavaxServletJavaxServletLibraryAccessors getServlet() {
            return laccForJavaxServletJavaxServletLibraryAccessors;
        }

    }

    public static class JavaxServletJavaxServletLibraryAccessors extends SubDependencyFactory {

        public JavaxServletJavaxServletLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for api (javax.servlet:javax.servlet-api)
         * with versionRef 'javax.servlet.javax.servlet.api'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getApi() {
                return create("javax.servlet.javax.servlet.api");
        }

    }

    public static class JavaxServletJspLibraryAccessors extends SubDependencyFactory {
        private final JavaxServletJspJspLibraryAccessors laccForJavaxServletJspJspLibraryAccessors = new JavaxServletJspJspLibraryAccessors(owner);

        public JavaxServletJspLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at javax.servlet.jsp.jsp
         */
        public JavaxServletJspJspLibraryAccessors getJsp() {
            return laccForJavaxServletJspJspLibraryAccessors;
        }

    }

    public static class JavaxServletJspJspLibraryAccessors extends SubDependencyFactory {

        public JavaxServletJspJspLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for api (javax.servlet.jsp:jsp-api)
         * with versionRef 'javax.servlet.jsp.jsp.api'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getApi() {
                return create("javax.servlet.jsp.jsp.api");
        }

    }

    public static class JavaxValidationLibraryAccessors extends SubDependencyFactory {
        private final JavaxValidationValidationLibraryAccessors laccForJavaxValidationValidationLibraryAccessors = new JavaxValidationValidationLibraryAccessors(owner);

        public JavaxValidationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at javax.validation.validation
         */
        public JavaxValidationValidationLibraryAccessors getValidation() {
            return laccForJavaxValidationValidationLibraryAccessors;
        }

    }

    public static class JavaxValidationValidationLibraryAccessors extends SubDependencyFactory {

        public JavaxValidationValidationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for api (javax.validation:validation-api)
         * with versionRef 'javax.validation.validation.api'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getApi() {
                return create("javax.validation.validation.api");
        }

    }

    public static class JavaxWebsocketLibraryAccessors extends SubDependencyFactory {
        private final JavaxWebsocketJavaxLibraryAccessors laccForJavaxWebsocketJavaxLibraryAccessors = new JavaxWebsocketJavaxLibraryAccessors(owner);

        public JavaxWebsocketLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at javax.websocket.javax
         */
        public JavaxWebsocketJavaxLibraryAccessors getJavax() {
            return laccForJavaxWebsocketJavaxLibraryAccessors;
        }

    }

    public static class JavaxWebsocketJavaxLibraryAccessors extends SubDependencyFactory {
        private final JavaxWebsocketJavaxWebsocketLibraryAccessors laccForJavaxWebsocketJavaxWebsocketLibraryAccessors = new JavaxWebsocketJavaxWebsocketLibraryAccessors(owner);

        public JavaxWebsocketJavaxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at javax.websocket.javax.websocket
         */
        public JavaxWebsocketJavaxWebsocketLibraryAccessors getWebsocket() {
            return laccForJavaxWebsocketJavaxWebsocketLibraryAccessors;
        }

    }

    public static class JavaxWebsocketJavaxWebsocketLibraryAccessors extends SubDependencyFactory {

        public JavaxWebsocketJavaxWebsocketLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for api (javax.websocket:javax.websocket-api)
         * with versionRef 'javax.websocket.javax.websocket.api'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getApi() {
                return create("javax.websocket.javax.websocket.api");
        }

    }

    public static class JunitLibraryAccessors extends SubDependencyFactory {

        public JunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for junit (junit:junit)
         * with versionRef 'junit.junit'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJunit() {
                return create("junit.junit");
        }

    }

    public static class Log4jLibraryAccessors extends SubDependencyFactory {

        public Log4jLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for log4j (log4j:log4j)
         * with versionRef 'log4j.log4j'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getLog4j() {
                return create("log4j.log4j");
        }

    }

    public static class OrgLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheLibraryAccessors laccForOrgApacheLibraryAccessors = new OrgApacheLibraryAccessors(owner);
        private final OrgAspectjLibraryAccessors laccForOrgAspectjLibraryAccessors = new OrgAspectjLibraryAccessors(owner);
        private final OrgBgeeLibraryAccessors laccForOrgBgeeLibraryAccessors = new OrgBgeeLibraryAccessors(owner);
        private final OrgHibernateLibraryAccessors laccForOrgHibernateLibraryAccessors = new OrgHibernateLibraryAccessors(owner);
        private final OrgJasyptLibraryAccessors laccForOrgJasyptLibraryAccessors = new OrgJasyptLibraryAccessors(owner);
        private final OrgMybatisLibraryAccessors laccForOrgMybatisLibraryAccessors = new OrgMybatisLibraryAccessors(owner);
        private final OrgProjectlombokLibraryAccessors laccForOrgProjectlombokLibraryAccessors = new OrgProjectlombokLibraryAccessors(owner);
        private final OrgSlf4jLibraryAccessors laccForOrgSlf4jLibraryAccessors = new OrgSlf4jLibraryAccessors(owner);
        private final OrgSpringframeworkLibraryAccessors laccForOrgSpringframeworkLibraryAccessors = new OrgSpringframeworkLibraryAccessors(owner);

        public OrgLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.apache
         */
        public OrgApacheLibraryAccessors getApache() {
            return laccForOrgApacheLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.aspectj
         */
        public OrgAspectjLibraryAccessors getAspectj() {
            return laccForOrgAspectjLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.bgee
         */
        public OrgBgeeLibraryAccessors getBgee() {
            return laccForOrgBgeeLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.hibernate
         */
        public OrgHibernateLibraryAccessors getHibernate() {
            return laccForOrgHibernateLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.jasypt
         */
        public OrgJasyptLibraryAccessors getJasypt() {
            return laccForOrgJasyptLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.mybatis
         */
        public OrgMybatisLibraryAccessors getMybatis() {
            return laccForOrgMybatisLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.projectlombok
         */
        public OrgProjectlombokLibraryAccessors getProjectlombok() {
            return laccForOrgProjectlombokLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.slf4j
         */
        public OrgSlf4jLibraryAccessors getSlf4j() {
            return laccForOrgSlf4jLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.springframework
         */
        public OrgSpringframeworkLibraryAccessors getSpringframework() {
            return laccForOrgSpringframeworkLibraryAccessors;
        }

    }

    public static class OrgApacheLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheCommonsLibraryAccessors laccForOrgApacheCommonsLibraryAccessors = new OrgApacheCommonsLibraryAccessors(owner);
        private final OrgApachePoiLibraryAccessors laccForOrgApachePoiLibraryAccessors = new OrgApachePoiLibraryAccessors(owner);
        private final OrgApacheTilesLibraryAccessors laccForOrgApacheTilesLibraryAccessors = new OrgApacheTilesLibraryAccessors(owner);

        public OrgApacheLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.apache.commons
         */
        public OrgApacheCommonsLibraryAccessors getCommons() {
            return laccForOrgApacheCommonsLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.apache.poi
         */
        public OrgApachePoiLibraryAccessors getPoi() {
            return laccForOrgApachePoiLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.apache.tiles
         */
        public OrgApacheTilesLibraryAccessors getTiles() {
            return laccForOrgApacheTilesLibraryAccessors;
        }

    }

    public static class OrgApacheCommonsLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheCommonsCommonsLibraryAccessors laccForOrgApacheCommonsCommonsLibraryAccessors = new OrgApacheCommonsCommonsLibraryAccessors(owner);

        public OrgApacheCommonsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.apache.commons.commons
         */
        public OrgApacheCommonsCommonsLibraryAccessors getCommons() {
            return laccForOrgApacheCommonsCommonsLibraryAccessors;
        }

    }

    public static class OrgApacheCommonsCommonsLibraryAccessors extends SubDependencyFactory {

        public OrgApacheCommonsCommonsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for dbcp2 (org.apache.commons:commons-dbcp2)
         * with versionRef 'org.apache.commons.commons.dbcp2'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getDbcp2() {
                return create("org.apache.commons.commons.dbcp2");
        }

            /**
             * Creates a dependency provider for email (org.apache.commons:commons-email)
         * with versionRef 'org.apache.commons.commons.email'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getEmail() {
                return create("org.apache.commons.commons.email");
        }

    }

    public static class OrgApachePoiLibraryAccessors extends SubDependencyFactory {
        private final OrgApachePoiPoiLibraryAccessors laccForOrgApachePoiPoiLibraryAccessors = new OrgApachePoiPoiLibraryAccessors(owner);

        public OrgApachePoiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.apache.poi.poi
         */
        public OrgApachePoiPoiLibraryAccessors getPoi() {
            return laccForOrgApachePoiPoiLibraryAccessors;
        }

    }

    public static class OrgApachePoiPoiLibraryAccessors extends SubDependencyFactory {

        public OrgApachePoiPoiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ooxml (org.apache.poi:poi-ooxml)
         * with versionRef 'org.apache.poi.poi.ooxml'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getOoxml() {
                return create("org.apache.poi.poi.ooxml");
        }

    }

    public static class OrgApacheTilesLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheTilesTilesLibraryAccessors laccForOrgApacheTilesTilesLibraryAccessors = new OrgApacheTilesTilesLibraryAccessors(owner);

        public OrgApacheTilesLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.apache.tiles.tiles
         */
        public OrgApacheTilesTilesLibraryAccessors getTiles() {
            return laccForOrgApacheTilesTilesLibraryAccessors;
        }

    }

    public static class OrgApacheTilesTilesLibraryAccessors extends SubDependencyFactory {

        public OrgApacheTilesTilesLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for extras (org.apache.tiles:tiles-extras)
         * with versionRef 'org.apache.tiles.tiles.extras'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getExtras() {
                return create("org.apache.tiles.tiles.extras");
        }

            /**
             * Creates a dependency provider for jsp (org.apache.tiles:tiles-jsp)
         * with versionRef 'org.apache.tiles.tiles.jsp'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJsp() {
                return create("org.apache.tiles.tiles.jsp");
        }

            /**
             * Creates a dependency provider for servlet (org.apache.tiles:tiles-servlet)
         * with versionRef 'org.apache.tiles.tiles.servlet'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getServlet() {
                return create("org.apache.tiles.tiles.servlet");
        }

    }

    public static class OrgAspectjLibraryAccessors extends SubDependencyFactory {

        public OrgAspectjLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for aspectjrt (org.aspectj:aspectjrt)
         * with versionRef 'org.aspectj.aspectjrt'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAspectjrt() {
                return create("org.aspectj.aspectjrt");
        }

    }

    public static class OrgBgeeLibraryAccessors extends SubDependencyFactory {
        private final OrgBgeeLog4jdbcLibraryAccessors laccForOrgBgeeLog4jdbcLibraryAccessors = new OrgBgeeLog4jdbcLibraryAccessors(owner);

        public OrgBgeeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.bgee.log4jdbc
         */
        public OrgBgeeLog4jdbcLibraryAccessors getLog4jdbc() {
            return laccForOrgBgeeLog4jdbcLibraryAccessors;
        }

    }

    public static class OrgBgeeLog4jdbcLibraryAccessors extends SubDependencyFactory {
        private final OrgBgeeLog4jdbcLog4j2LibraryAccessors laccForOrgBgeeLog4jdbcLog4j2LibraryAccessors = new OrgBgeeLog4jdbcLog4j2LibraryAccessors(owner);

        public OrgBgeeLog4jdbcLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.bgee.log4jdbc.log4j2
         */
        public OrgBgeeLog4jdbcLog4j2LibraryAccessors getLog4j2() {
            return laccForOrgBgeeLog4jdbcLog4j2LibraryAccessors;
        }

    }

    public static class OrgBgeeLog4jdbcLog4j2LibraryAccessors extends SubDependencyFactory {
        private final OrgBgeeLog4jdbcLog4j2Log4jdbcLibraryAccessors laccForOrgBgeeLog4jdbcLog4j2Log4jdbcLibraryAccessors = new OrgBgeeLog4jdbcLog4j2Log4jdbcLibraryAccessors(owner);

        public OrgBgeeLog4jdbcLog4j2LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.bgee.log4jdbc.log4j2.log4jdbc
         */
        public OrgBgeeLog4jdbcLog4j2Log4jdbcLibraryAccessors getLog4jdbc() {
            return laccForOrgBgeeLog4jdbcLog4j2Log4jdbcLibraryAccessors;
        }

    }

    public static class OrgBgeeLog4jdbcLog4j2Log4jdbcLibraryAccessors extends SubDependencyFactory {
        private final OrgBgeeLog4jdbcLog4j2Log4jdbcLog4j2LibraryAccessors laccForOrgBgeeLog4jdbcLog4j2Log4jdbcLog4j2LibraryAccessors = new OrgBgeeLog4jdbcLog4j2Log4jdbcLog4j2LibraryAccessors(owner);

        public OrgBgeeLog4jdbcLog4j2Log4jdbcLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.bgee.log4jdbc.log4j2.log4jdbc.log4j2
         */
        public OrgBgeeLog4jdbcLog4j2Log4jdbcLog4j2LibraryAccessors getLog4j2() {
            return laccForOrgBgeeLog4jdbcLog4j2Log4jdbcLog4j2LibraryAccessors;
        }

    }

    public static class OrgBgeeLog4jdbcLog4j2Log4jdbcLog4j2LibraryAccessors extends SubDependencyFactory {

        public OrgBgeeLog4jdbcLog4j2Log4jdbcLog4j2LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for jdbc4 (org.bgee.log4jdbc-log4j2:log4jdbc-log4j2-jdbc4)
         * with versionRef 'org.bgee.log4jdbc.log4j2.log4jdbc.log4j2.jdbc4'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJdbc4() {
                return create("org.bgee.log4jdbc.log4j2.log4jdbc.log4j2.jdbc4");
        }

    }

    public static class OrgHibernateLibraryAccessors extends SubDependencyFactory {
        private final OrgHibernateValidatorLibraryAccessors laccForOrgHibernateValidatorLibraryAccessors = new OrgHibernateValidatorLibraryAccessors(owner);

        public OrgHibernateLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.hibernate.validator
         */
        public OrgHibernateValidatorLibraryAccessors getValidator() {
            return laccForOrgHibernateValidatorLibraryAccessors;
        }

    }

    public static class OrgHibernateValidatorLibraryAccessors extends SubDependencyFactory {
        private final OrgHibernateValidatorHibernateLibraryAccessors laccForOrgHibernateValidatorHibernateLibraryAccessors = new OrgHibernateValidatorHibernateLibraryAccessors(owner);

        public OrgHibernateValidatorLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.hibernate.validator.hibernate
         */
        public OrgHibernateValidatorHibernateLibraryAccessors getHibernate() {
            return laccForOrgHibernateValidatorHibernateLibraryAccessors;
        }

    }

    public static class OrgHibernateValidatorHibernateLibraryAccessors extends SubDependencyFactory {

        public OrgHibernateValidatorHibernateLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for validator (org.hibernate.validator:hibernate-validator)
         * with versionRef 'org.hibernate.validator.hibernate.validator'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getValidator() {
                return create("org.hibernate.validator.hibernate.validator");
        }

    }

    public static class OrgJasyptLibraryAccessors extends SubDependencyFactory {
        private final OrgJasyptJasyptLibraryAccessors laccForOrgJasyptJasyptLibraryAccessors = new OrgJasyptJasyptLibraryAccessors(owner);

        public OrgJasyptLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.jasypt.jasypt
         */
        public OrgJasyptJasyptLibraryAccessors getJasypt() {
            return laccForOrgJasyptJasyptLibraryAccessors;
        }

    }

    public static class OrgJasyptJasyptLibraryAccessors extends SubDependencyFactory {

        public OrgJasyptJasyptLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for spring3 (org.jasypt:jasypt-spring3)
         * with versionRef 'org.jasypt.jasypt.spring3'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSpring3() {
                return create("org.jasypt.jasypt.spring3");
        }

    }

    public static class OrgMybatisLibraryAccessors extends SubDependencyFactory {
        private final OrgMybatisMybatisLibraryAccessors laccForOrgMybatisMybatisLibraryAccessors = new OrgMybatisMybatisLibraryAccessors(owner);

        public OrgMybatisLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.mybatis.mybatis
         */
        public OrgMybatisMybatisLibraryAccessors getMybatis() {
            return laccForOrgMybatisMybatisLibraryAccessors;
        }

    }

    public static class OrgMybatisMybatisLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public OrgMybatisMybatisLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for mybatis (org.mybatis:mybatis)
         * with versionRef 'org.mybatis.mybatis'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("org.mybatis.mybatis");
        }

            /**
             * Creates a dependency provider for spring (org.mybatis:mybatis-spring)
         * with versionRef 'org.mybatis.mybatis.spring'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSpring() {
                return create("org.mybatis.mybatis.spring");
        }

    }

    public static class OrgProjectlombokLibraryAccessors extends SubDependencyFactory {

        public OrgProjectlombokLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for lombok (org.projectlombok:lombok)
         * with versionRef 'org.projectlombok.lombok'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getLombok() {
                return create("org.projectlombok.lombok");
        }

    }

    public static class OrgSlf4jLibraryAccessors extends SubDependencyFactory {
        private final OrgSlf4jJclLibraryAccessors laccForOrgSlf4jJclLibraryAccessors = new OrgSlf4jJclLibraryAccessors(owner);
        private final OrgSlf4jSlf4jLibraryAccessors laccForOrgSlf4jSlf4jLibraryAccessors = new OrgSlf4jSlf4jLibraryAccessors(owner);

        public OrgSlf4jLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.slf4j.jcl
         */
        public OrgSlf4jJclLibraryAccessors getJcl() {
            return laccForOrgSlf4jJclLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.slf4j.slf4j
         */
        public OrgSlf4jSlf4jLibraryAccessors getSlf4j() {
            return laccForOrgSlf4jSlf4jLibraryAccessors;
        }

    }

    public static class OrgSlf4jJclLibraryAccessors extends SubDependencyFactory {
        private final OrgSlf4jJclOverLibraryAccessors laccForOrgSlf4jJclOverLibraryAccessors = new OrgSlf4jJclOverLibraryAccessors(owner);

        public OrgSlf4jJclLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.slf4j.jcl.over
         */
        public OrgSlf4jJclOverLibraryAccessors getOver() {
            return laccForOrgSlf4jJclOverLibraryAccessors;
        }

    }

    public static class OrgSlf4jJclOverLibraryAccessors extends SubDependencyFactory {

        public OrgSlf4jJclOverLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for slf4j (org.slf4j:jcl-over-slf4j)
         * with versionRef 'org.slf4j.jcl.over.slf4j'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSlf4j() {
                return create("org.slf4j.jcl.over.slf4j");
        }

    }

    public static class OrgSlf4jSlf4jLibraryAccessors extends SubDependencyFactory {

        public OrgSlf4jSlf4jLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for api (org.slf4j:slf4j-api)
         * with versionRef 'org.slf4j.slf4j.api'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getApi() {
                return create("org.slf4j.slf4j.api");
        }

            /**
             * Creates a dependency provider for log4j12 (org.slf4j:slf4j-log4j12)
         * with versionRef 'org.slf4j.slf4j.log4j12'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getLog4j12() {
                return create("org.slf4j.slf4j.log4j12");
        }

    }

    public static class OrgSpringframeworkLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBatchLibraryAccessors laccForOrgSpringframeworkBatchLibraryAccessors = new OrgSpringframeworkBatchLibraryAccessors(owner);
        private final OrgSpringframeworkSecurityLibraryAccessors laccForOrgSpringframeworkSecurityLibraryAccessors = new OrgSpringframeworkSecurityLibraryAccessors(owner);
        private final OrgSpringframeworkSpringLibraryAccessors laccForOrgSpringframeworkSpringLibraryAccessors = new OrgSpringframeworkSpringLibraryAccessors(owner);

        public OrgSpringframeworkLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springframework.batch
         */
        public OrgSpringframeworkBatchLibraryAccessors getBatch() {
            return laccForOrgSpringframeworkBatchLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.springframework.security
         */
        public OrgSpringframeworkSecurityLibraryAccessors getSecurity() {
            return laccForOrgSpringframeworkSecurityLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.springframework.spring
         */
        public OrgSpringframeworkSpringLibraryAccessors getSpring() {
            return laccForOrgSpringframeworkSpringLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBatchLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBatchSpringLibraryAccessors laccForOrgSpringframeworkBatchSpringLibraryAccessors = new OrgSpringframeworkBatchSpringLibraryAccessors(owner);

        public OrgSpringframeworkBatchLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springframework.batch.spring
         */
        public OrgSpringframeworkBatchSpringLibraryAccessors getSpring() {
            return laccForOrgSpringframeworkBatchSpringLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBatchSpringLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBatchSpringBatchLibraryAccessors laccForOrgSpringframeworkBatchSpringBatchLibraryAccessors = new OrgSpringframeworkBatchSpringBatchLibraryAccessors(owner);

        public OrgSpringframeworkBatchSpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springframework.batch.spring.batch
         */
        public OrgSpringframeworkBatchSpringBatchLibraryAccessors getBatch() {
            return laccForOrgSpringframeworkBatchSpringBatchLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBatchSpringBatchLibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkBatchSpringBatchLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (org.springframework.batch:spring-batch-core)
         * with versionRef 'org.springframework.batch.spring.batch.core'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() {
                return create("org.springframework.batch.spring.batch.core");
        }

            /**
             * Creates a dependency provider for infrastructure (org.springframework.batch:spring-batch-infrastructure)
         * with versionRef 'org.springframework.batch.spring.batch.infrastructure'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getInfrastructure() {
                return create("org.springframework.batch.spring.batch.infrastructure");
        }

    }

    public static class OrgSpringframeworkSecurityLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkSecuritySpringLibraryAccessors laccForOrgSpringframeworkSecuritySpringLibraryAccessors = new OrgSpringframeworkSecuritySpringLibraryAccessors(owner);

        public OrgSpringframeworkSecurityLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springframework.security.spring
         */
        public OrgSpringframeworkSecuritySpringLibraryAccessors getSpring() {
            return laccForOrgSpringframeworkSecuritySpringLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkSecuritySpringLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkSecuritySpringSecurityLibraryAccessors laccForOrgSpringframeworkSecuritySpringSecurityLibraryAccessors = new OrgSpringframeworkSecuritySpringSecurityLibraryAccessors(owner);

        public OrgSpringframeworkSecuritySpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springframework.security.spring.security
         */
        public OrgSpringframeworkSecuritySpringSecurityLibraryAccessors getSecurity() {
            return laccForOrgSpringframeworkSecuritySpringSecurityLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkSecuritySpringSecurityLibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkSecuritySpringSecurityLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for config (org.springframework.security:spring-security-config)
         * with versionRef 'org.springframework.security.spring.security.config'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getConfig() {
                return create("org.springframework.security.spring.security.config");
        }

            /**
             * Creates a dependency provider for taglibs (org.springframework.security:spring-security-taglibs)
         * with versionRef 'org.springframework.security.spring.security.taglibs'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTaglibs() {
                return create("org.springframework.security.spring.security.taglibs");
        }

            /**
             * Creates a dependency provider for web (org.springframework.security:spring-security-web)
         * with versionRef 'org.springframework.security.spring.security.web'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getWeb() {
                return create("org.springframework.security.spring.security.web");
        }

    }

    public static class OrgSpringframeworkSpringLibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkSpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for context (org.springframework:spring-context)
         * with versionRef 'org.springframework.spring.context'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getContext() {
                return create("org.springframework.spring.context");
        }

            /**
             * Creates a dependency provider for jdbc (org.springframework:spring-jdbc)
         * with versionRef 'org.springframework.spring.jdbc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJdbc() {
                return create("org.springframework.spring.jdbc");
        }

            /**
             * Creates a dependency provider for webmvc (org.springframework:spring-webmvc)
         * with versionRef 'org.springframework.spring.webmvc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getWebmvc() {
                return create("org.springframework.spring.webmvc");
        }

            /**
             * Creates a dependency provider for websocket (org.springframework:spring-websocket)
         * with versionRef 'org.springframework.spring.websocket'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getWebsocket() {
                return create("org.springframework.spring.websocket");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final CglibVersionAccessors vaccForCglibVersionAccessors = new CglibVersionAccessors(providers, config);
        private final ComVersionAccessors vaccForComVersionAccessors = new ComVersionAccessors(providers, config);
        private final CommonsVersionAccessors vaccForCommonsVersionAccessors = new CommonsVersionAccessors(providers, config);
        private final JavaxVersionAccessors vaccForJavaxVersionAccessors = new JavaxVersionAccessors(providers, config);
        private final JunitVersionAccessors vaccForJunitVersionAccessors = new JunitVersionAccessors(providers, config);
        private final Log4jVersionAccessors vaccForLog4jVersionAccessors = new Log4jVersionAccessors(providers, config);
        private final OrgVersionAccessors vaccForOrgVersionAccessors = new OrgVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.cglib
         */
        public CglibVersionAccessors getCglib() {
            return vaccForCglibVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.com
         */
        public ComVersionAccessors getCom() {
            return vaccForComVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.commons
         */
        public CommonsVersionAccessors getCommons() {
            return vaccForCommonsVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.javax
         */
        public JavaxVersionAccessors getJavax() {
            return vaccForJavaxVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.junit
         */
        public JunitVersionAccessors getJunit() {
            return vaccForJunitVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.log4j
         */
        public Log4jVersionAccessors getLog4j() {
            return vaccForLog4jVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org
         */
        public OrgVersionAccessors getOrg() {
            return vaccForOrgVersionAccessors;
        }

    }

    public static class CglibVersionAccessors extends VersionFactory  {

        public CglibVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: cglib.cglib (2.2.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCglib() { return getVersion("cglib.cglib"); }

    }

    public static class ComVersionAccessors extends VersionFactory  {

        private final ComAmazonawsVersionAccessors vaccForComAmazonawsVersionAccessors = new ComAmazonawsVersionAccessors(providers, config);
        private final ComFasterxmlVersionAccessors vaccForComFasterxmlVersionAccessors = new ComFasterxmlVersionAccessors(providers, config);
        private final ComGoogleVersionAccessors vaccForComGoogleVersionAccessors = new ComGoogleVersionAccessors(providers, config);
        private final ComGooglecodeVersionAccessors vaccForComGooglecodeVersionAccessors = new ComGooglecodeVersionAccessors(providers, config);
        private final ComOracleVersionAccessors vaccForComOracleVersionAccessors = new ComOracleVersionAccessors(providers, config);
        public ComVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.amazonaws
         */
        public ComAmazonawsVersionAccessors getAmazonaws() {
            return vaccForComAmazonawsVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.com.fasterxml
         */
        public ComFasterxmlVersionAccessors getFasterxml() {
            return vaccForComFasterxmlVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.com.google
         */
        public ComGoogleVersionAccessors getGoogle() {
            return vaccForComGoogleVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.com.googlecode
         */
        public ComGooglecodeVersionAccessors getGooglecode() {
            return vaccForComGooglecodeVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.com.oracle
         */
        public ComOracleVersionAccessors getOracle() {
            return vaccForComOracleVersionAccessors;
        }

    }

    public static class ComAmazonawsVersionAccessors extends VersionFactory  {

        private final ComAmazonawsAwsVersionAccessors vaccForComAmazonawsAwsVersionAccessors = new ComAmazonawsAwsVersionAccessors(providers, config);
        public ComAmazonawsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.amazonaws.aws
         */
        public ComAmazonawsAwsVersionAccessors getAws() {
            return vaccForComAmazonawsAwsVersionAccessors;
        }

    }

    public static class ComAmazonawsAwsVersionAccessors extends VersionFactory  {

        private final ComAmazonawsAwsJavaVersionAccessors vaccForComAmazonawsAwsJavaVersionAccessors = new ComAmazonawsAwsJavaVersionAccessors(providers, config);
        public ComAmazonawsAwsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.amazonaws.aws.java
         */
        public ComAmazonawsAwsJavaVersionAccessors getJava() {
            return vaccForComAmazonawsAwsJavaVersionAccessors;
        }

    }

    public static class ComAmazonawsAwsJavaVersionAccessors extends VersionFactory  {

        public ComAmazonawsAwsJavaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: com.amazonaws.aws.java.sdk (1.11.66)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSdk() { return getVersion("com.amazonaws.aws.java.sdk"); }

    }

    public static class ComFasterxmlVersionAccessors extends VersionFactory  {

        private final ComFasterxmlJacksonVersionAccessors vaccForComFasterxmlJacksonVersionAccessors = new ComFasterxmlJacksonVersionAccessors(providers, config);
        public ComFasterxmlVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.fasterxml.jackson
         */
        public ComFasterxmlJacksonVersionAccessors getJackson() {
            return vaccForComFasterxmlJacksonVersionAccessors;
        }

    }

    public static class ComFasterxmlJacksonVersionAccessors extends VersionFactory  {

        private final ComFasterxmlJacksonCoreVersionAccessors vaccForComFasterxmlJacksonCoreVersionAccessors = new ComFasterxmlJacksonCoreVersionAccessors(providers, config);
        public ComFasterxmlJacksonVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.fasterxml.jackson.core
         */
        public ComFasterxmlJacksonCoreVersionAccessors getCore() {
            return vaccForComFasterxmlJacksonCoreVersionAccessors;
        }

    }

    public static class ComFasterxmlJacksonCoreVersionAccessors extends VersionFactory  {

        private final ComFasterxmlJacksonCoreJacksonVersionAccessors vaccForComFasterxmlJacksonCoreJacksonVersionAccessors = new ComFasterxmlJacksonCoreJacksonVersionAccessors(providers, config);
        public ComFasterxmlJacksonCoreVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.fasterxml.jackson.core.jackson
         */
        public ComFasterxmlJacksonCoreJacksonVersionAccessors getJackson() {
            return vaccForComFasterxmlJacksonCoreJacksonVersionAccessors;
        }

    }

    public static class ComFasterxmlJacksonCoreJacksonVersionAccessors extends VersionFactory  {

        public ComFasterxmlJacksonCoreJacksonVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: com.fasterxml.jackson.core.jackson.databind (2.9.9)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getDatabind() { return getVersion("com.fasterxml.jackson.core.jackson.databind"); }

    }

    public static class ComGoogleVersionAccessors extends VersionFactory  {

        private final ComGoogleCodeVersionAccessors$1 vaccForComGoogleCodeVersionAccessors$1 = new ComGoogleCodeVersionAccessors$1(providers, config);
        private final ComGoogleGuavaVersionAccessors vaccForComGoogleGuavaVersionAccessors = new ComGoogleGuavaVersionAccessors(providers, config);
        public ComGoogleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.google.code
         */
        public ComGoogleCodeVersionAccessors$1 getCode() {
            return vaccForComGoogleCodeVersionAccessors$1;
        }

        /**
         * Returns the group of versions at versions.com.google.guava
         */
        public ComGoogleGuavaVersionAccessors getGuava() {
            return vaccForComGoogleGuavaVersionAccessors;
        }

    }

    public static class ComGoogleCodeVersionAccessors$1 extends VersionFactory  {

        private final ComGoogleCodeGsonVersionAccessors vaccForComGoogleCodeGsonVersionAccessors = new ComGoogleCodeGsonVersionAccessors(providers, config);
        public ComGoogleCodeVersionAccessors$1(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.google.code.gson
         */
        public ComGoogleCodeGsonVersionAccessors getGson() {
            return vaccForComGoogleCodeGsonVersionAccessors;
        }

    }

    public static class ComGoogleCodeGsonVersionAccessors extends VersionFactory  {

        public ComGoogleCodeGsonVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: com.google.code.gson.gson (2.8.6)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getGson() { return getVersion("com.google.code.gson.gson"); }

    }

    public static class ComGoogleGuavaVersionAccessors extends VersionFactory  {

        public ComGoogleGuavaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: com.google.guava.guava (31.1-jre)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getGuava() { return getVersion("com.google.guava.guava"); }

    }

    public static class ComGooglecodeVersionAccessors extends VersionFactory  {

        private final ComGooglecodeJsonVersionAccessors vaccForComGooglecodeJsonVersionAccessors = new ComGooglecodeJsonVersionAccessors(providers, config);
        public ComGooglecodeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.googlecode.json
         */
        public ComGooglecodeJsonVersionAccessors getJson() {
            return vaccForComGooglecodeJsonVersionAccessors;
        }

    }

    public static class ComGooglecodeJsonVersionAccessors extends VersionFactory  {

        private final ComGooglecodeJsonSimpleVersionAccessors vaccForComGooglecodeJsonSimpleVersionAccessors = new ComGooglecodeJsonSimpleVersionAccessors(providers, config);
        public ComGooglecodeJsonVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.googlecode.json.simple
         */
        public ComGooglecodeJsonSimpleVersionAccessors getSimple() {
            return vaccForComGooglecodeJsonSimpleVersionAccessors;
        }

    }

    public static class ComGooglecodeJsonSimpleVersionAccessors extends VersionFactory  {

        private final ComGooglecodeJsonSimpleJsonVersionAccessors vaccForComGooglecodeJsonSimpleJsonVersionAccessors = new ComGooglecodeJsonSimpleJsonVersionAccessors(providers, config);
        public ComGooglecodeJsonSimpleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.googlecode.json.simple.json
         */
        public ComGooglecodeJsonSimpleJsonVersionAccessors getJson() {
            return vaccForComGooglecodeJsonSimpleJsonVersionAccessors;
        }

    }

    public static class ComGooglecodeJsonSimpleJsonVersionAccessors extends VersionFactory  {

        public ComGooglecodeJsonSimpleJsonVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: com.googlecode.json.simple.json.simple (1.1.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSimple() { return getVersion("com.googlecode.json.simple.json.simple"); }

    }

    public static class ComOracleVersionAccessors extends VersionFactory  {

        private final ComOracleDatabaseVersionAccessors vaccForComOracleDatabaseVersionAccessors = new ComOracleDatabaseVersionAccessors(providers, config);
        public ComOracleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.oracle.database
         */
        public ComOracleDatabaseVersionAccessors getDatabase() {
            return vaccForComOracleDatabaseVersionAccessors;
        }

    }

    public static class ComOracleDatabaseVersionAccessors extends VersionFactory  {

        private final ComOracleDatabaseJdbcVersionAccessors vaccForComOracleDatabaseJdbcVersionAccessors = new ComOracleDatabaseJdbcVersionAccessors(providers, config);
        public ComOracleDatabaseVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.oracle.database.jdbc
         */
        public ComOracleDatabaseJdbcVersionAccessors getJdbc() {
            return vaccForComOracleDatabaseJdbcVersionAccessors;
        }

    }

    public static class ComOracleDatabaseJdbcVersionAccessors extends VersionFactory  {

        public ComOracleDatabaseJdbcVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: com.oracle.database.jdbc.ojdbc8 (21.1.0.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getOjdbc8() { return getVersion("com.oracle.database.jdbc.ojdbc8"); }

    }

    public static class CommonsVersionAccessors extends VersionFactory  {

        private final CommonsFileuploadVersionAccessors vaccForCommonsFileuploadVersionAccessors = new CommonsFileuploadVersionAccessors(providers, config);
        private final CommonsIoVersionAccessors vaccForCommonsIoVersionAccessors = new CommonsIoVersionAccessors(providers, config);
        public CommonsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.commons.fileupload
         */
        public CommonsFileuploadVersionAccessors getFileupload() {
            return vaccForCommonsFileuploadVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.commons.io
         */
        public CommonsIoVersionAccessors getIo() {
            return vaccForCommonsIoVersionAccessors;
        }

    }

    public static class CommonsFileuploadVersionAccessors extends VersionFactory  {

        private final CommonsFileuploadCommonsVersionAccessors vaccForCommonsFileuploadCommonsVersionAccessors = new CommonsFileuploadCommonsVersionAccessors(providers, config);
        public CommonsFileuploadVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.commons.fileupload.commons
         */
        public CommonsFileuploadCommonsVersionAccessors getCommons() {
            return vaccForCommonsFileuploadCommonsVersionAccessors;
        }

    }

    public static class CommonsFileuploadCommonsVersionAccessors extends VersionFactory  {

        public CommonsFileuploadCommonsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: commons.fileupload.commons.fileupload (1.4)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getFileupload() { return getVersion("commons.fileupload.commons.fileupload"); }

    }

    public static class CommonsIoVersionAccessors extends VersionFactory  {

        private final CommonsIoCommonsVersionAccessors vaccForCommonsIoCommonsVersionAccessors = new CommonsIoCommonsVersionAccessors(providers, config);
        public CommonsIoVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.commons.io.commons
         */
        public CommonsIoCommonsVersionAccessors getCommons() {
            return vaccForCommonsIoCommonsVersionAccessors;
        }

    }

    public static class CommonsIoCommonsVersionAccessors extends VersionFactory  {

        public CommonsIoCommonsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: commons.io.commons.io (2.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getIo() { return getVersion("commons.io.commons.io"); }

    }

    public static class JavaxVersionAccessors extends VersionFactory  {

        private final JavaxInjectVersionAccessors vaccForJavaxInjectVersionAccessors = new JavaxInjectVersionAccessors(providers, config);
        private final JavaxServletVersionAccessors vaccForJavaxServletVersionAccessors = new JavaxServletVersionAccessors(providers, config);
        private final JavaxValidationVersionAccessors vaccForJavaxValidationVersionAccessors = new JavaxValidationVersionAccessors(providers, config);
        private final JavaxWebsocketVersionAccessors vaccForJavaxWebsocketVersionAccessors = new JavaxWebsocketVersionAccessors(providers, config);
        public JavaxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.javax.inject
         */
        public JavaxInjectVersionAccessors getInject() {
            return vaccForJavaxInjectVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.javax.servlet
         */
        public JavaxServletVersionAccessors getServlet() {
            return vaccForJavaxServletVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.javax.validation
         */
        public JavaxValidationVersionAccessors getValidation() {
            return vaccForJavaxValidationVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.javax.websocket
         */
        public JavaxWebsocketVersionAccessors getWebsocket() {
            return vaccForJavaxWebsocketVersionAccessors;
        }

    }

    public static class JavaxInjectVersionAccessors extends VersionFactory  {

        private final JavaxInjectJavaxVersionAccessors vaccForJavaxInjectJavaxVersionAccessors = new JavaxInjectJavaxVersionAccessors(providers, config);
        public JavaxInjectVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.javax.inject.javax
         */
        public JavaxInjectJavaxVersionAccessors getJavax() {
            return vaccForJavaxInjectJavaxVersionAccessors;
        }

    }

    public static class JavaxInjectJavaxVersionAccessors extends VersionFactory  {

        public JavaxInjectJavaxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: javax.inject.javax.inject (1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getInject() { return getVersion("javax.inject.javax.inject"); }

    }

    public static class JavaxServletVersionAccessors extends VersionFactory  {

        private final JavaxServletJavaxVersionAccessors vaccForJavaxServletJavaxVersionAccessors = new JavaxServletJavaxVersionAccessors(providers, config);
        private final JavaxServletJspVersionAccessors vaccForJavaxServletJspVersionAccessors = new JavaxServletJspVersionAccessors(providers, config);
        public JavaxServletVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: javax.servlet.jstl (1.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJstl() { return getVersion("javax.servlet.jstl"); }

        /**
         * Returns the group of versions at versions.javax.servlet.javax
         */
        public JavaxServletJavaxVersionAccessors getJavax() {
            return vaccForJavaxServletJavaxVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.javax.servlet.jsp
         */
        public JavaxServletJspVersionAccessors getJsp() {
            return vaccForJavaxServletJspVersionAccessors;
        }

    }

    public static class JavaxServletJavaxVersionAccessors extends VersionFactory  {

        private final JavaxServletJavaxServletVersionAccessors vaccForJavaxServletJavaxServletVersionAccessors = new JavaxServletJavaxServletVersionAccessors(providers, config);
        public JavaxServletJavaxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.javax.servlet.javax.servlet
         */
        public JavaxServletJavaxServletVersionAccessors getServlet() {
            return vaccForJavaxServletJavaxServletVersionAccessors;
        }

    }

    public static class JavaxServletJavaxServletVersionAccessors extends VersionFactory  {

        public JavaxServletJavaxServletVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: javax.servlet.javax.servlet.api (3.1.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getApi() { return getVersion("javax.servlet.javax.servlet.api"); }

    }

    public static class JavaxServletJspVersionAccessors extends VersionFactory  {

        private final JavaxServletJspJspVersionAccessors vaccForJavaxServletJspJspVersionAccessors = new JavaxServletJspJspVersionAccessors(providers, config);
        public JavaxServletJspVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.javax.servlet.jsp.jsp
         */
        public JavaxServletJspJspVersionAccessors getJsp() {
            return vaccForJavaxServletJspJspVersionAccessors;
        }

    }

    public static class JavaxServletJspJspVersionAccessors extends VersionFactory  {

        public JavaxServletJspJspVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: javax.servlet.jsp.jsp.api (2.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getApi() { return getVersion("javax.servlet.jsp.jsp.api"); }

    }

    public static class JavaxValidationVersionAccessors extends VersionFactory  {

        private final JavaxValidationValidationVersionAccessors vaccForJavaxValidationValidationVersionAccessors = new JavaxValidationValidationVersionAccessors(providers, config);
        public JavaxValidationVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.javax.validation.validation
         */
        public JavaxValidationValidationVersionAccessors getValidation() {
            return vaccForJavaxValidationValidationVersionAccessors;
        }

    }

    public static class JavaxValidationValidationVersionAccessors extends VersionFactory  {

        public JavaxValidationValidationVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: javax.validation.validation.api (2.0.1.Final)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getApi() { return getVersion("javax.validation.validation.api"); }

    }

    public static class JavaxWebsocketVersionAccessors extends VersionFactory  {

        private final JavaxWebsocketJavaxVersionAccessors vaccForJavaxWebsocketJavaxVersionAccessors = new JavaxWebsocketJavaxVersionAccessors(providers, config);
        public JavaxWebsocketVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.javax.websocket.javax
         */
        public JavaxWebsocketJavaxVersionAccessors getJavax() {
            return vaccForJavaxWebsocketJavaxVersionAccessors;
        }

    }

    public static class JavaxWebsocketJavaxVersionAccessors extends VersionFactory  {

        private final JavaxWebsocketJavaxWebsocketVersionAccessors vaccForJavaxWebsocketJavaxWebsocketVersionAccessors = new JavaxWebsocketJavaxWebsocketVersionAccessors(providers, config);
        public JavaxWebsocketJavaxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.javax.websocket.javax.websocket
         */
        public JavaxWebsocketJavaxWebsocketVersionAccessors getWebsocket() {
            return vaccForJavaxWebsocketJavaxWebsocketVersionAccessors;
        }

    }

    public static class JavaxWebsocketJavaxWebsocketVersionAccessors extends VersionFactory  {

        public JavaxWebsocketJavaxWebsocketVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: javax.websocket.javax.websocket.api (1.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getApi() { return getVersion("javax.websocket.javax.websocket.api"); }

    }

    public static class JunitVersionAccessors extends VersionFactory  {

        public JunitVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: junit.junit (4.7)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJunit() { return getVersion("junit.junit"); }

    }

    public static class Log4jVersionAccessors extends VersionFactory  {

        public Log4jVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: log4j.log4j (1.2.15)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getLog4j() { return getVersion("log4j.log4j"); }

    }

    public static class OrgVersionAccessors extends VersionFactory  {

        private final OrgApacheVersionAccessors vaccForOrgApacheVersionAccessors = new OrgApacheVersionAccessors(providers, config);
        private final OrgAspectjVersionAccessors vaccForOrgAspectjVersionAccessors = new OrgAspectjVersionAccessors(providers, config);
        private final OrgBgeeVersionAccessors vaccForOrgBgeeVersionAccessors = new OrgBgeeVersionAccessors(providers, config);
        private final OrgHibernateVersionAccessors vaccForOrgHibernateVersionAccessors = new OrgHibernateVersionAccessors(providers, config);
        private final OrgJasyptVersionAccessors vaccForOrgJasyptVersionAccessors = new OrgJasyptVersionAccessors(providers, config);
        private final OrgMybatisVersionAccessors vaccForOrgMybatisVersionAccessors = new OrgMybatisVersionAccessors(providers, config);
        private final OrgProjectlombokVersionAccessors vaccForOrgProjectlombokVersionAccessors = new OrgProjectlombokVersionAccessors(providers, config);
        private final OrgSlf4jVersionAccessors vaccForOrgSlf4jVersionAccessors = new OrgSlf4jVersionAccessors(providers, config);
        private final OrgSpringframeworkVersionAccessors vaccForOrgSpringframeworkVersionAccessors = new OrgSpringframeworkVersionAccessors(providers, config);
        public OrgVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.apache
         */
        public OrgApacheVersionAccessors getApache() {
            return vaccForOrgApacheVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.aspectj
         */
        public OrgAspectjVersionAccessors getAspectj() {
            return vaccForOrgAspectjVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.bgee
         */
        public OrgBgeeVersionAccessors getBgee() {
            return vaccForOrgBgeeVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.hibernate
         */
        public OrgHibernateVersionAccessors getHibernate() {
            return vaccForOrgHibernateVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.jasypt
         */
        public OrgJasyptVersionAccessors getJasypt() {
            return vaccForOrgJasyptVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.mybatis
         */
        public OrgMybatisVersionAccessors getMybatis() {
            return vaccForOrgMybatisVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.projectlombok
         */
        public OrgProjectlombokVersionAccessors getProjectlombok() {
            return vaccForOrgProjectlombokVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.slf4j
         */
        public OrgSlf4jVersionAccessors getSlf4j() {
            return vaccForOrgSlf4jVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.springframework
         */
        public OrgSpringframeworkVersionAccessors getSpringframework() {
            return vaccForOrgSpringframeworkVersionAccessors;
        }

    }

    public static class OrgApacheVersionAccessors extends VersionFactory  {

        private final OrgApacheCommonsVersionAccessors vaccForOrgApacheCommonsVersionAccessors = new OrgApacheCommonsVersionAccessors(providers, config);
        private final OrgApachePoiVersionAccessors vaccForOrgApachePoiVersionAccessors = new OrgApachePoiVersionAccessors(providers, config);
        private final OrgApacheTilesVersionAccessors vaccForOrgApacheTilesVersionAccessors = new OrgApacheTilesVersionAccessors(providers, config);
        public OrgApacheVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.apache.commons
         */
        public OrgApacheCommonsVersionAccessors getCommons() {
            return vaccForOrgApacheCommonsVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.apache.poi
         */
        public OrgApachePoiVersionAccessors getPoi() {
            return vaccForOrgApachePoiVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.apache.tiles
         */
        public OrgApacheTilesVersionAccessors getTiles() {
            return vaccForOrgApacheTilesVersionAccessors;
        }

    }

    public static class OrgApacheCommonsVersionAccessors extends VersionFactory  {

        private final OrgApacheCommonsCommonsVersionAccessors vaccForOrgApacheCommonsCommonsVersionAccessors = new OrgApacheCommonsCommonsVersionAccessors(providers, config);
        public OrgApacheCommonsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.apache.commons.commons
         */
        public OrgApacheCommonsCommonsVersionAccessors getCommons() {
            return vaccForOrgApacheCommonsCommonsVersionAccessors;
        }

    }

    public static class OrgApacheCommonsCommonsVersionAccessors extends VersionFactory  {

        public OrgApacheCommonsCommonsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.apache.commons.commons.dbcp2 (2.9.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getDbcp2() { return getVersion("org.apache.commons.commons.dbcp2"); }

            /**
             * Returns the version associated to this alias: org.apache.commons.commons.email (1.5)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getEmail() { return getVersion("org.apache.commons.commons.email"); }

    }

    public static class OrgApachePoiVersionAccessors extends VersionFactory  {

        private final OrgApachePoiPoiVersionAccessors vaccForOrgApachePoiPoiVersionAccessors = new OrgApachePoiPoiVersionAccessors(providers, config);
        public OrgApachePoiVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.apache.poi.poi
         */
        public OrgApachePoiPoiVersionAccessors getPoi() {
            return vaccForOrgApachePoiPoiVersionAccessors;
        }

    }

    public static class OrgApachePoiPoiVersionAccessors extends VersionFactory  {

        public OrgApachePoiPoiVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.apache.poi.poi.ooxml (3.9)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getOoxml() { return getVersion("org.apache.poi.poi.ooxml"); }

    }

    public static class OrgApacheTilesVersionAccessors extends VersionFactory  {

        private final OrgApacheTilesTilesVersionAccessors vaccForOrgApacheTilesTilesVersionAccessors = new OrgApacheTilesTilesVersionAccessors(providers, config);
        public OrgApacheTilesVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.apache.tiles.tiles
         */
        public OrgApacheTilesTilesVersionAccessors getTiles() {
            return vaccForOrgApacheTilesTilesVersionAccessors;
        }

    }

    public static class OrgApacheTilesTilesVersionAccessors extends VersionFactory  {

        public OrgApacheTilesTilesVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.apache.tiles.tiles.extras (3.0.8)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getExtras() { return getVersion("org.apache.tiles.tiles.extras"); }

            /**
             * Returns the version associated to this alias: org.apache.tiles.tiles.jsp (3.0.8)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJsp() { return getVersion("org.apache.tiles.tiles.jsp"); }

            /**
             * Returns the version associated to this alias: org.apache.tiles.tiles.servlet (3.0.8)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getServlet() { return getVersion("org.apache.tiles.tiles.servlet"); }

    }

    public static class OrgAspectjVersionAccessors extends VersionFactory  {

        public OrgAspectjVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.aspectj.aspectjrt (1.6.10)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAspectjrt() { return getVersion("org.aspectj.aspectjrt"); }

    }

    public static class OrgBgeeVersionAccessors extends VersionFactory  {

        private final OrgBgeeLog4jdbcVersionAccessors vaccForOrgBgeeLog4jdbcVersionAccessors = new OrgBgeeLog4jdbcVersionAccessors(providers, config);
        public OrgBgeeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.bgee.log4jdbc
         */
        public OrgBgeeLog4jdbcVersionAccessors getLog4jdbc() {
            return vaccForOrgBgeeLog4jdbcVersionAccessors;
        }

    }

    public static class OrgBgeeLog4jdbcVersionAccessors extends VersionFactory  {

        private final OrgBgeeLog4jdbcLog4j2VersionAccessors vaccForOrgBgeeLog4jdbcLog4j2VersionAccessors = new OrgBgeeLog4jdbcLog4j2VersionAccessors(providers, config);
        public OrgBgeeLog4jdbcVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.bgee.log4jdbc.log4j2
         */
        public OrgBgeeLog4jdbcLog4j2VersionAccessors getLog4j2() {
            return vaccForOrgBgeeLog4jdbcLog4j2VersionAccessors;
        }

    }

    public static class OrgBgeeLog4jdbcLog4j2VersionAccessors extends VersionFactory  {

        private final OrgBgeeLog4jdbcLog4j2Log4jdbcVersionAccessors vaccForOrgBgeeLog4jdbcLog4j2Log4jdbcVersionAccessors = new OrgBgeeLog4jdbcLog4j2Log4jdbcVersionAccessors(providers, config);
        public OrgBgeeLog4jdbcLog4j2VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.bgee.log4jdbc.log4j2.log4jdbc
         */
        public OrgBgeeLog4jdbcLog4j2Log4jdbcVersionAccessors getLog4jdbc() {
            return vaccForOrgBgeeLog4jdbcLog4j2Log4jdbcVersionAccessors;
        }

    }

    public static class OrgBgeeLog4jdbcLog4j2Log4jdbcVersionAccessors extends VersionFactory  {

        private final OrgBgeeLog4jdbcLog4j2Log4jdbcLog4j2VersionAccessors vaccForOrgBgeeLog4jdbcLog4j2Log4jdbcLog4j2VersionAccessors = new OrgBgeeLog4jdbcLog4j2Log4jdbcLog4j2VersionAccessors(providers, config);
        public OrgBgeeLog4jdbcLog4j2Log4jdbcVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.bgee.log4jdbc.log4j2.log4jdbc.log4j2
         */
        public OrgBgeeLog4jdbcLog4j2Log4jdbcLog4j2VersionAccessors getLog4j2() {
            return vaccForOrgBgeeLog4jdbcLog4j2Log4jdbcLog4j2VersionAccessors;
        }

    }

    public static class OrgBgeeLog4jdbcLog4j2Log4jdbcLog4j2VersionAccessors extends VersionFactory  {

        public OrgBgeeLog4jdbcLog4j2Log4jdbcLog4j2VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.bgee.log4jdbc.log4j2.log4jdbc.log4j2.jdbc4 (1.16)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJdbc4() { return getVersion("org.bgee.log4jdbc.log4j2.log4jdbc.log4j2.jdbc4"); }

    }

    public static class OrgHibernateVersionAccessors extends VersionFactory  {

        private final OrgHibernateValidatorVersionAccessors vaccForOrgHibernateValidatorVersionAccessors = new OrgHibernateValidatorVersionAccessors(providers, config);
        public OrgHibernateVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.hibernate.validator
         */
        public OrgHibernateValidatorVersionAccessors getValidator() {
            return vaccForOrgHibernateValidatorVersionAccessors;
        }

    }

    public static class OrgHibernateValidatorVersionAccessors extends VersionFactory  {

        private final OrgHibernateValidatorHibernateVersionAccessors vaccForOrgHibernateValidatorHibernateVersionAccessors = new OrgHibernateValidatorHibernateVersionAccessors(providers, config);
        public OrgHibernateValidatorVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.hibernate.validator.hibernate
         */
        public OrgHibernateValidatorHibernateVersionAccessors getHibernate() {
            return vaccForOrgHibernateValidatorHibernateVersionAccessors;
        }

    }

    public static class OrgHibernateValidatorHibernateVersionAccessors extends VersionFactory  {

        public OrgHibernateValidatorHibernateVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.hibernate.validator.hibernate.validator (6.2.0.Final)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getValidator() { return getVersion("org.hibernate.validator.hibernate.validator"); }

    }

    public static class OrgJasyptVersionAccessors extends VersionFactory  {

        private final OrgJasyptJasyptVersionAccessors vaccForOrgJasyptJasyptVersionAccessors = new OrgJasyptJasyptVersionAccessors(providers, config);
        public OrgJasyptVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.jasypt.jasypt
         */
        public OrgJasyptJasyptVersionAccessors getJasypt() {
            return vaccForOrgJasyptJasyptVersionAccessors;
        }

    }

    public static class OrgJasyptJasyptVersionAccessors extends VersionFactory  {

        public OrgJasyptJasyptVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.jasypt.jasypt.spring3 (1.9.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSpring3() { return getVersion("org.jasypt.jasypt.spring3"); }

    }

    public static class OrgMybatisVersionAccessors extends VersionFactory  {

        private final OrgMybatisMybatisVersionAccessors vaccForOrgMybatisMybatisVersionAccessors = new OrgMybatisMybatisVersionAccessors(providers, config);
        public OrgMybatisVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.mybatis.mybatis
         */
        public OrgMybatisMybatisVersionAccessors getMybatis() {
            return vaccForOrgMybatisMybatisVersionAccessors;
        }

    }

    public static class OrgMybatisMybatisVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        public OrgMybatisMybatisVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the version associated to this alias: org.mybatis.mybatis (3.5.7)
         * If the version is a rich version and that its not expressible as a
         * single version string, then an empty string is returned.
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> asProvider() { return getVersion("org.mybatis.mybatis"); }

            /**
             * Returns the version associated to this alias: org.mybatis.mybatis.spring (2.0.6)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSpring() { return getVersion("org.mybatis.mybatis.spring"); }

    }

    public static class OrgProjectlombokVersionAccessors extends VersionFactory  {

        public OrgProjectlombokVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.projectlombok.lombok (1.18.28)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getLombok() { return getVersion("org.projectlombok.lombok"); }

    }

    public static class OrgSlf4jVersionAccessors extends VersionFactory  {

        private final OrgSlf4jJclVersionAccessors vaccForOrgSlf4jJclVersionAccessors = new OrgSlf4jJclVersionAccessors(providers, config);
        private final OrgSlf4jSlf4jVersionAccessors vaccForOrgSlf4jSlf4jVersionAccessors = new OrgSlf4jSlf4jVersionAccessors(providers, config);
        public OrgSlf4jVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.slf4j.jcl
         */
        public OrgSlf4jJclVersionAccessors getJcl() {
            return vaccForOrgSlf4jJclVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.slf4j.slf4j
         */
        public OrgSlf4jSlf4jVersionAccessors getSlf4j() {
            return vaccForOrgSlf4jSlf4jVersionAccessors;
        }

    }

    public static class OrgSlf4jJclVersionAccessors extends VersionFactory  {

        private final OrgSlf4jJclOverVersionAccessors vaccForOrgSlf4jJclOverVersionAccessors = new OrgSlf4jJclOverVersionAccessors(providers, config);
        public OrgSlf4jJclVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.slf4j.jcl.over
         */
        public OrgSlf4jJclOverVersionAccessors getOver() {
            return vaccForOrgSlf4jJclOverVersionAccessors;
        }

    }

    public static class OrgSlf4jJclOverVersionAccessors extends VersionFactory  {

        public OrgSlf4jJclOverVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.slf4j.jcl.over.slf4j (1.6.6)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSlf4j() { return getVersion("org.slf4j.jcl.over.slf4j"); }

    }

    public static class OrgSlf4jSlf4jVersionAccessors extends VersionFactory  {

        public OrgSlf4jSlf4jVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.slf4j.slf4j.api (1.6.6)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getApi() { return getVersion("org.slf4j.slf4j.api"); }

            /**
             * Returns the version associated to this alias: org.slf4j.slf4j.log4j12 (1.6.6)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getLog4j12() { return getVersion("org.slf4j.slf4j.log4j12"); }

    }

    public static class OrgSpringframeworkVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBatchVersionAccessors vaccForOrgSpringframeworkBatchVersionAccessors = new OrgSpringframeworkBatchVersionAccessors(providers, config);
        private final OrgSpringframeworkSecurityVersionAccessors vaccForOrgSpringframeworkSecurityVersionAccessors = new OrgSpringframeworkSecurityVersionAccessors(providers, config);
        private final OrgSpringframeworkSpringVersionAccessors vaccForOrgSpringframeworkSpringVersionAccessors = new OrgSpringframeworkSpringVersionAccessors(providers, config);
        public OrgSpringframeworkVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.springframework.batch
         */
        public OrgSpringframeworkBatchVersionAccessors getBatch() {
            return vaccForOrgSpringframeworkBatchVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.springframework.security
         */
        public OrgSpringframeworkSecurityVersionAccessors getSecurity() {
            return vaccForOrgSpringframeworkSecurityVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.springframework.spring
         */
        public OrgSpringframeworkSpringVersionAccessors getSpring() {
            return vaccForOrgSpringframeworkSpringVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBatchVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBatchSpringVersionAccessors vaccForOrgSpringframeworkBatchSpringVersionAccessors = new OrgSpringframeworkBatchSpringVersionAccessors(providers, config);
        public OrgSpringframeworkBatchVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.springframework.batch.spring
         */
        public OrgSpringframeworkBatchSpringVersionAccessors getSpring() {
            return vaccForOrgSpringframeworkBatchSpringVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBatchSpringVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBatchSpringBatchVersionAccessors vaccForOrgSpringframeworkBatchSpringBatchVersionAccessors = new OrgSpringframeworkBatchSpringBatchVersionAccessors(providers, config);
        public OrgSpringframeworkBatchSpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.springframework.batch.spring.batch
         */
        public OrgSpringframeworkBatchSpringBatchVersionAccessors getBatch() {
            return vaccForOrgSpringframeworkBatchSpringBatchVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBatchSpringBatchVersionAccessors extends VersionFactory  {

        public OrgSpringframeworkBatchSpringBatchVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.springframework.batch.spring.batch.core (3.0.1.RELEASE)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCore() { return getVersion("org.springframework.batch.spring.batch.core"); }

            /**
             * Returns the version associated to this alias: org.springframework.batch.spring.batch.infrastructure (3.0.1.RELEASE)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getInfrastructure() { return getVersion("org.springframework.batch.spring.batch.infrastructure"); }

    }

    public static class OrgSpringframeworkSecurityVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkSecuritySpringVersionAccessors vaccForOrgSpringframeworkSecuritySpringVersionAccessors = new OrgSpringframeworkSecuritySpringVersionAccessors(providers, config);
        public OrgSpringframeworkSecurityVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.springframework.security.spring
         */
        public OrgSpringframeworkSecuritySpringVersionAccessors getSpring() {
            return vaccForOrgSpringframeworkSecuritySpringVersionAccessors;
        }

    }

    public static class OrgSpringframeworkSecuritySpringVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkSecuritySpringSecurityVersionAccessors vaccForOrgSpringframeworkSecuritySpringSecurityVersionAccessors = new OrgSpringframeworkSecuritySpringSecurityVersionAccessors(providers, config);
        public OrgSpringframeworkSecuritySpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.springframework.security.spring.security
         */
        public OrgSpringframeworkSecuritySpringSecurityVersionAccessors getSecurity() {
            return vaccForOrgSpringframeworkSecuritySpringSecurityVersionAccessors;
        }

    }

    public static class OrgSpringframeworkSecuritySpringSecurityVersionAccessors extends VersionFactory  {

        public OrgSpringframeworkSecuritySpringSecurityVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.springframework.security.spring.security.config (4.2.3.RELEASE)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getConfig() { return getVersion("org.springframework.security.spring.security.config"); }

            /**
             * Returns the version associated to this alias: org.springframework.security.spring.security.taglibs (4.2.3.RELEASE)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getTaglibs() { return getVersion("org.springframework.security.spring.security.taglibs"); }

            /**
             * Returns the version associated to this alias: org.springframework.security.spring.security.web (4.2.3.RELEASE)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getWeb() { return getVersion("org.springframework.security.spring.security.web"); }

    }

    public static class OrgSpringframeworkSpringVersionAccessors extends VersionFactory  {

        public OrgSpringframeworkSpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.springframework.spring.context (4.3.9.RELEASE)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getContext() { return getVersion("org.springframework.spring.context"); }

            /**
             * Returns the version associated to this alias: org.springframework.spring.jdbc (4.3.9.RELEASE)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJdbc() { return getVersion("org.springframework.spring.jdbc"); }

            /**
             * Returns the version associated to this alias: org.springframework.spring.webmvc (4.3.9.RELEASE)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getWebmvc() { return getVersion("org.springframework.spring.webmvc"); }

            /**
             * Returns the version associated to this alias: org.springframework.spring.websocket (4.2.4.RELEASE)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getWebsocket() { return getVersion("org.springframework.spring.websocket"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
