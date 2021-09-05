# Participants
Daniel Tyler -- 20010348 <br />
Mathew Veale -- 19033865

# Directions
When the file is opened, users may write in the main textbox. They may press on the toolbar to for more options. <br />
To open a new document, users may press 'file' and then 'new'.They may press 'file' and then 'open' to open the <br />
file explorer that selects the wanted file. When selected, the text document will be shown on the main textbox of <br />
the text editor. The text editor supports copy-and-paste methods with Ctrl-C and Cntrl-V. Underneath 'file', users <br />
can save what they have written as a text document. Alternatively, users can copy and paste by selecting 'edit' and <br />
the associated button.

Users can close the text editor with the quit button underneath file. They can select certain words of the text by <br />
pressing 'search for word' underneath' search. They can also print, find the time and date and get information <br />
about the text-editor by pressing the associated buttons on the toolbar. <br />

# Folders
We employed two Java files to run our program. The first contains the code that brings up the display and toolbar. <br />
the second furnishes the applications with logic. Editor contains the former and EditorController contains the latter. <br/>

# Commit IDs
Daniel Tyler -- a30eb4f, 5b4463e, d0acc07 <br />
Mathew Veale -- 7535285, 318aca3, 0198d8e

# Running
Write the following command lines in the Text Editor directory (The one with pom.xml): <br />
- mvn compile
- mvn exec:java -Dexec.mainClass="application.Editor"
