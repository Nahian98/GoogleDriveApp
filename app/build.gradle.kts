plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.googledriveapp"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.googledriveapp"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    packagingOptions {
        // Exclude specific files or file patterns from being packaged in the APK
        exclude("META-INF/DEPENDENCIES")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    viewBinding{
        enable = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("com.google.android.gms:play-services-maps:18.1.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation ("com.google.android.gms:play-services-auth:20.7.0")
    implementation ("com.google.http-client:google-http-client-gson:1.43.3")
    implementation("com.google.api-client:google-api-client-android:1.30.9")
    {
        exclude(group = "org.apache.httpcomponents")
    }
    implementation("com.google.apis:google-api-services-drive:v3-rev136-1.25.0")
    {
        exclude(group = "org.apache.httpcomponents")
    }

//    implementation ("com.google.api-client:google-api-client:1.30.10")
//    implementation ("com.google.oauth-client:google-oauth-client:2.4.1")
//    implementation ("com.google.oauth-client:google-oauth-client-jetty:2.4.1")
//    implementation ("com.google.apis:google-api-services-drive:v3-rev305-1.30.10")
//    implementation ("com.google.http-client:google-http-client-gson:1.38.0")

}