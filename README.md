# Borderlands 2_Config_utility
- Borderlands 2 is FPS video game released by 2K games in 2012. 
Developed using Unreal Engine 3, the initial graphics settings are stored in an .ini configuration file in My documents which is used to load graphical, audio, network and control settings on game launch. 

- My configuration utility is a desktop app which uses javafx, scenebuilder and JavaSE File handling to make the process of editing the configuration file to improve game performance easier. Simply select the desired settings using the button and text box based java components and click on "SAVE" button to commit the changes to your actual configuration file saved in my documents folder.

![Alt text](https://i.imgur.com/YswU7jJ.png)

# Class breakdown

### GUI_Controller
- Extends Application from the Javafx API. 
- Injects FXML components at runtime, loads the FXML file generated by the Scenebuilder. 
- Contains handlers for various events in the GUI.
- Dependency on File_Accessor objects to do actual work behind the scenes.

### File Accessor

- Core Java/ JavaSE file handling classes that read, modify and write the .ini file. Uses Arraylist of custom type Pair as a temporary storage for the read file. 
- Each modfiied property in the GUI_controller is added to the Arraylist changed_settings. To actually make the change, the changed_settings Arraylist is compared with the read_file Arraylist and the matching if a property occurs in both Arraylists, the value of that property is changed in the read_file Arraylist. 
- **Using a Map would've been the ideal data structure but i found out that the file contains some duplicate keys, hence i swithced to Arraylist.**
- Finally the read_File arraylist is written to the disk at the actual location when the GUI_controller's Save and Exit button is fired.
- Used Buffering and try catches all around.

### Pair

- Custom type to hold the key value pairs.
- Two constrcutors,one for K_V pairs,one for heading without a corrosponding value.

### may.fxml
- fxml file generated by Scenebuilder.
- A grid pane, consisting of scroll panes. Individual components nested in Vboxes and hboxes(where neeeded).
- Can be much prettier.
