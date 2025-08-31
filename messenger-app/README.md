# Messenger Application

## Overview
This project is a messenger application that allows users to send and receive messages, share media, and manage chat functionalities. The application supports one-on-one chats and group chats, along with features like push notifications and message encryption.

## Features
- **One-on-One Chat**: Users can engage in private conversations.
- **Group Chat**: Users can create and participate in group chats.
- **Media Sharing**: Users can send and receive images, videos, and audio files.
- **Message Forwarding**: Users can forward messages to other users.
- **Push Notifications**: Users receive notifications for new messages.
- **Encryption**: Messages are encrypted for secure communication.
- **Database Recovery**: The application can recover from failures to ensure data integrity.

## Project Structure
```
messenger-app
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com
│   │   │   │   └── messenger
│   │   │   │       ├── App.java
│   │   │   │       ├── controllers
│   │   │   │       │   └── ChatController.java
│   │   │   │       ├── models
│   │   │   │       │   ├── User.java
│   │   │   │       │   ├── Message.java
│   │   │   │       │   └── Media.java
│   │   │   │       ├── services
│   │   │   │       │   ├── ChatService.java
│   │   │   │       │   ├── NotificationService.java
│   │   │   │       │   └── EncryptionService.java
│   │   │   │       └── db
│   │   │   │           └── DatabaseManager.java
│   │   └── resources
│   │       └── application.properties
├── pom.xml
└── README.md
```

## Setup Instructions
1. **Clone the Repository**: 
   ```
   git clone <repository-url>
   cd messenger-app
   ```

2. **Build the Project**: 
   Ensure you have Maven installed, then run:
   ```
   mvn clean install
   ```

3. **Run the Application**: 
   Execute the following command to start the application:
   ```
   mvn spring-boot:run
   ```

4. **Access the Application**: 
   Open your browser and navigate to `http://localhost:8080` to access the messenger application.

## Usage Guidelines
- **Creating Users**: Users can register and create profiles to start chatting.
- **Sending Messages**: Use the chat interface to send and receive messages in real-time.
- **Sharing Media**: Click on the media button to upload and share images, videos, or audio files.
- **Forwarding Messages**: Select a message and use the forward option to send it to another user.

## Technologies Used
- Java
- Spring Boot
- Maven
- MySQL (or any other database of choice)

## Contributing
Contributions are welcome! Please submit a pull request or open an issue for any enhancements or bug fixes.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.