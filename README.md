# OmniVerseCLI 🧩
The OmniVerseCLI repository is a command-line interface tool designed to enhance productivity and simplify interactions with the OmniVerse platform. Seamlessly integrated with the powerful features of OmniVerse, this CLI tool empowers users to streamline their workflow through efficient command execution.

## Building 🔨

OmniVerseCLI employs the Maven build system to efficiently compile, test, and package the project. By utilizing Maven, developers benefit from standardized project management, dependency resolution, and a straightforward build lifecycle. 

- You'll need Java 17 in order to build and run the package.

- You can build it just by running `./mvnw package` in the project root folder, the target file will be generated at `/target/` folder.

- You can always just use the most recent released version instead of building it. [Download it here](https://github.com/lucasapchagas/OmniverseCLI/releases/tag/release)

## Using it

Use the command `java -jar <target_file>.jar <Omniverse API URL>` in order to run the OmniVerseCLI app.

Example: `java -jar OmniVerseCLI-1.0-SNAPSHOT-jar-with-dependencies.jar http://localhost:8080/`

| Command   | Fields       | Description                           |
| :---------- | :--------- | :---------------------------------- |
| `user create` | `NONE` | Make an api call to OmniVerseAPI with the given id. Start's an  interative prompt to create the desired user.|
| `user list` | `NONE` | Make an api call to OmniVerseAPI with the given id. Shows all users info if available.|
| `user info` | `id` | Make an api call to OmniVerseAPI with the given id. Shows user's info if available.|
| `user delete` | `id` | Make an api call to OmniVerseAPI with the given id. Tries to delete the desired user.|
| `user update` | `id` | Make an api call to OmniVerseAPI with the given id. Start's an  interative prompt to update the desired user info.|
| `cep` | `digits` | Make an api call to ViaCEP with the given postal code. |
| `help` | `NONE` | Show's help command with all the commands |
| `exit` | `NONE` | Simply close the application |

## Libraries Used 📚

- Retrofit
- Jackson
