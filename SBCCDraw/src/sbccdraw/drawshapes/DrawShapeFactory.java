package sbccdraw.drawshapes;

import static java.nio.file.FileSystems.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;

import com.sun.nio.file.*;

import sbccdraw.*;

/**
 * DrawShapeFactory is used to create new DrawShapes. Upon instantiation,
 * DrawShapeFactory finds the .class files for all DrawShapes in
 * ./classes/sbccdraw/drawshapes/ . It provides access to the list of DrawShape
 * names via via getShapeNames().
 */
public class DrawShapeFactory {

  ArrayList<String> drawShapeNames = new ArrayList<>();

  private ArrayList<DrawShapeNamesChangedListener> drawShapeNamesChangedListeners = new ArrayList<>();

  String drawShapesPath;

  ExecutorService executor;

  WatchService watchService;

  /**
   * This is the FACTORY METHOD. It takes a shape name, or more accurately the
   * shape's class name, and returns the specified shape object.
   * 
   * @param shapeName
   * @return A DrawShape whose type matches the given shapeName
   * @throws Exception
   */
  public DrawShape createDrawShape(String shapeName) throws Exception {
    Class c = Class.forName("sbccdraw.drawshapes." + shapeName);
    DrawShape d = (DrawShape) c.newInstance();
    return d;
  }

  /**
   * This method allows client to see what types of DrawShapes are currently
   * available.
   */
  public ArrayList<String> getDrawShapeNames() {
    return (ArrayList<String>) drawShapeNames.clone();
  }

  /**
   * This constructor loads an initial set of DrawShape classes from the default
   * path. Then it starts a background service that watches for additions to or
   * deletions from the set of DrawShape classes.
   * 
   * @throws Exception
   */
  public DrawShapeFactory() throws Exception {

    // Load the initial set of DrawShapes
    drawShapesPath = "./classes/sbccdraw/drawshapes/";
    loadShapeClasses(drawShapesPath);

    // Create and start a service that watches drawShapesPath for changes
    watchService = getDefault().newWatchService();

    Paths.get(drawShapesPath).register(watchService,
        new WatchEvent.Kind[] { StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE },
        SensitivityWatchEventModifier.HIGH);

    executor = Executors.newSingleThreadExecutor();

    executor.submit(this::watchDrawShapePathForChanges);
  }

  /**
   * Watches for additions to or deletions from the set of DrawShapes. If a change
   * is detected, the list of classes is updated, and listeners are informed of
   * the change.
   */
  void watchDrawShapePathForChanges() {
    try {
      WatchKey key;
      while ((key = watchService.take()) != null) {
        key.pollEvents();
        Thread.sleep(250);
        loadShapeClasses(drawShapesPath);
        fireDrawShapeNamesChanged();
        key.reset();
      }
    } catch (ClosedWatchServiceException e) {
      // Ignore this exception
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Shuts down the directory watch service.
   * 
   * @throws IOException
   */
  public void shutdown() throws IOException {
    watchService.close();
    executor.shutdown();
  }

  /**
   * Loads DrawShape classes and populates the shapeNames list.
   * 
   * @param pathToDrawShapeClasses Path to the DrawShapes files (including
   *                               trailing "/")
   */
  public void loadShapeClasses(String pathToDrawShapeClasses) throws Exception {

    drawShapesPath = pathToDrawShapeClasses;
    drawShapeNames.clear();

    File file = new File(pathToDrawShapeClasses);

    for (String filename : file.list()) {

      // Try to load any .class except the base DrawShape.class
      if (filename.endsWith(".class") && !filename.startsWith("DrawShape")) {

        String className = filename.substring(0, filename.length() - 6);
        Class c = Class.forName("sbccdraw.drawshapes." + className);
        Object o = c.newInstance();

        // Verify that it is a DrawShape. If so, add its class name to the shape list.
        if (o instanceof DrawShape)
          drawShapeNames.add(className);
      }
    }
  }

  /**
   * Adds a client to the list of clients to inform when the DrawShapeNames list
   * changes.
   */
  public void addDrawShapeNamesChangedListener(DrawShapeNamesChangedListener listener) {
    drawShapeNamesChangedListeners.add(listener);
  }

  /**
   * Removes a client from the list of clients to inform when the DrawShapeNames
   * list changes.
   */
  public void removeDrawShapeNamesChangedListener(DrawShapeNamesChangedListener listener) {
    drawShapeNamesChangedListeners.remove(listener);
  }

  /**
   * Informs listeners that the DrawShapeNames list has changed.
   */
  private void fireDrawShapeNamesChanged() {
    for (DrawShapeNamesChangedListener listener : drawShapeNamesChangedListeners)
      listener.shapeNamesChanged(new ShapeNamesChangedEvent(this));
  }
}
