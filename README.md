# CS165 Software Design Pattern
### 2020/01/20

### 1. 2020/01/20 
Project: Factory and Observer

### 2. 2020/01/30
Project: Java AWT Examples

AWT (Abstract Windowing Toolkit) API was introduced in JDK 1.0. Most of the AWT 
components have become obsolete and should be replaced by newer Swing components.

JDK 1.0's AWT was awkward and non-object-oriented (using many `event.getSource()`). 
JDK 1.1's AWT introduced event-delegation (event-driven) model, much clearer and 
object-oriented.

### 3. 2020/01/31
Project: Java Swing Examples

Swing API, a much more comprehensive set of graphics libraries that enhances the 
AWT, was introduced as part of Java Foundation Classes (JFC) after the release of 
JDK 1.1. JFC consists of Swing, Java2D, Accessibility, Internationalization, and 
Pluggable Look-and-Feel Support APIs. JFC has been integrated into core Java 
since JDK 1.2.

Swing application uses AWT event-handling classes (in package java.awt.event). 
Swing added some new classes in package javax.swing.event, but they are not frequently used.
Swing application uses AWT's layout manager (such as FlowLayout and BorderLayout 
in package java.awt). It added new layout managers, such as Springs, Struts, and 
BoxLayout (in package javax.swing).

** As a rule, do not mix heavyweight AWT components and lightweight Swing components in the same program, as the heavyweight components will always be painted on top of the lightweight components. **

Just like AWT application, a Swing application requires ** a top-level container **. There are three top-level containers in Swing:

1. JFrame: used for the application's main window (with an icon, a title, minimize/maximize/close buttons, an optional menu-bar, and a content-pane), as illustrated.
2. JDialog: used for secondary pop-up window (with a title, a close button, and a content-pane).
3. JApplet: used for the applet's display-area (content-pane) inside a browser’s window.

Similarly to AWT, there are ** secondary containers ** (such as JPanel) which can be used to group and layout relevant components.

** However **, unlike AWT, the JComponents shall not be added onto the top-level container (e.g., JFrame, JApplet) directly because they are lightweight components. The JComponents must be added onto the so-called ** content-pane ** of the top-level container. ** Content-pane ** is in fact a java.awt.Container that can be used to group and layout components.

### 4. Running the GUI Construction Codes on the Event-Dispatching Thread
Invoking the constructor directly in the entry main() method to setup the GUI components, will be executed in the so-called "Main-Program" thread. This may cause multi-threading issues (such as unresponsive user-interface and deadlock).

It is recommended to execute the GUI setup codes in the so-called "Event-Dispatching" thread, instead of "Main-Program" thread, for thread-safe operations. Event-dispatching thread, which processes events, should be used when the codes updates the GUI.

To run the constructor on the event-dispatching thread, invoke * static * method `SwingUtilities.invokeLater()` to ** asynchronously queue ** the constructor on the event-dispatching thread. The codes will be run after all pending events have been processed.

** Note **: `javax.swing.SwingUtilities.invokeLater()` is a cover for `java.awt.EventQueue.invokeLater()`