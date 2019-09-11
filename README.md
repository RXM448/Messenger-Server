# Messenger-Server
Group project during year in computer science course as a demonstration of teamwork and coding ability 

Personally listed as RXM448 for the purpose of authoring files and mainly worked on aspects of the clinet, server, and communication between them. 

The scope of the project is to design and implement a simple chat program that allows users
to login, chat to other users and access previous chat histories offering real-time text
transmission based on a Client-Server architecture. Apart from the basic functionalities, the
system will also provide a translation tool.
The core running of the system involves the communication of the database to the server via
JDBC and the University PostgreSQL, allowing chat histories to be stored. Sockets are also
explored for communication integration between the server and clients. The multi-threaded
server implemented are to handle multiple clients simultaneously. To aid client interaction,
the client user interfaces are constructed based on Swing which displays the necessary
components to guide the user throughout the chat and to allow the ease of use.

The basic features are as follows:

User Registration:
User can sign-up selecting their username and password.

User Sign-In:
After a successful registration, users should sign-in by entering their username and
password.

Common Chat Room:
A common Chat Room with all the online users is available for all users to chat with each
other. When a user sends a message, the message is echoed to all the clients.

Private Chats:
Users can select users who they would like to create a private chat room and select the “New
Group” button to create a new Chat with the selected users only.

Translation:
User can translate short messages in 91 languages by calling an external API. The team has
acknowledged the security and performance risks of integrating an external API but decided
to proceed adopting an experimental approach towards this functionality. In the future, only a
trusted API should be used in the system. The translation service aims to build bridges
between users that do not speak the same language.
