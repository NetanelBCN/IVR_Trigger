
# IVR Callout

The IVR Callout Module interacts with an IVR (Interactive Voice Response) system via an API. It allows users to initiate IVR callouts by providing necessary details such as a phone number and a record template.

## Installation

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

![image](https://github.com/user-attachments/assets/0296918b-3047-43ee-960e-d4bc91df88c2)  ![image](https://github.com/user-attachments/assets/84751f70-d9f5-4ac0-bd28-d7ea17c0faf5)




## Authors

- [@octokatherine](https://www.github.com/octokatherine)

