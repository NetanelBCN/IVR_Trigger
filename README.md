
# IVR Callout

The IVR Callout Module interacts with an IVR (Interactive Voice Response) system via an API. It allows users to initiate IVR callouts by providing necessary details such as a phone number and a record template.

## Installation and Permissions

In your 'AndroidManifest.xml' file make sure you add:
```xml
    <uses-permission android:name="android.permission.INTERNET" />
```

To inatall this module please download the library and add to your app's gradle file the following:

```java
    implementation(project(":ivrcall"))
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.9.1")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")
    implementation("com.google.code.gson:gson:2.11.0")
```
sync the project and start working with the module!

### Dependency Explanations
#### - implementation(project(":ivrcall"))

This includes the custom ivrcall library as a module dependency.
The ivrcall library contains the core logic for interacting with the IVR API, including:
API service interfaces.
Models for request and response handling.
Utility methods to simplify API integration.

#### - implementation("com.squareup.retrofit2:retrofit:2.9.0")

Retrofit is a type-safe HTTP client for Android.
It simplifies API calls by allowing you to define interfaces to describe endpoints, HTTP methods, and parameters.
In this module, Retrofit handles the communication with the IVR API.
implementation("com.squareup.retrofit2:converter-gson:2.9.0")

This adds support for converting JSON responses into Java objects using Gson.
The IVR API responses are JSON-based, and this converter ensures that data is automatically parsed into your CallDetails, ApiResponse, and other model classes.

#### - implementation("com.squareup.okhttp3:okhttp:4.9.1")

OkHttp is the underlying library used by Retrofit to handle HTTP requests and responses.
It provides robust networking capabilities, including connection pooling, caching, and retries, making API calls efficient and reliable.

#### - implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")

This adds logging functionality to OkHttp.
It logs details of HTTP requests and responses (headers, bodies, status codes), making it easier to debug API interactions during development.

#### - implementation("com.google.code.gson:gson:2.11.0")

Gson is a library for serializing and deserializing JSON.
It is used by the converter-gson dependency to map JSON objects to Java classes and vice versa.
For example, it converts the API response JSON into ApiResponse and CallDetails objects.



    
## How It Should Work

In your app, the MainActivity should perform the following tasks:

Capture User Input:

1) Allow users to input a phone number.
Provides options to select a record template via radio buttons.
Validates Input:

2) Ensure the phone number is in the correct format (05XXXXXXXX) and contains only digits.
Makes API Call:

3) Send the phone number and selected template to the backend IVR API using the myApi class.
Displays a loading spinner during the API request.

4) Handle the API Response:
Parse the response to extract details such as the phone number, record template, HTTP code, and IVR response.

5) Navigate to the SummaryActivity to display the formatted results.




## Usage Example

### - Initiallized the baseURL in the MainActivity
 
 ```java
    private String baseURl="YOUR URL";
 ```

 
## Screenshots

<img src="https://github.com/user-attachments/assets/0296918b-3047-43ee-960e-d4bc91df88c2" width="300" />
<img src="https://github.com/user-attachments/assets/84751f70-d9f5-4ac0-bd28-d7ea17c0faf5" width="300" />




## License

Copyright (c) 2024 Netanel Boris Cohen Niazov




## Authors

- Netanel Boris Cohen Niazov


